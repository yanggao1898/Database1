package com.example.database1;

import android.database.sqlite.SQLiteDatabase;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private boolean isInsured;

    public static final String TABLE_NAME = "employee";
    public static final String COLUMN_ID = "emp_id";
    public static final String COLUMN_FIRSTNAME = "first_name";
    public static final String COLUMN_LASTNAME = "last_name";
    public static final String COLUMN_INSURED = "insured";

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_FIRSTNAME + " TEXT," +
                COLUMN_LASTNAME + " TEXT," +
                COLUMN_INSURED + " INTEGER" +
            ")";

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isInsured() {
        return isInsured;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }

    public Employee() {}

    public Employee(Long id, String fName, String lName, boolean insured) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.isInsured = insured;
    }

}
