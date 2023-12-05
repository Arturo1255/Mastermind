package com.example.mastermind;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

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
        setCardBackground(holder, position);


    }
    private void setCardBackground(ListItemHolder holder, int position){
        Random rand = new Random();

        switch (position % 4){
            case 0:
                holder.textViewName.setBackgroundResource(R.drawable.folder_color_1);
                break;
            case 1:
                holder.textViewName.setBackgroundResource(R.drawable.folder_color_2);
                break;
            case 2:
                holder.textViewName.setBackgroundResource(R.drawable.folder_color_3);
                break;
            default:
                holder.textViewName.setBackgroundResource(R.drawable.folder_color_4);

        }
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


        // When the name of the folder is clicked the corresponding view folder dialog is shown
        public void onClick(View view) {
            // Gets the index of the selected folder
            int position = getAdapterPosition();
            // Passes the index of the selected folder and creates and shows a new view folder dialog
            mainActivity.viewFolder(position);

        }
    }

}
