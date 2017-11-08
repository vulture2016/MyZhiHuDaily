package android.blackwhite.myzhihudaily.retrofit;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.bean.LatestData;
import android.blackwhite.myzhihudaily.bean.News;
import android.blackwhite.myzhihudaily.bean.StoryContent;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by awzy1 on 2017/9/16.
 */

public interface ApiService {

    //    最新消息
//    URL: http://news-at.zhihu.com/api/4/news/latest
    @GET("api/4/news/latest")
    Observable<LatestData> getLatestData();

    //        过往消息
//    URL: http://news-at.zhihu.com/api/4/news/before/20131119
//    若果需要查询 11 月 18 日的消息，before 后的数字应为 20131119
//    知乎日报的生日为 2013 年 5 月 19 日，若 before 后数字小于 20130520 ，只会接收到空消息
//    输入的今日之后的日期仍然获得今日内容，但是格式不同于最新消息的 JSON 格式
    @GET("api/4/news/before/{date}")
    Observable<News> getOldData(@Path("date") String date);

    //    消息内容获取与离线下载
//    URL: http://news-at.zhihu.com/api/4/news/3892357
//    使用在 最新消息 中获得的 id，拼接在 http://news-at.zhihu.com/api/4/news/ 后，得到对应消息 JSON 格式的内容
    @GET("api/4/news/{id}")
    Observable<StoryContent> getStoryContent(@Path("id") String id);

    @GET("api/4/news/latest")
    Observable<LatestData> getMultiData();
}
