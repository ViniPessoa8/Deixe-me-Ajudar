package com.example.user.testezin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_user_pagina_principal extends AppCompatActivity {

    private String emailUser, nomeUser;
    private UsuarioDAO userDao;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_principal);

        userDao = new UsuarioDAO(getApplicationContext());

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        Usuario user = userDao.getUsuarioEmail(emailUser);
        nomeUser = user.getNome();
        admin = intent.getBooleanExtra("admin", false);

        String txt = "Bem-vindo, "+nomeUser+"!";

        ImageView btnConteudo = findViewById(R.id.btnConteudo);
        ImageView btnConfig = findViewById(R.id.btnConfig);
        ImageButton btnVoltar = findViewById(R.id.btnVoltarInicioUser);
        TextView txtBemVindo = findViewById(R.id.txtBemVindo);

        txtBemVindo.setText(txt);


        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_config.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
            }
        });
        btnConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_pagina_principal.this, MainActivity.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_inicio_pagina_inicial.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
            }
        });
    }
}
