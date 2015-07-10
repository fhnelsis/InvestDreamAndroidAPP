package br.com.investdream.investdreamandroidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "investdream.db";
    private static final String TABLE_BENS = "bens";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME_BEM = "nome_bem";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_BENS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NOME_BEM + " TEXT," + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BENS);
        onCreate(db);
    }

    public Bem findProduct(String productname) {
        String query = "Select * FROM " + TABLE_BENS + " WHERE " + TABLE_BENS + " =  \"" + productname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Bem bem = new Bem();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            bem.setID(Integer.parseInt(cursor.getString(0)));
            bem.setNomeBem(cursor.getString(1));
            cursor.close();
        } else {
            bem = null;
        }
        db.close();
        return bem;
    }

}