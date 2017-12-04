package com.example.user.testezin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 03/12/2017.
 */

public class ListaAdapterItem extends ArrayAdapter<Conteudo>
{

    private Context context;
    private ArrayList<Conteudo> lista;

    public ListaAdapterItem(Context context, ArrayList<Conteudo> lista)
    {
        super(context,0, lista);
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Conteudo itemPosicao = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item,null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageView.setImageResource(android.R.drawable.ic_delete);

        TextView txtTitulo = (TextView)convertView.findViewById(R.id.txtTitulo);
        txtTitulo.setText(itemPosicao.getTitulo());

        TextView txtConteudo = (TextView)convertView.findViewById(R.id.txtConteudo);
        txtConteudo.setText(itemPosicao.getConteudo());

        return convertView;
    }
}
