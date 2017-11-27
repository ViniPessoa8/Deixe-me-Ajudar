package com.example.user.deixe_meajudar;

/**
 * Created by Fernanda Serra on 10/11/2017.
 */

public abstract class Conteudo
{
    protected int codigo;
    protected String titulo, descricao;
    //anexo

    public Conteudo(int codigo, String titulo, String descricao)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    public abstract int getCodigo();

    public abstract void setCodigo(int codigo);

    public abstract String getTitulo();

    public abstract void setTitulo(String titulo);

    public abstract String getDescricao();

    public abstract void setDescricao(String descricao);

}
