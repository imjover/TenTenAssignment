package com.magdaleno.tenten.base;

import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/2/2017.
 */

public class FragmentProgressDialog extends BaseFragment {

    private MaterialDialog progressDialog;

    public void showProgressDialog(@NonNull final int message) {
        dismissProgressDialog();

        this.getActivity().runOnUiThread(
                new Runnable() {
                    public void run() {
                        progressDialog = new MaterialDialog.Builder(getContext())
                                .content(message)
                                .progress(true, 0)
                                .progressIndeterminateStyle(true)
                                .cancelable(false)
                                .show();
                    }
                }
        );
    }

    public void showProgressDialog(@NonNull final int title, @NonNull final int message) {
        dismissProgressDialog();

        this.getActivity().runOnUiThread(
                new Runnable() {
                    public void run() {
                        progressDialog = new MaterialDialog.Builder(getContext())
                                .title(title)
                                .content(message)
                                .progress(true, 0)
                                .progressIndeterminateStyle(true)
                                .cancelable(false)
                                .show();
                    }
                }
        );
    }

    public void showProgressDialog(@NonNull final int title, @NonNull final int message, @NonNull final int icon) {
        dismissProgressDialog();

        this.getActivity().runOnUiThread(
                new Runnable() {
                    public void run() {
                        progressDialog = new MaterialDialog.Builder(getContext())
                                .title(title)
                                .content(message)
                                .iconRes(icon)
                                .progress(true, 0)
                                .progressIndeterminateStyle(true)
                                .cancelable(false)
                                .show();
                    }
                }
        );
    }

    public void dismissProgressDialog() {
        if(progressDialog!=null)
            progressDialog.dismiss();
    }
}
