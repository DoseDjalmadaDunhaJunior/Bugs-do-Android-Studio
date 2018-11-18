package com.example.djalmacunha.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

// Classe que faz o login do usuário

public class loginActivity extends AppCompatActivity{

    public EditText txtLogin;
    public EditText txtSenha;
    public DBHelper helper;

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

        helper = new DBHelper(this);
    }

    // Verificando se o usuário está correto
    public void carregarUser(View view) {

        List<User> users = new GerenciaSenhas(this).retornarUser();
        if (users.size() == 0) {
            Toast.makeText(this, "Não há nenhum usuário registrado", Toast.LENGTH_SHORT).show();
            return;

        }
        ArrayAdapter<User> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);

        String loginUser = txtLogin.getText().toString();
        String senhaUser = txtSenha.getText().toString();

        for(int i = 0; i < clientesAdapter.getCount(); i++){
            if(loginUser.equals(clientesAdapter.getItem(i).login) && senhaUser.equals(clientesAdapter.getItem(i).senha)) {
                startActivity(new Intent(this, menuActivity.class));
                txtLogin.setText("");
                txtSenha.setText("");
                return;
            }
        }
        Toast.makeText(this,"Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
    }

    // Chamando a classe de cadastro
    public void cadastraUsuario(View view){
        startActivity(new Intent(this, cadastrarActivity.class));
    }

}



