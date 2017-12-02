package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.DbHelper;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Conteudo;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Informacao;

public class Activity_admin_informacao_adicionar extends AppCompatActivity {

    public static DbHelper sql;
    Conteudo conteudo;
    Informacao informacao;
    private String emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.includeadmininformacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadmininformacaoadicionar).setVisibility(View.INVISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        Button btAdicionar = findViewById(R.id.btAdicionar);
        ImageButton btVoltar = findViewById(R.id.btVoltar);

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText txtTitulo = findViewById(R.id.txtTitulo);
                EditText txtConteudo = findViewById(R.id.txtConteudo);

                String texto = txtConteudo.getText().toString();
                String titulo = txtTitulo.getText().toString();

                if(texto.equals("") || titulo.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Digite algum conteúdo.",Toast.LENGTH_SHORT).show();
                }else
                {
                    try
                    {
                        conteudo = new Conteudo();
                        informacao = new Informacao();
                        sql = new DbHelper(getApplicationContext());
                        conteudo.setTipo(1);
                        conteudo.setTitulo(titulo);
                        conteudo.setConteudo(texto);
                        conteudo.setAnexo(null);
                        sql.addConteudo(conteudo);

                        sql.getIdConteudo(conteudo);
                        informacao.setId(sql.getIdConteudo(conteudo));
                        informacao.setAnexo(null);
                        informacao.setTitulo(titulo);
                        informacao.setConteudo(texto);
                        sql.addInformacao(informacao);

                        Toast.makeText(getApplicationContext(),"O conteúdo foi adicionado com sucesso.",Toast.LENGTH_SHORT).show();
                        txtTitulo.setText("");
                        txtConteudo.setText("");
                    }catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Não foi possível adicionar este conteúdo.",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            Intent intent = new Intent(Activity_admin_informacao_adicionar.this, Activity_admin_informacao.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
    }
}
