package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModificarActivity extends AppCompatActivity {


    Connection conn;
    Button btnBuscar;
    EditText textID;
    EditText textNom;
    EditText textPass;
    EditText textPass2;
    EditText textTipo;
    Button btnModificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        conn = new Connection(this);
        btnBuscar = (Button)  findViewById(R.id.btnBuscar);
        textID = (EditText) findViewById(R.id.editTextNumber2);
        textNom = (EditText) findViewById(R.id.editTextTextNombre);
        textPass = (EditText) findViewById(R.id.editTextTextPass);
        textPass2 = (EditText) findViewById(R.id.editTextTextPass3);
        textTipo = (EditText) findViewById(R.id.editTextTextTipo);
        btnModificar = (Button) findViewById(R.id.button9);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBtnSearch(v);
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBtnModificar(v);
            }
        });
    }

    public void clickBtnSearch(View view){

        String id = textID.getText().toString();
        if(textID.equals("")){
            System.out.println("Falta el ID");
        }else{
            Usuario1 usuario1;
            usuario1 = conn.findUserIdAll(id);
            textNom.setText(usuario1.nom);
            textPass.setText(usuario1.pass);
            textPass2.setText(usuario1.pass);
            textTipo.setText(usuario1.tipo);
        }

    }

    public void clickBtnModificar(View view){
        String id = textID.getText().toString();
        String nom = textNom.getText().toString();
        String pass = textPass.getText().toString();
        String pass2 = textPass2.getText().toString();
        String tipo = textTipo.getText().toString();

        String error = "";
        if(id.equals("")){
            error += "Falta el ID\n";
        }
        if(nom.equals("")){
            error += "Falta el nombre\n";
        }
        if(pass.equals("")){
            error += "Falta el password\n";
        }
        if(!pass.equals(pass2)){
            error += "El password no es igual\n";
        }
        if(tipo.equals("")){
            error += "Falta el tipo\n";
        }
        if(error.equals("")){
            conn.actualizar(id, nom, pass, tipo);
        }
        System.out.println(error);

    }
}