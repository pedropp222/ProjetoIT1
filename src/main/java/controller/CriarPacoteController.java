package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CriarPacoteController
{
    private final Companhia companhia;
    private final List<Reserva> listaServicos;
    private PacoteTurismo pacote;

    public CriarPacoteController()
    {
        companhia = Companhia.getInstance();
        listaServicos = new ArrayList<>();
    }

    public boolean criarPacoteTurismo()
    {
        if (!validatePacote()) return false;

        pacote = companhia.criarPacoteTurismo(listaServicos);

        if (!companhia.validarPacoteTurismo(pacote)) return false;

        return gravarPacoteTurismo();
    }

    private boolean validatePacote()
    {
        boolean atividade = false;
        boolean alojamento = false;

        for (Reserva c : listaServicos)
        {
            if (c.getEscolha() instanceof Alojamento)
            {
                alojamento = true;
            }
            else if (c.getEscolha() instanceof Atividade)
            {
                atividade = true;
            }
        }

        return atividade && alojamento;
    }

    public boolean gravarPacoteTurismo()
    {
        return companhia.gravarPacoteTurismo(pacote);
    }

    public boolean removerAlojamento(int j)
    {
        Alojamento l = getServicosAlojamento().get(j);
        if (l == null) return false;
        return removerReserva(l);
    }

    public boolean removerAtividade(int j)
    {
        Atividade l = getServicosAtividade().get(j);
        if (l == null) return false;
        return removerReserva(l);
    }

    public boolean removerReserva(Servico s)
    {
        for (Reserva r : listaServicos)
        {
            if (r.getEscolha().equals(s))
            {
                return listaServicos.remove(r);
            }
        }
        return false;
    }

    public boolean criarServico(Servico al, LocalDate data)
    {
        Reserva obj = new Reserva(data, al);

        if (listaServicos.contains(obj)) return false;

        return listaServicos.add(obj);
    }


    public List<Reserva> getListaServicos()
    {
        return listaServicos;
    }

    public List<Alojamento> getServicosAlojamento()
    {
        List<Alojamento> lst = new ArrayList<>();

        for(Reserva c : listaServicos)
        {
            if (c.getEscolha() instanceof Alojamento)
            {
                lst.add((Alojamento) c.getEscolha());
            }
        }

        return lst;
    }

    public List<Atividade> getServicosAtividade()
    {
        List<Atividade> lst = new ArrayList<>();

        for(Reserva c : listaServicos)
        {
            if (c.getEscolha() instanceof Atividade)
            {
                lst.add((Atividade) c.getEscolha());
            }
        }

        return lst;
    }

    public List<Alojamento> getAlojamentos()
    {
        return companhia.getListaAlojamentos();
    }

    public List<Atividade> getAtividades()
    {
        return companhia.getListaAtividades();
    }
}