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
    boolean userinfo = false;


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
        if( nickname == null){
            nickname = setting.getString("NICKNAME", null);
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        setting.edit().putString("NICKNAME" , nickname).apply();
        this.nickname = nickname;
    }

    public String getGender() {
        if ( gender == null){
            gender = setting.getString("GENDER" , null);
        }
        return gender;
    }

    public void setGender(String gender) {
        setting.edit().putString("GENDER" , gender).apply();
        this.gender = gender;
    }

    public int getAge() {
        if (age == 0){
            age = setting.getInt("AGE" , 0);
        }
        return age;
    }

    public void setAge(int age) {
        setting.edit().putInt("AGE" , age).apply();
        this.age = age;
    }

    public boolean isUserinfo() {
        userinfo = ( getNickname() != null && getGender() != null && getAge() != 0 );
        return userinfo;
    }

}
