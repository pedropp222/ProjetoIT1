package model.filtering.classes;

import model.filtering.Filter;
import model.filtering.config.NumberCompare;

public class FloatFilterCompare implements Filter<Float, NumberCompare<Float>>
{
    @Override
    public Class<Float> getType()
    {
        return Float.class;
    }

    @Override
    public Class<NumberCompare<Float>> getSecondType()
    {
        return (Class<NumberCompare<Float>>)(Class<?>)NumberCompare.class;
    }

    @Override
    public boolean evaluate(Float value, NumberCompare<Float> filter)
    {
        return NumberCompare.compare(value,filter);
    }
}
