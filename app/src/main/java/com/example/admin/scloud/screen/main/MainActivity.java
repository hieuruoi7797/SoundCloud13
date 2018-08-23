package com.example.admin.scloud.screen.main;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.admin.s_cloud.R;
import com.example.admin.scloud.screen.genre.GenreFragment;
import com.example.admin.scloud.screen.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        GenreFragment.OnGenreSelectedListener {

    private static final int REQUEST_CODE = 1;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String s) {
                        return false;
                    }
                }
        );
        return true;
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

    @Override
    public void onGenreSelected(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(mFrameLayoutContainFragment.getId(), fragment)
                .addToBackStack(null)
                .commit();
    }

    private void addFragment() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(mFrameLayoutContainFragment.getId(), mHomeFragment)
                .commit();
    }

    private void initViews() {
        mLayoutPlaying = findViewById(R.id.constraint_playing);
        mFrameLayoutContainFragment = findViewById(R.id.frame_fragment);
        mLayoutPlaying.setOnClickListener(this);
    }
}
