package com.example.support.customerview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HaiderAli on 8/21/2017.
 */
public class ThirdFragment extends Fragment {
    View myView;
    ManageDatabase manageDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.third_category, container, false);

        manageDatabase=new ManageDatabase(getActivity());

        manageDatabase.retrieve(myView.getTag().toString());

        return myView;
    }
}
