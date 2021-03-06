package com.example.djalmacunha.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// Classe que edita informações que estão no banco

public class EditarActivity extends AppCompatActivity {
    detalhesActivity detalhes;
    senhasActivity senha;

    TextView txtSite;
    EditText txtSenha, txtUser;

    menuActivity m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);


        // Colore a barra superior
        Window w = getWindow();

        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(android.R.color.holo_red_light));

        txtSenha = (EditText)findViewById(R.id.txtNovaSenha);
        txtUser = (EditText)findViewById(R.id.txtNovoUser);
        txtSite = (TextView)findViewById(R.id.txtSite);


        txtSite.setText(senha.site);
        txtSenha.setText(senha.senhaUser);
        txtUser.setText(senha.login);
    }


    // Chamando a listagem novamente quando troca a informação pra tudo ficar atualizado
    public void mostraLista(){
        List<Senha> senhas = new GerenciaSenhas(this).retornarSenhas(m.usuario);
        if(senhas.size() == 0)
            Toast.makeText(this,"Você ainda não cadastrou nenhuma senha",Toast.LENGTH_SHORT).show();

        ArrayAdapter<Senha> senha = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhas);
        senhasActivity.listView.setAdapter(senha);
    }

    // Salvando uma informçação nova
    public void salvarNovaSenha(View view){
        String senha = txtSenha.getText().toString();
        String user = txtUser.getText().toString();

        Senha senhas = new Senha(detalhes.idd,senha,user,detalhes.siteUser, m.usuario);
        new GerenciaSenhas(this).salvarSenhas(senhas);
        Toast.makeText(this, "Senha atualizada", Toast.LENGTH_SHORT).show();
        mostraLista();
        finish();
    }
}
