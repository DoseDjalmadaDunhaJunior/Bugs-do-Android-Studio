package com.example.djalmacunha.app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class menuActivity extends AppCompatActivity{

    private List<Map<String, Object>> viagens;
    private AlertDialog alertDialog;
    private DBHelper helper;
    private Double valorLimite;
    private int viagemSelecionada;
    private AlertDialog dialogConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        String[] de = {"login", "senha"};
        int[] para = {R.id.txtLogin, R.id.txtSenha};
        helper = new DBHelper(this);
    }

    public void voltaOnClick(View view){
        finish();
        //startActivity(new Intent(this, loginActivity.class));
    }

    public void cadastrarOnCLick(View view){
        startActivity(new Intent(this, adicionarActivity.class));
    }

    public void listarSenhasOnCLick(View view){
        startActivity(new Intent(this, senhasActivity.class));
    }

    public void listarViagens(View view) {

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _login, senha FROM usuarios", null);
                cursor.moveToFirst();
        viagens = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String id = cursor.getString(0);
            String login = cursor.getString(1);
            String senha = cursor.getString(2);
            viagens.add(item);
            cursor.moveToNext();

            System.out.println(login + "\n");
            System.out.println(senha + "\n");
        }
        cursor.close();
    }
}
