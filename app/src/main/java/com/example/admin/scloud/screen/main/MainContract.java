package com.example.admin.scloud.screen.main;

import com.example.admin.scloud.BasePresenter;
import com.example.admin.scloud.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void showTabLayout();

        void hideTabLayout();
    }

    interface Presenter extends BasePresenter {

    }

}

