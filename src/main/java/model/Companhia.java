package model;

import model.exception.NomeInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Companhia
{
    private List<Local> listaLocais;
    private List<TipoAlojamento> listaTipoAlojamentos;
    private List<TipoAtividade> listaTipoAtividades;
    private List<Alojamento> listaAlojamentos;
    private List<Atividade> listaAtividades;
    private List<PacoteTurismo> pacoteTurismos;

    private static Companhia instance = null;

    public Companhia()
    {
        if (instance == null)
        {
            instance = this;
        }
        else return;

        listaAlojamentos = new ArrayList<>();
        listaLocais = new ArrayList<>();
        listaTipoAlojamentos = new ArrayList<>();
        listaTipoAtividades = new ArrayList<>();
        listaAtividades = new ArrayList<>();
        pacoteTurismos = new ArrayList<>();
    }

    public Local criarLocal(String cidade, String pais, String desc) throws NomeInvalidoException
    {
        return new Local(cidade,pais,desc);
    }

    public TipoAlojamento criarTipoAlojamento(String desc) throws NomeInvalidoException
    {
        return new TipoAlojamento(desc);
    }

    public TipoAtividade criarTipoAtividade(String desc) throws NomeInvalidoException
    {
        return new TipoAtividade(desc);
    }

    public Alojamento criarAlojamento(String desc, TipoAlojamento tipo, Local l, int min, int max, DiaSemana sem, float prec) throws NomeInvalidoException, IllegalArgumentException
    {
        return new Alojamento(desc,tipo,l,min,max,sem,prec);
    }

    public Atividade criarAtividade(String designacao, TipoAtividade tipo, Local localPartida, Local localChegada, int horaInicio, int horaFim, DiaSemana diaSemana, float preco) throws IllegalArgumentException
    {
        return new Atividade(designacao, tipo, localPartida, localChegada, horaInicio, horaFim, diaSemana, preco);
    }

    public PacoteTurismo criarPacoteTurismo(List<Reserva> servicos)
    {
        return new PacoteTurismo(servicos);
    }

    public boolean gravarLocal(Local x)
    {
        if (listaLocais.contains(x))
        {
            return false;
        }
        return listaLocais.add(x);
    }

    public boolean gravarTipoAlojamento(TipoAlojamento t)
    {
        if (!validarTipoAlojamento(t))
        {
            return false;
        }

        return listaTipoAlojamentos.add(t);
    }

    public boolean gravarTipoAtividade(TipoAtividade t)
    {
        if(!validarTipoAtividade(t))
        {
            return false;
        }

        return listaTipoAtividades.add(t);
    }

    public boolean gravarAlojamento(Alojamento aloj)
    {
        if (!validarAlojamento(aloj))
        {
            return false;
        }

        return listaAlojamentos.add(aloj);
    }

    public boolean gravarAtividade(Atividade at)
    {
        if(!validarAtividade(at))
        {
            return false;
        }

        return listaAtividades.add(at);
    }

    public boolean gravarPacoteTurismo(PacoteTurismo t)
    {
        if (!validarPacoteTurismo(t))
        {
            return false;
        }

        return pacoteTurismos.add(t);
    }

    public boolean validarTipoAlojamento(TipoAlojamento t)
    {
        return !listaTipoAlojamentos.contains(t);
    }

    public boolean validarTipoAtividade(TipoAtividade t)
    {
        return !listaTipoAtividades.contains(t);
    }

    public boolean validarAtividade(Atividade t){return !listaAtividades.contains(t);}

    public boolean validarAlojamento(Alojamento a){return !listaAlojamentos.contains(a);}

    public boolean validarPacoteTurismo(PacoteTurismo t){return !pacoteTurismos.contains(t);}

    public static Companhia getInstance()
    {
        return instance;
    }

    public List<Local> getListaLocais()
    {
        return listaLocais;
    }

    public List<TipoAlojamento> getListaTipoAlojamento()
    {
        return listaTipoAlojamentos;
    }

    public List<TipoAtividade> getListaTipoAtividade()
    {
        return listaTipoAtividades;
    }

    public List<Alojamento> getListaAlojamentos()
    {
        return listaAlojamentos;
    }

    public List<Atividade> getListaAtividades(){return listaAtividades;}

    public List<PacoteTurismo> getPacoteTurismos() {return pacoteTurismos;}
}