package model;

import model.exception.NomeInvalidoException;

public class Local
{
    private String cidade;
    private String pais;
    private String designacao;

    public Local(String cidade, String pais, String designacao) throws NomeInvalidoException
    {
        setCidade(cidade);
        setPais(pais);
        setDesignacao(designacao);
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade) throws NomeInvalidoException
    {
        if (cidade == null) throw new NomeInvalidoException("Cidade nao pode ser null.");
        if (cidade.isBlank()) throw new NomeInvalidoException("Cidade nao pode estar vazio.");
        this.cidade = cidade;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais) throws NomeInvalidoException
    {
        if (pais == null) throw new NomeInvalidoException("Pais nao pode ser null.");
        if (pais.isBlank()) throw new NomeInvalidoException("Pais nao pode estar vazio.");
        this.pais = pais;
    }

    public String getDesignacao()
    {
        return designacao;
    }

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