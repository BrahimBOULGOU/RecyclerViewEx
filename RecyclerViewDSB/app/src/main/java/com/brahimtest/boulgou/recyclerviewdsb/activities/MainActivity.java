package com.brahimtest.boulgou.recyclerviewdsb.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.brahimtest.boulgou.recyclerviewdsb.R;
import com.brahimtest.boulgou.recyclerviewdsb.adapters.MyAdapter;
import com.brahimtest.boulgou.recyclerviewdsb.models.Items;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private List<Items> mItems = new ArrayList<>();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new MyAdapter(mItems, mContext);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            addElement();
        } else if (id == R.id.action_remove) {
            removeElement();

        }

        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        Items firstitems = new Items(getString(R.string.title_f), getString(R.string.description_f), R.drawable.imagef);
        Items seconditems = new Items(getString(R.string.title_s), getString(R.string.description_s), R.drawable.images);
        Items threitems = new Items(getString(R.string.title_t), getString(R.string.description_t), R.drawable.imaget);
        mItems.add(firstitems);
        mItems.add(seconditems);
        mItems.add(threitems);
    }

    private void addElement() {
        Items seconditems = new Items(getString(R.string.title_f), getString(R.string.description_f), R.drawable.imagef);
        mItems.add(seconditems);
        mAdapter.notifyDataSetChanged();
    }

    private void removeElement() {
        if (mItems.size() > 1) {
            mItems.remove(1);
            mAdapter.notifyItemRemoved(1);
        }else if (mItems.size() == 1){
            mItems.remove(0);
            mAdapter.notifyItemRemoved(0);
        }
    }
}
