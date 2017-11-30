package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.UsuarioDAO;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_user_config_excluir_conta extends AppCompatActivity {

    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        resetTelas();
        findViewById(R.id.includeuserexcluirconta).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");


        ImageButton btnVoltar = findViewById(R.id.btnVoltarMenuPrincipalUser);
        Button btnExcluir = findViewById(R.id.btnUserExcluirConta);

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etSenha = findViewById(R.id.etSenhaExcluirConta);
                String senha = etSenha.getText().toString();
                UsuarioDAO userDao = new UsuarioDAO(getApplicationContext());
                if(userDao.logar(emailUser, senha)){
                    userDao.deleteUsuario(emailUser);
                    Toast.makeText(Activity_user_config_excluir_conta.this, "Conta excluida.", Toast.LENGTH_SHORT).show();
                    resetTelas();
                    resetTelas();
                    Intent intent = new Intent(Activity_user_config_excluir_conta.this, Activity_user_pagina_principal.class);
                    intent.putExtra("emailUser", emailUser);
                    startActivity(intent);
                } else {
                    Toast.makeText(Activity_user_config_excluir_conta.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_config_excluir_conta.this, Activity_user_config.class);
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
