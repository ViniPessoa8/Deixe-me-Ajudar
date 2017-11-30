package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_user_pagina_principal extends AppCompatActivity {

    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        resetTelas();
        findViewById(R.id.includeuserprincipal).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        ImageView btnMotivacao = findViewById(R.id.btnMotivacao);
        ImageView btnRelatorio = findViewById(R.id.btnRelatorio);
        ImageView btnPertoDeVoce = findViewById(R.id.btnPertoDeVoce);
        ImageView btnConfig = findViewById(R.id.btnConfig);
        ImageView btnExercicios = findViewById(R.id.btnExercicios);
        ImageView btnInformacoes = findViewById(R.id.btnInformacoes);
        ImageView btnBuscar = findViewById(R.id.btnBuscarPrincipalUser);
        ImageButton btnVoltar = findViewById(R.id.btnVoltarInicioUser);

        btnMotivacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_motivacao.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
        btnRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_relatorio.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
        btnPertoDeVoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                //Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_.class);
                //intent.putExtra("emailUser", emailUser);
                //startActivity(intent);
            }
        });
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_config.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
        btnExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_exercicios.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_informacoes.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_user_buscar_conteudo.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_user_pagina_principal.this, Activity_inicio_pagina_inicial.class);
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
