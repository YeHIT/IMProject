package cn.yesomething.domain;

import java.util.Arrays;

//用于保存用户关键字及词云地址
public class TagsKeeper {
    String[] tags;
    String wordCloudPictureUrl;

    public TagsKeeper() {
    }

    public TagsKeeper(String[] tags, String wordCloudPictureUrl) {
        this.tags = tags;
        this.wordCloudPictureUrl = wordCloudPictureUrl;
    }

    @Override
    public String toString() {
        return "TagsKeeper{" +
                "tags=" + Arrays.toString(tags) +
                ", wordCloudPictureUrl='" + wordCloudPictureUrl + '\'' +
                '}';
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getWordCloudPictureUrl() {
        return wordCloudPictureUrl;
    }

    public void setWordCloudPictureUrl(String wordCloudPictureUrl) {
        this.wordCloudPictureUrl = wordCloudPictureUrl;
    }
}
