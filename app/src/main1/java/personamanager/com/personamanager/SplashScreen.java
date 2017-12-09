package personamanager.com.personamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by kola on 4/22/16.
 */
public class SplashScreen extends Activity {
    RelativeLayout introMessage;
    DrawerLayout appContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        introMessage = (RelativeLayout) findViewById(R.id.welcome_message_layout);
        appContent = (DrawerLayout) findViewById(R.id.drawer_layout);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
//
//    public void dismisWelcomeMessageBox(View view) {
//        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
//        startActivity(intent);
//        finish();
//
//    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
