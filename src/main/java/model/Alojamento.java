package model;

import model.exception.NomeInvalidoException;

import java.util.Objects;

public class Alojamento extends Servico
{
    private String designacao;
    private TipoAlojamento tipo;
    private Local local;
    private int minPessoas, maxPessoas;
    private DiaSemana diaSemana;
    private float preco;

    public Alojamento(String designacao, TipoAlojamento tipo, Local local, int minPessoas, int maxPessoas, DiaSemana diaSemana, float preco) throws NomeInvalidoException, IllegalArgumentException
    {
        setDesignacao(designacao);
        setTipo(tipo);
        setLocal(local);
        setMaxPessoas(maxPessoas);
        setMinPessoas(minPessoas);
        setDiaSemana(diaSemana);
        setPreco(preco);
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public void setDesignacao(String designacao) throws NomeInvalidoException
    {
        if (designacao.isBlank()) throw new NomeInvalidoException("Designacao nao pode ser vazio.");
        this.designacao = designacao;
    }

    public TipoAlojamento getTipo()
    {
        return tipo;
    }

    public void setTipo(TipoAlojamento tipo) throws IllegalArgumentException
    {
        if (tipo == null) throw new IllegalArgumentException("Tipo nao pode ser nulo.");
        this.tipo = tipo;
    }

    public Local getLocal()
    {
        return local;
    }

    public void setLocal(Local local) throws IllegalArgumentException
    {
        if (local == null) throw new IllegalArgumentException("Local nao pode ser nulo");
        this.local = local;
    }

    public int getMinPessoas()
    {
        return minPessoas;
    }

    public void setMinPessoas(int minPessoas) throws IllegalArgumentException
    {
        if (minPessoas < 0) throw new IllegalArgumentException("Minimo pessoas nao pode ser negativo.");
        if (minPessoas > this.maxPessoas) throw new IllegalArgumentException("Minimo pessoas nao pode ser superior ao maximo.");
        this.minPessoas = minPessoas;
    }

    public int getMaxPessoas()
    {
        return maxPessoas;
    }

    public void setMaxPessoas(int maxPessoas) throws IllegalArgumentException
    {
        if (maxPessoas < 0) throw new IllegalArgumentException("Maximo pessoas nao pode ser negativo");
        if (maxPessoas < this.minPessoas) throw new IllegalArgumentException("Maximo pessoas nao pode ser inferior ao minimo");
        this.maxPessoas = maxPessoas;
    }

    public DiaSemana getDiaSemana()
    {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) throws IllegalArgumentException
    {
        this.diaSemana = diaSemana;
    }

    public float getPreco()
    {
        return preco;
    }

    public void setPreco(float preco) throws IllegalArgumentException
    {
        if (preco <= 0f) throw new IllegalArgumentException("Preco nao pode ser negativo ou zero.");
        this.preco = preco;
    }

    @Override
    public String toString()
    {
        return "Alojamento{" +
                "designacao='" + designacao + '\'' +
                ", tipo=" + tipo +
                ", local=" + local +
                ", minPessoas=" + minPessoas +
                ", maxPessoas=" + maxPessoas +
                ", diaSemana=" + diaSemana +
                ", preco=" + preco +
                '}';
    }



    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alojamento that = (Alojamento) o;

        if (minPessoas != that.minPessoas) return false;
        if (maxPessoas != that.maxPessoas) return false;
        if (diaSemana != that.diaSemana) return false;
        if (Float.compare(that.preco, preco) != 0) return false;
        if (!Objects.equals(designacao, that.designacao)) return false;
        if (!Objects.equals(tipo, that.tipo)) return false;
        return Objects.equals(local, that.local);
    }
}