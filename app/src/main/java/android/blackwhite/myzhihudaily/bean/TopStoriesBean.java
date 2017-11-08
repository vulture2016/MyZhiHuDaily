package android.blackwhite.myzhihudaily.bean;

/**
 * Created by awzy1 on 2017/9/17.
 */

public class TopStoriesBean {
    /**
     * image : https://pic2.zhimg.com/v2-a871ab31ad226023b38b4ffe30456bf5.jpg
     * type : 0
     * id : 9617915
     * ga_prefix : 091614
     * title : 穷人为什么会贫穷？
     */
    private String image;
    private int type;
    private String id;
    private String ga_prefix;
    private String title;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TopStoriesBean{" +
                "image='" + image + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
