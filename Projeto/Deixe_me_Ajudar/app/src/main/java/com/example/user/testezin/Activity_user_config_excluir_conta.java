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

public class Activity_user_config_excluir_conta extends AppCompatActivity {

    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes_desativar_conta);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        ImageButton btnVoltar = findViewById(R.id.btVoltar);
        Button btnExcluir = findViewById(R.id.btnExcluir);

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDAO userDao = new UsuarioDAO(getApplicationContext());
                    if(userDao.deleteUsuario(emailUser)) {
                        Toast.makeText(Activity_user_config_excluir_conta.this, "Conta excluida.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Activity_user_config_excluir_conta.this, Activity_inicio_pagina_inicial.class);
                        startActivity(intent);
                    }
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_config_excluir_conta.this, Activity_user_config.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);

            }
        });
    }

}
