package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.UsuarioDAO;

public class ActivityInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_main);


        //Página de inicio
        Button btLogin = findViewById(R.id.btnLogin);
        Button btCadastro = findViewById(R.id.btnCadastro);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.includeinicio).setVisibility(View.INVISIBLE);
                findViewById(R.id.includelogin).setVisibility(View.VISIBLE);
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.includeinicio).setVisibility(View.INVISIBLE);
                findViewById(R.id.includecadastro).setVisibility(View.VISIBLE);
            }
        });

        //Página De Cadastro
        Button btCadastrar = findViewById(R.id.btnCadastrar);
        ImageView btVoltarInicioCadastro = findViewById(R.id.btnVoltarInicioCadastro);

        btVoltarInicioCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.includelogin).setVisibility(View.INVISIBLE);
                findViewById(R.id.includecadastro).setVisibility(View.INVISIBLE);
                findViewById(R.id.includeinicio).setVisibility(View.VISIBLE);
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
                        findViewById(R.id.includecadastro).setVisibility(View.INVISIBLE);
                        findViewById(R.id.includelogin).setVisibility(View.VISIBLE);
                        Toast.makeText(ActivityInicio.this, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ActivityInicio.this, "Não foi possível salvar sua conta.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Página de Login
        Button btLogar = findViewById(R.id.btnLogar);
        ImageView btVoltarInicioLogin = findViewById(R.id.btnVoltarInicioLogin);

        btVoltarInicioLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.includelogin).setVisibility(View.INVISIBLE);
                findViewById(R.id.includecadastro).setVisibility(View.INVISIBLE);
                findViewById(R.id.includeinicio).setVisibility(View.VISIBLE);
            }
        });

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtEmail = findViewById(R.id.txtEmailLogin);
                EditText txtSenha = findViewById(R.id.txtSenhaLogin);
                UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());

                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();
                Intent intent;
                if(usuarioDAO.logar(email, senha)){
                    if(email.equals("admin") && senha.equals("admin")){
                        Toast.makeText(ActivityInicio.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ActivityInicio.this, ActivityAdmin.class);
                        startActivity(intent);
                    }
                    Toast.makeText(ActivityInicio.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ActivityInicio.this, Activity_user_pagina_principal.class);
                    intent.putExtra("emailUser", email);
                    startActivity(intent);
                } else {
                    Toast.makeText(ActivityInicio.this, "Erro no login, verifique os dados.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
