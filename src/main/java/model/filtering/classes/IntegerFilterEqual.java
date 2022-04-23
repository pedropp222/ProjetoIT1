package model.filtering.classes;

import model.filtering.Filter;

public class IntegerFilterEqual implements Filter<Integer>
{
    @Override
    public boolean evaluate(Integer value, Integer filter)
    {
        return value.compareTo(filter) == 0;
    }
}