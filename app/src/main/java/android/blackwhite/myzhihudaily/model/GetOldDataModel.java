package android.blackwhite.myzhihudaily.model;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.bean.News;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/16.
 */

public interface GetOldDataModel {

    void getOldData(String date, CallBack<List<MultiEntity>> callBack);
}
