package model;

import java.util.Objects;

public class Atividade extends Servico
{
    private String designacao;
    private TipoAtividade tipo;
    private Local localPartida;
    private Local localChegada;
    private int horaInicio;
    private int horaFim;
    private DiaSemana diaSemana;
    private float preco;

    public Atividade(String designacao, TipoAtividade tipo, Local localPartida, Local localChegada, int horaInicio, int horaFim, DiaSemana diaSemana, float preco) throws IllegalArgumentException
    {
        setDesignacao(designacao);
        setTipo(tipo);
        setLocalPartida(localPartida);
        setLocalChegada(localChegada);
        setHoraInicio(horaInicio);
        setHoraFim(horaFim);
        setDiaSemana(diaSemana);
        setPreco(preco);
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public void setDesignacao(String designacao) throws IllegalArgumentException
    {
        if (designacao == null) throw new IllegalArgumentException("Designacao nao pode ser null.");
        if (designacao.isBlank()) throw new IllegalArgumentException("Designacao nao pode ser vazio.");
        this.designacao = designacao;
    }

    public TipoAtividade getTipo()
    {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) throws IllegalArgumentException
    {
        if (tipo == null) throw new IllegalArgumentException("Tipo nao pode ser nulo.");
        this.tipo = tipo;
    }

    public Local getLocalPartida()
    {
        return localPartida;
    }

    public void setLocalPartida(Local localPartida) throws IllegalArgumentException
    {
        if (localPartida == null) throw new IllegalArgumentException("Local partida nao pode ser nulo.");
        this.localPartida = localPartida;
    }

    public Local getLocalChegada()
    {
        return localChegada;
    }

    public void setLocalChegada(Local localChegada) throws IllegalArgumentException
    {
        if (localChegada == null) throw new IllegalArgumentException("Local chegada nao pode ser nulo");
        this.localChegada = localChegada;
    }

    public int getHoraInicio()
    {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio)
    {
        if (horaInicio < 0 || horaInicio > 24) throw new IllegalArgumentException("Hora Inicio tem que ser entre 0 e 23");
        this.horaInicio = horaInicio;
    }

    public int getHoraFim()
    {
        return horaFim;
    }

    public void setHoraFim(int horaFim)
    {
        if (horaFim < 0 || horaFim > 24) throw new IllegalArgumentException("Hora Fim tem que ser entre 0 e 23");
        this.horaFim = horaFim;
    }

    public DiaSemana getDiaSemana()
    {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) throws IllegalArgumentException
    {
        if (diaSemana == null) throw new IllegalArgumentException("Dia Semana nao pode ser null.");
        this.diaSemana = diaSemana;
    }

    public float getPreco()
    {
        return preco;
    }

    public void setPreco(float preco)
    {
        if (preco <= 0f) throw new IllegalArgumentException("Preco nao pode ser negativo ou zero.");
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;

        if (horaInicio != atividade.horaInicio) return false;
        if (horaFim != atividade.horaFim) return false;
        if (diaSemana != atividade.diaSemana) return false;
        if (Float.compare(atividade.preco, preco) != 0) return false;
        if (!Objects.equals(designacao, atividade.designacao)) return false;
        if (!Objects.equals(tipo, atividade.tipo)) return false;
        if (!Objects.equals(localPartida, atividade.localPartida))
            return false;
        return Objects.equals(localChegada, atividade.localChegada);
    }

    @Override
    public String toString()
    {
        return "Atividade{" +
                "designacao='" + designacao + '\'' +
                ", tipo=" + tipo +
                ", localPartida=" + localPartida +
                ", localChegada=" + localChegada +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                ", diaSemana=" + diaSemana +
                ", preco=" + preco +
                '}';
    }
}