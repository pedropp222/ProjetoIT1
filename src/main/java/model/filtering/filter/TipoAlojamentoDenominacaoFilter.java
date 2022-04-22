package model.filtering.filter;

import model.TipoAlojamento;
import model.filtering.Filter;

public interface TipoAlojamentoDenominacaoFilter extends Filter
{
    boolean complies(TipoAlojamento ta, String string);
}