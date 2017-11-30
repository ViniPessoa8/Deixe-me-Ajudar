package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_user_config extends AppCompatActivity {

    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        resetTelas();
        findViewById(R.id.includeuserconfig).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        Button btAlterarEmail = findViewById(R.id.btAlterarEmail);
        Button btAlterarSenha = findViewById(R.id.btAlterarSenha);
        Button btExcluirConta = findViewById(R.id.btExcluirConta);
        ImageButton btVoltar = findViewById(R.id.btVoltar);


        btAlterarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_config_alterar_email.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);

            }
        });

        btAlterarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_config_alterar_senha.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });

        btExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_config_excluir_conta.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config.this, Activity_user_pagina_principal.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
    }

    protected void resetTelas(){
        findViewById(R.id.includeuserconfig).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserexercicios).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserinformacoes).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeusermotivacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserpertodevoce).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserrelatorio).setVisibility(View.INVISIBLE);
    }
}