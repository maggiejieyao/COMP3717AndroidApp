package ca.bcit.explorenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Add animation to splash page icon
        iv = (ImageView)findViewById(R.id.splash_icon);
        Animation splash_anim = AnimationUtils.loadAnimation(this,R.anim.splash_transition_anim);
        iv.startAnimation(splash_anim);

        //Point to main page after loading 2000
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run (){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
