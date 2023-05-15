package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ListarActivity extends AppCompatActivity {
    Connection conn;
    EditText textArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        textArea = (EditText) findViewById(R.id.editTextTextMultiLine);
        conn = new Connection(this);
        String aux = conn.MuestraTodoUsuarios();
        textArea.setText(aux);
    }


}