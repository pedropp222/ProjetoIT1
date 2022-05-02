package model.filtering.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFilterContainsTest
{
    @Test
    public void shouldEvaluateFilter_correctValue()
    {
        StringFilterContains sc = new StringFilterContains();
        assertTrue(sc.evaluate("escadas","esc"));
    }

    @Test
    public void shouldNotEvaluateFilter_emptyFilter()
    {
        StringFilterContains sc = new StringFilterContains();
        assertFalse(sc.evaluate("escadas",""));
    }

    @Test
    public void shouldNotEvaluateFilter_emptyValue()
    {
        StringFilterContains sc = new StringFilterContains();
        assertFalse(sc.evaluate("","xyz"));
    }

    @Test
    public void shouldNotEvaluateFilter_incorrectValue()
    {
        StringFilterContains sc = new StringFilterContains();
        assertFalse(sc.evaluate("escadas","xyz"));
    }
}