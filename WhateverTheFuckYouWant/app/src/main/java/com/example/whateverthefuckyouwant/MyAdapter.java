package com.example.whateverthefuckyouwant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ebuttikofer20 on 1/20/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Team> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView left;
        public TextView right;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            left = (TextView) v.findViewById(R.id.left);
            right = (TextView) v.findViewById(R.id.right);

        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Team> myDataset) {
        mDataset = myDataset;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your data at this position
        // - replace the contents of the view with that element

        holder.mTextView.setText(mDataset.get(position).getTeamName());
        Random gen = new Random();

        if(gen.nextBoolean()) {
            lefter = mDataset.get(position).getTeamNumber();
            righter = mDataset.get(gen.nextInt(mDataset.size())).getTeamNumber();
            holder.left.setText(lefter);
            holder.right.setText(righter);
        } else {
            righter = mDataset.get(
                    position).getTeamNumber();
            lefter = mDataset.get(gen.nextInt(mDataset.size())).getTeamNumber();
            holder.right.setText(righter);
            holder.left.setText(lefter);

        }

    }

    String righter;
    String lefter;

    public String getLeft() {
        return lefter;
    }

    public String getRighter() {
        return righter;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}