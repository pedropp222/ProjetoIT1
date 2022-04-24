package controller;

import model.Alojamento;
import model.Atividade;
import model.Companhia;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarAtividadesController
{
    private final Companhia companhia;

    private Atividade refObj;

    public ListarAtividadesController()
    {
        companhia = Companhia.getInstance();
        if (companhia.getListaAtividades().size() != 0)
        {
            refObj = companhia.getListaAtividades().get(0);
        }
    }

    public List<String> getAtividades()
    {
        List<String> lst = new ArrayList<>();

        for(Atividade ta : companhia.getListaAtividades())
        {
            lst.add(ta.toString());
        }

        return lst;
    }

    public <F> List<Atividade> filtrar(Extractor<Atividade,F> extractor, Filter<F> filtro, F valor)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor);
    }

    public List<FilterEntry<Atividade,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
