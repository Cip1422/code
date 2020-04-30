package com.example.SAT_app.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.SAT_app.R;
import com.example.SAT_app.model.SAT;
import com.example.SAT_app.model.Schools;
import com.example.SAT_app.view.ItemClick;
import com.example.SAT_app.view.SchoolVHNodata;
import com.example.SAT_app.view.SchoolViewHolder;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Schools> dataSet;
    private List<SAT> dataSetSat;
    private ItemClick listener;

    public SchoolAdapter(ItemClick listener) {
        this.listener = listener;
    }

    public void setDataSet(List<Schools> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void setDataSetSat(List<SAT> dataSetSat) {
        this.dataSetSat = dataSetSat;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new SchoolViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.school_item_layout, parent, false));
            case 0:
                return new SchoolVHNodata(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_no_data, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SchoolViewHolder) {
            Schools item = dataSet.get(position);
            ((SchoolViewHolder) holder).onBind(item,
                    getRelatedSatFromSchoolDBN(item),
                    listener);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        return dataSet != null ? 1 : 0;
    }

    private SAT getRelatedSatFromSchoolDBN(Schools schoolDBN) {
        for (SAT item :
                dataSetSat) {
            if (item.getDbn().equals(schoolDBN.getDbn()))
                item.setBorough(schoolDBN.getBorough());
            return item;
        }
        return new SAT();
    }
}
