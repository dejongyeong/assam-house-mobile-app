package yeongdejong.com.assamhouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String PREF_NAME = "MYPREFS";
    SharedPreferences preferences;
    Editor editor;
    DB_Recipes db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Insert Cuisines into Database
        db = new DB_Recipes(this);
        db.removeAllData(); //Prevent duplicates for every run
        db.insertMalaysiaCuisine();
        db.insertThailandCuisine();
        db.insertVietnamCuisine();
        db.insertIndonesiaCuisine();
        db.insertKoreanCuisine();

        preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);

        //One Time Login
        boolean hasLoggedIn = preferences.getBoolean("IsLoggedIn",false);
        if(hasLoggedIn) {
            Intent home = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(home);
            finish();
        }
    }

    public void login(View view) {
        EditText usrEmail = (EditText) findViewById(R.id.edtEmail);
        EditText usrPassword = (EditText) findViewById(R.id.edtPassword);

        //Retrieve Value from SharedPreferences
        String prefEmail = preferences.getString("Email",null);
        String prefPassword = preferences.getString("Password",null);

        if(usrEmail.getText().toString().equals(prefEmail) && usrPassword.getText().toString().equals(prefPassword)) {
            //One Time Login
            editor = preferences.edit();
            editor.putBoolean("IsLoggedIn",true);
            editor.commit();

            Intent home = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(home);
            finish();
        } else {
            Toast.makeText(LoginActivity.this,"Invalid Email/Password",Toast.LENGTH_SHORT).show();
            usrEmail.requestFocus();
            usrPassword.setText("");
        }
    }

    public void signup(View view) {
        Intent signup = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(signup);
    }

    public void forget(View view) {
        Intent forget = new Intent(LoginActivity.this, ResetPasswordActivity.class);
        startActivity(forget);
    }
}
