package com.magdaleno.tenten.activities.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magdaleno.tenten.R;
import com.magdaleno.tenten.base.BaseFragment;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/29/2017.
 */

public class MainOutputFragment extends BaseFragment {

    private TextView tv_output;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_output_frag, container, false);
        tv_output = (TextView) view.findViewById(R.id.tv_output);
        return view;
    }

    public void setOutput(String text) {
        tv_output.setText(text);
    }
}
