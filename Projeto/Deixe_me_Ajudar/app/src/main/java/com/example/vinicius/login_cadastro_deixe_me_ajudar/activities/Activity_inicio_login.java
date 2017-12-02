package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.UsuarioDAO;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_inicio_login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_main);
        resetTelas();
        findViewById(R.id.includelogin).setVisibility(View.VISIBLE);

        Button btLogar = findViewById(R.id.btnLogar);
        ImageView btVoltarInicioLogin = findViewById(R.id.btnVoltarInicioLogin);

        btVoltarInicioLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_login.this, Activity_inicio_pagina_inicial.class);
                startActivity(intent);
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
                        Toast.makeText(Activity_inicio_login.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                        intent = new Intent(Activity_inicio_login.this, Activity_admin_pagina_principal.class);
                        intent.putExtra("emailUser", email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Activity_inicio_login.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                        intent = new Intent(Activity_inicio_login.this, Activity_user_pagina_principal.class);
                        intent.putExtra("emailUser", email);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(Activity_inicio_login.this, "Erro no login, verifique os dados.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    protected void resetTelas(){
        findViewById(R.id.includeinicio).setVisibility(View.INVISIBLE);
        findViewById(R.id.includelogin).setVisibility(View.INVISIBLE);
        findViewById(R.id.includecadastro).setVisibility(View.INVISIBLE);
    }
}