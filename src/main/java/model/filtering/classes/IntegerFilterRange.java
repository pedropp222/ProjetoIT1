package model.filtering.classes;

import model.filtering.Filter;
import model.filtering.config.Pair;


public class IntegerFilterRange implements Filter<Integer, Pair<Integer>>
{
    @Override
    public Class<Integer> getType()
    {
        return Integer.class;
    }

    @Override
    public Class<Pair<Integer>> getSecondType()
    {
        return (Class<Pair<Integer>>) new Pair<Integer>(0,0).getClass();
    }

    @Override
    public boolean evaluate(Integer value, Pair<Integer> filter)
    {
        return value >= filter.getFirst() && value <= filter.getSecond();
    }
}