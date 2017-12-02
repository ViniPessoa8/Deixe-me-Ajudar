
package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;

/**
 * Created by Vinicius on 29/11/2017.
 */

public class Activity_admin_pagina_principal extends AppCompatActivity {

    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.includeadminprincipal).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        userEmail = intent.getStringExtra("userEMail");

        ImageView btnMotivacao = findViewById(R.id.btnMotivacaoAdmin);
        ImageView btnConfig = findViewById(R.id.btnMotivacaoAdmin);
        ImageView btnExercicios = findViewById(R.id.btnExerciciosAdmin);
        ImageView btnPertoDeVoce = findViewById(R.id.btnPertoDeVoceAdmin);
        ImageView btnInformacoes = findViewById(R.id.btnInformacoesAdmin);
        ImageButton btnVoltar = findViewById(R.id.btnVoltarInicioAdmin);

        btnMotivacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_pagina_principal.this, Activity_admin_motivacao.class);
                intent.putExtra("userEmail", userEmail);
                startActivity(intent);
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // resetTelas();
                //Intent intent = new Intent(Activity_admin_pagina_principal.this, .class);
                //intent.putExtra("adminEmail", userEmail);
                //startActivity(intent);
            }
        });

        btnExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_pagina_principal.this, Activity_admin_exercicio.class);
                intent.putExtra("adminEmail", userEmail);
                startActivity(intent);
            }
        });

        btnPertoDeVoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //resetTelas();
                //Intent intent = new Intent(Activity_admin_pagina_principal.this, Activity_admin_perto_de_voce.class);
                //intent.putExtra("adminEmail",userEmail);
                //startActivity(intent);
            }
        });

        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_pagina_principal.this, Activity_admin_informacao.class);
                intent.putExtra("adminEmail", userEmail);
                startActivity(intent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                Intent intent = new Intent(Activity_admin_pagina_principal.this, Activity_inicio_pagina_inicial.class);
                intent.putExtra("adminEmail", userEmail);
                startActivity(intent);
            }
        });
    }

    protected void resetTelas() {
        findViewById(R.id.includeadminprincipal).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadmininformacaobuscar).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminexercicioadicionar).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminmotivacaoadicionar).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadmininformacaoadicionar).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadmininformacaoadicionar).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadmininformacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminexercicios).setVisibility(View.INVISIBLE);


    }
}