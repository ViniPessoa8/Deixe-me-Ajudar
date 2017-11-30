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

public class Activity_user_exercicios extends AppCompatActivity {

    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        resetTelas();
        findViewById(R.id.includeuserexercicios).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        Button btnMeditacoes = findViewById(R.id.btnUserMeditacoes);
        Button btnVideos = findViewById(R.id.btnUserVideos);
        Button btnOutros = findViewById(R.id.btnUserOutros);

        btnMeditacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
