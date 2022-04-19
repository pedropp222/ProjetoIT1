package controller;

import model.Companhia;
import model.TipoAtividade;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAtividadeController
{
    Companhia companhia;

    public ListarTipoAtividadeController()
    {
        companhia = Companhia.getInstance();
    }

    public List<String> getAtividades()
    {
        List<String> lst = new ArrayList<>();

        for(TipoAtividade at : companhia.getListaTipoAtividade())
        {
            lst.add(at.toString());
        }

        return lst;
    }
}
