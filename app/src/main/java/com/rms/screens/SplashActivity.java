package com.rms.screens;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.rms.R;

/**
 * Created by Ashish on 9/13/2016.
 */
public class SplashActivity extends AppCompatActivity {

    AnimatorSet set;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_page);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        }, 2000);
    }

    public void onStart() {
        super.onStart();
        ImageView imgView = (ImageView) findViewById(R.id.image);
        set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.wave);
        set.setTarget(imgView);
        set.start();
    }
}
