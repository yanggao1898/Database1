package com.example.database1;

import android.icu.text.AlphabeticIndex;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordHolderView> {

    private List<Employee> employeeList;

    class RecordHolderView extends RecyclerView.ViewHolder {


        TextView tvid, tvFName, tvLName;
        CheckBox cbInsured;

        RecordHolderView(@NonNull View v) {
            super(v);
            tvid = v.findViewById(R.id.tv_rec_id);
            tvFName = v.findViewById(R.id.tv_rec_fname);
            tvLName = v.findViewById(R.id.tv_rec_lname);
            cbInsured = v.findViewById(R.id.cbx_rec_isinsured);
        }
    }

    RecordAdapter(List<Employee> eList) {
        this.employeeList = eList;

    }

    @NonNull
    @Override
    public RecordHolderView onCreateViewHolder(@NonNull ViewGroup vGroup, int i) {
        View iView = LayoutInflater.from(vGroup.getContext())
                .inflate(R.layout.recordrecord, vGroup, false);
        return new RecordHolderView(iView);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull final RecordAdapter.RecordHolderView vh, final int i) {
        final Employee emp = employeeList.get(i);

        vh.tvid.setText(Long.toString(emp.getId()));
        vh.tvFName.setText(emp.getFirstName());
        vh.tvLName.setText(emp.getLastName());
        vh.cbInsured.setChecked(emp.isInsured());

    }

    @Override
    public int getItemCount() {
        return this.employeeList.size();
    }

}
