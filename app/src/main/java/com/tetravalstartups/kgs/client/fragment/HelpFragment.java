package com.tetravalstartups.kgs.client.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tetravalstartups.kgs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment implements View.OnClickListener {
    private ImageView ivBack;
    private View view;
    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_help, container, false);
        initView();
        return view;

    }

    private void initView() {
        ivBack = view.findViewById(R.id.ivBack);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ivBack){
            getActivity().onBackPressed();
        }
    }
}
