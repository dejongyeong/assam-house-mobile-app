package yeongdejong.com.assamhouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        preferences = getSharedPreferences(LoginActivity.PREF_NAME,MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void register(View view) {
        if(isValidEmail()) {
            if(isValidPassword()) {

                EditText email = (EditText) findViewById(R.id.edtRegisterEmail);
                EditText password = (EditText) findViewById(R.id.edtRegisterPassword);

                String usrEmail =  email.getText().toString();
                String usrPassword = password.getText().toString();

                editor.putString("Email",usrEmail);
                editor.putString("Password",usrPassword);
                editor.commit();

                Toast.makeText(SignUpActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();

                //Back to Login Screen
                Intent login = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(login);
            } else {
                Toast.makeText(SignUpActivity.this,"Password Not Match",Toast.LENGTH_SHORT).show();
                TextView password = (TextView) findViewById(R.id.edtRegisterPassword);
                TextView reenterPassword = (TextView) findViewById(R.id.edtReenterPassword);
                password.setText("");
                reenterPassword.setText("");
                password.requestFocus();
            }
        } else {
            Toast.makeText(SignUpActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
            TextView email = (TextView) findViewById(R.id.edtRegisterEmail);
            email.setText("");
            email.requestFocus();
        }
    }

    public boolean isValidEmail() {
        TextView email = (TextView) findViewById(R.id.edtRegisterEmail);
        String strEmail = email.getText().toString();

        if(!strEmail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPassword() {
        TextView password = (TextView) findViewById(R.id.edtRegisterPassword);
        TextView reenterPassword = (TextView) findViewById(R.id.edtReenterPassword);
        String strPassword = password.getText().toString();
        String strReenter = reenterPassword.getText().toString();

        if(strPassword.equals(strReenter) && !strPassword.isEmpty() && !strReenter.isEmpty())
            return true;
        else
            return false;
    }
}
