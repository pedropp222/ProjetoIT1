package model.factories;

import model.PacoteTurismo;
import model.Reserva;

import java.util.List;

public interface CreatePacoteTurismoFactory
{
    PacoteTurismo criarPacoteTurismo(List<Reserva> servicosEscolhidos);
}
