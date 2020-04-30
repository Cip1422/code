package com.example.SAT_app.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.SAT_app.R;

public class SchoolVHNodata extends RecyclerView.ViewHolder {

    private TextView tvNodata;

    public SchoolVHNodata(@NonNull View itemView) {
        super(itemView);
        tvNodata = itemView.findViewById(R.id.tv_no_data);
    }
}
