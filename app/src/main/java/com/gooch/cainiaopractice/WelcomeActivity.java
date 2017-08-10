package com.gooch.cainiaopractice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

import com.gooch.cainiaopractice.base.BaseActivity;
import com.gooch.cainiaopractice.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding> implements OnClickListener,
        OnCompletionListener {

    private ActivityWelcomeBinding welcomeBinding;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        welcomeBinding.videoViewWelcome
                .setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));
        welcomeBinding.videoViewWelcome.start();
        welcomeBinding.btnWelcome.setOnClickListener(this);
        welcomeBinding.videoViewWelcome.setOnCompletionListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (welcomeBinding.videoViewWelcome != null && welcomeBinding.videoViewWelcome.isPlaying()) {
            welcomeBinding.videoViewWelcome.stopPlayback();
        }
    }

    @Override
    public void onClick(View v) {
        if (welcomeBinding.videoViewWelcome != null && welcomeBinding.videoViewWelcome.isPlaying()) {
            welcomeBinding.videoViewWelcome.stopPlayback();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.start();
    }

}
