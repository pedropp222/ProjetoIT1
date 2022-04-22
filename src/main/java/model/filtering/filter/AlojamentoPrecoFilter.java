package model.filtering.filter;

import model.Alojamento;
import model.filtering.Filter;

public interface AlojamentoPrecoFilter extends Filter
{
    boolean complies(Alojamento alojamento, float preco);
}
