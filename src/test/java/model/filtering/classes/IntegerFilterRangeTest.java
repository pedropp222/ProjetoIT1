package model.filtering.classes;

import model.filtering.config.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerFilterRangeTest
{
    @Test
    public void shouldEvaluate_valueInRange()
    {
        IntegerFilterRange ir = new IntegerFilterRange();

        assertTrue(ir.evaluate(10,new Pair<>(5,15)));
    }

    @Test
    public void shouldNotEvaluate_valueBelowRange()
    {
        IntegerFilterRange ir = new IntegerFilterRange();

        assertFalse(ir.evaluate(10,new Pair<>(20,50)));
    }

    @Test
    public void shouldNotEvaluate_valueOverRange()
    {
        IntegerFilterRange ir = new IntegerFilterRange();

        assertFalse(ir.evaluate(50,new Pair<>(10,30)));
    }

}