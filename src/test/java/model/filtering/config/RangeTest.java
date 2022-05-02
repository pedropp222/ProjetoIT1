package model.filtering.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest
{
    @Test
    public void shouldCreatePair_validValues()
    {
        assertDoesNotThrow(()->new Range<>(10,20));
    }

    @Test
    public void shouldCreatePair_validValuesNegative()
    {
        assertDoesNotThrow(()->new Range<>(-20,-10));
    }

    @Test
    public void shouldNotCreatePair_sameValues()
    {
        assertThrows(IllegalArgumentException.class,()->new Range<Integer>(10,10));
    }

    @Test
    public void shouldNotCreatePair_minHigherThanMax()
    {
        assertThrows(IllegalArgumentException.class,()->new Range<Integer>(40,20));
    }
}