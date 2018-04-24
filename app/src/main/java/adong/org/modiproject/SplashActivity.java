package adong.org.modiproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

import adong.org.modiproject.data.User;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            User user = User.last(User.class);
            if(user != null) {
                Toast.makeText(getApplicationContext(), "자동로그인이 되었습니다.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }else
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        },1500);
    }
}
