package com.example.admin.scloud.screen;


import com.example.admin.scloud.data.model.Track;

import java.util.List;

public interface TrackListener {

    void onPlayTrack(int position, List<Track> tracks);

    void onAddToNextUp(Track track);

    void onDownloadTrack(Track track);
}
