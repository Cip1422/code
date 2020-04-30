package com.example.SAT_app.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.SAT_app.R;
import com.example.SAT_app.model.SAT;
import com.example.SAT_app.model.Schools;

public class SchoolViewHolder extends RecyclerView.ViewHolder {

    private TextView tvSchoolName, tvSchoolPhoneNumber, tvSchoolFaxNumber, tvSchoolEmail, tvSchoolWebSite, tvSchoolLocation;

    public SchoolViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSchoolName = itemView.findViewById(R.id.tv_school_name);
        tvSchoolPhoneNumber = itemView.findViewById(R.id.tv_phone_number);
        tvSchoolFaxNumber = itemView.findViewById(R.id.tv_fax_number);
        tvSchoolEmail = itemView.findViewById(R.id.tv_school_email);
        tvSchoolWebSite = itemView.findViewById(R.id.tv_website);
        tvSchoolLocation = itemView.findViewById(R.id.tv_location);
    }

    public void onBind(Schools dataItem,
                       final SAT dataSat,
                       final ItemClick listener) {
        tvSchoolName.setText(dataItem.getSchool_name());
        tvSchoolPhoneNumber.setText(itemView.getContext().getString(R.string.phone, dataItem.getPhone_number()));
        tvSchoolFaxNumber.setText(itemView.getContext().getString(R.string.fax, dataItem.getFax_number()));
        tvSchoolEmail.setText(itemView.getContext().getString(R.string.email, dataItem.getSchool_email()));
        tvSchoolWebSite.setText(itemView.getContext().getString(R.string.website, dataItem.getWebsite()));
        tvSchoolLocation.setText(removeCoordinates(dataItem.getLocation()));

        itemView.setOnClickListener(v -> listener.clickedItem(dataSat));
    }

    private StringBuilder removeCoordinates(String location){
        StringBuilder str = new StringBuilder(location);
        str.delete(str.indexOf("("), str.indexOf(")")+1);
        return str;
    }

}
