package com.example.database1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBClass extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;

    public DBClass(Context context) {
        super(context, Employee.TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Employee.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Employee.TABLE_NAME);

        onCreate(db);
    }

    public Employee addEmployee(Employee e) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();

        //val.put(Employee.COLUMN_ID, e.getId());
        val.put(Employee.COLUMN_FIRSTNAME, e.getFirstName());
        val.put(Employee.COLUMN_LASTNAME, e.getLastName());
        val.put(Employee.COLUMN_INSURED, e.isInsured() ? 1 : 0);

        long id = db.insert(Employee.TABLE_NAME, null, val);

        if (id == -1) {
            Log.w("INFO-DB-WARN", "Failed to add row for Employee");
        } else {
            Log.i("INFO-DB", "Employee added");
        }

        Employee newE = new Employee(id, e.getFirstName(), e.getLastName(), e.isInsured());
        return newE;

    }

    public Employee getEmployee(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor dbc = db.query(Employee.TABLE_NAME,
                null, Employee.COLUMN_ID + "=?", new String[]{Long.toString(id)}, null, null, null);
        Employee qEmp = null;
        if (dbc != null) {
            dbc.moveToFirst();
            qEmp = new Employee(dbc.getLong(dbc.getColumnIndex(Employee.COLUMN_ID)),
                    dbc.getString(dbc.getColumnIndex(Employee.COLUMN_FIRSTNAME)),
                    dbc.getString(dbc.getColumnIndex(Employee.COLUMN_LASTNAME)),
                    dbc.getInt(dbc.getColumnIndex(Employee.COLUMN_INSURED)) == 1);
        }
        dbc.close();
        return qEmp;

    }

    public List<Employee> getAllEmployees() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor dbc = db.query(Employee.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Employee> eList = new ArrayList<>();
        /*
        if (dbc != null)
            dbc.moveToFirst();
        //*/
        try {
            while (dbc.moveToNext()) {
                Employee e = new Employee(dbc.getLong(dbc.getColumnIndex(Employee.COLUMN_ID)),
                        dbc.getString(dbc.getColumnIndex(Employee.COLUMN_FIRSTNAME)),
                        dbc.getString(dbc.getColumnIndex(Employee.COLUMN_LASTNAME)),
                dbc.getInt(dbc.getColumnIndex(Employee.COLUMN_INSURED)) == 1);

                eList.add(e);
            }
        } finally {
            dbc.close();
        }

        return eList;
    }

}
