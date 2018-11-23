package com.example.djalmacunha.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Classe de criação do banco

public class DBHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "passwords.db";
    static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE senhas(id integer primary key autoincrement," +
                "senhaUser text not null, loginUser text not null, site text not null, usuario text not null);");

        db.execSQL("CREATE TABLE user(id integer primary key autoincrement," +
                "login text not null, senha text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String loginUser(String login, String senha) {
        Log.d("O que recebo de login", login);
        Log.d("O que recebo de senha", senha);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM user WHERE login=? AND senha =?", new String[]{login, senha});

        if (c.getCount() > 0) {
            return "OK";
        }

        return "ERRO";
    }
}

