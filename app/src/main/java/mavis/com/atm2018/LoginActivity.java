package mavis.com.atm2018;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText edusername;
    private EditText edpassword;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();
//        edusername = findViewById(R.id.ed_userName);
        String username = getSharedPreferences("atm", MODE_PRIVATE).getString("USERNAME" , " ");
        edusername.setText(username);
        //用空字串，第一次登入才不會產生null
    }
    public void login(View view) {
        Log.d("LoginActivity", "login");
        findView();
        username = edusername.getText().toString();
        password = edpassword.getText().toString();
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
            new AlertDialog.Builder(this)
                    .setMessage("Wrong user name or wrong password.")
                    .setTitle("ERROR!")
                    .setPositiveButton("OK!", null)
                    .show();

        }
    }

    private void findView() {
        edusername = findViewById(R.id.ed_userName);
        edpassword = findViewById(R.id.ed_password);
    }
}
