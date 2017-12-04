package com.example.user.testezin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_user_config_alterar_email extends AppCompatActivity {

    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes_alterar_email);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        Button btAlterar = findViewById(R.id.btAlterar);
        ImageButton btnVoltarAlterarEmail = findViewById(R.id.btVoltarAlterarEmail);

        btAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDAO userDao = new UsuarioDAO(getApplicationContext());
                EditText etEmailNovo = findViewById(R.id.txtNewEmail);
                EditText etEmailConfirma = findViewById(R.id.txtConfirmacao);
                EditText etSenha = findViewById(R.id.txtSenhaAlterarEmail);

                String email = etEmailNovo.getText().toString();
                String confirmaEmail = etEmailConfirma.getText().toString();
                String senha = etSenha.getText().toString();

                if(email.equals(confirmaEmail)){
                    if(userDao.logar(emailUser, senha)){
                        if(userDao.alterarEmail(emailUser, email)){
                            emailUser = email;
                            Toast.makeText(Activity_user_config_alterar_email.this, "O E-mail foi alterado com sucesso.\n email: "+email+"\nemailUser: "+emailUser  , Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Activity_user_config_alterar_email.this, Activity_user_pagina_principal.class);
                            intent.putExtra("emailUser", emailUser);
                            intent.putExtra("admin", admin);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        Toast.makeText(Activity_user_config_alterar_email.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Activity_user_config_alterar_email.this, "Os E-mails não são iguais!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnVoltarAlterarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config_alterar_email.this, Activity_user_config.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });
    }


}