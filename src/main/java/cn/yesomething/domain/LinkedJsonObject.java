package cn.yesomething.domain;

import java.util.HashMap;

public class LinkedJsonObject {
    private String url;
    private HashMap<String,String> requestMap;

    public LinkedJsonObject() {
    }

    public LinkedJsonObject(String url, HashMap<String, String> requestMap) {
        this.url = url;
        this.requestMap = requestMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(HashMap<String, String> requestMap) {
        this.requestMap = requestMap;
    }
}
