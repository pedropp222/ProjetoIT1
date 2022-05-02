package model.filtering.config;

public class Pair<T extends Comparable<T>>
{
    private final T first;
    private final T second;

    public Pair(T first, T second) throws IllegalArgumentException
    {
        if (first.compareTo(second) >= 0)
        {
            throw new IllegalArgumentException("O primeiro valor deve ser menor que o segundo");
        }

        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }
}
