package android.blackwhite.myzhihudaily.ui;

import android.blackwhite.myzhihudaily.R;
import android.blackwhite.myzhihudaily.bean.StoryContent;
import android.blackwhite.myzhihudaily.presenter.GetStoryContentPresenter;
import android.blackwhite.myzhihudaily.view.StoryContentView;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

public class StoryContentActivity extends AppCompatActivity implements StoryContentView, View.OnClickListener {

    private GetStoryContentPresenter mPresenter;
    private WebView mWebView;
    private ImageView mTitleImageView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mPresenter = new GetStoryContentPresenter();
        mPresenter.attach(this);
        String id = getIntent().getStringExtra("id");
        mPresenter.requestStoryContent(id);

        mWebView = (WebView) findViewById(R.id.web_view);
        mTitleImageView = (ImageView) findViewById(R.id.backdrop);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void updateUI(StoryContent content) {

        Glide.with(this).load(content.getImageUrl()).into(mTitleImageView);

        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle(content.getTitle());
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(this);

        //初始化WebView
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        //设置数据
        String formatCss = String.format("<link href=\"%s\" rel=\"stylesheet\" type=\"text/css\"/>", content.getCss().get(0));
        String formatHtml = content.getBody().replace("class=\"img-place-holder\"", "class=\"img-place-holder-ignored\"");
        mWebView.loadData(formatCss + formatHtml, "text/html; charset=UTF-8", null);
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
