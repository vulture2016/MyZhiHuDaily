package android.blackwhite.myzhihudaily.presenter;

import android.blackwhite.myzhihudaily.view.BaseView;

/**
 * Created by awzy1 on 2017/9/16.
 */

public abstract class BasePresenter<T> {

    public T mView;

    public void attach(T view) {
        mView = view;
    }

    public void detach() {
        mView = null;
    }

}
