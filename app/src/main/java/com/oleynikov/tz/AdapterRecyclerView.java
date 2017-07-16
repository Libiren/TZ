package com.oleynikov.tz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.pinxter.letters.Letters;

/**
 * Created by HP on 7/14/2017.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List list = new ArrayList<>();
    private Letters letters;


    public RecyclerViewAdapter(List list, Letters letters) {
        this.list = list;
        this.letters = letters;

    }


    class MyView extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewLetters;


        MyView(final View itemView) {
            super(itemView);


            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewLetters = (TextView) itemView.findViewById(R.id.item_users_letter);


        }
    }

    class MyView1 extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewLetters;


        MyView1(final View itemView) {
            super(itemView);


            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewLetters = (TextView) itemView.findViewById(R.id.item_users_letter);


        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case 0:
                return new MyView(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false));
            case 2:
                return new MyView1(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item1, parent, false));

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                MyView myView = (MyView) holder;
                myView.textViewTitle.setText(list.get(position).toString());
                myView.textViewLetters.setText(letters.getLetter(position));

                break;

            case 2:
                MyView1 myView1 = (MyView1) holder;
                myView1.textViewTitle.setText(list.get(position).toString());
                myView1.textViewLetters.setText(letters.getLetter(position));

                break;
        }


    }


    @Override
    public int getItemViewType(int position) {

        return position % 2 * 2;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}
