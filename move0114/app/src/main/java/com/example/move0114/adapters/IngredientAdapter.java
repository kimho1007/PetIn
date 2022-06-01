package com.example.move0114.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.move0114.R;
import com.example.move0114.models.Ingredient;

import java.util.List;

public class IngredientAdapter extends ArrayAdapter<Ingredient> {

    public IngredientAdapter(Context context, int resource, List<Ingredient> ingredientList){
        super(context, resource, ingredientList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent){

        Ingredient ingredient = getItem(position);

        if(converView == null){
            converView = LayoutInflater.from(getContext()).inflate(R.layout.ingredient_item, parent, false);
        }

        TextView tv = converView.findViewById(R.id.ingredient_name);
        ImageView iv = converView.findViewById(R.id.ingredient_image);

        tv.setText(ingredient.getName());
        iv.setImageResource(ingredient.getImage());

        return converView;

    }

}
