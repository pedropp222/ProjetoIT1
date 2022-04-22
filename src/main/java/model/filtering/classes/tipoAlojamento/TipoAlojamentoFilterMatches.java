package model.filtering.classes.tipoAlojamento;

import model.TipoAlojamento;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

public class TipoAlojamentoFilterMatches implements TipoAlojamentoDenominacaoFilter
{
    private final String nome = "Filtrar denominacao regex";

    @Override
    public String getName()
    {
        return nome;
    }

    @Override
    public boolean complies(TipoAlojamento ta, String string)
    {
        return ta.getDesignacao().matches(string);
    }
}
