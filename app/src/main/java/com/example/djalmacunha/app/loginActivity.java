package com.example.djalmacunha.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

// Classe que faz o login do usuário

public class loginActivity extends AppCompatActivity{

    public EditText txtLogin;
    public EditText txtSenha;
    public DBHelper helper;
    public static String usuario;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Colorindo a barra de cima
        Window w = getWindow();

        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(android.R.color.holo_red_light));

        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenhaEdicao);

        db = new DBHelper(this);
    }

    // Verificando se o usuário está correto
    public void carregarUser(View view) {


        String username = txtLogin.getText().toString();
        String password = txtSenha.getText().toString();

        usuario = username;

        if (username.equals("")) {
            Toast.makeText(loginActivity.this, "Não deixe o login vazio", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(loginActivity.this, "Não deixe a senha vazia", Toast.LENGTH_SHORT).show();

        } else {

            String res = db.loginUser(username, password);
            if (res.equals("OK")) {
                startActivity(new Intent(loginActivity.this, menuActivity.class));
                txtLogin.setText("");
                txtSenha.setText("");

            } else {
                Toast.makeText(loginActivity.this, "Login ou senha incorretos", Toast.LENGTH_SHORT).show();

            }


        }

    }

    // Chamando a classe de cadastro
    public void cadastraUsuario(View view){
        startActivity(new Intent(this, cadastrarActivity.class));
    }

}



