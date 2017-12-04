package com.example.user.testezin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        Button btMotivacao = (Button)findViewById(R.id.btMotivacao);
        Button btExercicios = (Button)findViewById(R.id.btExercicios);
        Button btInformacao = (Button)findViewById(R.id.btInformacao);
        ImageButton btnVoltar = findViewById(R.id.btnVoltar);


        btExercicios.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,Activity_exercicio.class);
                intent.putExtra("admin", admin);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);

                finish();
            }
        });

        btMotivacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,Activity_motivacao.class);
                intent.putExtra("admin", admin);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);

                finish();
            }
        });

        btInformacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,Activity_informacao.class);
                intent.putExtra("admin", admin);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(admin) {
                    Intent intent = new Intent(MainActivity.this, Activity_admin_pagina_principal.class);
                    intent.putExtra("emailUser", emailUser);
                    intent.putExtra("admin", true);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, Activity_user_pagina_principal.class);
                    intent.putExtra("emailUser", emailUser);
                    intent.putExtra("admin", false);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
