package android.blackwhite.myzhihudaily.adapter;

import android.app.Activity;
import android.blackwhite.myzhihudaily.R;
import android.blackwhite.myzhihudaily.bean.LatestData;
import android.blackwhite.myzhihudaily.bean.Story;
import android.blackwhite.myzhihudaily.retrofit.RetrofitApplication;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/16.
 */

public class LatestDataAdapter extends BaseQuickAdapter<Story, BaseViewHolder> {

    private Context mContext;

    public LatestDataAdapter(int layoutResId, @Nullable List<Story> data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Story item) {
        helper.setText(R.id.new_title, item.getTitle());
        if (item.isMultiPic()) {
            helper.getView(R.id.isMulti).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.isMulti).setVisibility(View.GONE);
        }
        Glide.with(mContext).load(item.getImageUrl()).crossFade().into((ImageView) helper.getView(R.id.new_image));
    }

}
