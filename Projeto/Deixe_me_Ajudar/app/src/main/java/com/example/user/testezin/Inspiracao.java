package com.example.user.testezin;

/**
 * Created by user on 30/11/2017.
 */
public class Inspiracao extends Conteudo
{
    private byte[] foto;
    private int id;

    public Inspiracao()
    {
        super();
    }

    public Inspiracao(int id, byte[] anexo, String titulo, String conteudo, int tipo)
    {
        super(id, anexo, titulo, conteudo,tipo);
    }

    @Override
    public int getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(int tipo) {
        super.setTipo(tipo);
    }

    @Override
    public byte[] getAnexo() {
        return super.getAnexo();
    }

    @Override
    public void setAnexo(byte[] anexo) {
        super.setAnexo(anexo);
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    @Override
    public String getConteudo() {
        return super.getConteudo();
    }

    @Override
    public void setConteudo(String conteudo) {
        super.setConteudo(conteudo);
    }

    public byte[] getFoto()
    {
        return foto;
    }

    public void setFoto(byte[] foto)
    {
        this.foto = foto;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
