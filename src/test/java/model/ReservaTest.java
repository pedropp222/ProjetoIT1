package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ReservaTest
{
    static LocalDate dateMock;
    static Servico servicoMock;

    @BeforeAll
    public static void setup()
    {
        dateMock = LocalDate.of(2022,4,21);
        servicoMock = mock(Servico.class);
    }

    @Test
    public void shouldCreateReserva_correctValues()
    {
        assertDoesNotThrow(()->new Reserva(dateMock,servicoMock));
    }

    @Test
    public void shouldNotCreateReserva_nullDate()
    {
        assertThrows(IllegalArgumentException.class,()->new Reserva(null,servicoMock));
    }

    @Test
    public void shouldNotCreateReserva_nullServico()
    {
        assertThrows(IllegalArgumentException.class,()->new Reserva(dateMock,null));
    }

    @Test
    public void shouldNotEqualReserva_differentClass()
    {
        Reserva r = new Reserva(dateMock,servicoMock);

        assertNotEquals(r,new Object());
    }

    @Test
    public void shouldNotEqualReserva_differentDate()
    {
        Reserva r = new Reserva(dateMock,servicoMock);

        LocalDate date2 = LocalDate.of(2022,4,22);

        Reserva r2 = new Reserva(date2, servicoMock);

        assertNotEquals(r,r2);
    }

    @Test
    public void shouldNotEqualReserva_differentServico()
    {
        Reserva r = new Reserva(dateMock,servicoMock);

        Servico sv = mock(Servico.class);

        Reserva r2 = new Reserva(dateMock,sv);

        assertNotEquals(r,r2);
    }

    @Test
    public void shouldEqualReserva_sameValues()
    {
        Reserva r = new Reserva(dateMock,servicoMock);
        Reserva r2 = new Reserva(dateMock,servicoMock);

        assertEquals(r,r2);
    }
}