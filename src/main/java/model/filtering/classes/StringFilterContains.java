package model.filtering.classes;

import model.filtering.Filter;

public class StringFilterContains implements Filter<String,String>
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
        if (filter.isEmpty()) return false;
        if (filter.startsWith("#"))
        {
            filter = filter.substring(1).toUpperCase();
            return value.toUpperCase().contains(filter);
        }
        return value.contains(filter);
    }
}