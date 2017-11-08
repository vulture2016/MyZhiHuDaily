package android.blackwhite.myzhihudaily.presenter;

import android.blackwhite.myzhihudaily.adapter.MultiEntity;
import android.blackwhite.myzhihudaily.model.CallBack;
import android.blackwhite.myzhihudaily.model.GetLatestDataModel;
import android.blackwhite.myzhihudaily.model.GetLatestDataModelImpl;
import android.blackwhite.myzhihudaily.view.LatestDataView;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class GetLatestDataPresenter extends BasePresenter<LatestDataView> {

    private GetLatestDataModel mModel;

    public GetLatestDataPresenter() {
        mModel = new GetLatestDataModelImpl();
    }

    public void requestData() {
        mModel.getLatestData(new CallBack<List<MultiEntity>>() {
            @Override
            public void showSuccess(List<MultiEntity> bean) {
                mView.updateUI(bean);
            }

            @Override
            public void showFail(String errorMsg) {
                mView.showErrorMsg(errorMsg);
            }
        });
    }
}
