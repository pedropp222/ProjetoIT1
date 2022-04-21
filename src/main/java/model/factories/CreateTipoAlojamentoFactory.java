package model.factories;


import model.TipoAlojamento;
import model.exception.NomeInvalidoException;

public interface CreateTipoAlojamentoFactory
{
    TipoAlojamento criarTipoAlojamento(String designacao) throws NomeInvalidoException;
}
