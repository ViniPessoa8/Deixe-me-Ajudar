package com.example.user.testezin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_exercicio_buscar extends AppCompatActivity
{
    DbHelper sql;
    Conteudo conteudo;
    ImageButton btBuscar, btVoltar;
    EditText txtConteudoBuscar;
    ArrayList<Conteudo> lista;
    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio_buscar);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        btVoltar = (ImageButton)findViewById(R.id.btVoltar);
        btBuscar = (ImageButton)findViewById(R.id.btBuscar);

        sql = new DbHelper(getApplicationContext());
        lista = sql.retornarTodos();

        ListaAdapterItem adapterItem = new ListaAdapterItem(getApplicationContext(),lista);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapterItem);

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                txtConteudoBuscar = (EditText)findViewById(R.id.txtBusca);
                String conteudoBuscar = txtConteudoBuscar.getText().toString();

                if(conteudoBuscar.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Digite um conteúdo para ser buscado.", Toast.LENGTH_SHORT).show();
                }else
                {
                    Intent intent = new Intent(Activity_exercicio_buscar.this,ListaBusca.class);
                    intent.putExtra("conteudoBuscar",conteudoBuscar);
                    intent.putExtra("admin", admin);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Activity_exercicio_buscar.this, Activity_exercicio.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
                finish();
            }
        });
    }
}
