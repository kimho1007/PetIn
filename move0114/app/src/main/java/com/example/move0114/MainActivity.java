package com.example.move0114;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button recipe_btn;
    private Button post_btn;
    private Button sr_btn;
    private Button refrigerator_btn;
    private Button petbmi_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipe_btn = findViewById(R.id.recipe_btn);  // recipe_btn 값을 가져온다.
        recipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Recipe.class);  // 클래스 이동 intent
                startActivity(intent);
            }
        });

        post_btn = findViewById(R.id.post_btn);
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PostTotal.class);
                startActivity(intent);
            }
        });

        sr_btn = findViewById(R.id.sr_btn);
        sr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Search.class);  // 클래스 이동 intent
                startActivity(intent);
            }
        });


        refrigerator_btn = findViewById(R.id.refrigerator_btn);
        refrigerator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Refrigerator.class);  // 클래스 이동 intent
                startActivity(intent);
            }
        });

        petbmi_btn = findViewById(R.id.petbmi_btn);
        petbmi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PetBmi.class);  // 클래스 이동 intent
                startActivity(intent);
            }
        });


    }
}