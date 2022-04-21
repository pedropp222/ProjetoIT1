package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PacoteTurismoTest
{
    @Test
    public void shouldCreatePacoteTurismo_validValues()
    {
        List<Reserva> res = new ArrayList<>();

        for(int i = 0; i < 5; i++)
        {
            res.add(mock(Reserva.class));
        }

        assertDoesNotThrow(()->new PacoteTurismo(res));
    }

    @Test
    public void shouldNotCreatePacoteTurismo_invalidValue()
    {
        assertThrows(IllegalArgumentException.class,()->new PacoteTurismo(null));
    }
}