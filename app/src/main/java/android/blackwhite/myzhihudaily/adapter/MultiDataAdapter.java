package android.blackwhite.myzhihudaily.adapter;

import android.blackwhite.myzhihudaily.R;
import android.blackwhite.myzhihudaily.ui.StoryContentActivity;
import android.blackwhite.myzhihudaily.utils.DateFormat;
import android.blackwhite.myzhihudaily.widget.GlideImageLoader;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

import static android.blackwhite.myzhihudaily.adapter.MultiEntity.TYPE_BANNER;
import static android.blackwhite.myzhihudaily.adapter.MultiEntity.TYPE_DATE;
import static android.blackwhite.myzhihudaily.adapter.MultiEntity.TYPE_STORY;

/**
 * Created by awzy1 on 2017/9/17.
 */

public class MultiDataAdapter extends BaseMultiItemQuickAdapter<MultiEntity, BaseViewHolder> {

    private Context mContext;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultiDataAdapter(List<MultiEntity> data, Context context) {
        super(data);
        this.mContext = context;
        addItemType(TYPE_BANNER, R.layout.banner_holder_layout);
        addItemType(TYPE_DATE, R.layout.date_holder_layout);
        addItemType(TYPE_STORY, R.layout.story_holder_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MultiEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_BANNER:
                ((Banner) helper.getView(R.id.banner))
                        .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                        .setImageLoader(new GlideImageLoader())
                        .setDelayTime(3000)
                        .setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                Intent intent = new Intent(mContext, StoryContentActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("id", item.getTopStoriesId().get(position));
                                mContext.startActivity(intent);
                            }
                        })
                        .setImages(item.getImgUrl())
                        .setBannerTitles(item.getTitle())
                        .start();
                break;
            case TYPE_DATE:
                helper.setText(R.id.date_text, DateFormat.format(item.getDate()));
                break;
            case TYPE_STORY:
                helper.setText(R.id.new_title, item.getStories().getTitle());
                if (item.getStories().isMultiPic()) {
                    helper.getView(R.id.isMulti).setVisibility(View.VISIBLE);
                } else {
                    helper.getView(R.id.isMulti).setVisibility(View.GONE);
                }
                Glide.with(mContext).load(item.getStories().getImageUrl()).crossFade()
                        .into((ImageView) helper.getView(R.id.new_image));
                break;
        }
    }
}
