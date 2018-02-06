package acitivites;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.takeoffandroid.seatBookingrecyclerView.R;
/**
 * shankar
 ***/
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initSplashScreen();

    }

    private void initSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMainScreen();
            }
        }, 500);
    }

    private void navigateToMainScreen() {
        Intent mSplashIntent = new Intent(SplashActivity.this, TheatersListActivity.class);
        startActivity(mSplashIntent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        finish();
    }
}
