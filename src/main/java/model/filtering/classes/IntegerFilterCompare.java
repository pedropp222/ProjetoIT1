package model.filtering.classes;

import model.filtering.Filter;
import model.filtering.config.NumberCompare;

public class IntegerFilterCompare implements Filter<Integer, NumberCompare<Integer>>
{
    @Override
    public Class<Integer> getType()
    {
        return Integer.class;
    }

    @Override
    public Class<NumberCompare<Integer>> getSecondType()
    {
        return (Class<NumberCompare<Integer>>) (Class<?>)NumberCompare.class;
    }

    @Override
    public boolean evaluate(Integer value, NumberCompare<Integer> filter)
    {
        return NumberCompare.compare(value,filter);
    }
}
