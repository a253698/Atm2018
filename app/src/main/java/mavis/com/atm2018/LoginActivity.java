package mavis.com.atm2018;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view) {
        EditText edusername = findViewById(R.id.ed_userName);
        EditText edpassword = findViewById(R.id.ed_password);
        String username = edusername.getText().toString();
        String password = edpassword.getText().toString();
        if ("mavis".equals(username) && "253698".equals(password)) {
//            SharedPreferences settings = getSharedPreferences("atm", MODE_PRIVATE);
//            settings.edit().putString().apply();
//              因為只要用一次，所以直接使用就好。
            getSharedPreferences("atm", MODE_PRIVATE)
                    .edit()
                    .putString("USERNAME" , username)
                    .apply();
            setResult(RESULT_OK);
            finish();
        }else{
            new AlertDialog.Builder(this).setMessage("Wrong user name or wrong password.").setTitle("ERROR!").setPositiveButton("OK!", null).show();

        }
    }
}
