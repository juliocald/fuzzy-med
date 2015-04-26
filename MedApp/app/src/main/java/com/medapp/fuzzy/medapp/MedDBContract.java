package com.medapp.fuzzy.medapp;

import android.provider.BaseColumns;

/**
 * Created by andres on 26/04/15.
 */
public final class MedDBContract {

    //constructor vacio
    public MedDBContract(){}

    public static abstract class MedicineContract implements BaseColumns{

        public static final String TABLE_NAME = "Medicines";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_TITLE = "Name";
        public static final String COLUMN_NAME_DOSE = "Dose";
        public static final String TEXT_TYPE = " TEXT";
    }

}
