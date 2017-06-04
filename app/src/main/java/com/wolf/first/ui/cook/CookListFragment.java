package com.wolf.first.ui.cook;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.first.R;
import com.wolf.first.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CookListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CookListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CookListFragment extends BaseFragment {
    private String mParam2;


    public CookListFragment() {
        // Required empty public constructor
    }

    public static CookListFragment newInstance(String param1, String param2) {
        CookListFragment fragment = new CookListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initPresenter() {

    }

    @Override
    public int setContent() {
        return R.layout.fragment_cook_list;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
