package com.example.vinicius.login_cadastro_deixe_me_ajudar.java;

/**
 * Created by user on 01/12/2017.
 */

public class Conteudo
{
    public int id,tipo;
    public byte[] anexo;
    public String titulo, conteudo;

    public Conteudo(int id, byte[] anexo, String titulo, String conteudo, int tipo)
    {
        this.id = id;
        this.anexo = anexo;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tipo = tipo;
    }

    public Conteudo( byte[] anexo, String titulo, String conteudo,int tipo)
    {
        this.anexo = anexo;
        this.titulo = titulo;
        this.conteudo = conteudo;
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

    public Conteudo()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
