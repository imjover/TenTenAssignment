package com.magdaleno.tenten.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.magdaleno.tenten.R;

/**
 * Created with Android Studio
 *
 * @author: John Oliver "JoVer" Magdaleno
 * @date: 10/5/2016.
 */

public class BaseFragment extends Fragment {

    public static enum MessageType { NEUTRAL, POSITIVE, NEGATIVE }

    private MaterialDialog progressDialog;

    public void showProgressDialog(final int title, final int message, final int icon) {
        dismissProgressDialog();

        this.getActivity().runOnUiThread(
                new Runnable() {
                    public void run() {
                        progressDialog = new MaterialDialog.Builder(getContext())
                                .title(title)
                                .content(getString(message))
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

    public void showMessage(final int message, final MessageType type) {
        showMessage(getString(message), type);
    }
    public void showMessage(final String message, final MessageType type) {

        int icon;
        switch(type) {
            case POSITIVE:
                icon = R.drawable.ic_check;
                break;
            case NEGATIVE:
                icon = R.drawable.ic_close_octagon;
                break;
            default:
//            case NEUTRAL:
                icon = R.drawable.ic_message;
                break;
        }

        new MaterialDialog.Builder(this.getContext())
                .title(R.string.message_lbl)
                .content(message)
                .iconRes(icon)
                .negativeText(R.string.ok_btn)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .cancelable(false)
                .show();
    }
}
