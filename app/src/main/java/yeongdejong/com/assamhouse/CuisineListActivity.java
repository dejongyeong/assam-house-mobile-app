package yeongdejong.com.assamhouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;

public class CuisineListActivity extends AppCompatActivity implements OnItemClickListener {

    public static final String INTENT_COLUMN_FOOD_ID = "FoodID";
    public static final String INTENT_COLUMN_NAME = "Name";
    public static final String INTENT_COLUMN_CATEGORY = "Category";
    public static final String INTENT_COLUMN_IMAGE = "Image";
    public static final String INTENT_COLUMN_DESCRIPTION = "Description";
    public static final String INTENT_COLUMN_SERVING = "Servings";
    public static final String INTENT_COLUMN_PREPARE_TIME = "PrepareTime";
    public static final String INTENT_COLUMN_COOK_TIME = "CookTime";
    public static final String INTENT_COLUMN_INGREDIENT = "Ingredient";
    public static final String INTENT_COLUMN_DIRECTION = "Direction";

    SharedPreferences preferences;
    Editor editor;
    DB_Recipes db;
    String title;
    ListView cuisineList;
    EditText search;
    ArrayList<Recipes> cuisines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getSharedPreferences(LoginActivity.PREF_NAME,MODE_PRIVATE);

        //Get back intent
        Intent intent = getIntent();
        title = intent.getStringExtra(HomeActivity.CATEGORY_NAME);
        setTitle(title + " Recipes");

        //Fill List View
        fillListView(title);

        //Reset ListView is search Text Box is empty
        reset();
    }

    //Reset ListView
    public void reset() {
        search = (EditText) findViewById(R.id.searchText);

        /*****************************************************
         * Title: Android programming: How to save EditText changes without a save button (i.e., on text changed event)
         * Author: Alvin Alexander
         * Site owner/sponsor: alvinalexander.com
         * Date: June 5, 2016
         * Availability: http://alvinalexander.com/source-code/android/android-programming-how-save-edittext-changes-without-save-button-ie-text-change (Accessed 21 April 2017)
         * Modified: Identifiers rename
         * *****************************************************/
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty()) {
                    fillListView(title);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void search(View view) {
        db = new DB_Recipes(this);
        search = (EditText) findViewById(R.id.searchText);
        String key = search.getText().toString();
        if(key.isEmpty()) {
            //Reset ListView
            fillListView(title);
            Toast.makeText(CuisineListActivity.this,"Search field must not be empty",Toast.LENGTH_SHORT).show();
        } else {
            cuisines = db.getSearchRecipes(title, key);
            if(cuisines.size() == 0) {
                //Reset ListView
                fillListView(title);
                Toast.makeText(CuisineListActivity.this,"No such keyword found",Toast.LENGTH_SHORT).show();
            } else {
                //Display List View of the searched cuisines
                cuisineList = (ListView) findViewById(R.id.lstCuisine);
                CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.custom_listview, cuisines);
                cuisineList.setAdapter(adapter);
                cuisineList.setOnItemClickListener(this);
            }
        }
    }

    private void fillListView(String title) {
        db = new DB_Recipes(this);
        cuisines = db.getSelectedCategory(title);

        //Display List View
        /*****************************************************
         * Title: Android Custom ListView with Images and Text - Example
         * Author: Raj Amal
         * Site owner/sponsor: learn2crack.com
         * Date: October 29, 2013
         * Availability: https://www.learn2crack.com/2013/10/android-custom-listview-images-text-example.html (Accessed 16 April 2017)
         * Modified: Identifiers rename
         * *****************************************************/
        if(cuisines != null) {
            cuisineList = (ListView) findViewById(R.id.lstCuisine);
            CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.custom_listview, cuisines);
            cuisineList.setAdapter(adapter);
            cuisineList.setOnItemClickListener(this);
        } else {
            Toast.makeText(CuisineListActivity.this, "No cuisines on this category", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(CuisineListActivity.this, HomeActivity.class);
            startActivity(back);
        }

        //Testing Purpose
        //Toast.makeText(CuisineListActivity.this, String.valueOf(cuisines.size()), Toast.LENGTH_SHORT).show();
        //Toast.makeText(CuisineListActivity.this, "Rows: " + String.valueOf(db.numberOfRows()),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate menu
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_logout:
                //Change the value of "IsLoggedIn" to false for log out
                editor = preferences.edit();
                editor.putBoolean("IsLoggedIn",false);
                editor.commit();

                Intent logout = new Intent(CuisineListActivity.this,LoginActivity.class);
                startActivity(logout);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent recipe = new Intent(CuisineListActivity.this,CuisineRecipeActivity.class);
        for(int i = 0; i < cuisines.size(); i++) {
            if(cuisines.get(i).getName().equals(cuisines.get(position).getName())) {
                recipe.putExtra(INTENT_COLUMN_FOOD_ID, cuisines.get(position).getFoodID());
                recipe.putExtra(INTENT_COLUMN_NAME, cuisines.get(position).getName());
                recipe.putExtra(INTENT_COLUMN_CATEGORY, cuisines.get(position).getCategory());
                recipe.putExtra(INTENT_COLUMN_IMAGE, cuisines.get(position).getImage());
                recipe.putExtra(INTENT_COLUMN_DESCRIPTION, cuisines.get(position).getDescription());
                recipe.putExtra(INTENT_COLUMN_SERVING, cuisines.get(position).getServings());
                recipe.putExtra(INTENT_COLUMN_PREPARE_TIME, cuisines.get(position).getPrepareTime());
                recipe.putExtra(INTENT_COLUMN_COOK_TIME, cuisines.get(position).getCookTime());
                recipe.putExtra(INTENT_COLUMN_INGREDIENT, cuisines.get(position).getIngredient());
                recipe.putExtra(INTENT_COLUMN_DIRECTION, cuisines.get(position).getDirection());
                startActivity(recipe);
            }
        }
    }
}
