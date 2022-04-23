package model.filtering.classes;

import model.filtering.Filter;

public class StringFilterContains implements Filter<String>
{
    @Override
    public boolean evaluate(String value, String filter)
    {
        return value.contains(filter);
    }
}