package model.filtering.classes;

import model.filtering.Filter;

public class StringFilterNotContains implements Filter<String,String>
{
    @Override
    public Class<String> getType()
    {
        return String.class;
    }

    @Override
    public Class<String> getSecondType()
    {
        return String.class;
    }

    @Override
    public boolean evaluate(String value, String filter)
    {
        return !value.contains(filter);
    }
}