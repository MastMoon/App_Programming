package com.example.dice_project;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2;

    int diceImages[] = {
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };

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


        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        imageView1.setImageResource(diceImages[0]);
        imageView2.setImageResource(diceImages[0]);

    }

    public void Roll_Dice(View view) {
        Random rand = new Random();
        int dice1 = rand.nextInt(6);
        int dice2 = rand.nextInt(6);

        imageView1.setImageResource(diceImages[dice1]);
        imageView2.setImageResource(diceImages[dice2]);

        /*

        switch (dice1) {
            case 1:
                imageView1.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                imageView1.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                imageView1.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                imageView1.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageView1.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageView1.setImageResource(R.drawable.dice_6);
                break;

        }

        switch (dice2) {
            case 1:
                imageView2.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                imageView2.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                imageView2.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                imageView2.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageView2.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageView2.setImageResource(R.drawable.dice_6);
                break;
        }

         */

    }
}