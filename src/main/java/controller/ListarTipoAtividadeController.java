package controller;

import controller.interfaces.ControllerLister;
import controller.interfaces.Filterable;
import model.Companhia;
import model.PacoteTurismo;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAtividadeController extends ControllerLister<TipoAtividade>
{
    public ListarTipoAtividadeController()
    {
        super(Companhia.getInstance());
    }

    public <F,F2> List<TipoAtividade> filtrar(Extractor<TipoAtividade, F> extractor, Filter<F,F2> filtro, F2 valor, boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor, negate);
    }

    public List<FilterEntry<TipoAtividade,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }

    @Override
    public TipoAtividade getRefObj()
    {
        if (companhia.getListaTipoAtividade().size() != 0)
        {
            refObj = companhia.getListaTipoAtividade().get(0);
            return refObj;
        }
        return refObj;
    }
}
