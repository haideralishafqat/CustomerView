package com.example.support.customerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.GridView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by HaiderAli on 8/21/2017.
 */
public class ManageDatabase {

    private static String DB_NAME = "warehouse";
    private static String ENTITY_NAME_PROFILES = "products";
    private static String TABLE_NAME="snacks";

    private FirebaseDatabase firebase;
    private DatabaseReference database;
    private DatabaseReference table;
    private DatabaseReference category;
    private Adapter adapter;
    private Context context;


    public ManageDatabase(Context context){
        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference(DB_NAME);
        table = database.child(ENTITY_NAME_PROFILES);
        this.context = context;

    }

    //Retrive data from firbase

    public void retrieve(final String tag){

        final ArrayList<Product> productList = new ArrayList<>();

       table.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Log.i("Message:", "Outside onChildAdded " + dataSnapshot.getKey());


                if(dataSnapshot.getKey().equalsIgnoreCase(tag)) {
                    for (DataSnapshot record : dataSnapshot.getChildren()) {
                        Product product = record.getValue(Product.class);
                        productList.add(product);
                        Log.i("Message:", "Inside onChildAdded " + dataSnapshot.getKey());
                    }

                    setData(productList,tag);
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i("Message:", "Inside onChildChanged");
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setData(ArrayList<Product> productList, String tag){

        adapter = new Adapter(context, productList);
        adapter.notifyDataSetChanged();


        if(tag.equalsIgnoreCase("snacks")) {
            GridView gridView = (GridView) ((Activity) context).findViewById(R.id.firstgridViewId);
            gridView.setAdapter(adapter);
            Log.i("Message:", "Inside setData() SNACKS");
        }


        else if(tag.equalsIgnoreCase("appliances")) {
            GridView gridView = (GridView) ((Activity) context).findViewById(R.id.secondgridViewId);
            gridView.setAdapter(adapter);
            Log.i("Message:", "Inside setData() APPLIANCES");
        }


        else if(tag.equalsIgnoreCase("clothes")) {
            GridView gridView = (GridView) ((Activity) context).findViewById(R.id.thirdgridViewId);
            gridView.setAdapter(adapter);
            Log.i("Message:", "Inside setData() CLOTHES");
        }


    }


}
