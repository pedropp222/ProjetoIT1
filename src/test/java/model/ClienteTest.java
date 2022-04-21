package model;

import model.exception.NomeInvalidoException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest
{
    @Test
    public void shouldCreateClient_validValues()
    {
        assertDoesNotThrow(() -> new Cliente("nome","mail", LocalDate.now()));
    }

    @Test
    public void shouldNotCreateClient_invalidName()
    {
        assertThrows(NomeInvalidoException.class,()->new Cliente(null,"email",LocalDate.now()));
    }

    @Test
    public void shouldNotCreateClient_emptyName()
    {
        assertThrows(NomeInvalidoException.class,()->new Cliente("","email",LocalDate.now()));
    }

    @Test
    public void shouldNotCreateClient_invalidMail()
    {
        assertThrows(NomeInvalidoException.class,()->new Cliente("nome",null,LocalDate.now()));
    }

    @Test
    public void shouldNotCreateClient_emptyMail()
    {
        assertThrows(NomeInvalidoException.class,()->new Cliente("nome","",LocalDate.now()));
    }

    @Test
    public void shouldNotCreateClient_invalidDate()
    {
        assertThrows(IllegalArgumentException.class,()->new Cliente("nome","email",null));
    }
}