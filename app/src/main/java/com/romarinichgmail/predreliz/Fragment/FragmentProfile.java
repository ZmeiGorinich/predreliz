package com.romarinichgmail.predreliz.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romarinichgmail.predreliz.R;


public class FragmentProfile extends Fragment {


    public FragmentProfile() {

    }

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }

}
