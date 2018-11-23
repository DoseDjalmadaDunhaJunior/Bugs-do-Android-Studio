package com.example.djalmacunha.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

// Classe de cadastro da senha

public class senhasActivity extends AppCompatActivity {
    menuActivity m;

    static ListView listView;

    static String senhaUser, login, site;
    static int idd;

    ArrayAdapter<Senha> clientesAdapter;
    List<Senha> senhas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senhas);


        listView = (ListView) findViewById(R.id.ListViewSenhas);
        carregarListagem();


        // Criando o longo clique para deletar algo do banco
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Context context = view.getContext();
                final Senha senha = (Senha)listView.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Exluir").setMessage("Quer mesmo exluir esta senha?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new GerenciaSenhas(getBaseContext()).excluirSenha(senha.id);
                        carregarListagem();
                        Toast.makeText(context,"Senha exluida", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancelar",null).create().show();
                return true;
            }
        });

        // Criando o toque no item para abrir os detalhes
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                final Senha senha = (Senha) listView.getItemAtPosition(position);
                senhaUser = senha.senha;
                login = senha.login;
                site = senha.site;
                idd = senha.id;
                Intent detalhes = new Intent(senhasActivity.this, detalhesActivity.class);
                startActivity(detalhes);
            }

        });
    }

    // Função que preenche a listView com o que tem no banco
    public void carregarListagem(){

        List<Senha> senhas = new GerenciaSenhas(this).retornarSenhas(m.usuario);
        if(senhas.size() == 0){
            Toast.makeText(this, "Você ainda não cadastrou nenhuma senha", Toast.LENGTH_SHORT).show();

        }
        ArrayAdapter<Senha> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhas);

        listView.setAdapter(clientesAdapter);
    }
}
