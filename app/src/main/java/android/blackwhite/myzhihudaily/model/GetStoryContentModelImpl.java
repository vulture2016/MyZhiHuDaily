package android.blackwhite.myzhihudaily.model;

import android.blackwhite.myzhihudaily.bean.StoryContent;
import android.blackwhite.myzhihudaily.retrofit.ApiService;
import android.blackwhite.myzhihudaily.retrofit.RetrofitUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class GetStoryContentModelImpl implements GetStoryContentModel {

    @Override
    public void getStoryContent(String id, final CallBack<StoryContent> callBack) {
        RetrofitUtil.getInstance()
                .getRetrofit()
                .create(ApiService.class)
                .getStoryContent(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<StoryContent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showFail(e.getMessage());
                    }

                    @Override
                    public void onNext(StoryContent storyContent) {
                        callBack.showSuccess(storyContent);
                    }
                });
    }
}
