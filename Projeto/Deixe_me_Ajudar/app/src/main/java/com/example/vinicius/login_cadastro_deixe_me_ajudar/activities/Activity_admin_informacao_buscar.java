package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.DbHelper;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Informacao;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.ViewLista;

public class Activity_admin_informacao_buscar extends AppCompatActivity {
    public static DbHelper sql;
    Informacao informacao;
    private SimpleCursorAdapter dataSource;
    private static final String campos[] = {"titulo", "conteudo"};
    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.includeadmininformacao).setVisibility(View.INVISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        ListView listagem = (ListView) findViewById(R.id.listagemInformacao);
        ImageButton btBuscar = (ImageButton) findViewById(R.id.btBuscar);
        ImageButton btVoltar = (ImageButton) findViewById(R.id.btVoltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_admin_informacao_buscar.this, Activity_admin_informacao.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });


        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtBusca = (EditText) findViewById(R.id.txtBusca);
                String conteudoBuscar = txtBusca.getText().toString();

                if (conteudoBuscar.equals("")) {
                    Toast.makeText(getApplicationContext(), "Digite um conteúdo para ser buscado.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Activity_admin_informacao_buscar.this, ViewLista.class);
                    startActivity(intent);
                }
            }
        });
    }

}
