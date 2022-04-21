package model.factories;

import model.Local;
import model.exception.NomeInvalidoException;

public interface CreateLocalFactory
{
    Local criarLocal(String cidade, String pais, String designacao) throws NomeInvalidoException;
}
