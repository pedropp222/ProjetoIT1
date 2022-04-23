package controller;

import model.Companhia;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAtividadeController
{
    Companhia companhia;
    TipoAtividade refObj;

    public ListarTipoAtividadeController()
    {
        companhia = Companhia.getInstance();

        if (companhia.getListaTipoAtividade().size() != 0)
        {
            refObj = companhia.getListaTipoAtividade().get(0);
        }
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

    public <F> List<TipoAtividade> filtrar(Extractor<TipoAtividade,F> extractor, Filter<F> filtro, F valor)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor);
    }

    public List<FilterEntry<TipoAtividade,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
