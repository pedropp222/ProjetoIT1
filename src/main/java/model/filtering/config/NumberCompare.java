package model.filtering.config;

public class NumberCompare<T extends Number>
{
    private final T value;
    private final CompareType type;

    public NumberCompare(T value, CompareType type)
    {
        this.value = value;
        this.type = type;
    }

    public T getValue()
    {
        return value;
    }

    public CompareType getType()
    {
        return type;
    }
}
