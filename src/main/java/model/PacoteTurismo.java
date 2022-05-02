package model;

import java.util.List;

public class PacoteTurismo
{
    private final List<Reserva> servicosEscolhidos;

    public PacoteTurismo(List<Reserva> servicosEscolhidos) throws IllegalArgumentException
    {
        if (servicosEscolhidos == null || servicosEscolhidos.size() == 0) throw new IllegalArgumentException("Lista de servicos nao pode estar vazia.");
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

    public int getNumServicos()
    {
        return servicosEscolhidos.size();
    }
}