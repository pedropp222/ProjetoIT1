package controller;

import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.List;

public interface Filterable<T>
{
    <F,F2> List<T> filtrar(Extractor<T,F> extractor, Filter<F,F2> filtro, F2 valor,boolean negate);
    List<FilterEntry<T,?,?>> getFiltros();
}