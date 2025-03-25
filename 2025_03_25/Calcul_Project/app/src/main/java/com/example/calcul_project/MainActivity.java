package com.example.calcul_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*

     버튼 XML ID

     XML_7 XML_8 XML_9 XML_D
     XML_6 XML_5 XML_4 XML_M
     XML_3 XML_2 XML_1 XML_S
     XML_0 XML_C XML_E XML_A

     */


    private TextView TextView1, TextView2; // 각각 버튼 입력값은 TextView1에 결과는 TextView2에 보이게 하기.
    private Button button7, button8, button9, buttonD
                 , button6, button5, button4, buttonM
                 , button3, button2, button1, buttonS
                 , button0, buttonC, buttonE, buttonA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView1 = findViewById(R.id.XML_textView1);


    }

    private void appendText(View view) {
        Button button = (Button) view;
        String current = TextView1.getText().toString();
        String newText = current + button.getText().toString();
        TextView1.setText(newText);
    }


    public void onClick7(View view) {
        appendText(view);
    }

    public void onClick8(View view) {
        appendText(view);
    }

    public void onClick9(View view) {
        appendText(view);
    }

    public void onClickD(View view) {
        appendText(view);
    }

    public void onClick4(View view) {
        appendText(view);
    }

    public void onClick5(View view) {
        appendText(view);
    }

    public void onClick6(View view) {
        appendText(view);
    }

    public void onClickM(View view) {
        appendText(view);
    }

    public void onClick1(View view) {
        appendText(view);
    }

    public void onClick2(View view) {
        appendText(view);
    }

    public void onClick3(View view) {
        appendText(view);
    }

    public void onClickS(View view) {
        appendText(view);
    }

    public void onClick0(View view) {
        appendText(view);
    }

    public void onClickC(View view) {
        TextView1.setText("");
    }

    public void onClickE(View view) {
        String expression = TextView1.getText().toString();

    }


    public void onClickA(View view) {
        appendText(view);
    }
}