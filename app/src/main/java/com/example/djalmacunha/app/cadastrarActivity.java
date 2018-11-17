package com.example.djalmacunha.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrarActivity extends AppCompatActivity {
    User s;

    EditText txtUser, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        txtUser = (EditText)findViewById(R.id.txtUser);
        txtSenha = (EditText)findViewById(R.id.txtSenha);
    }

    public void salvarUser(View view){
        int id = s == null ? 0 : s.id;
        String senha = txtUser.getText().toString();
        String login = txtSenha.getText().toString();

        User s = new User(id, login, senha);
        new GerenciaSenhas(this).salvarUser(s);
        Toast.makeText(this,"Cadastro realizado" ,Toast.LENGTH_SHORT).show();
        finish();
    }
}
