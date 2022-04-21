package model.factories;

import model.TipoAtividade;
import model.exception.NomeInvalidoException;

public interface CreateTipoAtividadeFactory
{
    TipoAtividade criarTipoAtividade(String designacao) throws NomeInvalidoException;
}
