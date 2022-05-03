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

    public static <T extends Number & Comparable<T>> boolean compare(T value, NumberCompare<T> filter)
    {
        switch (filter.getType())
        {
            case EQUAL -> {
                return value.compareTo(filter.getValue())==0;
            }
            case LESS -> {
                return value.compareTo(filter.getValue())<0;
            }
            case MORE -> {
                return value.compareTo(filter.getValue())>0;
            }
            case LESSEQUAL -> {
                return value.compareTo(filter.getValue())<=0;
            }
            case MOREEQUAL -> {
                return value.compareTo(filter.getValue())>=0;
            }
        }

        return false;
    }
}
