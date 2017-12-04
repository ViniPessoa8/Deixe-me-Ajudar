package com.example.user.testezin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaItemActivity extends AppCompatActivity
{
    DbHelper sql;
    EditText txtBusca;
    ImageButton btBuscar, btnVoltar;
    ArrayList<Conteudo> lista;
    private String emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_item_melevadeus);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        btBuscar = (ImageButton)findViewById(R.id.btBuscar);
        btnVoltar = findViewById(R.id.btnVoltar);

        sql = new DbHelper(getApplicationContext());
        lista = new ArrayList<>();
        lista = sql.retornarTodos();

        ListaAdapterItem adapterItem = new ListaAdapterItem(getApplicationContext(),lista);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapterItem);

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                txtBusca = (EditText)findViewById(R.id.txtBusca);
                String conteudoBuscar = txtBusca.getText().toString();

                if(conteudoBuscar.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Digite um conteúdo para ser buscado.", Toast.LENGTH_SHORT).show();
                }else
                {
                    Intent intent = new Intent(ListaItemActivity.this,ListaBusca.class);
                    intent.putExtra("conteudoBuscar",conteudoBuscar);
                    startActivity(intent);
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaItemActivity.this, Activity_informacao.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });

    }
}
