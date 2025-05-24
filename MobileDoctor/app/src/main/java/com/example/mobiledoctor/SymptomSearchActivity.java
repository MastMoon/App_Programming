package com.example.mobiledoctor;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.appbar.MaterialToolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SymptomSearchActivity extends AppCompatActivity {

    // ✔ 전역에 현재 위치 저장 변수 추가
    private LatLng currentLocation;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;


    private Spinner spCategory, spSub;
    private ListView lvResults, lvHospitals, lvPharmacies;
    private TextView tvMedicineCount, tvHospitalCount, tvPharmacyCount;

    private Map<String, List<String>> categoryMap = new HashMap<>();
    private Map<String, List<Medicine>> medicineData = new HashMap<>();

    private FusedLocationProviderClient fusedLocationClient;
    private String placesApiKey; // Places API 키
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final int SEARCH_RADIUS = 1000; // 1km 반경
    private static final String TAG = "SymptomSearchActivity";  // TAG 정의

    // 장소+좌표 보관용
    private static class PlaceItem {
        final String name;
        final double lat, lng;
        PlaceItem(String name, double lat, double lng) {
            this.name = name;
            this.lat  = lat;
            this.lng  = lng;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_search);


        // UI 초기화
        spCategory = findViewById(R.id.spinner_category);
        spSub = findViewById(R.id.spinner_sub);
        lvResults = findViewById(R.id.list_results);
        tvMedicineCount = findViewById(R.id.medicine_count);
        tvHospitalCount = findViewById(R.id.nearby_hospitals_count);
        tvPharmacyCount = findViewById(R.id.nearby_pharmacies_count);

        lvHospitals = findViewById(R.id.list_nearby_hospitals);  // 병원 리스트 뷰 초기화
        lvPharmacies = findViewById(R.id.list_nearby_pharmacies); // 약국 리스트 뷰 초기화

        // 툴바 세팅
        MaterialToolbar toolbar = findViewById(R.id.toolbar_symptom_search);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 카테고리와 약 정보 초기화
        initCategoryMap();
        initMedicineData();

        // 3) 스피너에 어댑터 & 리스너 연결
        setupMedicineSpinners();  // ← 이 줄을 꼭 추가하세요!

        // 위치 권한 요청
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Places API 키를 Manifest에서 가져오는 코드
        placesApiKey = getString(R.string.PLACES_API_KEY); // 이를 values/strings.xml에 저장

        requestLocationPermission();  // 위치 권한 요청 및 위치 정보 가져오기
    }

    // 메뉴 붙이기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_symptom_search, menu);
        return true;
    }

    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {
        // (1) 요청 전에 명시적으로 퍼미션 체크
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // 권한이 없으면 바로 리턴
            Log.w(TAG, "startLocationUpdates: 위치 권한 없음, 업데이트 중단");
            return;
        }

        // (2) 위치 요청 파라미터 세팅
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(5000)        // 5초마다
                .setFastestInterval(2000);// 최소 2초마다

        // (3) 콜백 정의
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult result) {
                if (result == null) return;
                Location loc = result.getLastLocation();
                currentLocation = new LatLng(loc.getLatitude(), loc.getLongitude());
                Log.d(TAG, "🔄 위치 업데이트: "
                        + currentLocation.latitude + ", "
                        + currentLocation.longitude);
            }
        };

        // (4) 업데이트 시작
        fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
        );
    }

    // 뒤로가기·새로고침 처리
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        if (id == R.id.action_refresh) {
            if (currentLocation != null) {
                Log.d(TAG, "📌 새로고침: "
                        + currentLocation.latitude + ", "
                        + currentLocation.longitude);
                fetchNearbyPlacesWithDistance(currentLocation, "hospital", lvHospitals, tvHospitalCount);
                fetchNearbyPlacesWithDistance(currentLocation, "pharmacy", lvPharmacies, tvPharmacyCount);
            } else {
                Toast.makeText(this,
                        "현재 위치를 가져오는 중…",
                        Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // 퍼미션 요청 콜백
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // 권한 방금 허용: 초기 한 번 + 업데이트
            getCurrentLocation();
            startLocationUpdates();
        } else {
            Toast.makeText(this, "위치 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationCallback != null) {
            fusedLocationClient.removeLocationUpdates(locationCallback);
        }
    }


    /**
     * Initialize category to sub-symptom mapping.
     */
    // 카테고리 → 증상 매핑
    private void initCategoryMap() {
        categoryMap = new HashMap<>();
        categoryMap.put("두통 계열", Arrays.asList("두통", "편두통", "머리아픔", "두통약"));
        categoryMap.put("피부 계열", Arrays.asList("알레르기", "피부염", "발진", "여드름", "가려움"));
        categoryMap.put("소화 계열", Arrays.asList("소화불량", "속쓰림", "소화", "위염", "역류성 식도염"));
        categoryMap.put("감기 계열", Arrays.asList("감기", "콧물", "목아픔", "기침", "인후염"));
        categoryMap.put("염증 계열", Arrays.asList("염증", "통증", "근육통", "관절염"));
        categoryMap.put("심혈관 계열", Arrays.asList("고혈압", "혈전", "심장병"));
        categoryMap.put("호흡기 계열", Arrays.asList("천식", "기침", "호흡곤란", "폐렴"));
        categoryMap.put("정신건강 계열", Arrays.asList("우울증", "불안", "불면증"));
        categoryMap.put("당뇨 계열", Arrays.asList("당뇨", "혈당", "인슐린"));
        categoryMap.put("기타",       Arrays.asList("기타"));
    }

    /**
     * Initialize sub-symptom to medicine mapping.
     */
    private void initMedicineData() {
        // 두통 계열 (4개)
        medicineData.put("두통 계열", Arrays.asList(
                new Medicine("타이레놀",     "두통·발열 완화",    "500mg 4~6h", "₩3,000"),
                new Medicine("게보린",       "두통 완화",         "400mg 4h",   "₩3,500"),
                new Medicine("브롬페리드",   "편두통 완화",       "2정 2회",    "₩4,000"),
                new Medicine("이부프로펜",   "통증·염증 완화",    "200mg 3회",  "₩2,500")
        ));

        // 감기 계열 (5개)
        medicineData.put("감기 계열", Arrays.asList(
                new Medicine("판피린",       "감기 증상 완화",      "2정 3회",    "₩2,500"),
                new Medicine("콜대원",       "기침·가래 완화",      "1포 3회",    "₩4,000"),
                new Medicine("테라플루",     "감기 복합 증상 완화", "1포 4회",    "₩5,500"),
                new Medicine("판콜",         "콧물·재채기 완화",    "2정 3회",    "₩3,200"),
                new Medicine("타이레놀 콜드","감기 통증·해열",      "500mg 4회",  "₩4,200")
        ));

        // 소화 계열 (5개)
        medicineData.put("소화 계열", Arrays.asList(
                new Medicine("겔포스",       "위산 중화",           "1포 식전·식후", "₩1,500"),
                new Medicine("베아제",       "소화불량 개선",       "2정 식전",      "₩1,800"),
                new Medicine("우르사",       "간 보호",             "1정 3회",       "₩3,200"),
                new Medicine("가스터정",     "위염·속쓰림 완화",    "1정 2회",       "₩2,200"),
                new Medicine("모사프리드",   "위장 운동 촉진",      "5mg 3회",       "₩2,600")
        ));

        // 피부 계열 (4개)
        medicineData.put("피부 계열", Arrays.asList(
                new Medicine("센텔라 크림", "가려움 완화",     "적당량 도포",   "₩5,000"),
                new Medicine("벤젠크림",     "발진 억제",       "1일 2회",       "₩4,500"),
                new Medicine("히루닥",       "상처 치료",       "적용부위 도포", "₩6,000"),
                new Medicine("스테로이드 연고","염증 완화",     "1일 1회",       "₩3,800")
        ));

        // 염증 계열 (4개)
        medicineData.put("염증 계열", Arrays.asList(
                new Medicine("나프록센",   "염증·통증 완화",    "220mg 2회", "₩4,000"),
                new Medicine("피록시캄",   "염증 완화",         "20mg 1회",  "₩3,500"),
                new Medicine("프레드니솔론","중등도 염증 억제", "5mg 1회",   "₩2,000"),
                new Medicine("아스피린",   "통증·염증 완화",    "325mg 4~6h","₩3,000")
        ));

        // 심혈관 계열 (4개)
        medicineData.put("심혈관 계열", Arrays.asList(
                new Medicine("로수바스타틴","콜레스테롤 저하", "10mg 1회",   "₩8,000"),
                new Medicine("카르베디롤",  "혈압 강하",       "12.5mg 2회", "₩5,500"),
                new Medicine("디곡신",      "심박 조절",       "0.25mg 1회", "₩6,000"),
                new Medicine("클로피도그렐","혈전 예방",       "75mg 1회",   "₩7,000")
        ));

        // 호흡기 계열 (5개)
        medicineData.put("호흡기 계열", Arrays.asList(
                new Medicine("알부테롤흡입제","천식 증상 완화",   "1~2회 흡입",  "₩4,500"),
                new Medicine("몬테루카스트",  "기관지 확장",       "10mg 1회",    "₩3,000"),
                new Medicine("암브록솔",      "가래 배출 도움",     "30mg 3회",    "₩2,800"),
                new Medicine("타이로민",      "콧물 완화",         "1포 3회",     "₩4,000"),
                new Medicine("스테로이드 흡입제","천식 염증 억제","1일 2회 흡입","₩7,500")
        ));

        // 정신건강 계열 (4개)
        medicineData.put("정신건강 계열", Arrays.asList(
                new Medicine("시탈로프람", "우울증 치료",     "20mg 1회",  "₩5,500"),
                new Medicine("알프라졸람", "불안 완화",        "0.5mg 2회", "₩6,000"),
                new Medicine("졸피뎀",     "수면 유도",        "10mg 취침 전","₩4,200"),
                new Medicine("부스피론",   "경도 불안 완화",   "5mg 2회",   "₩3,800")
        ));

        // 당뇨 계열 (5개)
        medicineData.put("당뇨 계열", Arrays.asList(
                new Medicine("메트포르민",     "혈당 강하",       "500mg 2회",     "₩4,500"),
                new Medicine("인슐린 글라진","혈당 조절",       "1회 자가주사",  "₩15,000"),
                new Medicine("시타글립틴",   "혈당 조절",       "50mg 1회",      "₩6,000"),
                new Medicine("글리벤클라미드","인슐린 분비 촉진","5mg 1회",       "₩4,200"),
                new Medicine("에토글리플로진","혈당 배출 촉진", "10mg 1회",      "₩7,500")
        ));

        // 기타 (3개)
        medicineData.put("기타", Arrays.asList(
                new Medicine("비타민C",    "면역력 증진",    "500mg 1회",  "₩1,000"),
                new Medicine("폴리덴탈겔","치은염 완화",    "3~4회 도포", "₩1,500"),
                new Medicine("니코틴패치","금연 보조",      "21mg 1패치", "₩5,000")
        ));
    }



    private void fetchNearbyPlaces(LatLng currentLocation) {
        Log.d(TAG, "▶ fetchNearbyPlaces() 시작: " + currentLocation.latitude + ", " + currentLocation.longitude);
        // 병원 검색 URL
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + currentLocation.latitude + "," + currentLocation.longitude +
                "&radius=" + SEARCH_RADIUS + "&type=hospital&key=" + placesApiKey;

        // 병원 요청
        new OkHttpClient().newCall(new Request.Builder().url(url).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "병원 검색 실패", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    JSONObject json = null;
                    try {
                        json = new JSONObject(response.body().string());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    JSONArray results = json.optJSONArray("results");
                    List<String> hospitals = new ArrayList<>();
                    if (results != null) {
                        for (int i = 0; i < results.length(); i++) {
                            JSONObject place = results.optJSONObject(i);
                            String hospitalName = place.optString("name", "이름 없음");
                            hospitals.add(hospitalName);
                        }
                        Log.d(TAG, "✅ 병원 검색 결과 개수: " + hospitals.size());

                        runOnUiThread(() -> {
                            // 병원이 있을 경우 ListView에 데이터 세팅
                            lvHospitals.setAdapter(new ArrayAdapter<>(SymptomSearchActivity.this, android.R.layout.simple_list_item_1, hospitals));
                            tvHospitalCount.setText("병원 수: " + hospitals.size());

                            // 병원 리스트가 비어있으면 메시지 보이기, 아니면 리스트 보이기
                            if (hospitals.isEmpty()) {
                                lvHospitals.setVisibility(View.GONE);
                                findViewById(R.id.no_hospitals_message).setVisibility(View.VISIBLE);
                            } else {
                                lvHospitals.setVisibility(View.VISIBLE);
                                findViewById(R.id.no_hospitals_message).setVisibility(View.GONE);
                            }
                        });
                    }
                }
            }
        });

        // 약국 요청 (병원과 같은 방식으로, type을 "pharmacy"로 변경)
        url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + currentLocation.latitude + "," + currentLocation.longitude +
                "&radius=" + SEARCH_RADIUS + "&type=pharmacy&key=" + placesApiKey;

        new OkHttpClient().newCall(new Request.Builder().url(url).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "약국 검색 실패", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    JSONObject json = null;
                    try {
                        json = new JSONObject(response.body().string());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    JSONArray results = json.optJSONArray("results");
                    List<String> pharmacies = new ArrayList<>();
                    if (results != null) {
                        for (int i = 0; i < results.length(); i++) {
                            JSONObject place = results.optJSONObject(i);
                            String pharmacyName = place.optString("name", "이름 없음");
                            pharmacies.add(pharmacyName);
                        }
                        Log.d(TAG, "✅ 약국 검색 결과 개수: " + pharmacies.size());

                        runOnUiThread(() -> {
                            // 약국이 있을 경우 ListView에 데이터 세팅
                            lvPharmacies.setAdapter(new ArrayAdapter<>(SymptomSearchActivity.this, android.R.layout.simple_list_item_1, pharmacies));
                            tvPharmacyCount.setText("약국 수: " + pharmacies.size());

                            // 약국 리스트가 비어있으면 메시지 보이기, 아니면 리스트 보이기
                            if (pharmacies.isEmpty()) {
                                lvPharmacies.setVisibility(View.GONE);
                                findViewById(R.id.no_pharmacies_message).setVisibility(View.VISIBLE);
                            } else {
                                lvPharmacies.setVisibility(View.VISIBLE);
                                findViewById(R.id.no_pharmacies_message).setVisibility(View.GONE);
                            }
                        });
                    }
                }
            }
        });
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // 안전하게 또 요청하고 반환
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{ Manifest.permission.ACCESS_FINE_LOCATION },
                    LOCATION_PERMISSION_REQUEST_CODE
            );
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        // 최초 리스트 조회
                        fetchNearbyPlacesWithDistance(currentLocation, "hospital", lvHospitals, tvHospitalCount);
                        fetchNearbyPlacesWithDistance(currentLocation, "pharmacy", lvPharmacies, tvPharmacyCount);
                    } else {
                        Toast.makeText(this, "현재 위치를 가져올 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // 거리 계산+어댑터 연결
    private void fetchNearbyPlacesWithDistance(LatLng loc, String type,
                                               ListView listView, TextView countView) {

        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                + "?location=" + loc.latitude + "," + loc.longitude
                + "&radius=" + SEARCH_RADIUS
                + "&type=" + type
                + "&key=" + placesApiKey;

        new OkHttpClient().newCall(new Request.Builder().url(url).build())
                .enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                        Log.e(TAG, "검색 실패", e);
                    }
                    @Override public void onResponse(Call call, Response resp) throws IOException {
                        if (!resp.isSuccessful()) return;
                        try {
                            JSONObject  root = new JSONObject(resp.body().string());
                            JSONArray   arr  = root.optJSONArray("results");
                            List<PlaceItem> items = new ArrayList<>();
                            for(int i=0; i<arr.length(); i++){
                                JSONObject o = arr.getJSONObject(i);
                                String name = o.optString("name");
                                double  lat  = o.getJSONObject("geometry")
                                        .getJSONObject("location")
                                        .optDouble("lat");
                                double  lng  = o.getJSONObject("geometry")
                                        .getJSONObject("location")
                                        .optDouble("lng");
                                items.add(new PlaceItem(name, lat, lng));
                            }
                            runOnUiThread(() -> {
                                countView.setText((type.equals("hospital")?"병원":"약국")+" 수: "+items.size());
                                if(items.isEmpty()){
                                    listView.setVisibility(View.GONE);
                                } else {
                                    listView.setVisibility(View.VISIBLE);
                                    listView.setAdapter(new ArrayAdapter<PlaceItem>(
                                            SymptomSearchActivity.this,
                                            android.R.layout.simple_list_item_2,
                                            android.R.id.text1,
                                            items
                                    ) {
                                        @NonNull @Override
                                        public View getView(int pos, View cv, ViewGroup parent) {
                                            View v = super.getView(pos, cv, parent);
                                            TextView t1 = v.findViewById(android.R.id.text1);
                                            TextView t2 = v.findViewById(android.R.id.text2);
                                            PlaceItem it = getItem(pos);
                                            t1.setText(it.name);
                                            // 내 위치 ↔ 장소 거리 계산
                                            float[] res = new float[1];
                                            Location.distanceBetween(
                                                    currentLocation.latitude,
                                                    currentLocation.longitude,
                                                    it.lat, it.lng,
                                                    res
                                            );
                                            t2.setText(Math.round(res[0]) + "m");
                                            return v;
                                        }
                                    });
                                }
                            });
                        } catch (JSONException ex) {
                            Log.e(TAG, "JSON 파싱 에러", ex);
                        }
                    }
                });
    }


    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{ Manifest.permission.ACCESS_FINE_LOCATION },
                    LOCATION_PERMISSION_REQUEST_CODE
            );
        } else {
            // 권한이 이미 있을 때: ① 초기 한 번 위치 가져와서 리스트 채우기
            getCurrentLocation();
            // ② 그 후엔 실시간 업데이트만 저장
            startLocationUpdates();
        }
    }

    /**
     * Set up adapters and listeners for medicine selection spinners.
     */
    // 계열별 약 검색 수 업데이트 부분 (스피너 선택 시)
    private void setupMedicineSpinners() {
        ArrayAdapter<String> catAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<>(categoryMap.keySet()));
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(catAdapter);

        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String key = catAdapter.getItem(pos);
                List<String> subs = categoryMap.getOrDefault(key, Collections.emptyList());
                ArrayAdapter<String> subAdapter = new ArrayAdapter<>(SymptomSearchActivity.this, android.R.layout.simple_spinner_item, subs);
                subAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSub.setAdapter(subAdapter);
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String catKey = (String) spCategory.getSelectedItem();
                List<Medicine> meds = medicineData.getOrDefault(catKey, Collections.emptyList());
                lvResults.setAdapter(new ArrayAdapter<>(SymptomSearchActivity.this, android.R.layout.simple_list_item_1, meds));
                tvMedicineCount.setText("계열별 약 검색 수: " + meds.size());
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        lvResults.setOnItemClickListener((parent, view, position, id) -> {
            Medicine m = (Medicine) parent.getItemAtPosition(position);
            Intent intent = new Intent(SymptomSearchActivity.this, MapActivity.class);
            intent.putExtra("search_medicine", m.getName());
            startActivity(intent);
        });
    }
}
