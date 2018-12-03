package mavis.com.atm2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BasicActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                if (!user.isUserinfo()) {
                    login = true;
                    Intent nickname = new Intent(this, NicknameActivity.class);
                    startActivity(nickname);
                }
//                若以得到所有資料，下次啟動就不用在輸入。用物件導向之後不用在打那麼多。
//                login = true ;
//                String nickname = getSharedPreferences("user" , MODE_PRIVATE)
//                        .getString("NICKNAME", null);
//                int age = getSharedPreferences("user" , MODE_PRIVATE)
//                        .getInt("AGE" , 0);
//                String gender = getSharedPreferences("user" , MODE_PRIVATE)
//                        .getString("GENDER" , null);
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
        listView();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void listView() {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Guava");
        //類別+s = 工具型
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
        //Adapter 為媒介，從SDK抓資料
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}