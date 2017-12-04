package com.example.user.testezin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_inicio_cadastro extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        Button btCadastrar = findViewById(R.id.btnCadastrar);
        ImageView btVoltarInicioCadastro = findViewById(R.id.btnVoltarInicioCadastro);

        btVoltarInicioCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_cadastro.this, Activity_inicio_pagina_inicial.class);
                startActivity(intent);
                finish();
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtEmail = findViewById(R.id.txtEmailCadastro);
                EditText txtSenha = findViewById(R.id.txtSenhaCadastro);
                EditText txtConfirmacao = findViewById(R.id.txtConfirmacaoCadastro);
                EditText txtNome = findViewById(R.id.txtNome);

                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();
                String confirmacao = txtConfirmacao.getText().toString();
                String nome = txtNome.getText().toString();

                if(senha.equals(confirmacao)) {
                    UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());
                    if(usuarioDAO.cadastrar(nome, email, senha, false)){
                        Intent intent = new Intent(Activity_inicio_cadastro.this, Activity_inicio_login.class);

                        startActivity(intent);

                        Toast.makeText(Activity_inicio_cadastro.this, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();

                        finish();
                    } else {
                        Toast.makeText(Activity_inicio_cadastro.this, "Não foi possível salvar sua conta.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}