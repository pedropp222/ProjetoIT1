package model.filtering.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest
{
    @Test
    public void shouldCreatePair_validValues()
    {
        assertDoesNotThrow(()->new Pair<>(10,20));
    }

    @Test
    public void shouldCreatePair_validValuesNegative()
    {
        assertDoesNotThrow(()->new Pair<>(-20,-10));
    }

    @Test
    public void shouldNotCreatePair_sameValues()
    {
        assertThrows(IllegalArgumentException.class,()->new Pair<Integer>(10,10));
    }

    @Test
    public void shouldNotCreatePair_minHigherThanMax()
    {
        assertThrows(IllegalArgumentException.class,()->new Pair<Integer>(40,20));
    }
}