package com.example.SAT_app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.SAT_app.R;
import com.example.SAT_app.model.SAT;
import com.example.SAT_app.model.Schools;
import com.example.SAT_app.util.SchoolApplication;
import com.example.SAT_app.view.adapter.SchoolAdapter;
import com.example.SAT_app.viewmodel.SchoolViewModel;
import com.example.SAT_app.viewmodel.SchoolViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ItemClick {

    private SchoolAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FrameLayout root;
    @Inject
    public SchoolViewModelFactory factory;
    private SchoolViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SchoolApplication) getApplicationContext()).getComponent().inject(this);

        viewModel = factory.create(SchoolViewModel.class);

        initViews();

        viewModel.initNetworkCall();

        viewModel.getDataListSat().observe(this,
                SATs -> updateAdapterSat(SATs));
        viewModel.getDataListSchools().observe(this,
                schools -> updateAdapterSchools(schools));

    }

    private void updateAdapterSat(List<SAT> SAT) {

        adapter.setDataSetSat(SAT);
    }

    private void updateAdapterSchools(List<Schools> schools) {
        progressBar.setVisibility(View.GONE);
        adapter.setDataSet(schools);
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        root = findViewById(R.id.root);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SchoolAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void clickedItem(SAT dataItem) {
        SchoolFragment fragment = SchoolFragment.getInstance(dataItem);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.root,
                fragment)
                .setCustomAnimations(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .addToBackStack(null)
                .commit();
        getSupportFragmentManager().executePendingTransactions();
        fragment.initData();
    }
}