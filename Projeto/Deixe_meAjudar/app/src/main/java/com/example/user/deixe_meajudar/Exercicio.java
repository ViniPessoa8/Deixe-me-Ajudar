package com.example.user.deixe_meajudar;

/**
 * Created by Fernanda Serra on 10/11/2017.
 */

public class Exercicio extends Conteudo
{
    protected int tipo;


    public Exercicio(Conteudo conteudo, int tipo)
    {
        super(conteudo.codigo,conteudo.titulo,conteudo.descricao);
        this.tipo = tipo;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

}
