package controller;

import model.Alojamento;
import model.Companhia;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarAlojamentosController implements Filterable<Alojamento>
{
    private final Companhia companhia;

    private Alojamento refObj;

    public ListarAlojamentosController()
    {
        companhia = Companhia.getInstance();
        if (companhia.getListaAlojamentos().size() != 0)
        {
            refObj = companhia.getListaAlojamentos().get(0);
        }
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

    public <F,F2> List<Alojamento> filtrar(Extractor<Alojamento,F> extractor, Filter<F,F2> filtro, F2 valor, boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor, negate);
    }

    public List<FilterEntry<Alojamento,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }

}
