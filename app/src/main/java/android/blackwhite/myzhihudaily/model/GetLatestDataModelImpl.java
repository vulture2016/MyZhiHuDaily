package android.blackwhite.myzhihudaily.model;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.bean.LatestData;
import android.blackwhite.myzhihudaily.bean.Story;
import android.blackwhite.myzhihudaily.bean.TopStoriesBean;
import android.blackwhite.myzhihudaily.retrofit.ApiService;
import android.blackwhite.myzhihudaily.retrofit.RetrofitUtil;
import android.blackwhite.myzhihudaily.view.LatestDataView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class GetLatestDataModelImpl implements GetLatestDataModel {

    @Override
    public void getLatestData(final CallBack<List<MultiEntity>> callBack) {
        RetrofitUtil.getInstance()
                .getRetrofit()
                .create(ApiService.class)
                .getLatestData()
                .map(new Func1<LatestData, List<MultiEntity>>() {
                    @Override
                    public List<MultiEntity> call(LatestData data) {
                        List<MultiEntity> multiEntityList = new ArrayList<>();
                        MultiEntity multiEntity = new MultiEntity();
                        multiEntity.type = MultiEntity.TYPE_BANNER;
                        List<String> title = new ArrayList<>();
                        List<String> imgUrl = new ArrayList<>();
                        List<String> topStoriesId = new ArrayList<>();
                        for (TopStoriesBean story : data.getTop_stories()) {
                            title.add(story.getTitle());
                            imgUrl.add(story.getImage());
                            topStoriesId.add(story.getId());
                        }
                        multiEntity.setTitle(title);
                        multiEntity.setImgUrl(imgUrl);
                        multiEntity.setTopStoriesId(topStoriesId);
                        multiEntityList.add(multiEntity);
                        multiEntity = new MultiEntity();
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MultiEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<MultiEntity> latestData) {
                        callBack.showSuccess(latestData);
                    }
                });
    }
}
