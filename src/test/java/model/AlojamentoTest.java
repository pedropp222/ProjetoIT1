package model;

import model.exception.NomeInvalidoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AlojamentoTest
{

    static TipoAlojamento tipoMock;
    static Local localMock;

    @BeforeAll
    static void setup()
    {
        tipoMock = mock(TipoAlojamento.class);
        localMock = mock(Local.class);
    }

    @Test
    public void shouldCreateAlojamento_correctValues()
    {
        assertDoesNotThrow(() -> {new Alojamento("hotel", tipoMock, localMock, 1, 2, DiaSemana.DOMINGO, 10f);});
    }

    @Test
    public void shouldNotCreateAlojamento_nullTipoAlojamento()
    {
        assertThrows(Exception.class,()->{new Alojamento("hotel",null,localMock,1,2,DiaSemana.DOMINGO,10f);});
    }

    @Test
    public void shouldNotCreateAlojamento_nullLocal()
    {
        assertThrows(Exception.class,()->{new Alojamento("hotel",tipoMock,null,1,2,DiaSemana.DOMINGO,10f);});
    }

    @Test
    public void shouldNotCreateAlojamento_emptyDesignacao()
    {
        assertThrows(Exception.class,()->{new Alojamento("",tipoMock,localMock,1,2,DiaSemana.DOMINGO,10f);});
    }

    @Test
    public void shouldNotCreateAlojamento_designacaoNull()
    {
        assertThrows(Exception.class,()->new Alojamento(null,tipoMock,localMock,1,2,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAlojamento_spacesDesignacao()
    {
        assertThrows(Exception.class,()->new Alojamento("        ",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shoudNotCreateAlojamento_minPessoasMoreThanMaxPessoas()
    {
        assertThrows(Exception.class,()->{new Alojamento("hotel",tipoMock,localMock,5,2,DiaSemana.DOMINGO,10f);});
    }

    @Test
    public void shouldNotCreateAlojamento_negativeMinPessoas()
    {
        assertThrows(Exception.class,()->new Alojamento("hotel",tipoMock,localMock,-4,5,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAlojamento_negativeMaxPessoas()
    {
        assertThrows(Exception.class,()->new Alojamento("hotel",tipoMock,localMock,5,-3,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAlojamento_zeroPessoas()
    {
        assertThrows(Exception.class,()->new Alojamento("hotel",tipoMock,localMock,0,0,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldNotCreateAlojamento_negativePreco()
    {
        assertThrows(Exception.class,()->new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,-5f));
    }

    @Test
    public void shouldNotCreateAlojamento_nullDiaSemana()
    {
        assertThrows(Exception.class,()->new Alojamento("hotel",tipoMock,localMock,2,3,null,10f));
    }

    @Test
    public void shouldNotCreateAlojamento_zeroPreco()
    {
        assertThrows(Exception.class,()->new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,0f));
    }

    @Test
    public void shouldNotEqualAlojamento_differentClass()
    {
        assertNotEquals(new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f),new Object());
    }

    @Test
    public void shouldNotEqualAlomamento_differentDesignacao()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        Alojamento alojamento2 = new Alojamento("hotel2",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldNotEqualAlojamento_differentTipoAlojamento()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);

        TipoAlojamento tipoMock2 = mock(TipoAlojamento.class);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock2,localMock,2,3,DiaSemana.DOMINGO,10f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldNotEqualAlojamento_differentLocal()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);

        Local localMock2 = mock(Local.class);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock,localMock2,2,3,DiaSemana.DOMINGO,10f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldNotEqualAlojamento_differentMinPessoas()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock,localMock,3,3,DiaSemana.DOMINGO,10f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldNotEqualAlojamento_differentMaxPessoas()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock,localMock,2,4,DiaSemana.DOMINGO,10f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldNotEqualAlojamento_differentDiaSemana()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.SEGUNDA,10f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldNotEqualAlojamento_differentPreco()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,11f);
        assertFalse(alojamento.equals(alojamento2));
    }

    @Test
    public void shouldEqualAlojamento_sameObject()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        assertEquals(alojamento,alojamento);
    }

    @Test
    public void shouldEqualAlojamento_sameValues()
    {
        Alojamento alojamento = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);
        Alojamento alojamento2 = new Alojamento("hotel",tipoMock,localMock,2,3,DiaSemana.DOMINGO,10f);

        assertEquals(alojamento,alojamento2);
    }
}