package controller;

import controller.interfaces.ControllerLister;
import controller.interfaces.Filterable;
import model.Alojamento;
import model.Companhia;
import model.Local;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarLocaisController extends ControllerLister<Local>
{
    public ListarLocaisController()
    {
        super(Companhia.getInstance());
    }

    public <F,F2> List<Local> filtrar(Extractor<Local,F> extractor, Filter<F,F2> filtro, F2 valor, boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor,negate);
    }

    public List<FilterEntry<Local,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }

    @Override
    public Local getRefObj()
    {
        if (companhia.getListaLocais().size() == 0)
        {
            return refObj;
        }
        refObj = companhia.getListaLocais().get(0);
        return refObj;
    }
}
