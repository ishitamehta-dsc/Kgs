package com.tetravalstartups.kgs.client.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetravalstartups.kgs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FactoriesFragment extends Fragment {

    public FactoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_factories, container, false);
    }
}
