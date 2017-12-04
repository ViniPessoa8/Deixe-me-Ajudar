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

public class Activity_inicio_login extends AppCompatActivity {

    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        admin = false;

        Button btLogar = findViewById(R.id.btnLogar);
        ImageView btVoltarInicioLogin = findViewById(R.id.btnVoltarInicioLogin);

        btVoltarInicioLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_login.this, Activity_inicio_pagina_inicial.class);
                startActivity(intent);

                finish();
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
                        admin = true;
                        Toast.makeText(Activity_inicio_login.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                        intent = new Intent(Activity_inicio_login.this, Activity_admin_pagina_principal.class);
                        intent.putExtra("emailUser", email);
                        intent.putExtra("admin", true);
                        startActivity(intent);
                        finish();
                    } else {

                        Toast.makeText(Activity_inicio_login.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                        intent = new Intent(Activity_inicio_login.this, Activity_user_pagina_principal.class);
                        intent.putExtra("emailUser", email);
                        intent.putExtra("admin", false);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(Activity_inicio_login.this, "Erro no login, verifique os dados.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}