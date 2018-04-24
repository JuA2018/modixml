package adong.org.modiproject.data;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class User extends SugarRecord {
    @SerializedName("data")
    private String username;
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
