package controller;

import model.Companhia;
import model.Local;
import model.PacoteTurismo;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarPacoteController
{
    private final Companhia companhia;

    private PacoteTurismo refObj;

    public ListarPacoteController()
    {
        companhia = Companhia.getInstance();
        if (companhia.getPacoteTurismos().size() != 0)
        {
            refObj = companhia.getPacoteTurismos().get(0);
        }
    }

    public List<String> getLocais()
    {
        List<String> lst = new ArrayList<>();

        for(PacoteTurismo l : companhia.getPacoteTurismos())
        {
            lst.add(l.toString());
        }

        return lst;
    }

    public <F,F2> List<PacoteTurismo> filtrar(Extractor<PacoteTurismo,F> extractor, Filter<F,F2> filtro, F2 valor)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor);
    }

    public List<FilterEntry<PacoteTurismo,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
