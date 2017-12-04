package com.example.user.testezin;

/**
 * Created by Vinicius on 27/11/2017.
 */

public class Usuario {
    private String nome,email,senha;
    private int codigo;
    private boolean admin;

    public Usuario(String nome, String email, String senha, int codigo, boolean admin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.codigo = codigo;
        this.admin = admin;
    }

    public Usuario() {
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }
}
