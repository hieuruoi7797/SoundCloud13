package com.example.admin.scloud.screen.main;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.admin.s_cloud.R;
import com.example.admin.scloud.screen.home.HomeFragment;
import com.example.admin.scloud.screen.search.SearchFragment;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener,
        SearchView.OnQueryTextListener, TabLayout.OnTabSelectedListener {

    private ConstraintLayout mLayoutPlaying;
    private FrameLayout mFrameLayoutContainFragment;
    private HomeFragment mHomeFragment;
    private SearchFragment mSearchFragment;
    private ProgressBar mProgressBar;
    private TabLayout mTabLayout;

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
        initializeSearchView(menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initializeSearchView(Menu menu) {
        mTabLayout = mHomeFragment.getTabLayout();
        MenuItem searchMenu = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchMenu.getActionView();
        searchView.setQueryHint(getString(R.string.message_finding_tracks));
        searchView.setOnQueryTextListener(this);
        searchMenu.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                hideTabLayout();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                showTabLayout();
                return true;
            }
        });
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
                .commit();
    }

    private void initViews() {
        mLayoutPlaying = findViewById(R.id.constraint_playing);
        mFrameLayoutContainFragment = findViewById(R.id.frame_fragment);
        mLayoutPlaying.setOnClickListener(this);
        mProgressBar = findViewById(R.id.progress_loading);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        if (mSearchFragment == null) return false;

        mSearchFragment.submitQueryText(s);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void showTabLayout() {
        mTabLayout.setVisibility(View.VISIBLE);
        closeSearchFragment();
    }

    private void closeSearchFragment() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void hideTabLayout() {
        mTabLayout.setVisibility(View.GONE);
        openSearchFragment();
    }

    private void openSearchFragment() {
        mSearchFragment = SearchFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.layout_main, mSearchFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
