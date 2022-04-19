package controller;

import model.Companhia;
import model.Local;

import java.util.ArrayList;
import java.util.List;

public class ListarLocaisController
{
    private final Companhia companhia;

    public ListarLocaisController()
    {
        companhia = Companhia.getInstance();
    }

    public List<String> getLocais()
    {
        List<String> lst = new ArrayList<>();

        for(Local l : companhia.getListaLocais())
        {
            lst.add(l.toString());
        }

        return lst;
    }
}
