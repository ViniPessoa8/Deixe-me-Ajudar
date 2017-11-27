package com.example.user.deixe_meajudar;

/**
 * Created by Fernanda Serra on 10/11/2017.
 */

public class Artigo extends Conteudo
{
    protected String fontes;

    public Artigo(Conteudo conteudo, String fontes)
    {
        super(conteudo.codigo, conteudo.titulo, conteudo.descricao);
        this.fontes = fontes;
    }

    public String getFontes()
    {
        return fontes;
    }

    public void setFontes(String fontes)
    {
        this.fontes = fontes;
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
