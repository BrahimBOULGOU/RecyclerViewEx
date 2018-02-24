package com.brahimtest.boulgou.recyclerviewdsb.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahimtest.boulgou.recyclerviewdsb.R;
import com.brahimtest.boulgou.recyclerviewdsb.models.Items;

public class DetailsActivity extends AppCompatActivity {
    private Items items;
    private TextView mTitle;
    private TextView mDescription;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         mTitle = (TextView) findViewById(R.id.mtitle);
         mDescription = (TextView) findViewById(R.id.mdescription);
        imageView = (ImageView) findViewById(R.id.mimage);

        Intent intent = getIntent();
        items = (Items) intent.getSerializableExtra("mitem");

        mTitle.setText(items.getmTitle());
        mDescription.setText(items.getmDescription());
        imageView.setImageResource(items.getmImage());
    }
}
