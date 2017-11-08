package android.blackwhite.myzhihudaily.ui;

import android.blackwhite.myzhihudaily.R;
import android.blackwhite.myzhihudaily.adapter.MultiDataAdapter;
import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.presenter.GetLatestDataPresenter;
import android.blackwhite.myzhihudaily.presenter.GetOldDataPresenter;
import android.blackwhite.myzhihudaily.view.LatestDataView;
import android.blackwhite.myzhihudaily.view.OldDataView;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.blackwhite.myzhihudaily.adapter.MultiEntity.TYPE_DATE;
import static android.blackwhite.myzhihudaily.adapter.MultiEntity.TYPE_STORY;

public class MainActivity extends AppCompatActivity implements LatestDataView, OldDataView, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {

    GetLatestDataPresenter mLDPresenter;
    GetOldDataPresenter mODPresenter;
    private RecyclerView mRecyclerView;
    private MultiDataAdapter mAdapter;
    private List<MultiEntity> mMultiDataList;
    private String date;
    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLDPresenter = new GetLatestDataPresenter();
        mLDPresenter.attach(this);
        mLDPresenter.requestData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mMultiDataList = new ArrayList<>();
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setBackgroundResource(R.color.colorPrimary);
        mToolbar.setTitle("知乎日报");
        setSupportActionBar(mToolbar);

        mSwipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mLDPresenter.requestData();
            }
        });


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mAdapter = new MultiDataAdapter(mMultiDataList, getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.openLoadAnimation();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void updateUI(List<MultiEntity> data) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).type == TYPE_DATE) {
                date = data.get(i).getDate();
            }
        }

        mMultiDataList.clear();
        //TODO 先清除数据 不然会导致今天若是还没更新数据 则会加载两次Latest数据

        mSwipeRefreshLayout.setRefreshing(false);
        System.out.println("DATE = " + date);
        mMultiDataList.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMoreRequested() {
        if (mODPresenter == null) {
            mODPresenter = new GetOldDataPresenter();
            mODPresenter.attach(this);
        }
        //加载往日新闻
        mODPresenter.requestData(date);

    }

    @Override
    public void updateUI(List<MultiEntity> data, boolean isOld) {
        date = data.get(0).getDate();
        mMultiDataList.addAll(data);
        mAdapter.loadMoreComplete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLDPresenter != null) {
            mLDPresenter.detach();
        }
        if (mODPresenter != null) {
            mODPresenter.detach();
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        for (int i = 0; i < mMultiDataList.size(); i++) {
            if (mMultiDataList.get(position).type == TYPE_STORY) {
                String id = mMultiDataList.get(position).getStories().getId();
                Intent intent = new Intent(this, StoryContentActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                return;
            }
        }
    }


}
