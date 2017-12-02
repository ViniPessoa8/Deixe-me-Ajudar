package com.example.vinicius.login_cadastro_deixe_me_ajudar.java;

/**
 * Created by user on 30/11/2017.
 */

public class Exercicio extends Conteudo
{
    public int tipoExercicio;
    public Exercicio(int id, byte[] anexo, String titulo, String conteudo, int tipo, int tipoExercicio) {
        super(id, anexo, titulo, conteudo,tipo);
        this.tipoExercicio = tipoExercicio;
    }

    public Exercicio() {
        super();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
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

    @Override
    public int getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(int tipo) {
        super.setTipo(tipo);
    }

    public int getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(int tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }
}
