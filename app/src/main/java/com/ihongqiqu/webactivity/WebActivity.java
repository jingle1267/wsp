package com.ihongqiqu.webactivity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.ihognqiqu.kv.KeyValueUtil;
import com.ihognqiqu.wsp.R;
import com.ihognqiqu.wsp.common.CopyOfStringUtil;
import com.ihognqiqu.wsp.target.jianshu.JSCommon;

public class WebActivity extends AppCompatActivity implements WebFragment.OnWebViewChangeListener {

    private WebFragment mWebFragment;
    private ProgressBar mProgressBar;

    /**
     * 启动 Web 容器页面
     *
     * @param from
     * @param url  URL 链接
     */
    public static void launch(@NonNull Activity from, @NonNull String url, String title) {
        Intent intent = new Intent(from, WebActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        from.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mProgressBar = findViewById(R.id.pb_web);
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");

        setTitle(title);

        mWebFragment = WebFragment.newInstance(url);
        mWebFragment.setListener(this);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_web, mWebFragment);
        transaction.commit();
    }

    @Override
    public void onWebViewTitleChanged(String title) {
        setTitle(title);
    }

    @Override
    public void onWebViewProgressChanged(int newProgress) {
        if (newProgress >= 100) {
            mProgressBar.setVisibility(View.GONE);
        } else {
            if (mProgressBar.getVisibility() == View.GONE) {
                mProgressBar.setVisibility(View.VISIBLE);
            }
            mProgressBar.setProgress(newProgress);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.web_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (!mWebFragment.onBackPressed()) {
                    super.onBackPressed();
                }
                this.finish(); // back button
                return true;
            case R.id.action_add:
                Toast.makeText(this, "Compose", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_save:
                String value = CopyOfStringUtil.map2str(JSCommon.getHeaders("", 1));
                KeyValueUtil.insertOrUpdate("jscookie", value);
                Toast.makeText(this, "Save Success!", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
