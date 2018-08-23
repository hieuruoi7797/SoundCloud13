package com.example.admin.scloud.data.model;

public class Genre {
    private String mName;
    private int mImagerResource;
    private int mTitleResource;

    public Genre(String name, int titleResource, int imagerResource) {
        mName = name;
        mImagerResource = imagerResource;
        mTitleResource = titleResource;
    }

    public Genre() {
    }

    public int getTitleResource() {
        return mTitleResource;
    }

    public void setTitleResource(int titleResource) {
        mTitleResource = titleResource;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setImagerResource(int imagerResource) {
        mImagerResource = imagerResource;
    }

    public String getApiName() {
        return mName;
    }

    public int getImagerResource() {
        return mImagerResource;
    }
}
