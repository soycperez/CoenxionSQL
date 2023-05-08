package com.example.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;

public class Connection {

    ConexionSQLITE conn;

    public Connection(Activity form){
        conn = new ConexionSQLITE(form.getApplicationContext(), "app", null, 1);
    }

    public String findUser(String user, String pass){
        String sql = "select * from usuario where nom  = '" + user + "' and pass = '" + pass + "'";
        String aux = "0";

        /*Se hace la conexión hace la base*/
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        try {
            Cursor c = sqLiteDatabase.rawQuery(sql, null);
            while (c.moveToNext()){
                aux = "1";
            }
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return aux;
    }

    public void crearUsuario(String id, String nom, String pass, String tipo){
        String sql = "insert into usuario values ('"+id+"','"+nom+"','"+pass+"','"+tipo+"')";
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }
}
