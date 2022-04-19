package model;

import java.util.List;

public class PacoteTurismo
{
    private final List<Reserva> servicosEscolhidos;

    public PacoteTurismo(List<Reserva> servicosEscolhidos)
    {
        this.servicosEscolhidos = servicosEscolhidos;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Pacote de turismo: ");
        for (Reserva c : servicosEscolhidos)
        {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}