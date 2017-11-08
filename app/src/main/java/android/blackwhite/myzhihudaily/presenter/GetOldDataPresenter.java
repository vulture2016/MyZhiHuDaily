package android.blackwhite.myzhihudaily.presenter;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.bean.News;
import android.blackwhite.myzhihudaily.model.CallBack;
import android.blackwhite.myzhihudaily.model.GetOldDataModel;
import android.blackwhite.myzhihudaily.model.GetOldDataModelImpl;
import android.blackwhite.myzhihudaily.view.OldDataView;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class GetOldDataPresenter extends BasePresenter<OldDataView> {

    private GetOldDataModel mModel;

    public GetOldDataPresenter() {
        mModel = new GetOldDataModelImpl();
    }

    public void requestData(String date) {
        mModel.getOldData(date, new CallBack<List<MultiEntity>>() {
            @Override
            public void showSuccess(List<MultiEntity> bean) {
                mView.updateUI(bean, true);
            }

            @Override
            public void showFail(String errorMsg) {
                mView.showErrorMsg(errorMsg);
            }
        });
    }
}
