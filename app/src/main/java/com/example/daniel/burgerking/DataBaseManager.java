package com.example.daniel.burgerking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Daniel on 09/06/2015.
 */
public class DataBaseManager {

    public static final String TABLE_NAME ="nuevasede";
    public static final String CN_ID ="_id";
    public static final String CN_NAME ="nombre";
    public static final String CN_LAT ="latitud";
    public static final String CN_LON ="longitud";

    public static final String CREATE_TABLE = " create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_NAME + " text not null,"
            + CN_LAT + " text not null,"
            + CN_LON + " text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String nombre, String latitud, String longitud){

        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, nombre);
        valores.put(CN_LAT, latitud);
        valores.put(CN_LON, longitud);
        return valores;
    }

    public void insertar (String nombre, String latitud, String longitud){
        db.insert(TABLE_NAME,null,generarContentValues(nombre, latitud, longitud));
    }

    public void insertar2 (String nombre, String latitud, String longitud){
        db.execSQL("insert into " + TABLE_NAME+" values (null," +nombre+","+latitud+","+longitud+")");
    }

    public void eliminar(String nombre){
        db.delete(TABLE_NAME,CN_NAME+"=?",new String[]{nombre});
    }

    public void eliminar_latitud (String latitud){
        db.delete(TABLE_NAME,CN_LAT+"=?",new String[]{latitud});
    }

    public void eliminarMultiple (String nom1, String nom2){
        db.delete(TABLE_NAME,CN_NAME+"IN [?,?]",new String[]{nom1,nom2});
    }

    public void modificarLatitud (String nombre, String nuevaLatitud){
        db.update(TABLE_NAME,generarContentValues(nombre, nuevaLatitud, null),CN_NAME + "=?",new String[]{nombre});
    }

    public Cursor cargarCursorContactos(){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_LAT,CN_LON};
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }

    public Cursor buscarContacto(String nombre){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_LAT,CN_LON};
        return db.query(TABLE_NAME,columnas,CN_NAME + "=?", new String[]{nombre},null,null,null);
    }

}