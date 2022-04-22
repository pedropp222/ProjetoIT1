package model.filtering.classes.alojamento;

import model.Alojamento;
import model.filtering.filter.AlojamentoPrecoRangeFilter;

public class AlojamentoFilterPrecoRange implements AlojamentoPrecoRangeFilter
{
    private static final String name = "Filtrar por intervalo de precos";

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public boolean complies(Alojamento alojamento, float precoMin, float precoMax)
    {
        return alojamento.getPreco() >= precoMin && alojamento.getPreco() <= precoMax;
    }
}
