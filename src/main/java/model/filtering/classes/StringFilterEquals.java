package model.filtering.classes;

import model.filtering.Filter;

public class StringFilterEquals implements Filter<String, String>
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
        if (filter.startsWith("#"))
        {
            return value.equalsIgnoreCase(filter.substring(1));
        }
        return value.equals(filter);
    }
}