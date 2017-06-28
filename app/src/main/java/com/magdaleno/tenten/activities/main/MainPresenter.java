package com.magdaleno.tenten.activities.main;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.R;
import com.magdaleno.tenten.activities.main.usecase.LoadComputerCommands;
import com.magdaleno.tenten.base.BaseFragment;
import com.magdaleno.tenten.base.UseCase;
import com.magdaleno.tenten.base.UseCaseHandler;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private UseCaseHandler mUseCaseHandler;
    private LoadComputerCommands mLoadComputerCommands;

    public MainPresenter(@NonNull MainContract.View view,
                         @NonNull UseCaseHandler useCaseHandler,
                         @NonNull LoadComputerCommands loadComputerCommands) {
        this.mView = checkNotNull(view);
        mView.setPresenter(this);
        this.mUseCaseHandler = checkNotNull(useCaseHandler);
        this.mLoadComputerCommands = checkNotNull(loadComputerCommands);
    }

    @Override
    public void start() {
    }

    @Override
    public void run() {
        mView.showProgressDialog(R.string.running_lbl, R.string.please_wait_msg, R.drawable.ic_code);

        LoadComputerCommands.RequestValues requestValue = new LoadComputerCommands.RequestValues();
        mUseCaseHandler.execute(mLoadComputerCommands, requestValue,
                new UseCase.UseCaseCallback<LoadComputerCommands.ResponseValue>() {
                    @Override
                    public void onFinish(LoadComputerCommands.ResponseValue response) {
                        mView.showOutput(response.getOutput());
                        mView.dismissProgressDialog();
                    }

                    @Override
                    public void onError() {
                        // The view may not be able to handle UI updates anymore
                        mView.dismissProgressDialog();
                        mView.showMessage(R.string.error_msg, BaseFragment.MessageType.NEGATIVE);
                    }

                    @Override
                    public void onError(String message) {
                        mView.dismissProgressDialog();
                        mView.showMessage(message, BaseFragment.MessageType.NEGATIVE);
                    }
                });
    }
}
