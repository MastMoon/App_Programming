package com.example.mobiledoctor;

import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private Button zoomButton;
    private TextView sampleText;
    private TextView brightnessText;
    private SeekBar brightnessSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 화면 밝기 값 초기화
        brightnessText = findViewById(R.id.brightnessText);
        brightnessSeekBar = findViewById(R.id.seek_bar);

        // 권한 요청 (Android 6.0 이상)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                // 권한 요청: 사용자에게 권한을 요청하는 화면으로 이동
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                startActivityForResult(intent, 0); // 요청 코드 0
            }
        }

        // 화면 밝기 값 초기화
        try {
            int currentBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
            // 화면 밝기 값이 0~255 범위에서 0~100 범위로 변환
            int currentBrightnessPercentage = (int) (currentBrightness / 255.0 * 100);
            brightnessSeekBar.setProgress(currentBrightnessPercentage);

            brightnessText.setText("현재 밝기: " + currentBrightnessPercentage);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        // SeekBar 값 변경 시 밝기 조정
        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 0~100 범위에서 밝기 값을 0~255 범위로 변환
                int brightnessValue = (int) (progress / 100.0 * 255);

                // 밝기 값 업데이트
                if (Settings.System.canWrite(MainActivity.this)) {
                    ContentResolver cResolver = getContentResolver();
                    Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightnessValue);

                    // 밝기 텍스트 업데이트
                    brightnessText.setText("현재 밝기: " + progress);
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // ImageView 설정
        ImageView imageView = findViewById(R.id.iv_bottom_image);
        // 애니메이션 설정: 아래로 100dp 만큼 이동 후 원위치로 돌아옴
        ObjectAnimator moveDown = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 100f);
        moveDown.setDuration(1000);  // 1초 동안 아래로 이동
        moveDown.setInterpolator(new DecelerateInterpolator());  // 자연스러운 속도 변화

        // 이동 후 원위치로 돌아오는 애니메이션 설정
        ObjectAnimator moveUp = ObjectAnimator.ofFloat(imageView, "translationY", 100f, 0f);
        moveUp.setDuration(1000);  // 1초 동안 원위치로 돌아옴
        moveUp.setInterpolator(new DecelerateInterpolator());  // 자연스러운 속도 변화

        // 애니메이션 순차 실행 (아래로 이동 -> 원위치로 돌아오기)
        moveDown.start();
        moveDown.addListener(new android.animation.AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                moveUp.start();  // 첫 번째 애니메이션이 끝난 후 두 번째 애니메이션 실
            }
        });

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
