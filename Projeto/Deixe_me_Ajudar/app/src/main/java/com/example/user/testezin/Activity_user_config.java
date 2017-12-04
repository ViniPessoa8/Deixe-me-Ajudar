package com.example.user.testezin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_user_config extends AppCompatActivity {

    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        Button btAlterarEmail = findViewById(R.id.btAlterarEmail);
        Button btAlterarSenha = findViewById(R.id.btAlterarSenha);
        Button btExcluirConta = findViewById(R.id.btExcluirConta);
        ImageButton btVoltar = findViewById(R.id.btVoltar);


        btAlterarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_config_alterar_email.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();

            }
        });

        btAlterarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_config_alterar_senha.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });

        btExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_config_excluir_conta.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_pagina_principal.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });
    }
}