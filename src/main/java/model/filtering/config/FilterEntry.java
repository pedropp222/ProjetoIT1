package model.filtering.config;

import model.filtering.Extractor;
import model.filtering.Filter;

public class FilterEntry<T,F,F2>
{
    private final Class<T> objectType;
    private final Filter<F,F2> filterClass;
    private final Extractor<T,F> extratorMethod;
    private final String text;

    public FilterEntry(Class<T> objectType, Filter<F,F2> filterClass, Extractor<T,F> extratorMethod, String text)
    {
        this.objectType = objectType;
        this.filterClass = filterClass;
        this.extratorMethod = extratorMethod;
        this.text = text;
    }

    public Class<T> getObjectType()
    {
        return objectType;
    }

    public Filter<F,F2> getFilterClass()
    {
        return filterClass;
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
