package com.example.admin.scloud.screen.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Track implements Parcelable {
    private int mId;
    private Artist mArtist;
    private String mTitle;
    private String mArtworkURL;
    private String mDownloadURL;
    private int mLikeCount;
    private String mSongURI;
    private int mDuration;


    protected Track(Parcel in) {
        mId = in.readInt();
        mTitle = in.readString();
        mArtworkURL = in.readString();
        mDownloadURL = in.readString();
        mLikeCount = in.readInt();
        mSongURI = in.readString();
        mDuration = in.readInt();
        mArtist.setName(in.readString());
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mTitle);
        parcel.writeString(mArtworkURL);
        parcel.writeString(mDownloadURL);
        parcel.writeInt(mLikeCount);
        parcel.writeString(mSongURI);
        parcel.writeInt(mDuration);
        parcel.writeString(mArtist.getName());
    }

    public Track() {
        mArtworkURL = "";
        mDownloadURL = "";
        mDuration = 0;
        mId = 0;
        mArtist = new Artist();
        mLikeCount = 0;
        mTitle = "";
        mSongURI = "";

    }

    public void setId(int id) {
        mId = id;
    }

    public void setArtist(String artistName) {
        mArtist.setName(artistName);
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setArtworkURL(String artworkURL) {
        mArtworkURL = artworkURL;
    }

    public void setDownloadURL(String downloadURL) {
        mDownloadURL = downloadURL;
    }

    public void setLikeCount(int likeCount) {
        mLikeCount = likeCount;
    }

    public void setSongURI(String songURI) {
        mSongURI = songURI;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getId() {
        return mId;
    }

    public Artist getArtist() {
        return mArtist;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtworkURL() {
        return mArtworkURL;
    }

    public String getDownloadURL() {
        return mDownloadURL;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public String getSongURI() {
        return mSongURI;
    }

    public int getDuration() {
        return mDuration;
    }

    public static Creator<Track> getCREATOR() {
        return CREATOR;
    }

    public static class TrackEntity {
        public static final String COLLECTION = "collection";
        public static final String ARTWORK_URL = "artwork_url";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String DURATION = "duration";
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String SONGURI = "uri";
        public static final String USER = "user";
        public static final String TRACK = "track";
        public static final String USERNAME = "username";
        public static final String LIKES_COUNT = "likes_count";
        public static final String AVATAR_URL = "avatar_url";
        public static final String LARGE_IMAGE_SIZE = "large";
        public static final String BETTER_IMAGE_SIZE = "original";
    }
}
