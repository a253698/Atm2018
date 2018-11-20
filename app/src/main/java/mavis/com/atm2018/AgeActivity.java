package mavis.com.atm2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    private EditText edage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }

    public void agenext(View view){
        Log.d("AgeActivity", "agenext");
        edage = findViewById(R.id.ed_age);
        String age = edage.getText().toString();
        getSharedPreferences("user" , MODE_PRIVATE)
                .edit()
                .putString("AGE", age)
                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }
}
