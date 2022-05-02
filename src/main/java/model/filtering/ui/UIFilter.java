package model.filtering.ui;

import model.filtering.Extractor;
import model.filtering.Filter;

public class UIFilter<T,F,F2>
{
    private final F2 valor;

    private final Extractor<T, F> ext;

    private final Filter<F,F2> filtro;

    public UIFilter(F2 valor, Extractor<T, F> ext, Filter<F,F2> filtro)
    {
        this.valor = valor;
        this.ext = ext;
        this.filtro = filtro;
    }

    public F2 getValor()
    {
        return valor;
    }

    public Extractor<T, F> getExt()
    {
        return ext;
    }

    public Filter<F,F2> getFiltro()
    {
        return filtro;
    }
}
