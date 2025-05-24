package com.example.mobiledoctor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {  // AppCompatActivity -> BaseActivity로 변경

    private Button zoomButton;
    private TextView sampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 증상 검색 및 병원/약국 찾기 버튼 클릭 시 액티비티 전환
        findViewById(R.id.btn_symptom)
                .setOnClickListener(v -> startActivity(new Intent(this, SymptomSearchActivity.class)));

        findViewById(R.id.btn_map)
                .setOnClickListener(v -> startActivity(new Intent(this, MapActivity.class)));

        // SharedPreferences 초기화
        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);

        // 돋보기 버튼 및 텍스트뷰 연결
        zoomButton = findViewById(R.id.btn_zoom);
        sampleText = findViewById(R.id.tv_sample_text);

        // 돋보기 버튼 클릭 시 텍스트 크기 조정
        zoomButton.setOnClickListener(v -> {
            toggleZoom();
            applyZoomState();  // 버튼 클릭 시 실시간 반영
        });

        // 앱 실행 시 돋보기 상태를 가져와서 텍스트 크기 조정
        applyZoomState();
    }

    // 돋보기 활성화/비활성화
    private void toggleZoom() {
        boolean isZoomEnabled = sharedPreferences.getBoolean("isZoomEnabled", false);

        // 상태 반전 후 SharedPreferences에 저장
        if (isZoomEnabled) {
            // 돋보기 비활성화
            sharedPreferences.edit().putBoolean("isZoomEnabled", false).apply();
            zoomButton.setText("돋보기 활성화");
            sampleText.setTextSize(16); // 기본 텍스트 크기
        } else {
            // 돋보기 활성화
            sharedPreferences.edit().putBoolean("isZoomEnabled", true).apply();
            zoomButton.setText("돋보기 비활성화");
            sampleText.setTextSize(30); // 확대된 텍스트 크기
        }
    }
}
