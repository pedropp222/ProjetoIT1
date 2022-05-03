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
