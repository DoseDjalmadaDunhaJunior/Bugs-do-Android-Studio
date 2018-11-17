package com.example.djalmacunha.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class adicionarActivity extends AppCompatActivity {
    Senha s;

    EditText txtSenha, txtLogin, txtSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar);

        txtSenha = (EditText)findViewById(R.id.txtSenha);
        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtSite = (EditText)findViewById(R.id.txtSite);
    }

    public void salvaSenha(View view){
        int id = s == null ? 0 : s.id;
        String senha = txtSenha.getText().toString();
        String login = txtLogin.getText().toString();
        String site = txtSite.getText().toString();

        Senha s = new Senha(id, senha, login, site);
        new GerenciaSenhas(this).salvarSenhas(s);
        Toast.makeText(this,"Senha salva" ,Toast.LENGTH_SHORT).show();
        finish();
    }


}
