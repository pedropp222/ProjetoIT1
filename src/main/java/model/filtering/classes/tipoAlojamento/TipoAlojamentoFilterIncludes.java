package model.filtering.classes.tipoAlojamento;

import model.TipoAlojamento;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

public class TipoAlojamentoFilterIncludes implements TipoAlojamentoDenominacaoFilter
{
    private final String name = "Filtrar denominacao contem";

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public boolean complies(TipoAlojamento ta, String string)
    {
        return ta.getDesignacao().contains(string);
    }
}
