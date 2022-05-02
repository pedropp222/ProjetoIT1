package model.filtering.classes;

import model.filtering.Filter;
import model.filtering.config.Range;


public class IntegerFilterRange implements Filter<Integer, Range<Integer>>
{
    @Override
    public Class<Integer> getType()
    {
        return Integer.class;
    }

    @Override
    public Class<Range<Integer>> getSecondType()
    {
        return (Class<Range<Integer>>) (Class<?>) Range.class;
    }

    @Override
    public boolean evaluate(Integer value, Range<Integer> filter)
    {
        return value >= filter.getFirst() && value <= filter.getSecond();
    }
}