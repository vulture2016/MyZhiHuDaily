package android.blackwhite.myzhihudaily.retrofit;

import org.litepal.LitePalApplication;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class RetrofitApplication extends LitePalApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitUtil.getInstance().init(getApplicationContext());
    }
}
