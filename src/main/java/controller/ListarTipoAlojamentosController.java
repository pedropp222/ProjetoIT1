package controller;

import model.Companhia;
import model.TipoAlojamento;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAlojamentosController
{
    private final Companhia companhia;

    public ListarTipoAlojamentosController()
    {
        companhia = Companhia.getInstance();
    }

    public List<String> getAlojamentos()
    {
        List<String> lst = new ArrayList<>();

        for(TipoAlojamento ta : companhia.getListaTipoAlojamento())
        {
            lst.add(ta.toString());
        }

        return lst;
    }
}
