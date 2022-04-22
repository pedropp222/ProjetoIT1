package controller;

import model.Alojamento;
import model.Companhia;
import model.TipoAlojamento;
import model.filtering.filter.AlojamentoDenominacaoFilter;
import model.filtering.filter.AlojamentoPrecoFilter;
import model.filtering.filter.AlojamentoPrecoRangeFilter;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

import java.util.ArrayList;
import java.util.List;

public class ListarAlojamentosController
{
    private final Companhia companhia;

    public ListarAlojamentosController()
    {
        companhia = Companhia.getInstance();
    }

    public List<String> getAlojamentos()
    {
        List<String> lst = new ArrayList<>();

        for(Alojamento ta : companhia.getListaAlojamentos())
        {
            lst.add(ta.toString());
        }

        return lst;
    }

    public List<AlojamentoDenominacaoFilter> getAlojamentoDenominacaoFilters() {
        return companhia.getAlojamentoDenominacaoFilters();
    }

    public List<AlojamentoPrecoFilter> getAlojamentoPrecoFilters()
    {
        return companhia.getAlojamentoPrecoFilters();
    }

    public List<AlojamentoPrecoRangeFilter> getAlojamentoPrecoRangeFilters()
    {
        return companhia.getAlojamentoPrecoRangeFilters();
    }

    public List<Alojamento> filtrarDenominacao(AlojamentoDenominacaoFilter filtro, String v)
    {
        List<Alojamento> lista = companhia.filtrarAlojamentoDenominacao( filtro, v );

        return lista;
    }

    public List<Alojamento> filtrarPreco(AlojamentoPrecoFilter filtro, float valor)
    {
        return companhia.filtrarAlojamentoPreco(filtro,valor);
    }

    public List<Alojamento> filtrarPrecoRange(AlojamentoPrecoRangeFilter filtro, float valorMin, float valorMax)
    {
        return companhia.filtrarAlojamentoPrecoRange(filtro,valorMin,valorMax);
    }


}
