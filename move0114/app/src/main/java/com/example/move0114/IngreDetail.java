package com.example.move0114;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.move0114.models.Ingredient;

public class IngreDetail extends AppCompatActivity {

    Ingredient selectIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingre_detail);

        getSelectedIngredient();

        setValues();
    }

    private void setValues() {

        TextView tv = findViewById(R.id.ingredient_detail_name);
        ImageView iv = findViewById(R.id.ingredient_detail_image);
        ImageView iv2 = findViewById(R.id.ingredient_introduce_image);

        tv.setText(selectIngredient.getName());
        iv.setImageResource(selectIngredient.getImage());
        iv2.setImageResource(selectIngredient.getImage_intro());
    }

    private void getSelectedIngredient() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        //id = getIntent().getStringExtra(FirebaseID.pos);

        selectIngredient = Search.ingredientList.get(Integer.valueOf(id));
    }
}