package model.filtering.classes;

import model.filtering.config.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerFilterRangeTest
{
    @Test
    public void shouldEvaluate_valueInRange()
    {
        IntegerFilterRange ir = new IntegerFilterRange();

        assertTrue(ir.evaluate(10,new Range<>(5,15)));
    }

    @Test
    public void shouldNotEvaluate_valueBelowRange()
    {
        IntegerFilterRange ir = new IntegerFilterRange();

        assertFalse(ir.evaluate(10,new Range<>(20,50)));
    }

    @Test
    public void shouldNotEvaluate_valueOverRange()
    {
        IntegerFilterRange ir = new IntegerFilterRange();

        assertFalse(ir.evaluate(50,new Range<>(10,30)));
    }

}