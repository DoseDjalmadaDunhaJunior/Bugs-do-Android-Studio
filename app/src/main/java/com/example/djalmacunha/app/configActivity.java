package com.example.djalmacunha.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

// Classe de configuração, onde é possível limpar todos os dados do app

public class configActivity extends AppCompatActivity {

    Button btnDeletar, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes);

        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnDeletar = (Button) findViewById(R.id.btnDeletar);
    }

    public void limparTudo(View view){
        // List que armazena as senhas que são obtidas do banco
        List<Senha> senhas = new GerenciaSenhas(this).retornarSenhas();

        ArrayAdapter<Senha> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhas);

        /* For que verifica o banco para limpa-lo */
        for(int i = 0; i < clientesAdapter.getCount(); i++){
            new GerenciaSenhas(getBaseContext()).excluirSenha(clientesAdapter.getItem(i).id);
        }

        List<User> users = new GerenciaSenhas(this).retornarUser();
        ArrayAdapter<User> clientesAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);

        for(int i = 0; i < clientesAdapter2.getCount(); i++){
            new GerenciaSenhas(getBaseContext()).exluirUser(clientesAdapter2.getItem(i).id);
        }


        Toast.makeText(this, "Todas as informações foram deletadas. Você voltará para a tela de login", Toast.LENGTH_SHORT).show();


        // Um jeito de trocar de activity fechando todas as anteriores
        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



    // Mesma coisa que a função de cima, mas só pras senhas
    public void limparSenhas(View view) {

        List<Senha> senhas = new GerenciaSenhas(this).retornarSenhas();
        if (senhas.size() == 0) {
            Toast.makeText(this, "Não há senha para ser deletada", Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayAdapter<Senha> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhas);

        for(int i = 0; i < clientesAdapter.getCount(); i++){
            new GerenciaSenhas(getBaseContext()).excluirSenha(clientesAdapter.getItem(i).id);
        }

        Toast.makeText(this, "Todas as senhas foram deletadas", Toast.LENGTH_SHORT).show();

        finish();
    }
}
