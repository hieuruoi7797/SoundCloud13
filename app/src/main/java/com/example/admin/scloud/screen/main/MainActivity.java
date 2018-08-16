package com.example.admin.scloud.screen.main;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.admin.s_cloud.R;
import com.example.admin.scloud.screen.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout mLayoutPlaying;
    private FrameLayout mFrameLayoutContainFragment;
    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        addFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //click at playing layout
            case R.id.constraint_playing:
                break;
            //click at button play/pause
            case R.id.button_main_change_state:
                break;
        }
    }

    private void addFragment() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(mFrameLayoutContainFragment.getId(), mHomeFragment)
                .addToBackStack(null)
                .commit();
    }

    private void initViews() {
        mLayoutPlaying = findViewById(R.id.constraint_playing);
        mFrameLayoutContainFragment = findViewById(R.id.frame_fragment);
        mLayoutPlaying.setOnClickListener(this);
    }
}