package controller;

import model.Alojamento;
import model.Companhia;

import java.util.ArrayList;
import java.util.List;

public class ListarAlojamentosController
{
    private final Companhia companhia;

    public ListarAlojamentosController()
    {
        companhia = Companhia.getInstance();
    }

    public List<String> getAlojamentos()
    {
        List<String> lst = new ArrayList<>();

        for(Alojamento ta : companhia.getListaAlojamentos())
        {
            lst.add(ta.toString());
        }

        return lst;
    }

}
