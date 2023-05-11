package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Connection conn;

    EditText user;
    EditText pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checar(view);
            }
        });

    }

    public void checar(View view){
        conn = new Connection(this);
        String result = conn.findUser(user.getText().toString(), pass.getText().toString());
        System.out.println(result);
        if(result.equals("1")){
            user.setText("");
            pass.setText("");
            Intent i = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "El usuario no es valido", Toast.LENGTH_SHORT).show();
            user.setText("");
            pass.setText("");
        }

    }
}

