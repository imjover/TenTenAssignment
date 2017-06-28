package com.magdaleno.tenten.activities.main;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.base.BaseFragment;
import com.magdaleno.tenten.base.BasePresenter;
import com.magdaleno.tenten.base.BaseView;
import com.magdaleno.tenten.util.computer.Output;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public interface MainContract {

    /**
     * This is the contract for the View
     */
    interface View extends BaseView<Presenter> {
        void showMessage(int message, BaseFragment.MessageType type);
        void showMessage(String message, BaseFragment.MessageType type);
        void showProgressDialog(final int title, final int message, final int icon);
        void dismissProgressDialog();
        void showOutput(Output output);
    }

    /**
     * This is the contract for the Presenter
     */
    interface Presenter extends BasePresenter {
        void run();
    }
}
