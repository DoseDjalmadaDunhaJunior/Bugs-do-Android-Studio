package com.example.djalmacunha.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.LinearLayout;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity{

    public EditText txtLogin;
    public EditText txtSenha;
    public DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Window w = getWindow();

        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(android.R.color.holo_red_light));

        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        helper = new DBHelper(this);
    }

    public void salvarViagem (String login, String senha){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("login", login);
        values.put("senha", senha);

        long resultado = db.insert("usuarios", null, values);

        if(resultado != -1){
            Toast.makeText(this,"Erro ao cadastrar" ,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Cadastro realizado, insira os dados para fazer login", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastraUsuario(View view){
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cadastro");

        builder.setMessage("Insira seus dados para se cadastrar:\n");

        Context context = view.getContext();
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText txtLoginUser = new EditText(context);
        txtLoginUser.setHint("Usuário");
        layout.addView(txtLoginUser);


        final EditText txtSenhaUser = new EditText(context);
        txtSenhaUser.setHint("Senha");
        layout.addView(txtSenhaUser);

        builder.setView(layout);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                salvarViagem(txtLoginUser.getText().toString(), txtSenhaUser.getText().toString());
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    public void btnEntrarOnClick(View view){
        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();

        startActivity(new Intent(this, menuActivity.class));
/*
        if("abc".equals(login) && "123".equals(senha)){

        }
        else{
            AlertDialog alerta;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Erro");

            builder.setMessage("Login ou senha incorretos.\n\nCaso não tenha login, clique no ícone de cadastro.");
            builder.setNeutralButton("OK", null);

            alerta = builder.create();
            alerta.show();
        }*/
    }

}



