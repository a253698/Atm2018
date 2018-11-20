package mavis.com.atm2018;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    // Alt + Insert

    private Context context;
    String id ;
    String nickname ;
    String gender ;
    int age ;
    SharedPreferences setting ;

    public User(Context context){
        this.context = context;
        setting = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
