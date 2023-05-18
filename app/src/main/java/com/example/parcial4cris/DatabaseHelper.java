package com.example.parcial4cris;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "formulario.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "formulario";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_APELLIDO = "apellido";
    private static final String COLUMN_DIRECCION = "direccion";
    private static final String COLUMN_CIUDAD = "ciudad";
    private static final String COLUMN_MARCA_CARRO = "marca_carro";
    private static final String COLUMN_MODELO = "modelo";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOMBRE + " TEXT, " +
            COLUMN_APELLIDO + " TEXT, " +
            COLUMN_DIRECCION + " TEXT, " +
            COLUMN_CIUDAD + " TEXT, " +
            COLUMN_MARCA_CARRO + " TEXT, " +
            COLUMN_MODELO + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
