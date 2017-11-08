package android.blackwhite.myzhihudaily.model;

import android.blackwhite.myzhihudaily.bean.StoryContent;

/**
 * Created by awzy1 on 2017/9/16.
 */

public interface GetStoryContentModel {

    void getStoryContent(String id, CallBack<StoryContent> callBack);
}
