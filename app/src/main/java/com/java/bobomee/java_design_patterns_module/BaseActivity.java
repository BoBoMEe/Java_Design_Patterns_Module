package com.java.bobomee.java_design_patterns_module;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

/**
 * Created on 16/8/25.下午11:01.
 *
 * @author bobomee.
 * @description:
 */
public class BaseActivity extends AppCompatActivity {

  public BaseActivity mActivity;

  private String mTitle;
  public static final String KEY_TITLE = "KEY_TITLE";

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mActivity = this;

    handleIntent();
  }

  private void handleIntent() {
    Intent intent = getIntent();
    mTitle = intent.getStringExtra(KEY_TITLE);

    if (!TextUtils.isEmpty(mTitle)) {
      setTitle(mTitle);
    }
  }
}
