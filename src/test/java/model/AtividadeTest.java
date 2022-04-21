package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AtividadeTest
{
    static TipoAtividade mockTipoAtividade;
    static Local mockLocal;

    @BeforeAll
    public static void setup()
    {
        mockTipoAtividade = mock(TipoAtividade.class);
        mockLocal = mock(Local.class);
    }

    @Test
    public void shouldCreateAtividade_correctValues()
    {
        assertDoesNotThrow(()->new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_nullDesignacao()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade(null,mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_emptyDesignacao()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_spacesDesignacao()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("  ",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_nullTipoAtividade()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",null,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_nullLocalPartida()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,null,mockLocal,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_nullLocalChegada()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,null,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_negativeHoraInicio()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,-10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_negativeHoraFim()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,10,-12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_wrongHoraInicio()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,26,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_wrongHoraFim()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,10,26,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAtividade_nullDiaSemana()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,10,12,null,10f));
    }

    @Test
    public void shouldNotCreateAtividade_zeroPreco()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,0f));
    }

    @Test
    public void shouldNotCreateAtividade_negativePreco()
    {
        assertThrows(IllegalArgumentException.class,()->new Atividade("atividade",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,-10f));
    }

    @Test
    public void shouldNotEqualAtividade_differentClass()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,new Object());
    }

    @Test
    public void shouldNotEqualAtividade_differentDesignacao()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);
        Atividade t2 = new Atividade("designacao 2",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldNotEqualAtividade_differentTipoAtividade()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        TipoAtividade mockTipoAtividade2 = mock(TipoAtividade.class);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade2,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldNotEqualAtividade_differentLocalInicio()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        Local l2 = mock(Local.class);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,l2,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldNotEqualAtividade_differentLocalFim()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        Local l2 = mock(Local.class);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,mockLocal,l2,10,12,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldNotEqualAtividade_differentHoraInicio()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,11,12,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldNotEqualAtividade_differentHoraFim()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,13,DiaSemana.DOMINGO,10f);

        assertNotEquals(t,t2);
    }


    @Test
    public void shouldNotEqualAtividade_differentDiaSemana()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.SEGUNDA,10f);

        assertNotEquals(t,t2);
    }


    @Test
    public void shouldNotEqualAtividade_differentPreco()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,11f);

        assertNotEquals(t,t2);
    }

    @Test
    public void shouldEqualAtividade_sameObject()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        assertEquals(t,t);
    }

    @Test
    public void shouldEqualAtividade_sameValues()
    {
        Atividade t = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);
        Atividade t2 = new Atividade("designacao",mockTipoAtividade,mockLocal,mockLocal,10,12,DiaSemana.DOMINGO,10f);

        assertEquals(t,t2);
    }
}