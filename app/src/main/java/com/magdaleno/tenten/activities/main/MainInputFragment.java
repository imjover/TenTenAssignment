package com.magdaleno.tenten.activities.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magdaleno.tenten.R;
import com.magdaleno.tenten.base.BaseFragment;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/29/2017.
 */

public class MainInputFragment extends BaseFragment {

    private TextView tv_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_input_frag, container, false);
        tv_input = (TextView) view.findViewById(R.id.tv_input);
        return view;
    }

    public void setInput(String text) {
        tv_input.setText(text);
    }
}
