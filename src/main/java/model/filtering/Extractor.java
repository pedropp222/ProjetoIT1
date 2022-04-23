package model.filtering;

public interface Extractor<O, F>
{
    F extractValue(O object);
}