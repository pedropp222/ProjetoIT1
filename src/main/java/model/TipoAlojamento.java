package model;

import model.exception.NomeInvalidoException;

public class TipoAlojamento
{
    private String designacao;

    public TipoAlojamento(String designacao) throws NomeInvalidoException
    {
        setDesignacao(designacao);
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public void setDesignacao(String designacao) throws NomeInvalidoException
    {
        if (designacao == null) throw new NomeInvalidoException("Designacao nao pode ser null.");
        if (designacao.isBlank()) throw new NomeInvalidoException("Nome invalido.");
        this.designacao = designacao;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoAlojamento that = (TipoAlojamento) o;

        return that.designacao.equalsIgnoreCase(designacao);
    }

    @Override
    public String toString()
    {
        return designacao;
    }
}