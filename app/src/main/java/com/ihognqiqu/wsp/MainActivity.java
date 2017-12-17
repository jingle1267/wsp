package com.ihognqiqu.wsp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.ihognqiqu.wsp.target.jianshu.JSConstants;
import com.ihognqiqu.wsp.target.jianshu.JianShuFacade;
import com.ihongqiqu.webactivity.WebActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickJianshuLogin(View view) {
        WebActivity.launch(this, JSConstants.JSLoginURL, "");
    }

    public void onClickJianshu(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new JianShuFacade().autoCommment("Android Architecture Components之LiveData", 1);
            }
        }).start();
    }

}
