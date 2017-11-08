package android.blackwhite.myzhihudaily.model;

/**
 * Created by awzy1 on 2017/9/16.
 */

public interface CallBack<T> {

    void showSuccess(T bean);

    void showFail(String errorMsg);
}
