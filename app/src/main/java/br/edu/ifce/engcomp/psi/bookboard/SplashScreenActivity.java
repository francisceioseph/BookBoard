package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

/**
 * Created by FAMÍLIA on 27/03/2015.
 */
public class SplashScreenActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.tela_abertura);

        Handler splashScreenHandle = new Handler();
        splashScreenHandle.postDelayed(SplashScreenActivity.this,4000);
    }

    public void run(){
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        finish();
    }

}
