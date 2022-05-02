package controller;

import model.Companhia;
import model.Local;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarLocaisController implements Filterable<Local>
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

    public <F,F2> List<Local> filtrar(Extractor<Local,F> extractor, Filter<F,F2> filtro, F2 valor)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor);
    }

    public List<FilterEntry<Local,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
