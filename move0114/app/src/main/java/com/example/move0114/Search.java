package com.example.move0114;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.move0114.adapters.IngredientAdapter;
import com.example.move0114.models.Ingredient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    public static ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    ListView listview;

    public Search() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setUpSearch();

        setUpData(); //데이터 셋팅

        setUpList(); //리스트 셋팅

        setUponClickListener(); //상세 페이지 이벤트

    }

    private void setUpSearch() {
        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Ingredient> filterIngredient = new ArrayList<Ingredient>();

                for (int i = 0; i < ingredientList.size(); i++) {

                    Ingredient ingredient = ingredientList.get(i);

                    if (ingredient.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filterIngredient.add(ingredient);
                    }
                }
                IngredientAdapter adepter = new IngredientAdapter(getApplicationContext(), 0, filterIngredient);

                listview.setAdapter(adepter);

                return false;
            }
        });
    }

    private void setUpData() {

        Ingredient pork = new Ingredient("0", "Pork", R.drawable.pig, R.drawable.pig_intro);
        ingredientList.add(pork);

        Ingredient beef = new Ingredient("1", "Beef", R.drawable.cow, R.drawable.cow_intro);
        ingredientList.add(beef);

        Ingredient chicken = new Ingredient("2", "Chicken", R.drawable.chicken, R.drawable.chicken_intro);
        ingredientList.add(chicken);

        Ingredient fish = new Ingredient("3", "Fish", R.drawable.fish, R.drawable.fish_intro);
        ingredientList.add(fish);

        Ingredient banana = new Ingredient("4", "Banana", R.drawable.banana, R.drawable.banana_intro);
        ingredientList.add(banana);

        Ingredient apple = new Ingredient("5", "Apple", R.drawable.apple, R.drawable.apple_intro);
        ingredientList.add(apple);

        Ingredient strawberry = new Ingredient("6", "Strawberry", R.drawable.strawberry, R.drawable.strawberry_intro);
        ingredientList.add(strawberry);

        Ingredient grapes = new Ingredient("7", "Grapes", R.drawable.grapes, R.drawable.grapes_intro);
        ingredientList.add(grapes);

        Ingredient salt = new Ingredient("8", "Salt", R.drawable.salt, R.drawable.salt_intro);
        ingredientList.add(salt);

        Ingredient Chocolate = new Ingredient("9", "Chocolate", R.drawable.chocolate, R.drawable.chocolate_intro);
        ingredientList.add(Chocolate);


    }

    private void setUpList() {

        listview = findViewById(R.id.ingredient_list);

        IngredientAdapter adepter = new IngredientAdapter(getApplicationContext(), 0, ingredientList);
        listview.setAdapter(adepter);
    }



    private void setUponClickListener() {

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Ingredient selectIngredient = (Ingredient)listview.getItemAtPosition(position);

                Intent showDetail = new Intent(getApplicationContext(), IngreDetail.class);

                showDetail.putExtra("id", selectIngredient.getId());
                //showDetail.putExtra(FirebaseID.post, mDatas.get(position).getPosition());

                startActivity(showDetail);
            }
        });
    }
}