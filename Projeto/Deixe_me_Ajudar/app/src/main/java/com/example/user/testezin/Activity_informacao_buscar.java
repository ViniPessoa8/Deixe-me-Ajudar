package com.example.user.testezin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_informacao_buscar extends AppCompatActivity
{
    DbHelper sql;
    EditText txtBusca;
    ImageButton btBuscar, btnVoltar;
    ArrayList<Conteudo> lista;
    private String emailUser;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_item_melevadeus);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        btBuscar = (ImageButton) findViewById(R.id.btBuscar);
        btnVoltar = findViewById(R.id.btnVoltar);

        sql = new DbHelper(getApplicationContext());
        lista = new ArrayList<>();
        lista = sql.retornarTodos();

        ListaAdapterItem adapterItem = new ListaAdapterItem(getApplicationContext(), lista);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapterItem);

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBusca = (EditText) findViewById(R.id.txtBusca);
                String conteudoBuscar = txtBusca.getText().toString();

                if (conteudoBuscar.equals("")) {
                    Toast.makeText(getApplicationContext(), "Digite um conteúdo para ser buscado.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Activity_informacao_buscar.this, ListaBusca.class);
                    intent.putExtra("conteudoBuscar", conteudoBuscar);
                    intent.putExtra("admin", admin);
                    startActivity(intent);
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_informacao_buscar.this, Activity_informacao.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);
            }
        });
    }

}
