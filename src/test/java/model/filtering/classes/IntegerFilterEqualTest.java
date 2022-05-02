package model.filtering.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerFilterEqualTest
{
    @Test
    public void shouldEvaluate_sameValues()
    {
        IntegerFilterEqual ie = new IntegerFilterEqual();

        assertTrue(ie.evaluate(10, 10));
    }

    @Test
    public void shouldNotEvaluate_differentValues()
    {
        IntegerFilterEqual ie = new IntegerFilterEqual();

        assertFalse(ie.evaluate(10,12));
    }
}