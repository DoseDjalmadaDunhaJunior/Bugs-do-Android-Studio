package com.example.djalmacunha.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText log;
    private EditText code;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = (EditText)findViewById(R.id.loginB);
        code = (EditText)findViewById(R.id.senhaB);
        ok = (Button)findViewById(R.id.go);

    }
}
