package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;

public class Activity_admin_motivacao extends AppCompatActivity {

    private String emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.includeadminadicionarconteudo).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminmotivacao).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        Button btAdicionar = findViewById(R.id.btAdicionar);
        Button btBuscar = findViewById(R.id.btBuscar);
        ImageButton btVoltar = findViewById(R.id.btVoltar);

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"Aqui reside um bug",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_admin_motivacao.this,Activity_admin_motivacao_adicionar.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"Não está pronto ainda.", Toast.LENGTH_SHORT).show();
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Activity_admin_motivacao.this,Activity_admin_pagina_principal.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
    }
}
