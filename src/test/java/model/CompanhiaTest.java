package model;

import model.exception.NomeInvalidoException;
import model.factories.CreateLocalFactory;
import model.factories.MegaFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompanhiaTest
{
    static MegaFactory factoryMock;

    @BeforeAll
    public static void setup()
    {
        factoryMock = mock(MegaFactory.class);
    }

    @BeforeEach
    public void before()
    {
        Companhia.destroy();
    }

    @Test
    public void shouldCreateCompanhia_validValues()
    {
        assertDoesNotThrow(()->new Companhia(factoryMock));
    }

    @Test
    public void shouldNotCreateCompanhia_nullValue()
    {
        assertThrows(IllegalArgumentException.class,()->new Companhia(null));
    }

    @Test
    public void shouldCreateLocal_validValues()
    {
        Local localMock = mock(Local.class);
        when(factoryMock.criarLocal("cidade","pais","descricao")).thenReturn(localMock);

        Companhia comp = new Companhia(factoryMock);

        Local local2 = comp.criarLocal("cidade","pais","descricao");

        assertEquals(localMock, local2);
    }

    @Test
    public void shouldNotCreateLocal_invalidValue()
    {
        when(factoryMock.criarLocal(null,"pais","designacao")).thenThrow(NomeInvalidoException.class);

        Companhia comp = new Companhia(factoryMock);

        assertThrows(NomeInvalidoException.class,()->comp.criarLocal(null,"pais","designacao"));
    }

    @Test
    public void shouldCreateTipoAtividade_validValues()
    {
        TipoAtividade atMock = mock(TipoAtividade.class);
        when(factoryMock.criarTipoAtividade("tipo")).thenReturn(atMock);

        Companhia comp = new Companhia(factoryMock);

        TipoAtividade atMock2 = comp.criarTipoAtividade("tipo");

        assertEquals(atMock, atMock2);
    }

    @Test
    public void shouldNotCreateTipoAtividade_invalidValues()
    {
        when(factoryMock.criarTipoAtividade(null)).thenThrow(NomeInvalidoException.class);

        Companhia comp = new Companhia(factoryMock);

        assertThrows(NomeInvalidoException.class,()->comp.criarTipoAtividade(null));
    }

    @Test
    public void shouldCreateTipoAlojamento_validValues()
    {
        TipoAlojamento atMock = mock(TipoAlojamento.class);
        when(factoryMock.criarTipoAlojamento("tipo")).thenReturn(atMock);

        Companhia comp = new Companhia(factoryMock);

        TipoAlojamento atMock2 = comp.criarTipoAlojamento("tipo");

        assertEquals(atMock, atMock2);
    }

    @Test
    public void shouldNotCreateTipoAlojamento_invalidValues()
    {
        when(factoryMock.criarTipoAlojamento(null)).thenThrow(NomeInvalidoException.class);

        Companhia comp = new Companhia(factoryMock);

        assertThrows(NomeInvalidoException.class,()->comp.criarTipoAlojamento(null));
    }

    @Test
    public void shouldCreateAlojamento_validValues()
    {
        Alojamento alMock = mock(Alojamento.class);

        TipoAlojamento tMock = mock(TipoAlojamento.class);
        Local lMock = mock(Local.class);

        when(factoryMock.criarAlojamento("desn",tMock,lMock,1,2,DiaSemana.DOMINGO,10f)).thenReturn(alMock);

        Companhia comp = new Companhia(factoryMock);


        Alojamento al2 = comp.criarAlojamento("desn",tMock,lMock,1,2,DiaSemana.DOMINGO,10f);


        assertEquals(alMock,al2);
    }

    @Test
    public void shouldNotCreateAlojamento_invalidValues()
    {
        TipoAlojamento tMock = mock(TipoAlojamento.class);
        Local lMock = mock(Local.class);

        when(factoryMock.criarAlojamento(null,tMock,lMock,1,2,DiaSemana.DOMINGO,10f)).thenThrow(NomeInvalidoException.class);

        Companhia comp = new Companhia(factoryMock);

        assertThrows(NomeInvalidoException.class,()->comp.criarAlojamento(null,tMock,lMock,1,2,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldCreateAtividade_validValues()
    {
        Atividade atMock = mock(Atividade.class);

        TipoAtividade tMock = mock(TipoAtividade.class);
        Local lMock = mock(Local.class);

        when(factoryMock.criarAtividade("desn",tMock,lMock,lMock,10,12,DiaSemana.DOMINGO,10f)).thenReturn(atMock);

        Companhia comp = new Companhia(factoryMock);

        Atividade at2 = comp.criarAtividade("desn",tMock,lMock,lMock,10,12,DiaSemana.DOMINGO,10f);

        assertEquals(atMock,at2);
    }

    @Test
    public void shouldNotCreateAtividade_invalidValue()
    {
        TipoAtividade tMock = mock(TipoAtividade.class);
        Local lMock = mock(Local.class);

        when(factoryMock.criarAtividade(null,tMock,lMock,lMock,10,12,DiaSemana.DOMINGO,10f)).thenThrow(IllegalArgumentException.class);

        Companhia comp = new Companhia(factoryMock);

        assertThrows(IllegalArgumentException.class,()->comp.criarAtividade(null,tMock,lMock,lMock,10,12,DiaSemana.DOMINGO,10f));
    }

    @Test
    public void shouldCreatePacoteTurismo_validValues()
    {
        List<Reserva> re = new ArrayList<>();

        for(int i = 0; i < 5; i++)
        {
            re.add(mock(Reserva.class));
        }

        PacoteTurismo pMock = mock(PacoteTurismo.class);

        when(factoryMock.criarPacoteTurismo(re)).thenReturn(pMock);

        Companhia comp = new Companhia(factoryMock);

        PacoteTurismo p2 = comp.criarPacoteTurismo(re);

        assertEquals(pMock,p2);
    }

    @Test
    public void shouldNotCreatePacoteTurismo_invalidValues()
    {
        when(factoryMock.criarPacoteTurismo(null)).thenThrow(IllegalArgumentException.class);

        Companhia comp = new Companhia(factoryMock);

        assertThrows(IllegalArgumentException.class,()->comp.criarPacoteTurismo(null));
    }
}