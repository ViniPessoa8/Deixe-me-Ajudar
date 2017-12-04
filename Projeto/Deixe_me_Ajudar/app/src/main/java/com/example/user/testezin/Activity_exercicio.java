package com.example.user.testezin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity_exercicio extends AppCompatActivity
{

    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        Button btAdicionar = (Button)findViewById(R.id.btAdicionar);
        Button btBuscar = (Button)findViewById(R.id.btBuscar);
        ImageButton btVoltar = (ImageButton)findViewById(R.id.btVoltar);

        if(admin){
            btAdicionar.setVisibility(View.INVISIBLE);
        }

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Activity_exercicio.this,Activity_exercicio_adicionar.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"Não está pronto ainda.", Toast.LENGTH_SHORT).show();
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Activity_exercicio.this,MainActivity.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });
    }
}
