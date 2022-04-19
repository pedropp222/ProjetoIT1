package controller;

import model.Companhia;
import model.TipoAtividade;

public class CriarTipoAtividadeController
{
    Companhia companhia;
    TipoAtividade at;

    public CriarTipoAtividadeController()
    {
        companhia = Companhia.getInstance();
    }

    public boolean criarTipoAtividade(String den)
    {
        at = companhia.criarTipoAtividade(den);

        if (!companhia.validarTipoAtividade(at))
        {
            return false;
        }

        return true;
    }

    public boolean gravarTipoAtividade()
    {
        return companhia.gravarTipoAtividade(at);
    }
}
