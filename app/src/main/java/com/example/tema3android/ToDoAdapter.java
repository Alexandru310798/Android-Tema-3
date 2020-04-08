package com.example.tema3android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>
{
    private List<ToDo> list;
    private Context context;

    public ToDoAdapter(List<ToDo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    ToDo item = list.get(position);
    String string = "Title : " + item.getTitle() + "\nuserId : "  +item.getUserId() + "\n Completed : " +item.getDone();
    holder.textView.setText(string);

    }

    @Override
    public int getItemCount() {
       return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;

        public ViewHolder( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.my_list_item);

        }
    }
}
