package model.filtering.filter;


import model.Alojamento;
import model.filtering.Filter;

public interface AlojamentoPrecoRangeFilter extends Filter
{
    boolean complies(Alojamento alojamento, float precoMin, float precoMax);
}
