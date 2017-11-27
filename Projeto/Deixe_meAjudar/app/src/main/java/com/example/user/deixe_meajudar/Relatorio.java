package com.example.user.deixe_meajudar;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Fernanda Serra on 10/11/2017.
 */

public class Relatorio
{

    protected int codigo, codigoUsuario;
    protected ArrayList sintomas;
    protected Calendar hora, data;

    public Relatorio()
    {
    }

    public Relatorio(int codigo, int codigoUsuario, Calendar dt, Calendar hora, ArrayList sintomas)
    {
        this.codigo = codigo;
        this.codigoUsuario = codigoUsuario;
        this.data = dt;
        this.hora = hora;
        this.sintomas = sintomas;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public ArrayList getSintomas()
    {
        return sintomas;
    }

    public void setSintomas(ArrayList sintomas)
    {
        this.sintomas = sintomas;
    }

    public Calendar getHora()
    {
        return hora;
    }

    public void setHora(Calendar hora)
    {
        this.hora = hora;
    }

    public Calendar getDt()
    {
        return data;
    }

    public void setDt(Calendar data)
    {
        this.data = data;
    }

}
