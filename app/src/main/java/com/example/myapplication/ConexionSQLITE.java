package com.example.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ConexionSQLITE extends SQLiteOpenHelper {
    String tabla = "CREATE TABLE usuario(id int,nom text,pass text, roll text )";
    public ConexionSQLITE(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla);
        sqLiteDatabase.execSQL("insert into usuario values (1,'root','123','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists usuario");
        onCreate(sqLiteDatabase);
    }
}
