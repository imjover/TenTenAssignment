package com.magdaleno.tenten.activities.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magdaleno.tenten.R;
import com.magdaleno.tenten.base.BaseFragment;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class MainFragment extends BaseFragment implements MainContract.View {

    private MainContract.Presenter mPresenter;

    public MainFragment() {
        // Requires empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_frag, container, false);
        return view;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
