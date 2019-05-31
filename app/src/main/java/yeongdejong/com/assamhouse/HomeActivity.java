package yeongdejong.com.assamhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.*;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Editor editor;
    public final static String CATEGORY_NAME = "yeongdejong.com.assamhouse.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getSharedPreferences(LoginActivity.PREF_NAME,MODE_PRIVATE);
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

                Intent logout = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(logout);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Button onClick listener
    public void category(View view) {
        String category;
        Intent cuisine = new Intent(HomeActivity.this,CuisineListActivity.class);
        switch(view.getId()) {
            case R.id.btnMalaysia:
                Button btnMalaysia = (Button) findViewById(R.id.btnMalaysia);
                category = btnMalaysia.getText().toString();
                cuisine.putExtra(CATEGORY_NAME, category);
                break;
            case R.id.btnThailand:
                Button btnThailand = (Button) findViewById(R.id.btnThailand);
                category = btnThailand.getText().toString();
                cuisine.putExtra(CATEGORY_NAME, category);
                break;
            case R.id.btnVietnam:
                Button btnVietnam = (Button) findViewById(R.id.btnVietnam);
                category = btnVietnam.getText().toString();
                cuisine.putExtra(CATEGORY_NAME, category);
                break;
            case R.id.btnIndonesia:
                Button btnIndonesia = (Button) findViewById(R.id.btnIndonesia);
                category = btnIndonesia.getText().toString();
                cuisine.putExtra(CATEGORY_NAME, category);
                break;
            case R.id.btnKorea:
                Button btnKorea = (Button) findViewById(R.id.btnKorea);
                category = btnKorea.getText().toString();
                cuisine.putExtra(CATEGORY_NAME, category);
                break;
        }
        startActivity(cuisine);
    }

}
