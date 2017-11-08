package android.blackwhite.myzhihudaily.presenter;

import android.blackwhite.myzhihudaily.bean.StoryContent;
import android.blackwhite.myzhihudaily.model.CallBack;
import android.blackwhite.myzhihudaily.model.GetStoryContentModel;
import android.blackwhite.myzhihudaily.model.GetStoryContentModelImpl;
import android.blackwhite.myzhihudaily.view.StoryContentView;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class GetStoryContentPresenter extends BasePresenter<StoryContentView> {

    private GetStoryContentModel mModel;

    public GetStoryContentPresenter() {
        this.mModel = new GetStoryContentModelImpl();
    }

    public void requestStoryContent(String id) {
        mModel.getStoryContent(id, new CallBack<StoryContent>() {
            @Override
            public void showSuccess(StoryContent bean) {
                mView.updateUI(bean);
            }

            @Override
            public void showFail(String errorMsg) {
                mView.showErrorMsg(errorMsg);
            }
        });
    }
}
