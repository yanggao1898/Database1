package com.example.database1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ReadRecord extends AppCompatActivity {

    private List<Employee> eList;
    private RecordAdapter ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_record);

        eList = fillList();
        RecyclerView rv = findViewById(R.id.recyv_readall);

        ra = new RecordAdapter(eList);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        DividerItemDecoration did = new DividerItemDecoration(rv.getContext(), ((LinearLayoutManager) lm).getOrientation());
        rv.addItemDecoration(did);

        rv.setLayoutManager(lm);
        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(ra);

        Button btnBack = findViewById(R.id.btn_readall_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backClicked(v);
            }
        });
    }

    private List<Employee> fillList() {
        DBClass dbc = new DBClass(this.getBaseContext());

        return dbc.getAllEmployees();
    }

    private void backClicked(View v) {
        this.finish();
    }
}
