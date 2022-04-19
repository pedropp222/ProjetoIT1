package controller;

import model.Companhia;
import model.TipoAlojamento;
import model.exception.NomeInvalidoException;

public class CriarTipoAlojamentoController
{
    private Companhia companhia;
    private TipoAlojamento tipo;

    public CriarTipoAlojamentoController()
    {
        companhia = Companhia.getInstance();
    }

    public boolean criarTipoAlojamento(String desc) throws NomeInvalidoException
    {
        tipo = companhia.criarTipoAlojamento(desc);

        if (!companhia.validarTipoAlojamento(tipo))
        {
            return false;
        }

        return true;
    }

    public boolean gravarTipoAlojamento()
    {
        return companhia.gravarTipoAlojamento(tipo);
    }
}
