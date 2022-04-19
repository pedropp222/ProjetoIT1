package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class CriarAtividadeController
{
    Companhia companhia;
    Atividade atividade;

    public CriarAtividadeController()
    {
        companhia = Companhia.getInstance();
    }

    public boolean criarAtividade(String designacao, int tipo, int localPartida, int localChegada, int horaInicio, int horaFim, DiaSemana diaSemana, float preco) throws IllegalArgumentException
    {
        atividade = companhia.criarAtividade(designacao, companhia.getListaTipoAtividade().get(tipo), companhia.getListaLocais().get(localPartida), companhia.getListaLocais().get(localChegada), horaInicio, horaFim, diaSemana, preco);

        if (!companhia.validarAtividade(atividade))
        {
            return false;
        }

        return true;
    }

    public List<String> getTiposAtividade()
    {
        List<String> lst = new ArrayList<>();

        for(TipoAtividade t : companhia.getListaTipoAtividade())
        {
            lst.add(t.toString());
        }

        return lst;
    }

    public List<String> getLocais()
    {
        List<String> lst = new ArrayList<>();

        for(Local l : companhia.getListaLocais())
        {
            lst.add(l.toString());
        }

        return lst;
    }

    public boolean isTipoAtividadeValido(int esc)
    {
        return esc >= 0 && esc <= companhia.getListaTipoAtividade().size() - 1;
    }

    public boolean isLocalValido(int loc)
    {
        return loc >= 0 && loc <= companhia.getListaLocais().size()-1;
    }

    public boolean gravarAtividade()
    {
        return companhia.gravarAtividade(atividade);
    }
}