package controller;

import model.Companhia;
import model.TipoAlojamento;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

import java.util.ArrayList;
import java.util.List;

public class ListarTipoAlojamentosController
{
    private final Companhia companhia;

    public ListarTipoAlojamentosController()
    {
        companhia = Companhia.getInstance();
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

    public List<TipoAlojamentoDenominacaoFilter> getTipoAlojamentoDenominacaoFilters() {
        return companhia.getTipoAlojamentoDenominacaoFilters();
    }

    public List<TipoAlojamento> filtrarDenominacao(TipoAlojamentoDenominacaoFilter filtro, String v)
    {
        List<TipoAlojamento> lista = companhia.filtrarTiposAlojamentoDenominacao( filtro, v );

        return lista;
    }
}
