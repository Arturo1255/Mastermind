package com.example.mastermind;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlashCardAdapter extends RecyclerView.Adapter<FlashCardAdapter.ListItemHolder> {
    private ViewFlashCardsActivity flashCardsActivity;
    private final ArrayList<FlashCard> list;


    public FlashCardAdapter (ViewFlashCardsActivity flashCardsActivity, ArrayList<FlashCard> list) {
        this.flashCardsActivity = flashCardsActivity;
        this.list = list;

    }
    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.flash_card_recycler, parent, false);

        return new ListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        FlashCard flashCard = list.get (position);
        holder.question.setText(flashCard.getQuestion());
        holder.answer.setText(flashCard.getAnswer());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView answer;
        private TextView question;

        private TextView folderName;

        public ListItemHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            answer = itemView.findViewById(R.id.answer);
            question.setClickable(true);
            question.setOnClickListener(this);
        }

        // When the flash card is clicked the corresponding view flash card dialog should open.
        public void onClick(View view) {
            // Gets the index of the selected folder
            int position = getAdapterPosition();
            // Passes the index of the selected card and creates and shows a new view card dialog
           // flashCardsActivity.viewFlashCard(position);

        }
    }

}

