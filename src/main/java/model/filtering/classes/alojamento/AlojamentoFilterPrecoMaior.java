package model.filtering.classes.alojamento;

import model.Alojamento;
import model.filtering.filter.AlojamentoPrecoFilter;

public class AlojamentoFilterPrecoMaior implements AlojamentoPrecoFilter
{
    private String nome = "Filtrar preco maior que";

    @Override
    public String getName()
    {
        return nome;
    }

    @Override
    public boolean complies(Alojamento alojamento, float preco)
    {
        return alojamento.getPreco() > preco;
    }
}
