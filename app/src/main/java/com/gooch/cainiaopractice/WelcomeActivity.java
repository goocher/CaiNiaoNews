package com.gooch.cainiaopractice;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.gooch.cainiaopractice.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity implements OnClickListener,
    OnCompletionListener {

  private ActivityWelcomeBinding welcomeBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    welcomeBinding = DataBindingUtil
        .setContentView(this, R.layout.activity_welcome);
    welcomeBinding.videoViewWelcome
        .setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kr36));
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
  }

  @Override
  public void onCompletion(MediaPlayer mp) {
    mp.start();
  }

}
