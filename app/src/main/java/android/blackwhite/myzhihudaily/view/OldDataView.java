package android.blackwhite.myzhihudaily.view;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/16.
 */

public interface OldDataView extends BaseView {

    void updateUI(List<MultiEntity> data, boolean isOld);
}
