package com.example.user.testezin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 03/12/2017.
 */

public class ListaBusca extends AppCompatActivity
{
    DbHelper sql;
    EditText txtBusca;
    ImageButton btBuscar, btnVoltar;
    ArrayList<Conteudo> lista;
    String emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_item_melevadeus);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        TextView txtBusca = (TextView)findViewById(R.id.txtBusca);
        btBuscar = (ImageButton)findViewById(R.id.btBuscar);
        btnVoltar = findViewById(R.id.btnVoltar);

        sql = new DbHelper(getApplicationContext());
        lista = new ArrayList<>();
        intent = getIntent();
        String conteudoBuscar = (String)intent.getSerializableExtra("conteudoBuscar");
        //teste
        txtBusca.setText(conteudoBuscar);


        lista = sql.getConteudo(conteudoBuscar);

        ListaAdapterItem adapterItem = new ListaAdapterItem(getApplicationContext(),lista);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapterItem);

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ListaBusca.this.txtBusca = (EditText)findViewById(R.id.txtBusca);
                String conteudoBuscar = ListaBusca.this.txtBusca.getText().toString();

                if(conteudoBuscar.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Digite um conteúdo para ser buscado.", Toast.LENGTH_SHORT).show();
                }else
                {
                    Intent intent = new Intent(ListaBusca.this,ListaBusca.class);
                    intent.putExtra("conteudoBuscar",conteudoBuscar);
                    startActivity(intent);
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaBusca.this,MainActivity.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });

    }
}
