package com.example.djalmacunha.app;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText log;
    private EditText code;
    private Button ok;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_controle);
        /*log = (EditText)findViewById(R.id.loginB);
        code = (EditText)findViewById(R.id.senhaB);
        ok = (Button)findViewById(R.id.go);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("pegou os dados " + log + "\n" + code + "\n");
            }
        });*/

    }
}
