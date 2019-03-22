package com.example.database1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReadRecordO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_record_o);

        Button get = findViewById(R.id.btn_read_get);
        final Button back = findViewById(R.id.btn_read_back);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBClass dbc = new DBClass(v.getContext());
                EditText etid = findViewById(R.id.et_read_id);
                if(etid.getText().toString().length() > 0) {
                    Employee q = dbc.getEmployee(Long.parseLong(etid.getText().toString()));

                    if (q != null) {
                        TextView tvfname = findViewById(R.id.tv_read_fname);
                        TextView tvlname = findViewById(R.id.tv_read_lname);
                        CheckBox insured = findViewById(R.id.cbx_read_isinsured);

                        tvfname.setText(q.getFirstName());
                        tvlname.setText(q.getLastName());
                        insured.setChecked(q.isInsured());
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backClicked(v);
            }
        });
    }

    private void backClicked(View v) {
        this.finish();
    }
}
