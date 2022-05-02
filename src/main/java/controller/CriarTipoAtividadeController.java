package controller;

import model.Companhia;
import model.TipoAtividade;

public class CriarTipoAtividadeController
{
    private final Companhia companhia;
    private TipoAtividade at;

    public CriarTipoAtividadeController()
    {
        companhia = Companhia.getInstance();
    }

    public boolean criarTipoAtividade(String den)
    {
        at = companhia.criarTipoAtividade(den);

        return companhia.validarTipoAtividade(at);
    }

    public boolean gravarTipoAtividade()
    {
        return companhia.gravarTipoAtividade(at);
    }
}
