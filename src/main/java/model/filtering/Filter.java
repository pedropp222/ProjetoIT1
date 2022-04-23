package model.filtering;

public interface Filter<V>
{
    boolean evaluate(V value, V filter);
}