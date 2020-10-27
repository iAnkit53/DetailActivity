package com.staybees.detailsapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder>{

    private ArrayList<DetailModel> detailModels = new ArrayList<>();
    private Context context;

    public DetailAdapter(Context context, ArrayList<DetailModel> detailModels) {
        this.detailModels=detailModels;
        this.context=context;
    }

    @NonNull
    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_list_item,viewGroup,false);
        return new DetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ViewHolder viewHolder, int i) {
        viewHolder.detail_name.setText(detailModels.get(i).getName());
        viewHolder.detail_mobile.setText(detailModels.get(i).getMobile());
        viewHolder.detail_email.setText(detailModels.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return detailModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView detail_name;
        private TextView detail_mobile;
        private TextView detail_email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            detail_name=(TextView)itemView.findViewById(R.id.detail_name);
            detail_mobile=(TextView)itemView.findViewById(R.id.detail_mobile);
            detail_email=(TextView)itemView.findViewById(R.id.detail_email);
        }
    }
}
