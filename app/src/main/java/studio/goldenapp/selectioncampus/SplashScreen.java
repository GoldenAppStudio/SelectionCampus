package studio.goldenapp.selectioncampus;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

;

public class SplashScreen extends AppCompatActivity {

    private TextView t_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        t_login = (TextView) findViewById(R.id.text_splash);

        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/Raleway-ExtraBold.ttf");
        t_login.setTypeface(myCustomFont);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);


                finish();

            }
        }, 2500);
    }
}
