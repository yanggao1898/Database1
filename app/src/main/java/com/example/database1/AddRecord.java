package com.example.database1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        Button add = findViewById(R.id.btn_add_done);
        Button cancel = findViewById(R.id.btn_add_cancel);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBClass dbc = new DBClass(v.getContext());

                EditText fName = findViewById(R.id.et_fName);
                EditText lName = findViewById(R.id.et_lName);
                Switch insured = findViewById(R.id.swt_insur);

                Employee addE = new Employee((long)-1, fName.getText().toString(), lName.getText().toString(), insured.isChecked());

                dbc.addEmployee(addE);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCancel(v);
            }
        });
    }

    private void btnCancel(View v) {
        this.finish();
    }
}
