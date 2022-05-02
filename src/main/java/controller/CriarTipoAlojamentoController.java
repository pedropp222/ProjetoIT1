package controller;

import model.Companhia;
import model.TipoAlojamento;
import model.exception.NomeInvalidoException;

public class CriarTipoAlojamentoController
{
    private final Companhia companhia;
    private TipoAlojamento tipo;

    public CriarTipoAlojamentoController()
    {
        companhia = Companhia.getInstance();
    }

    public boolean criarTipoAlojamento(String desc) throws NomeInvalidoException
    {
        tipo = companhia.criarTipoAlojamento(desc);

        return companhia.validarTipoAlojamento(tipo);
    }

    public boolean gravarTipoAlojamento()
    {
        return companhia.gravarTipoAlojamento(tipo);
    }
}
