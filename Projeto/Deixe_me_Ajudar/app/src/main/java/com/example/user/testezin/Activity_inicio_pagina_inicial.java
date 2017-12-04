package com.example.user.testezin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_inicio_pagina_inicial extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);


        Button btLogin = findViewById(R.id.btnLogin);
        Button btCadastro = findViewById(R.id.btnCadastro);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_pagina_inicial.this, Activity_inicio_login.class);

                startActivity(intent);
                finish();
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inicio_pagina_inicial.this, Activity_inicio_cadastro.class);

                startActivity(intent);
                finish();
            }
        });
    }
}
