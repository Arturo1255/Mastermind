package com.example.mastermind;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ListItemHolder> {
    private MainActivity mainActivity;
    private ArrayList<Folder> list;

    public FolderAdapter (MainActivity mainActivity, ArrayList<Folder> list) {
        this.mainActivity = mainActivity;
        this.list = list;

    }
    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.folder_layout, parent, false);

        return new ListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {

        Folder folder = list.get (position);
        holder.textViewName.setText(folder.getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewName;

        public ListItemHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewName.setClickable(true);
            textViewName.setOnClickListener(this);
        }

        public void onClick(View view) {
            int position = getAdapterPosition();
            mainActivity.viewFolder(position);

        }
    }

}
