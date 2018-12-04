package mavis.com.atm2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BasicActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;

    List<String> fruits = Arrays.asList("Banana", "Apple", "Guava");

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
       // listView();
        List<String> fruits = Arrays.asList("Banana", "Apple", "Guava");
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FruitAdapter());
    }

    //<<1 class >> <3 extends>
    public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
        @NonNull
        @Override
        public FruitAdapter.FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull FruitAdapter.FruitViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }

        //<<2 class>>
        class FruitViewHolder extends RecyclerView.ViewHolder {
            TextView fruitname;
            public FruitViewHolder(View itemView) {
                super(itemView);
                fruitname = itemView.findViewById(android.R.id.text1);
                //先建立layout拉元件，定位 ewHolder類別中建立屬性(配合layout元件)，建立建構子，使用itemView.findViewById()。
                //如果直接用findViewById會直接在activity_age裡面去做尋找，所以要先itemView
            }
        }
    }

    //list 是舊的 後來新增了RecyclerView取代 並且需要使用 <<1>>Adapter  (繼承RecylerView.Adapter) 還需要使用抽象類別abstract class
    //每一列都需要一個viewHolder()
    //含需要一個 <<2>>ViewHolder  並且繼承 RecylerViewHolder

    private void listView() {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Guava");
        //類別+s = 工具型
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
        //Adapter 為媒介，從SDK抓資料
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}