package model.filtering.filter;

import model.Alojamento;
import model.filtering.Filter;

public interface AlojamentoDenominacaoFilter extends Filter
{
    boolean complies(Alojamento ta, String string);
}
