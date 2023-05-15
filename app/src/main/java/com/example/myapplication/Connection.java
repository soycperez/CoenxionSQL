package com.example.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

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

    public String findUserId(String id){
        String sql = "select * from usuario where id='"+id+"'";
        String aux = "0";
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        try {
            Cursor c = sqLiteDatabase.rawQuery(sql, null);
            while (c.moveToNext()){
                aux="1";
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return aux;
    }

    public void eliminarUser(String id){
        String sql = "delete from usuario where id='"+id+"'";
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }

    public void actualizar(String id, String nom, String pass, String tipo) {
        String sql = "update usuario set nom = '"+nom+"', pass = '"+pass+"', tipo = '"+tipo+"' where id = '"+id+"'";
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }

    public Usuario1 findUserIdAll(String id){
        Usuario1 usuario1= new Usuario1();
        String sql = "select * from usuario where id='"+id+"'";
        String aux = "0";
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        try {
            Cursor c = sqLiteDatabase.rawQuery(sql, null);
            while (c.moveToNext()){
                usuario1.id = "" + c.getString(0);
                usuario1.nom = c.getString(1);
                usuario1.pass = c.getString(2);
                usuario1.tipo = c.getString(3);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return usuario1;
    }

    public String MuestraTodoUsuarios(){
        Usuario1 usuario1 = new Usuario1();

        String sql = "select * from usuario";
        String aux = "";
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();
        try{
            Cursor c = sqLiteDatabase.rawQuery(sql, null);
            while (c.moveToNext()) {
                aux += "" + c.getInt(0) + "---";
                aux += "" + c.getString(1) + "---";
                aux += "" + c.getString(2) + "---";
                aux += "" + c.getString(3) + "\n\n";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return aux;
    }
}
