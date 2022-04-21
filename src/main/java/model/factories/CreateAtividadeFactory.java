package model.factories;

import model.Atividade;
import model.DiaSemana;
import model.Local;
import model.TipoAtividade;

public interface CreateAtividadeFactory
{
    Atividade criarAtividade(String designacao, TipoAtividade tipo, Local localPartida, Local localChegada, int horaInicio, int horaFim, DiaSemana diaSemana, float preco) throws IllegalArgumentException;
}
