package com.magdaleno.tenten.activities.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.magdaleno.tenten.R;
import com.magdaleno.tenten.base.BaseFragment;
import com.magdaleno.tenten.base.dynamicviewpager.ViewPagerAdapter;
import com.magdaleno.tenten.base.dynamicviewpager.WrappingViewPager;
import com.magdaleno.tenten.util.computer.Output;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class MainFragment extends BaseFragment implements MainContract.View, View.OnClickListener {

    private MainContract.Presenter mPresenter;

    private Button btn_run;
    private MainInputFragment f_input;
    private MainOutputFragment f_output;

    private WrappingViewPager viewPager;
    private TabLayout tabLayout;

    public MainFragment() {
        // Requires empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag, container, false);

        btn_run = (Button) view.findViewById(R.id.btn_run);
        btn_run.setOnClickListener(this);

        // Setup Tab
        viewPager = (WrappingViewPager) view.findViewById(R.id.viewpager);
        // Setup ViewPager;
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getFragmentManager());

        f_input = new MainInputFragment();
        f_output = new MainOutputFragment();
        adapter.addFragment(f_input, getString(R.string.input_lbl));
        adapter.addFragment(f_output, getString(R.string.output_lbl));

        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_run:
                mPresenter.run();
                break;
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }

    /**
     * Display the output of the program.
     * @param output
     */
    @Override
    public void showOutput(Output output) {
        f_output.setOutput(output.toString());
        // Display Output Tab
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
    }
}
