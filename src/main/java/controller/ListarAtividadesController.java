package controller;

import model.Atividade;
import model.Companhia;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.List;

public class ListarAtividadesController implements Filterable<Atividade>
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

    public <F,F2> List<Atividade> filtrar(Extractor<Atividade,F> extractor, Filter<F,F2> filtro, F2 valor, boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor,negate);
    }

    public List<FilterEntry<Atividade,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }
}
