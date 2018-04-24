package adong.org.modiproject.data;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Token extends SugarRecord {
    @SerializedName("data")
    private String data;

    public Token(){}

    public Token(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
