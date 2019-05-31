package yeongdejong.com.assamhouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CuisineRecipeActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Editor editor;
    Intent intent;
    String cuisineName, cuisineCategory, cuisineDescription, cuisineServing, cuisinePrepareTime, cuisineCookTime, cuisineIngredient, cuisineDirection;
    int cuisineFoodID, cuisineImage;
    public static Recipes recipe;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_recipe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Create the adapter that will return a fragment for each of the three primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        preferences = getSharedPreferences(LoginActivity.PREF_NAME,MODE_PRIVATE);

        //Get cuisine element by calling method
        getCuisineElement();
        setTitle(cuisineName);

        recipe = new Recipes(cuisineFoodID, cuisineName, cuisineCategory, cuisineImage, cuisineDescription, cuisineServing, cuisinePrepareTime, cuisineCookTime, cuisineIngredient, cuisineDirection);
    }

    public void getCuisineElement() {
        intent = getIntent();
        cuisineFoodID = intent.getExtras().getInt(CuisineListActivity.INTENT_COLUMN_FOOD_ID);
        cuisineName = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_NAME);
        cuisineCategory = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_CATEGORY);
        cuisineImage = intent.getExtras().getInt(CuisineListActivity.INTENT_COLUMN_IMAGE);
        cuisineDescription = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_DESCRIPTION);
        cuisineServing = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_SERVING);
        cuisinePrepareTime = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_PREPARE_TIME);
        cuisineCookTime = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_COOK_TIME);
        cuisineIngredient = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_INGREDIENT);
        cuisineDirection = intent.getStringExtra(CuisineListActivity.INTENT_COLUMN_DIRECTION);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
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

                Intent logout = new Intent(CuisineRecipeActivity.this,LoginActivity.class);
                startActivity(logout);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    DescriptionTab descriptionTab = new DescriptionTab();
                    return descriptionTab;
                case 1:
                    IngredientTab ingredientTab = new IngredientTab();
                    return ingredientTab;
                case 2:
                    DirectionTab directionTab = new DirectionTab();
                    return directionTab;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DESCRIPTION";
                case 1:
                    return "INGREDIENT";
                case 2:
                    return "DIRECTION";
            }
            return null;
        }
    }
}
