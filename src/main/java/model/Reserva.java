package model;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva
{
    private final LocalDate dataEscolha;
    private final Servico escolha;

    public Reserva(LocalDate dataEscolha, Servico servico) throws IllegalArgumentException
    {
        if (dataEscolha == null || servico == null) throw new IllegalArgumentException("Campos nao podem ser null.");
        this.dataEscolha = dataEscolha;
        this.escolha = servico;
    }

    public Servico getEscolha()
    {
        return escolha;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserva that = (Reserva) o;

        return Objects.equals(escolha, that.escolha) && dataEscolha.equals(((Reserva) o).dataEscolha);
    }

    @Override
    public String toString()
    {
        return "Reserva{" +
                "dataEscolha=" + dataEscolha +
                ", escolha=" + escolha +
                '}';
    }
}