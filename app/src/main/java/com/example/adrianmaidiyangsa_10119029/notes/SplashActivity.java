/*  IDENTITAS DIRI :
 *  NIM : 10119029
 *  NAMA : Adrian Maidiyangsa
 *  KELAS : IF-1
 */

package com.example.adrianmaidiyangsa_10119029.notes;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_SCREEN_TIME = 2000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_SCREEN_TIME);
    }
}