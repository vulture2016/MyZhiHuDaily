package android.blackwhite.myzhihudaily.adapter;

import android.blackwhite.myzhihudaily.bean.LatestData;
import android.blackwhite.myzhihudaily.bean.Story;
import android.blackwhite.myzhihudaily.bean.TopStoriesBean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by awzy1 on 2017/9/17.
 */

public class MultiEntity implements MultiItemEntity {


    public int type;
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_DATE = 1;
    public static final int TYPE_STORY = 2;

    public MultiEntity(int type) {
        this.type = type;
    }

    public MultiEntity() {
    }


    /**
     * date : 20170916
     * stories : [{"images":["https://pic3.zhimg.com/v2-4b896bb2b168716f8213ee7f633315ca.jpg"],"type":0,"id":9618034,"ga_prefix":"091615","title":"这么一看，古代考秀才可比现在高考难多了"},{"images":["https://pic2.zhimg.com/v2-4d4b2474341c242205e699f8448cfced.jpg"],"type":0,"id":9617915,"ga_prefix":"091614","title":"穷人为什么会贫穷？"},{"images":["https://pic4.zhimg.com/v2-c764e5a62b2af5244eeae4259de317ff.jpg"],"type":0,"id":9615944,"ga_prefix":"091613","title":"从书法的角度告诉你，为什么有些字写小一点好看？"},{"images":["https://pic2.zhimg.com/v2-6e8ed658ffb8c68283f2c79f14ccd1e9.jpg"],"type":0,"id":9617442,"ga_prefix":"091612","title":"大误 · 白听了这么多年《你的背包》"},{"title":"一口咬下去，这就是巴黎的味道","ga_prefix":"091611","images":["https://pic3.zhimg.com/v2-6a0ad5e6e867c2d74e8af60144389152.jpg"],"multipic":true,"type":0,"id":9617810},{"images":["https://pic2.zhimg.com/v2-fb9c310e695026616495a4566b1fedf9.jpg"],"type":0,"id":9615997,"ga_prefix":"091610","title":"「她肯定不知道我在偷偷看她」，答应我，下次可别这么天真了"},{"images":["https://pic4.zhimg.com/v2-54be2c3301521e4606929b74ec0851df.jpg"],"type":0,"id":9613582,"ga_prefix":"091609","title":"阳光、海浪，去日本旅游，这是最最让我难忘的一条路线"},{"images":["https://pic4.zhimg.com/v2-1d7d28c122a3e9c50f27f5716ace7987.jpg"],"type":0,"id":9616423,"ga_prefix":"091608","title":"都打到你家了，还要我们掏护照，是要搞事情吗？"},{"images":["https://pic3.zhimg.com/v2-44c0e20715a30129f6bdae937223a82e.jpg"],"type":0,"id":9614794,"ga_prefix":"091607","title":"研究了一下这位「私募一哥」，发现每天用 12 个小时研究股票都不够"},{"images":["https://pic4.zhimg.com/v2-da96a559f98a2598da16d49e61bf81cb.jpg"],"type":0,"id":9618444,"ga_prefix":"091607","title":"律师事务所有哪些潜规则？"},{"images":["https://pic2.zhimg.com/v2-8357665bab0f153205b177b9ec404139.jpg"],"type":0,"id":9614467,"ga_prefix":"091607","title":"几百年前，人们储存电就跟「把皮卡丘关瓶子里」差不多"},{"images":["https://pic4.zhimg.com/v2-24c4c29414ebf6522d6e3c01b6cb6437.jpg"],"type":0,"id":9617180,"ga_prefix":"091606","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-a871ab31ad226023b38b4ffe30456bf5.jpg","type":0,"id":9617915,"ga_prefix":"091614","title":"穷人为什么会贫穷？"},{"image":"https://pic2.zhimg.com/v2-2cc36b3eade70fe9a199b938af320431.jpg","type":0,"id":9613582,"ga_prefix":"091609","title":"阳光、海浪，去日本旅游，这是最最让我难忘的一条路线"},{"image":"https://pic4.zhimg.com/v2-5162ed499892c79842a348c4f98991cb.jpg","type":0,"id":9614794,"ga_prefix":"091607","title":"研究了一下这位「私募一哥」，发现每天用 12 个小时研究股票都不够"},{"image":"https://pic4.zhimg.com/v2-14fdde5b2bb398e636ea474e3c420d2f.jpg","type":0,"id":9618444,"ga_prefix":"091607","title":"律师事务所有哪些潜规则？"},{"image":"https://pic2.zhimg.com/v2-9dbb02a88569e59fdb6e90c95f58e72d.jpg","type":0,"id":9618002,"ga_prefix":"091519","title":"天上地下，在日本的一些中国人"}]
     */

    private String date;
    private Story stories;
    private List<TopStoriesBean> top_stories;
    private List<String> title;
    private List<String> imgUrl;
    private List<String> topStoriesId;

    public List<String> getTopStoriesId() {
        return topStoriesId;
    }

    public void setTopStoriesId(List<String> topStoriesId) {
        this.topStoriesId = topStoriesId;
    }

    public Story getStories() {
        return stories;
    }

    public void setStories(Story stories) {
        this.stories = stories;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    @Override
    public int getItemType() {
        return type;
    }

    @Override
    public String toString() {
        return "LatestData{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}
