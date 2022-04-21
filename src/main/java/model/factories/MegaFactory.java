package model.factories;

import model.*;
import model.exception.NomeInvalidoException;

import java.util.List;

public class MegaFactory implements CreateAlojamentoFactory,CreateAtividadeFactory,CreateLocalFactory,CreatePacoteTurismoFactory,CreateTipoAlojamentoFactory,CreateTipoAtividadeFactory
{
    @Override
    public Alojamento criarAlojamento(String designacao, TipoAlojamento tipo, Local local, int minPessoas, int maxPessoas, DiaSemana diaSemana, float preco) throws NomeInvalidoException, IllegalArgumentException
    {
        return new Alojamento(designacao, tipo, local, minPessoas, maxPessoas, diaSemana, preco);
    }

    @Override
    public Atividade criarAtividade(String designacao, TipoAtividade tipo, Local localPartida, Local localChegada, int horaInicio, int horaFim, DiaSemana diaSemana, float preco) throws IllegalArgumentException
    {
        return new Atividade(designacao, tipo, localPartida, localChegada, horaInicio, horaFim, diaSemana, preco);
    }

    @Override
    public Local criarLocal(String cidade, String pais, String designacao) throws NomeInvalidoException
    {
        return new Local(cidade, pais, designacao);
    }

    @Override
    public PacoteTurismo criarPacoteTurismo(List<Reserva> servicosEscolhidos)
    {
        return new PacoteTurismo(servicosEscolhidos);
    }

    @Override
    public TipoAlojamento criarTipoAlojamento(String designacao) throws NomeInvalidoException
    {
        return new TipoAlojamento(designacao);
    }

    @Override
    public TipoAtividade criarTipoAtividade(String designacao) throws NomeInvalidoException
    {
        return new TipoAtividade(designacao);
    }
}
