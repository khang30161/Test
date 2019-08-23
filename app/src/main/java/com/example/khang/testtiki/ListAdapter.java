package com.example.khang.testtiki;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Tiki> tiki;
    private Context context;

    public ListAdapter(Context context, List<Tiki> tiki) {
        this.tiki = tiki;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_additem, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (tiki.get(position) == null) {
            return;
        }
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.text.setText(tiki.get(position).getText());
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.text.setBackgroundColor(color);

    }


    @Override
    public int getItemCount() {
        return (tiki != null ? tiki.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_display);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
