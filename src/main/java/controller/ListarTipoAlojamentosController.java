package controller;

import model.Companhia;
import model.TipoAlojamento;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAlojamentosController
{
    private final Companhia companhia;

    private TipoAlojamento refObj;

    public ListarTipoAlojamentosController()
    {
        companhia = Companhia.getInstance();
        if (companhia.getListaTipoAlojamento().size() != 0)
        {
            refObj = companhia.getListaTipoAlojamento().get(0);
        }
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

    public <F,F2> List<TipoAlojamento> filtrar(Extractor<TipoAlojamento,F> extractor, Filter<F,F2> filtro, F2 valor)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor);
    }

    public List<FilterEntry<TipoAlojamento,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
