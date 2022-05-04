package controller;

import controller.interfaces.ControllerLister;
import model.Alojamento;
import model.Companhia;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.List;

public class ListarAlojamentosController extends ControllerLister<Alojamento>
{
    public ListarAlojamentosController()
    {
        super(Companhia.getInstance());
    }

    public Alojamento getRefObj()
    {
        if (companhia.getListaAlojamentos().size() == 0)
        {
            return refObj;
        }
        else
        {
            refObj = companhia.getListaAlojamentos().get(0);
            return refObj;
        }
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
