package mavis.com.atm2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BasicActivity {

    private EditText edage;

    int[] age = {19, 20, 21, 22, 23, 24, 25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }

    public void agenext(View view){
        Log.d("AgeActivity", "agenext");
        edage = findViewById(R.id.ed_age);
        int age = Integer.parseInt(edage.getText().toString());
        user.setAge(age);
//        getSharedPreferences("user" , MODE_PRIVATE)
//                .edit()
//                .putInt("AGE", 20)
//                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        finish();
    }

    //list 是舊的 後來新增了RecyclerView取代 並且需要使用 <<1>>Adapter  (繼承RecylerView.Adapter) 還需要使用抽象類別abstract class
    //每一列都需要一個viewHolder()
    //含需要一個 <<2>>ViewHolder  並且繼承 RecylerViewHolder
    // 先 Adapter  -> ViewHolder  -> extends RecylerView.Adapter<> ->

    // <<1 class>> <3 extends>
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder>{
        @NonNull
        @Override
        public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull AgeViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        //<<2 class>>
        class AgeViewHolder extends RecyclerView.ViewHolder{
            TextView ageView;
            public AgeViewHolder(View itemView) {
                super(itemView);
                ageView = itemView.findViewById(R.id.age_tv);
                //先建立layout拉元件，定位 ewHolder類別中建立屬性(配合layout元件)，建立建構子，使用itemView.findViewById()。
                //如果直接用findViewById會直接在activity_age裡面去做尋找，所以要先itemView
            }
        }
    }
}
