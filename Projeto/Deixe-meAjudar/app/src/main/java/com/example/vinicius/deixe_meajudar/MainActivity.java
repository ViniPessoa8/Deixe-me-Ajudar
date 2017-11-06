package com.example.vinicius.deixe_meajudar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregapagInicial();
    }

    public void carregaCadastro(){

    }

    public void carregaEntrar(){
        carregaPagUserPrincipal();
    }

    public void carregaPagUserPrincipal(){
        setContentView(R.layout.user_principal);

        ImageView btnInformacoes = (ImageView)findViewById(R.id.btnInformacoes);
        ImageView btnMotivacao = (ImageView)findViewById(R.id.btnMotivacao);
        ImageButton btnVoltar = (ImageButton)findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregapagInicial();
            }
        });

        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaInformacoes();
            }
        });

        btnMotivacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaMotivacao();
            }
        });

    }

    public void carregaInformacoes(){
        setContentView(R.layout.info);

        ImageButton btnVoltar = (ImageButton)findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPagUserPrincipal();
            }
        });
    }

    public void carregaMotivacao(){
        setContentView(R.layout.infoteste);

        ImageButton btnVoltar = (ImageButton)findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPagUserPrincipal();
            }
        });
    }

    public void carregaConfig(){
        setContentView(R.layout.configuracoes);

        ImageButton btnVoltar = (ImageButton)findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPagUserPrincipal();
            }
        });
    }

    public void carregapagInicial(){
        setContentView(R.layout.paginicial);

        Button btnEntrar = (Button)findViewById(R.id.btnEntrar);
        Button btnCadastro = (Button)findViewById(R.id.btnCadastro);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPagUserPrincipal();
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPagAdminPrincipal();
            }
        });
    }

    public void carregaPagAdminPrincipal(){
        setContentView(R.layout.admin_principal);

        ImageView btnPertoDeVoce = (ImageView)findViewById(R.id.btnPertoDeVoce);

        btnPertoDeVoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPertoDeVoce();
            }
        });
    }

    public void carregaPertoDeVoce(){
        setContentView(R.layout.admin_pertodevoce);

        ImageButton btnVoltar = (ImageButton)findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaPagAdminPrincipal();
            }
        });
    }
}
