package com.example.support.customerview;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HaiderAli on 8/21/2017.
 */

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<Product> products;
    Intent intent;

    public Adapter(Context context, ArrayList<Product> products){
        this.context=context;
        this.products=products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        ImageButton imageButton= (ImageButton) convertView.findViewById(R.id.imageViewId);
        TextView textView= (TextView) convertView.findViewById(R.id.textViewId);


        textView.setText(products.get(position).getName());

        Picasso.with(context).load(products.get(position).geturl().toString()).into(imageButton);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), ProductDetail.class);
                intent.putExtra("product", products.get(position));
                context.startActivity(intent);
                Log.i("Product Name: ", products.get(position).getName());
            }
        });




        return convertView;
    }

}
