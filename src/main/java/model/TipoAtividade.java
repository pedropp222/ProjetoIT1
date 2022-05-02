package model;

import model.exception.NomeInvalidoException;

import java.util.Objects;

public class TipoAtividade
{
    private String designacao;

    public TipoAtividade(String designacao) throws NomeInvalidoException
    {
        setDesignacao(designacao);
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public int getDesignacaoLength(){return designacao.length();}

    public void setDesignacao(String designacao) throws NomeInvalidoException
    {
        if (designacao == null) throw new NomeInvalidoException("Designacao nao pode ser null.");
        if (designacao.isBlank()) throw new NomeInvalidoException("Designacao nao pode estar vazio.");
        this.designacao = designacao;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoAtividade that = (TipoAtividade) o;

        return Objects.equals(designacao, that.designacao);
    }

    @Override
    public String toString()
    {
        return designacao;
    }
}