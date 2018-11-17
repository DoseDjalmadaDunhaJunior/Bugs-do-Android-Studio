package com.example.djalmacunha.app;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class senhasActivity extends AppCompatActivity {

    ListView listView;

    ArrayAdapter<Senha> clientesAdapter;
    List<Senha> senhas;

    //Dessa forma fica o cadastro com o clique longo para a exclusão
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senhas);

        Window w = getWindow();

        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(android.R.color.holo_red_light));


        listView = (ListView) findViewById(R.id.ListViewSenhas);
        carregarListagem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {


                AlertDialog.Builder adb = new AlertDialog.Builder(
                        senhasActivity.this);
                adb.setTitle("Sua senha do " + parent.getItemAtPosition(position).toString());
                adb.setMessage("Usuário: " + get);
                adb.setPositiveButton("Ok", null);
                adb.show();

            }

        });

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

    public String getLogin(String site){
        for (int i = 0; i < clientesAdapter.getCount(); i++){
            if(site.equals(clientesAdapter.getItem(i).site)){
                return clientesAdapter.getItem(i).login;
            }
        }
        return null;
    }


    public void carregarListagem(){
        ListView resultsListView = (ListView) findViewById(R.id.ListViewSenhas);

        List<Senha> senhas = new GerenciaSenhas(this).retornarSenhas();
        if(senhas.size() == 0){
            Toast.makeText(this, "Você ainda não cadastrou nenhuma senha", Toast.LENGTH_SHORT).show();

        }
        ArrayAdapter<Senha> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhas);

        resultsListView.setAdapter(clientesAdapter);



        /*
        HashMap<String, String> nameAddresses = new HashMap<>();

        for(int i = 0; i < clientesAdapter.getCount(); i++){
            nameAddresses.put(clientesAdapter.getItem(i).site, clientesAdapter.getItem(i).login);
        }


        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.senhas,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});


        Iterator it = nameAddresses.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", "Usuário: " + pair.getValue().toString() + "\n");
            listItems.add(resultsMap);
        }





        listView.setAdapter(adapter);



        for(int i = 0; i < clientesAdapter.getCount(); i++){
            Log.d("User", clientesAdapter.getItem(i).login);
            Log.d("Senha", clientesAdapter.getItem(i).senha);
            Log.d("Site", clientesAdapter.getItem(i).site);
        }*/
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
