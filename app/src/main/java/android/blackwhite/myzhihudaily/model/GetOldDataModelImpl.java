package android.blackwhite.myzhihudaily.model;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.bean.LatestData;
import android.blackwhite.myzhihudaily.bean.News;
import android.blackwhite.myzhihudaily.bean.Story;
import android.blackwhite.myzhihudaily.retrofit.ApiService;
import android.blackwhite.myzhihudaily.retrofit.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class GetOldDataModelImpl implements GetOldDataModel {

    @Override
    public void getOldData(String date, final CallBack<List<MultiEntity>> callBack) {
        RetrofitUtil.getInstance()
                .getRetrofit()
                .create(ApiService.class)
                .getOldData(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<News, List<MultiEntity>>() {
                    @Override
                    public List<MultiEntity> call(News data) {
                        List<MultiEntity> multiEntityList = new ArrayList<>();
                        MultiEntity multiEntity = new MultiEntity();
                        multiEntity.setDate(data.getDate());
                        multiEntity.type = MultiEntity.TYPE_DATE;
                        multiEntityList.add(multiEntity);
                        for (Story story : data.getStories()) {
                            multiEntity = new MultiEntity();
                            multiEntity.setStories(story);
                            multiEntity.type = MultiEntity.TYPE_STORY;
                            multiEntityList.add(multiEntity);
                        }
                        return multiEntityList;
                    }
                })
                .subscribe(new Subscriber<List<MultiEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<MultiEntity> news) {
                        callBack.showSuccess(news);
                    }
                });
    }
}
