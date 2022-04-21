package model;

import model.exception.NomeInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoAtividadeTest
{
    @Test
    public void shouldCreateTipoAtividade()
    {
        assertDoesNotThrow(()->new TipoAtividade("designacao"));
    }

    @Test
    public void shouldNotCreateTipoAtividade_designacaoNull()
    {
        assertThrows(NomeInvalidoException.class,()->new TipoAtividade(null));
    }

    @Test
    public void shouldNotCreateTipoAtividade_designacaoSpaces()
    {
        assertThrows(NomeInvalidoException.class,()->new TipoAtividade("     "));
    }

    @Test
    public void shouldNotCreateTipoAtividade_designacaoEmpty()
    {
        assertThrows(NomeInvalidoException.class,()->new TipoAtividade(""));
    }

    @Test
    public void shouldNotEqualTipoAtividade_differentClass()
    {
        TipoAtividade t = new TipoAtividade("designacao");

        assertNotEquals(t,new Object());
    }

    @Test
    public void shouldNotEqualTipoAtividade_differentDesignacao()
    {
        TipoAtividade t = new TipoAtividade("designacao");
        TipoAtividade t2 = new TipoAtividade("designacao 2");

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldEqualTipoAtividade_sameObject()
    {
        TipoAtividade t = new TipoAtividade("designacao");

        assertEquals(t,t);
    }

    @Test
    public void shouldEqualTipoAtividade_sameValues()
    {
        TipoAtividade t = new TipoAtividade("designacao");
        TipoAtividade t2 = new TipoAtividade("designacao");

        assertEquals(t,t2);
    }
}