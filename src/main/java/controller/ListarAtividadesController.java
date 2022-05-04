package controller;

import controller.interfaces.ControllerLister;
import controller.interfaces.Filterable;
import model.Alojamento;
import model.Atividade;
import model.Companhia;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarAtividadesController extends ControllerLister<Atividade>
{
    public ListarAtividadesController()
    {
        super(Companhia.getInstance());
    }

    @Override
    public Atividade getRefObj()
    {
        if (companhia.getListaAtividades().size() == 0)
        {
            return refObj;
        }
        refObj = companhia.getListaAtividades().get(0);
        return refObj;
    }

    public <F,F2> List<Atividade> filtrar(Extractor<Atividade,F> extractor, Filter<F,F2> filtro, F2 valor, boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor,negate);
    }

    public List<FilterEntry<Atividade,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}