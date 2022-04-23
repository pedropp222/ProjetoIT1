package model.filtering.config;

import model.filtering.Extractor;
import model.filtering.Filter;

public class FilterEntry<T,F>
{
    private final T objectType;
    private final Filter<F> tipo;
    private final Extractor<T,F> extratorMethod;
    private final String text;

    public FilterEntry(T objectType, Filter<F> tipo, Extractor<T,F> extratorMethod, String text)
    {
        this.objectType = objectType;
        this.tipo = tipo;
        this.extratorMethod = extratorMethod;
        this.text = text;
    }

    public T getObjectType()
    {
        return objectType;
    }

    public Filter<F> getTipo()
    {
        return tipo;
    }

    public Extractor<T, F> getExtratorMethod()
    {
        return extratorMethod;
    }

    public String getText()
    {
        return text;
    }
}
