package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;

/**
 * Created by vinicius on 30/11/17.
 */

public class Activity_admin_informacoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        resetTelas();
        findViewById(R.id.includeadmininformacoes).setVisibility(View.VISIBLE);

        Button btnAdicionar = findViewById(R.id.btnAdicionarAdminInformacoes);
        Button btnBuscar = findViewById(R.id.btnBuscarAdminInformacoes);
        Button btnExcluir = findViewById(R.id.btnExcluirAdminInformacoes);
        ImageButton btnVoltar = findViewById(R.id.btnVoltarAdminInformacoes);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_informacoes.this, Activity_admin_pagina_principal.class);
                startActivity(intent);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_informacoes.this, Activity_admin_pagina_principal.class);
                startActivity(intent);
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_informacoes.this, Activity_admin_pagina_principal.class);
                startActivity(intent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_informacoes.this, Activity_admin_pagina_principal.class);
                startActivity(intent);
            }
        });

    }

    protected void resetTelas(){
        findViewById(R.id.includeadminprincipal).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminbuscarmotivacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminbuscarinformacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminbuscarexercicio).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminadicionarexercicio).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminadicionarmotivacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminadicionarinformacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadmininformacoes).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminexercicios).setVisibility(View.INVISIBLE);


    }
}
