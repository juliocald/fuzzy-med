package com.medapp.fuzzy.medapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Clase handler para todas las operaciones de la BD
 * TODO: Agregar metodos para operaciones CRUD
 * TODO: Ver como se crea una PK unica para cada fila de tabla (que va a ser la PK?)
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MedApp.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
    * Metodo que crea las tablas de la base de datos.
    * TODO: Agregar strings para crear tablas restantes
    * */
    @Override
    public void onCreate(SQLiteDatabase db){
        final String CREATE_MEDICINE_TABLE = "CREATE TABLE " + MedDBContract.MedicineContract.TABLE_NAME +
                " (" + MedDBContract.MedicineContract._ID + " INTEGER PRIMARY KEY, " +
                MedDBContract.MedicineContract.COLUMN_NAME_TITLE + MedDBContract.TEXT_TYPE +
                ", " + MedDBContract.MedicineContract.COLUMN_NAME_DOSE + MedDBContract.TEXT_TYPE +
                ", " + MedDBContract.MedicineContract.COLUMN_NAME_DETAILS + MedDBContract.TEXT_TYPE +
                ")";

        final String CREATE_PRESCRIPTION_TABLE = "CREATE TABLE " + MedDBContract.PrescriptionContract.TABLE_NAME +
                "( " + MedDBContract.PrescriptionContract._ID + " INTEGER PRIMARY KEY, " +
                MedDBContract.PrescriptionContract.COLUMN_NAME_DOCTOR + MedDBContract.TEXT_TYPE +
                ", " + MedDBContract.PrescriptionContract.COLUMN_NAME_DATE + MedDBContract.TEXT_TYPE +
                ")";

        final String CREATE_MEDPRESC_TABLE = "CREATE TABLE " + MedDBContract.MedPrescContract.TABLE_NAME +
                "(" + MedDBContract.MedPrescContract.COLUMN_NAME_PRESC_ID + "INTEGER, " +
                MedDBContract.MedPrescContract.COLUMN_NAME_MED_ID + "INTEGER, "+
                "PRIMARY KEY(" + MedDBContract.MedPrescContract.COLUMN_NAME_PRESC_ID +
                ", " + MedDBContract.MedPrescContract.COLUMN_NAME_MED_ID + "), " +
                "FOREIGN KEY(" + MedDBContract.MedPrescContract.COLUMN_NAME_PRESC_ID + ") " +
                "REFERENCES " + MedDBContract.PrescriptionContract.TABLE_NAME + "(" +
                MedDBContract.PrescriptionContract._ID + "), " +
                "FOREIGN KEY(" + MedDBContract.MedPrescContract.COLUMN_NAME_MED_ID + ") " +
                "REFERENCES " + MedDBContract.MedicineContract.TABLE_NAME + "(" +
                MedDBContract.MedicineContract._ID + ")";

        db.execSQL(CREATE_MEDICINE_TABLE);
        db.execSQL(CREATE_PRESCRIPTION_TABLE);
        db.execSQL(CREATE_MEDPRESC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + MedDBContract.MedicineContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MedDBContract.PrescriptionContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MedDBContract.MedPrescContract.TABLE_NAME);

        onCreate(db);
    }
}
