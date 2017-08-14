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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {

        mBinding.videoViewWelcome
                .setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));
        mBinding.videoViewWelcome.start();
        mBinding.btnWelcome.setOnClickListener(this);
        mBinding.videoViewWelcome.setOnCompletionListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBinding.videoViewWelcome != null && mBinding.videoViewWelcome.isPlaying()) {
            mBinding.videoViewWelcome.stopPlayback();
        }
    }

    @Override
    public void onClick(View v) {
        if (mBinding.videoViewWelcome != null && mBinding.videoViewWelcome.isPlaying()) {
            mBinding.videoViewWelcome.stopPlayback();
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
