package controller;

import model.Companhia;
import model.Local;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarLocaisController
{
    private final Companhia companhia;

    private Local refObj;

    public ListarLocaisController()
    {
        companhia = Companhia.getInstance();
        if (companhia.getListaLocais().size() != 0)
        {
            refObj = companhia.getListaLocais().get(0);
        }
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

    public <F> List<Local> filtrar(Extractor<Local,F> extractor, Filter<F> filtro, F valor)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor);
    }

    public List<FilterEntry<Local,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
