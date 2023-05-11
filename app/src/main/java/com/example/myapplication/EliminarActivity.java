package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EliminarActivity extends AppCompatActivity {

    EditText txtID;
    Button btnEliminar;
    TextView labelEliminar;

    Connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        txtID = (EditText) findViewById(R.id.editTextNumber);
        btnEliminar = (Button) findViewById(R.id.button7);
        labelEliminar = (TextView) findViewById(R.id.textView9);
        conn = new Connection(this);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar(view);
            }
        });
    }

    public void eliminar(View view) {
        String valida = conn.findUserId(txtID.getText().toString());
        if(valida.equals("1")){
            conn.eliminarUser(txtID.getText().toString());
            labelEliminar.setText("Se elimino el ID: " + txtID.getText().toString());
            txtID.setText("");
        }else{
            labelEliminar.setText("La clave no existe");
        }
    }
}