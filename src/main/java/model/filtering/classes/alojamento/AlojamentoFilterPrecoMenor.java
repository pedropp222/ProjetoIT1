package model.filtering.classes.alojamento;

import model.Alojamento;
import model.filtering.filter.AlojamentoPrecoFilter;

public class AlojamentoFilterPrecoMenor implements AlojamentoPrecoFilter
{
    private final String nome = "Filtrar preco menor que";

    @Override
    public String getName()
    {
        return nome;
    }

    @Override
    public boolean complies(Alojamento alojamento, float preco)
    {
        return alojamento.getPreco() < preco;
    }
}
