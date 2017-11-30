package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_inicio_pagina_inicial extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_main);
        resetTelas();
        findViewById(R.id.includeinicio).setVisibility(View.VISIBLE);

        findViewById(R.id.includeinicio).setVisibility(View.VISIBLE);


        Button btLogin = findViewById(R.id.btnLogin);
        Button btCadastro = findViewById(R.id.btnCadastro);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_pagina_inicial.this, Activity_inicio_login.class);

                startActivity(intent);
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_pagina_inicial.this, Activity_inicio_cadastro.class);

                startActivity(intent);
            }
        });
    }

    protected void resetTelas(){
        findViewById(R.id.includeinicio).setVisibility(View.INVISIBLE);
        findViewById(R.id.includelogin).setVisibility(View.INVISIBLE);
        findViewById(R.id.includecadastro).setVisibility(View.INVISIBLE);
    }
}
