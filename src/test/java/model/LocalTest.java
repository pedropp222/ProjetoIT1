package model;

import static org.junit.jupiter.api.Assertions.*;

import model.exception.NomeInvalidoException;
import org.junit.jupiter.api.Test;


class LocalTest
{
    @Test
    public void shouldCreateLocal_correctValues()
    {
        assertDoesNotThrow(()->new Local("cidade","pais","designacao"));
    }

    @Test
    public void shouldNotCreateLocal_emptyCidade()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("","pais","designacao"));
    }

    @Test
    public void shouldNotCreateLocal_spacesCidade()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("     ","pais","designacao"));
    }

    @Test
    public void shouldNotCreateLocal_nullCidade()
    {
        assertThrows(NomeInvalidoException.class,()->new Local(null,"pais","designacao"));
    }

    @Test
    public void shouldNotCreateLocal_emptyPais()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("cidade","","designacao"));
    }

    @Test
    public void shouldNotCreateLocal_spacesPais()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("cidade","    ","designacao"));
    }

    @Test
    public void shouldNotCreateLocal_nullPais()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("cidade",null,"designacao"));
    }

    @Test
    public void shouldNotCreateLocal_emptyDesignacao()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("cidade","pais",""));
    }

    @Test
    public void shouldNotCreateLocal_spacesDesignacao()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("cidade","pais","     "));
    }

    @Test
    public void shouldNotCreateLocal_nullDesignacao()
    {
        assertThrows(NomeInvalidoException.class,()->new Local("cidade","pais",null));
    }

    @Test
    public void shouldEqualLocal_sameObject()
    {
        Local l = new Local("cidade","pais","designacao");

        assertEquals(l,l);
    }

    @Test
    public void shouldEqualLocal_sameValues()
    {
        Local l = new Local("cidade","pais","designacao");
        Local l2 = new Local("cidade","pais","designacao");

        assertEquals(l,l2);
    }

    @Test
    public void shouldNotEqualLocal_differentObject()
    {
        Local l = new Local("cidade","pais","designacao");

        assertNotEquals(l,new Object());
    }

    @Test
    public void shouldNotEqualLocal_differentCidade()
    {
        Local l = new Local("cidade","pais","designacao");
        Local l2 = new Local("cidade 2","pais","designacao");

        assertNotEquals(l,l2);
    }

    @Test
    public void shouldNotEqualLocal_differentPais()
    {
        Local l = new Local("cidade","pais","designacao");
        Local l2 = new Local("cidade","pais 2","designacao");

        assertNotEquals(l,l2);
    }

    @Test
    public void shouldNotEqualLocal_differentDesignacao()
    {
        Local l = new Local("cidade","pais","designacao");
        Local l2 = new Local("cidade","pais","designacao 2");

        assertNotEquals(l,l2);
    }
}