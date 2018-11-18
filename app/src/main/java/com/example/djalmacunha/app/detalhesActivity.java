package com.example.djalmacunha.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class detalhesActivity extends AppCompatActivity {
    senhasActivity senha;

    TextView txtSenha, txtUser, txtSite;
    static int idd;
    static String senhaUser, loginUser, siteUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes);

        Window w = getWindow();

        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(android.R.color.holo_red_light));

        txtSenha = (TextView)findViewById(R.id.txtSenhaEdicao);
        txtUser = (TextView)findViewById(R.id.txtUser);
        txtSite = (TextView)findViewById(R.id.txtSite);

        senhaUser = senha.senhaUser;
        loginUser = senha.login;
        siteUser = senha.site;
        idd = senha.idd;

        txtSite.setText(siteUser);
        txtSenha.setText(senhaUser);
        txtUser.setText(loginUser);
    }

    public void editarOnClick(View view){
        startActivity(new Intent(this, EditarActivity.class));
        finish();
    }

}
