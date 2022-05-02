package model.filtering;

public interface Filter<V,V2>
{
    Class<V> getType();
    Class<V2> getSecondType();
    boolean evaluate(V value, V2 filter);
}