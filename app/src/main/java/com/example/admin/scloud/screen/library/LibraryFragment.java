package com.example.admin.scloud.screen.library;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.s_cloud.R;
import com.example.admin.scloud.data.model.Track;
import com.example.admin.scloud.data.repository.TrackRepository;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment implements LibraryContract.View {

    private static final int REQUEST_CODE = 1;

    private ArrayList<Track> mTracks = new ArrayList<>();
    private LibraryContract.Presenter mPresenter;
    private LibraryRecyclerAdapter mLibraryRecyclerAdapter;
    private RecyclerView mRecyclerLocalTrack;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        initRecycler(view);
        initPresenter();
        checkForPermission();
        return view;
    }

    private void checkForPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE);
        }
    }

    @Override
    public void showListTrack(List<Track> tracks) {
        mLibraryRecyclerAdapter = new LibraryRecyclerAdapter((ArrayList<Track>) tracks);
        mRecyclerLocalTrack.setAdapter(mLibraryRecyclerAdapter);
    }

    @Override
    public void showNoTrack() {
        Toast.makeText(getContext(),
                getContext().getString(R.string.title_shownotrack), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorNotLoadedTrack() {
        Toast.makeText(getContext(),
                getContext().getString(R.string.title_showerrornotrack), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPresenter.loadListSong();
            } else {

            }
        }
    }

    private void initRecycler(View view) {
        RecyclerView.LayoutManager layoutManager;
        mRecyclerLocalTrack = view.findViewById(R.id.recycler_library);
        mRecyclerLocalTrack.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerLocalTrack.setLayoutManager(layoutManager);
        mLibraryRecyclerAdapter = new LibraryRecyclerAdapter(mTracks);
        mRecyclerLocalTrack.setAdapter(mLibraryRecyclerAdapter);
    }

    private void initPresenter() {
        TrackRepository trackRepository = TrackRepository.getInstance(getContext());
        mPresenter = new LibraryPresenter(trackRepository);
        mPresenter.setView(this);
    }
}
