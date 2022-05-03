package model.filtering.classes;

import model.filtering.Filter;
import model.filtering.config.Range;

public class FloatFilterRange implements Filter<Float, Range<Float>>
{
    @Override
    public Class<Float> getType()
    {
        return Float.class;
    }

    @Override
    public Class<Range<Float>> getSecondType()
    {
        return (Class<Range<Float>>)(Class<?>)Range.class;
    }

    @Override
    public boolean evaluate(Float value, Range<Float> filter)
    {
        return value >= filter.getFirst() && value <= filter.getSecond();
    }
}