package com.example.djalmacunha.app;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class senhasActivity extends AppCompatActivity {

    ListView listView;

    //Dessa forma fica o cadastro com o clique longo para a exclusão
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senhas);
        listView = (ListView) findViewById(R.id.ListViewSenhas);
        carregarListagem();

        /*

        listView.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final Context ctx = view.getContext();
                final Cliente cliente = (Cliente) listView.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Confirmação").setMessage("Tem certeza que deseja excluir este cliente?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new GerenciadorClientes(getBaseContext()).excluirCliente(cliente.id);
                        carregarListagem();
                        Toast.makeText(ctx, "Cliente excluído com sucesso!", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("Cancelar", null).create().show();
                return false;
            }
        });*/
    }


    public void carregarListagem(){
        List<Senha> senhas = new GerenciaSenhas(this).retornarSenhas();
        if(senhas.size() == 0){
            Toast.makeText(this, "Nenhum cliente cadastrado!", Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<Senha> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhas);
        listView.setAdapter(clientesAdapter);
    }
/*
    @Override
    protected void onRestart(){
        super.onRestart();
        carregarListagem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("Novo Cliente");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
        return true;
    }*/

}
