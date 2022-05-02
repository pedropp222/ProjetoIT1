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
    public void shouldNotCreatePacoteTurismo_emptyArray()
    {
        List<Reserva> res = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,()->new PacoteTurismo(res));
    }

    @Test
    public void shouldCreateAndContain3Reservas()
    {
        List<Reserva> res = new ArrayList<>();
        for(int i = 0; i < 3; i++)
        {
            res.add(mock(Reserva.class));
        }

        PacoteTurismo pt = new PacoteTurismo(res);

        assertEquals(3,pt.getNumServicos());

    }


    @Test
    public void shouldNotCreatePacoteTurismo_invalidValue()
    {
        assertThrows(IllegalArgumentException.class,()->new PacoteTurismo(null));
    }
}