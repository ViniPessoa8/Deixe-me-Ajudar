package com.example.vinicius.deixe_meajudar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Activity.Activity_cadastrar;
import Activity.Activity_logar;
import Activity.inicio;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.user.deixe_meajudar.R.layout.activity_inicio);
        Button btCadastrar = (Button)findViewById(com.example.user.deixe_meajudar.R.id.btCadastrar);
        Button btLogar = (Button)findViewById(com.example.user.deixe_meajudar.R.id.btLogar);

        btCadastrar.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                setContentView(com.example.user.deixe_meajudar.R.layout.cadastrar);
                startActivity(new Intent(MainActivity.this, Activity_cadastrar.class));
            }

        });

        btLogar.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                setContentView(com.example.user.deixe_meajudar.R.layout.logar);
                startActivity(new Intent(MainActivity.this, Activity_logar.class));
            }

        });
    }
}
