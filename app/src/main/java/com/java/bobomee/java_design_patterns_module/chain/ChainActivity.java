package com.java.bobomee.java_design_patterns_module.chain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.java.bobomee.java_design_patterns_module.BaseActivity;

/**
 * Created on 16/8/18.下午11:46.
 *
 * @author bobomee.
 * @description:
 */
public class ChainActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    Button button = new Button(this);
    button.setText("Click");

    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, 150);

    addContentView(button, params);


    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();

        groupLeader.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        groupLeader.handleRequest(50000);
      }
    });
  }
}
