package com.example.mastermind;




import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;






import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ListItemHolder> {
   private MainActivity mainActivity;
   private ArrayList<Folder> list;
   private TextView textViewName;


   public FolderAdapter(MainActivity mainActivity, ArrayList<Folder> list) {
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


       Folder folder = list.get(position);
       holder.textViewName.setText(folder.getName());




   }


   @Override
   public int getItemCount() {
       return list.size();
   }


   public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


       private TextView textViewName;
       private Button deleteButton;


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
           if (position != RecyclerView.NO_POSITION) {
               // Passes the index of the selected folder and creates and shows a new view folder dialog
               //mainActivity.viewFolder(position);                  //conflicts here
               Folder clickedFolder = list.get(position);
               showFolderDetailsDialog(clickedFolder, FolderAdapter.this);


           }
       }


       private void showFolderDetailsDialog(Folder folder, FolderAdapter folderAdapter) {
           //deleteButton.setOnClickListener(this);
           View dialogView = LayoutInflater.from(mainActivity).inflate(R.layout.dialog_view_folder, null);
           //Button deleteButton = itemView.findViewById(R.id.DeleteButton);


           deleteButton = dialogView.findViewById(R.id.DeleteButton);
           deleteButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // Show a confirmation dialog for delete
                   showDeleteConfirmationDialog(folder, folderAdapter);
               }
           });
           // Create and show a dialog with your custom layout
           AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
           builder.setView(dialogView);
           builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   dialog.dismiss();
               }
           });
           builder.show();
       }




           private void showDeleteConfirmationDialog(final Folder folder, FolderAdapter folderAdapter){
               AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
               builder.setTitle("Delete Folder");
               builder.setMessage("Are you sure you want to delete this folder?");
               builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       // Delete the contact from the list
                       list.remove(folder);
                       // Notify the adapter about the change
                       folderAdapter.notifyDataSetChanged();


                       // Dismiss the dialog
                       dialog.dismiss();
                   }
               });
               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       // Do nothing or handle cancel
                       dialog.dismiss();
                   }
               });
               builder.show();
           }
       }
   }
