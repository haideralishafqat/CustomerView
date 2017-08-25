package com.example.support.customerview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by HaiderAli on 8/21/2017.
 */
public class FirstFragment extends Fragment {
    private View myView;
    private GridView gridView;
    private Adapter firstCategoryAdapter;
    private ArrayList<Product> productList;
    private ManageDatabase manageDatabase;
    //private ArrayAdapter<String> arrayAdapter;
    //private static String[] stringArray={"Haider", "Ali", "Shafqat"};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.first_category, container, false);

        //Data base call here
        manageDatabase=new ManageDatabase(getActivity());
        //Log.i("1st tag= ", myView.getTag().toString());
        manageDatabase.retrieve(myView.getTag().toString());


//        firstCategoryAdapter=new Adapter(getActivity(),productList);
//
//        firstCategoryAdapter.notifyDataSetChanged();
//
//        gridView=(GridView) myView.findViewById(R.id.firstgridViewId);
//
//        gridView.setAdapter(firstCategoryAdapter);

        //gridView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,stringArray));

//        ImageButton imageButton=(ImageButton) myView.findViewById(R.id.imageViewId);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("Message: ",);
//
//            }
//        });

        return myView;
    }
}
