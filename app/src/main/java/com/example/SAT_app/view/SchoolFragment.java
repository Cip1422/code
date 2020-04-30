package com.example.SAT_app.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.SAT_app.R;
import com.example.SAT_app.model.SAT;

public class SchoolFragment extends Fragment {

    private static final String DATA_ITEM = SchoolFragment.class.getSimpleName() + "DATA_ITEM";
    private TextView tvDetailedName, tvDetailedSatTakers, tvDetailedSatReading, tvDetailedSatMat, tvDetailedSatWriting;
    private ImageButton btnClose;

    public static SchoolFragment getInstance(SAT data) {
        SchoolFragment fragment = new SchoolFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(DATA_ITEM, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.school_fragment_layout, container, false);
        tvDetailedName = view.findViewById(R.id.tv_detailed_name);
        tvDetailedSatMat = view.findViewById(R.id.tv_detailed_sat_mat);
        tvDetailedSatTakers = view.findViewById(R.id.tv_detailed_sat_takers);
        tvDetailedSatReading = view.findViewById(R.id.tv_detailed_sat_reading);
        tvDetailedSatWriting = view.findViewById(R.id.tv_detailed_sat_writing);
        btnClose = view.findViewById(R.id.btn_close_fragment);
        btnClose.setOnClickListener(x -> {
            getActivity().onBackPressed();
        });
        return view;
    }

    public void initData() {
        SAT item = getArguments().getParcelable(DATA_ITEM);
        if (item != null) {
            tvDetailedSatWriting.setText(getString(R.string.avg_writing, item.getSat_writing_avg_score()));
            tvDetailedName.setText(item.getSchool_name());
            tvDetailedSatMat.setText(getString(R.string.avg_math, item.getSat_math_avg_score()));
            tvDetailedSatTakers.setText(getString(R.string.test_takers, item.getNum_of_sat_test_takers()));
            tvDetailedSatReading.setText(getString(R.string.avg_reading,item.getSat_critical_reading_avg_score()));
        }
    }
}
