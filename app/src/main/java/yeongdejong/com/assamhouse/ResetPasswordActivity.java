package yeongdejong.com.assamhouse;

import android.content.*;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        preferences = getSharedPreferences(LoginActivity.PREF_NAME,MODE_PRIVATE);
    }

    public void reset(View view) {
        EditText email = (EditText) findViewById(R.id.edtForgetEmail);
        EditText password = (EditText) findViewById(R.id.edtNewPassword);
        EditText reenter = (EditText) findViewById(R.id.edtReenterNewPassword);

        String emailData = preferences.getString("Email",null);

        if(email.getText().toString().equals(emailData)) {
            if(password.getText().toString().equals(reenter.getText().toString())) {
                editor = preferences.edit();
                editor.putString("Password",password.getText().toString());
                editor.commit();

                Toast.makeText(ResetPasswordActivity.this,"Password Changed",Toast.LENGTH_SHORT).show();

                Intent login = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            } else {
                Toast.makeText(ResetPasswordActivity.this,"Password Not Match",Toast.LENGTH_SHORT).show();
                password.setText("");
                reenter.setText("");
                password.requestFocus();
            }
        } else {
            Toast.makeText(ResetPasswordActivity.this,"Invalid User, Try again/Register",Toast.LENGTH_SHORT).show();
            email.setText("");
            password.setText("");
            reenter.setText("");
            email.requestFocus();
        }
    }
}
