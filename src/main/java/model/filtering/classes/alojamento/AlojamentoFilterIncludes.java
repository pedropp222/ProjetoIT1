package model.filtering.classes.alojamento;

import model.Alojamento;
import model.filtering.filter.AlojamentoDenominacaoFilter;

public class AlojamentoFilterIncludes implements AlojamentoDenominacaoFilter
{
    private final String nome = "Filtrar denominacao contem";

    @Override
    public String getName()
    {
        return nome;
    }

    @Override
    public boolean complies(Alojamento ta, String string)
    {
        return ta.getDesignacao().contains(string);
    }
}
