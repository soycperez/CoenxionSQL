package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnCrear;
    Button btnModificar;
    Button btnEliminar;
    Button btnConsultar;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCrear = (Button) findViewById(R.id.button2);
        btnModificar = (Button) findViewById(R.id.button3);
        btnEliminar = (Button) findViewById(R.id.button4);
        btnConsultar = (Button) findViewById(R.id.button5);
        btnSalir = (Button) findViewById(R.id.button6);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, EliminarActivity.class);
                startActivity(i);
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ModificarActivity.class);
                startActivity(i);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ListarActivity.class);
                startActivity(i);
            }
        });

    }
}