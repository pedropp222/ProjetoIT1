package model;

import model.exception.NomeInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoAlojamentoTest
{
    @Test
    public void shouldCreateTipoAlocamento()
    {
        assertDoesNotThrow(()->new TipoAlojamento("designacao"));
    }

    @Test
    public void shouldNotCreateTipoAlojamento_nullDesignacao()
    {
        assertThrows(NomeInvalidoException.class,()->new TipoAlojamento(null));
    }

    @Test
    public void shouldNotCreateTipoAlojamento_spacesDesignacao()
    {
        assertThrows(NomeInvalidoException.class,()->new TipoAlojamento("    "));
    }

    @Test
    public void shouldNotCreateTipoAlojamento_emptyDesignacao()
    {
        assertThrows(NomeInvalidoException.class,()->new TipoAlojamento(""));
    }

    @Test
    public void shouldNotEqualTipoAlojamento_differentClass()
    {
        TipoAlojamento t = new TipoAlojamento("designacao");

        assertNotEquals(t,new Object());
    }

    @Test
    public void shouldNotEqualTipoAlojamento_differentDesignacao()
    {
        TipoAlojamento t = new TipoAlojamento("designacao");
        TipoAlojamento t2 = new TipoAlojamento("designacao 2");

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldEqualTipoAlojamento_sameValues()
    {
        TipoAlojamento t = new TipoAlojamento("designacao");
        TipoAlojamento t2 = new TipoAlojamento("designacao");

        assertEquals(t,t2);
    }
}