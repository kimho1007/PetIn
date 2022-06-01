package com.example.move0114;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PetBmi extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_bmi);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
    }


    public void calculateBMI(View v){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr)
        && weightStr != null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr)/10;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }

    }
    private void displayBMI(float bmi){
        String bmiLable = "";

        if(Float.compare(bmi, 15f) <=0){
            bmiLable = getString(R.string.very_severely_underweight);
        }else if (Float.compare(bmi,15f) > 0 && Float.compare(bmi, 16f) <=0 ){
            bmiLable = getString(R.string.severely_underweight);
        }else if (Float.compare(bmi,16f) > 0 && Float.compare(bmi, 18.5f) <=0 ){
            bmiLable = getString(R.string.underweight);
        }else if (Float.compare(bmi,18.5f) > 0 && Float.compare(bmi, 25f) <=0 ){
            bmiLable = getString(R.string.normal);
        }else if (Float.compare(bmi,25f) > 0 && Float.compare(bmi, 30f) <=0 ){
            bmiLable = getString(R.string.overweight);
        }else if (Float.compare(bmi,30f) > 0 && Float.compare(bmi, 35f) <=0 ){
            bmiLable = getString(R.string.obese_class_i);
        }else if (Float.compare(bmi,35f) > 0 && Float.compare(bmi, 40f) <=0 ){
            bmiLable = getString(R.string.obese_class_ii);
        }else{
            bmiLable = getString(R.string.obese_class_iii);
        }

        bmiLable = bmi + "\n\n" + bmiLable;
        result.setText(bmiLable);


    }

}