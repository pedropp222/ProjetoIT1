package controller;

import controller.interfaces.ControllerLister;
import controller.interfaces.Filterable;
import model.Companhia;
import model.Local;
import model.TipoAlojamento;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAlojamentosController extends ControllerLister<TipoAlojamento>
{
    public ListarTipoAlojamentosController()
    {
        super(Companhia.getInstance());
    }

    @Override
    public TipoAlojamento getRefObj()
    {
        if (companhia.getListaTipoAlojamento().size() != 0)
        {
            refObj = companhia.getListaTipoAlojamento().get(0);
            return refObj;
        }

        return refObj;
    }

    public <F,F2> List<TipoAlojamento> filtrar(Extractor<TipoAlojamento,F> extractor, Filter<F,F2> filtro, F2 valor, boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor,negate);
    }

    public List<FilterEntry<TipoAlojamento,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }


}
