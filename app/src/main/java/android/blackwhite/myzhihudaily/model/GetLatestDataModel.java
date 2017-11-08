package android.blackwhite.myzhihudaily.model;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.bean.LatestData;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/16.
 */

public interface GetLatestDataModel {

    void getLatestData(CallBack<List<MultiEntity>> callBack);

}
