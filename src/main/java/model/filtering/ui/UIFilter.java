package model.filtering.ui;

import model.filtering.Extractor;
import model.filtering.Filter;

public class UIFilter<T,F>
{
    private final F valor;

    private final Extractor<T, F> ext;

    private final Filter<F> filtro;

    public UIFilter(F valor, Extractor<T, F> ext, Filter<F> filtro)
    {
        this.valor = valor;
        this.ext = ext;
        this.filtro = filtro;
    }

    public F getValor()
    {
        return valor;
    }

    public Extractor<T, F> getExt()
    {
        return ext;
    }

    public Filter<F> getFiltro()
    {
        return filtro;
    }
}
