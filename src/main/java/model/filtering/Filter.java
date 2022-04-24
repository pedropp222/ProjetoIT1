package model.filtering;

public interface Filter<V>
{
    Class<V> getType();
    boolean evaluate(V value, V filter);
}