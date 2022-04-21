package model.factories;

import model.Alojamento;
import model.DiaSemana;
import model.Local;
import model.TipoAlojamento;
import model.exception.NomeInvalidoException;

public interface CreateAlojamentoFactory
{
    Alojamento criarAlojamento(String designacao, TipoAlojamento tipo, Local local, int minPessoas, int maxPessoas, DiaSemana diaSemana, float preco) throws NomeInvalidoException, IllegalArgumentException;
}
