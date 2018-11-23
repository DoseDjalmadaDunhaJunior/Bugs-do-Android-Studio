package com.example.djalmacunha.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

// Classe que faz o cadastro do usuário

public class cadastrarActivity extends AppCompatActivity {
    User s;

    DBHelper db;

    EditText txtUser, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        db = new DBHelper(this);

        txtUser = (EditText)findViewById(R.id.txtUser);
        txtSenha = (EditText)findViewById(R.id.txtSenhaEdicao);
    }

    public void salvarUser(View view){
        if(txtUser.getText().toString().equals("") || txtSenha.getText().toString().equals("")){
            Toast.makeText(this, "Não deixe nennum campo vazio", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = s == null ? 0 : s.id;
        String senha = txtUser.getText().toString();
        String login = txtSenha.getText().toString();

        User s = new User(id, login, senha);
        new GerenciaSenhas(this).salvarUser(s);
        Toast.makeText(this,"Cadastro realizado" ,Toast.LENGTH_SHORT).show();
        finish();
    }
}
