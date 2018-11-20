package mavis.com.atm2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if (resultCode != RESULT_OK){
                finish();
            } else {
               //若以得到所有資料，下次啟動就不用在輸入。
                login = true ;
                String nickname = getSharedPreferences("user" , MODE_PRIVATE)
                        .getString("NICKNAME", null);
                int age = getSharedPreferences("user" , MODE_PRIVATE)
                        .getInt("AGE" , 0);
                String gender = getSharedPreferences("user" , MODE_PRIVATE)
                        .getString("GENDER" , null);

                if(nickname == null || age == 0 || gender == null){
                    Intent nick = new Intent(this,NicknameActivity.class);
                    startActivity(nick);
                }
            }
        }
    }

    // ctrl + O 修改父類別
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }
    }
}