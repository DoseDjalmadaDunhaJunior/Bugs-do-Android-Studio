package com.example.djalmacunha.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.List;
import java.util.Map;

// Classe que exibe o menu

public class menuActivity extends AppCompatActivity{

    loginActivity l;

    private List<Map<String, Object>> viagens;
    private AlertDialog alertDialog;
    private DBHelper helper;
    private Double valorLimite;
    private int viagemSelecionada;
    private AlertDialog dialogConfirmacao;
    public static String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        String[] de = {"login", "senha"};
        int[] para = {R.id.txtLogin, R.id.txtSenhaEdicao};
        helper = new DBHelper(this);
        usuario = l.usuario;
    }

    // Todas as funções pra troca de tela abaixo

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

    public void configOnClick(View view){
        startActivity(new Intent(this, configActivity.class));
    }
}
