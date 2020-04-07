package com.example.tema3android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<ListItem> listItemList;
    private Context context;


    public MyAdapter( List<ListItem> listItemList, Context context) {
        this.listItemList = listItemList;
        this.context = context;
    }


    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {


        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ListItem listItem = listItemList.get(position);
        String text_to_display =  listItem.getId().toString()+"\n" + listItem.getName() + "\n" + listItem.getUsername() + "\n" + listItem.getEmail()+"\n";
        holder.textView.setText(text_to_display);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listItemList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.my_list_item);
        }
    }

}
