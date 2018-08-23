package com.example.admin.scloud.data.repository;

import android.content.Context;

import com.example.admin.scloud.data.model.Track;
import com.example.admin.scloud.data.source.TrackDataSource;
import com.example.admin.scloud.data.source.local.TrackLocalDataSource;
import com.example.admin.scloud.data.source.remote.TrackRemoteDataSource;

public class TrackRepository implements TrackDataSource.RemoteDataSource,
        TrackDataSource.LocalDataSource {
    private static TrackRepository sTrackRepository;
    private TrackDataSource.LocalDataSource mLocalDataSource;
    private TrackDataSource.RemoteDataSource mRemoteDataSource;

    public static TrackRepository getInstance(Context context) {
        if (sTrackRepository == null) {
            sTrackRepository = new TrackRepository(
                    TrackLocalDataSource.getInstance(context),
                    (RemoteDataSource) TrackRemoteDataSource.getInstance());
        }
        return sTrackRepository;
    }

    private TrackRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getTracksRemote(String genre,
                                int limit, int offSet, OnFetchDataListener<Track> listener) {
        if (mRemoteDataSource == null) return;
        mRemoteDataSource.getTracksRemote(genre, limit, offSet, listener);
    }

    @Override
    public void searchTracksRemote(String trackName,
                                   int offSet, OnFetchDataListener<Track> listener) {
        if (mRemoteDataSource != null) {
            mRemoteDataSource.searchTracksRemote(trackName, offSet, listener);
        }
    }

    @Override
    public void getTrackLocal(OnFetchDataListener<Track> listener) {
        if (mLocalDataSource != null) {
            mLocalDataSource.getTrackLocal(listener);
        }
    }
}
