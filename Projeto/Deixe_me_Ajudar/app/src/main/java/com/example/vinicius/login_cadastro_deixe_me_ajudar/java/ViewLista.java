package com.example.vinicius.login_cadastro_deixe_me_ajudar.java;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.DbHelper;

import java.util.ArrayList;

/**
 * Created by user on 01/12/2017.
 */

public class ViewLista extends AppCompatActivity {
    DbHelper sql;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_informacao_buscar);

        EditText txtBusca = (EditText) findViewById(R.id.txtBusca);
        String conteudoBuscar = txtBusca.getText().toString();
        ListView lista = (ListView) findViewById(R.id.listagemInformacao);

        sql = new DbHelper(this);

        ArrayList<String> listagem = new ArrayList<>();
        if (sql.getConteudo(conteudoBuscar) == null) {
            Toast.makeText(getApplicationContext(), "Null", Toast.LENGTH_SHORT).show();
        } else {
            Cursor cursor = sql.getConteudo(conteudoBuscar);
            if (cursor.getCount() == 0) {
                Toast.makeText(getApplicationContext(), "Não há registro de nenhuma informação no momento.", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    Toast.makeText(getApplicationContext(), "tem treta aqui", Toast.LENGTH_SHORT).show();
                    int i = 0;
                    while (cursor.moveToNext()) {

                        listagem.add(cursor.getString(1));
                        ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listagem);
                        lista.setAdapter(adaptador);
                        i++;
                        Toast.makeText(getApplicationContext(), i, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
