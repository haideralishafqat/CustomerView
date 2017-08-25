package com.example.support.customerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Intent intent= getIntent();
        Product product=(Product) intent.getExtras().getSerializable("product");

        ImageView productImage = (ImageView) findViewById(R.id.imageViewPD);
        TextView productView= (TextView) findViewById(R.id.prouctNamePD);
        TextView priceView= (TextView) findViewById(R.id.priceViewPD);
        TextView quantityView= (TextView) findViewById(R.id.quantityViewPD);


        Picasso.with(this).load(product.geturl()).into(productImage);
        productView.setText("Product Name: "+product.getName());
        priceView.setText("Price: "+product.getPrice());
        quantityView.setText("Quantity: "+product.getQuantity());
    }
}
