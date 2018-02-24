package com.brahimtest.boulgou.recyclerviewdsb.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.brahimtest.boulgou.recyclerviewdsb.R;
import com.brahimtest.boulgou.recyclerviewdsb.activities.DetailsActivity;
import com.brahimtest.boulgou.recyclerviewdsb.models.Items;

import java.util.List;

/**
 * Created by Brahim BOULGOU on 2/22/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Items> items;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView imageView;
        public Button mDetailsButton;
        public Button mShareButton;
        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            imageView = view.findViewById(R.id.imageView);
            mDetailsButton = view.findViewById(R.id.details_but);
            mShareButton = view.findViewById(R.id.share_but);
        }
    }

    public MyAdapter(List<Items> mItems, Context context) {
        this.items = mItems;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Items item = items.get(position);
        holder.title.setText(item.getmTitle());
        holder.description.setText(item.getmDescription());
        holder.imageView.setImageResource(item.getmImage());

        holder.mDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(mContext, DetailsActivity.class);
               intent.putExtra("mitem", item);
               mContext.startActivity(intent);
            }
        });

        holder.mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, item.getmTitle());
                sendIntent.setType("text/plain");
                mContext.startActivity(sendIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
