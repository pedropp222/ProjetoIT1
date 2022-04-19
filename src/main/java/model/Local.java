package model;

import model.exception.NomeInvalidoException;

public class Local
{
    private String cidade;
    private String pais;
    private String designacao;

    public Local(String cidade, String pais, String designacao) throws NomeInvalidoException
    {
        if (cidade.isBlank() || pais.isBlank() || designacao.isBlank())
        {
            throw new NomeInvalidoException("Valores nao podem estar vazios.");
        }

        this.cidade = cidade;
        this.pais = pais;
        this.designacao = designacao;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public void setDesignacao(String designacao)
    {
        this.designacao = designacao;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Local local = (Local) o;

        return local.cidade.equalsIgnoreCase(this.cidade) &&
                local.pais.equalsIgnoreCase(this.pais) &&
                local.designacao.equalsIgnoreCase(this.designacao);
    }

    @Override
    public String toString()
    {
        return cidade+", "+pais+" - "+designacao;
    }
}