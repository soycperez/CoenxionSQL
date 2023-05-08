package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    Connection conn;
    EditText id;
    EditText nom;
    EditText pass;
    EditText pass2;
    EditText tipo;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id = (EditText) findViewById(R.id.editTextTextId);
        nom = (EditText) findViewById(R.id.editTextTextNombre);
        pass = (EditText) findViewById(R.id.editTextTextPass);
        pass2 = (EditText) findViewById(R.id.editTextTextPass2);
        tipo = (EditText) findViewById(R.id.editTextTextTipo);
        btn = (Button) findViewById(R.id.buttonCrear);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });
    }

    public void click(View v){
        String error = "";
        if(id.getText().equals("")){
            error+="Falta el Id\n";
        }
        if(nom.getText().equals("")){
            error+="Falta el Nombre\n";
        }
        if(pass.getText().equals("")){
            error+="Falta el Password\n";
        }
        if(pass2.getText().equals("")){
            error+="Falta el Pasword 2\n";
        }
        if(tipo.getText().equals("")){
            error+="Falta el Tipo\n";
        }
        if(!(pass.getText().toString().equals(pass2.getText().toString()))){
            error+="El password no es igual";
        }
        if(error.equals("")){
            System.out.println("ok");
            conn = new Connection(this);
            conn.crearUsuario(id.getText().toString(),
                            nom.getText().toString(),
                            pass.getText().toString(),
                            tipo.getText().toString());
        }else{
            System.out.println(error);
        }
    }
}