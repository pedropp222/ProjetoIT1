package controller;

import model.*;
import model.exception.NomeInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class CriarAlojamentoController
{
    private final Companhia companhia;
    private Alojamento aloj;

    public CriarAlojamentoController()
    {
        companhia = Companhia.getInstance();
    }

    public boolean criarAlojamento(String d, int t, int l, int min, int max, DiaSemana sem, float prec) throws NomeInvalidoException, IllegalArgumentException
    {
        aloj = companhia.criarAlojamento(d,companhia.getListaTipoAlojamento().get(t),companhia.getListaLocais().get(l),min,max,sem,prec);

        return companhia.validarAlojamento(aloj);
    }

    public List<String> getTiposAlojamento()
    {
        List<String> lst = new ArrayList<>();

        for(TipoAlojamento t : companhia.getListaTipoAlojamento())
        {
            lst.add(t.toString());
        }

        return lst;
    }

    public List<String> getLocais()
    {
        List<String> lst = new ArrayList<>();

        for(Local l: companhia.getListaLocais())
        {
            lst.add(l.toString());
        }

        return lst;
    }

    public boolean isTipoAlojamentoValido(int esc)
    {
        return esc >= 0 && esc <= getTiposAlojamento().size() - 1;
    }

    public boolean isLocalValido(int loc)
    {
        return loc >= 0 && loc <= getLocais().size() - 1;
    }

    public boolean guardarAlojamento()
    {
        return companhia.gravarAlojamento(aloj);
    }
}