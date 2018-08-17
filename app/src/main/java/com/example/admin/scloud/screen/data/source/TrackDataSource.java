package com.example.admin.scloud.screen.data.source;

import com.example.admin.scloud.screen.data.model.Track;

import java.util.List;

public interface TrackDataSource {

    //    local data
    interface LocalDataSource extends TrackDataSource {

    }

//    remote data

    interface RemoteDataSource extends TrackDataSource {
        void getTracksRemote(String genre, int limit, int offSet,
                             OnFetchDataListener<Track> listener);

        void searchTracksRemote(String trackName, int offSet, OnFetchDataListener<Track> listener);
    }

    interface OnFetchDataListener<T> {
        void onFectDataSuccess(List<T> data);

        void onFectDataFailure(String massage);
    }

}
