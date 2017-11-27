package com.example.user.deixe_meajudar;

/**
 * Created by Fernanda Serra on 20/11/2017.
 */

public class Sintomas
{
    public String nome = "", descricao = "";

    public Sintomas ()
    {

    }

    public Sintomas(String nome, String descricao)
    {
        this.nome = nome;
        this.descricao = descricao;
    }



    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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
