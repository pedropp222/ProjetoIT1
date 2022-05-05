package controller;

import DTO.object.LocalDTO;
import model.Companhia;
import model.Local;
import model.exception.NomeInvalidoException;

public class CriarLocalController
{
    private final Companhia companhia;
    private Local local;

    public CriarLocalController()
    {
        companhia = Companhia.getInstance();
        local = null;
    }

    public boolean criarLocal(String cidade, String pais, String desc) throws NomeInvalidoException
    {
        local = companhia.criarLocal(cidade,pais,desc);

        return true;
    }

    public boolean criarLocal(LocalDTO dto)
    {
        local = companhia.criarLocal(dto);

        return true;
    }

    public boolean gravarLocal()
    {
        return companhia.gravarLocal(local);
    }
}
