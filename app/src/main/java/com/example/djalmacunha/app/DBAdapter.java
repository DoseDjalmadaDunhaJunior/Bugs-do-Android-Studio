package com.example.djalmacunha.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Classe de conexão do banco

public class DBAdapter{

    SQLiteDatabase db = null;
    DBHelper dbHelper = null;

    public DBAdapter(Context ctx){
        dbHelper = new DBHelper(ctx);
    }

    private void abrirConexao(){
        if(db == null)
            db = dbHelper.getWritableDatabase();
    }

    public void fecharConexao(){
        if(db!= null && db.isOpen()) {
            db.close();
            db = null;
        }
    }

    public void executarComandoSQL(String sql){
        abrirConexao();
        db.execSQL(sql);
        fecharConexao();
    }

    public Cursor executarConsultaSQL(String sql){
        abrirConexao();
        return db.rawQuery(sql, null);
    }
}
