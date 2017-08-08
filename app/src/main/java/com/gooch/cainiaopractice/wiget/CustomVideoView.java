package com.gooch.cainiaopractice.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * <pre>
 * author : gooch
 * e-mail : zhaoguangchao@100tal.com
 * time   : 2017/8/8
 * desc   :
 * version: 1.0
 * </pre>
 */


public class CustomVideoView extends VideoView {

  public CustomVideoView(Context context) {
    super(context);
  }

  public CustomVideoView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width = getDefaultSize(0, widthMeasureSpec);
    int height = getDefaultSize(0, heightMeasureSpec);
    setMeasuredDimension(width, height);
  }
}
