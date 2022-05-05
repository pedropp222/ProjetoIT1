package model;

import DTO.AttributeType;
import DTO.DTOAttribute;
import DTO.object.AlojamentoDTO;
import DTO.object.GenericDTO;
import DTO.object.LocalDTO;
import model.exception.NomeInvalidoException;
import model.factories.MegaFactory;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Companhia
{
    private List<Local> listaLocais;
    private List<TipoAlojamento> listaTipoAlojamentos;
    private List<TipoAtividade> listaTipoAtividades;
    private List<Alojamento> listaAlojamentos;
    private List<Atividade> listaAtividades;
    private List<PacoteTurismo> pacoteTurismos;

    private MegaFactory factory;

    private static Companhia instance = null;

    private List<FilterEntry<?,?,?>> listaFiltros;

    public Companhia(MegaFactory factory) throws IllegalArgumentException
    {
        if (factory == null) throw new IllegalArgumentException("factory nao pode ser null.");

        if (instance == null)
        {
            instance = this;
            this.factory = factory;
        } else return;

        listaAlojamentos = new ArrayList<>();
        listaLocais = new ArrayList<>();
        listaTipoAlojamentos = new ArrayList<>();
        listaTipoAtividades = new ArrayList<>();
        listaAtividades = new ArrayList<>();
        pacoteTurismos = new ArrayList<>();
        listaFiltros = new ArrayList<>();
    }

    public Local criarLocal(String cidade, String pais, String desc) throws NomeInvalidoException
    {
        return factory.criarLocal(cidade, pais, desc);
    }

    public Local criarLocal(LocalDTO l) throws NomeInvalidoException
    {
        return factory.criarLocal(findType(AttributeType.STRING,l,0), findType(AttributeType.STRING,l,1), findType(AttributeType.STRING,l,2));
    }

    public Alojamento criarAlojamento(AlojamentoDTO dto) throws NomeInvalidoException, IllegalArgumentException
    {
        return factory.criarAlojamento(findType(AttributeType.STRING,dto,0), getListaTipoAlojamento().get(findType(AttributeType.DTO,dto,0)), getListaLocais().get(findType(AttributeType.DTO,dto,1)), findType(AttributeType.INTEGER,dto,0), findType(AttributeType.INTEGER,dto,1), findType(AttributeType.WEEKDAY,dto,0), findType(AttributeType.FLOAT,dto,0));
    }

    private <T> T findType(AttributeType attrType, GenericDTO<?> g, int index)
    {
        Iterator<DTOAttribute<?>> it = g.getAttributeList();
        int ind = 0;
        while (it.hasNext())
        {
            DTOAttribute<?> attr = it.next();
            if (attr.getType() == attrType)
            {
                if (ind == index)
                {
                    return (T) attr.getValue();
                }
                else
                {
                    ind++;
                }
            }
        }

        return (T) Integer.valueOf(-1);
    }

    public TipoAlojamento criarTipoAlojamento(String desc) throws NomeInvalidoException
    {
        return factory.criarTipoAlojamento(desc);
    }

    public TipoAtividade criarTipoAtividade(String desc) throws NomeInvalidoException
    {
        return factory.criarTipoAtividade(desc);
    }

    public Alojamento criarAlojamento(String desc, TipoAlojamento tipo, Local l, int min, int max, DiaSemana sem, float prec) throws NomeInvalidoException, IllegalArgumentException
    {
        return factory.criarAlojamento(desc, tipo, l, min, max, sem, prec);
    }

    public Atividade criarAtividade(String designacao, TipoAtividade tipo, Local localPartida, Local localChegada, int horaInicio, int horaFim, DiaSemana diaSemana, float preco) throws IllegalArgumentException
    {
        return factory.criarAtividade(designacao, tipo, localPartida, localChegada, horaInicio, horaFim, diaSemana, preco);
    }

    public PacoteTurismo criarPacoteTurismo(List<Reserva> servicos)
    {
        return factory.criarPacoteTurismo(servicos);
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
        if (!validarTipoAtividade(t))
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
        if (!validarAtividade(at))
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

    public boolean validarAtividade(Atividade t)
    {
        return !listaAtividades.contains(t);
    }

    public boolean validarAlojamento(Alojamento a)
    {
        return !listaAlojamentos.contains(a);
    }

    public boolean validarPacoteTurismo(PacoteTurismo t)
    {
        return !pacoteTurismos.contains(t);
    }

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

    public List<Atividade> getListaAtividades()
    {
        return listaAtividades;
    }

    public List<PacoteTurismo> getPacoteTurismos()
    {
        return pacoteTurismos;
    }

    public static void destroy()
    {
        instance = null;
    }

    public <T,F,F2> void addFilter(Class<T> objectType, Filter<F,F2> type, Extractor<T,F> method, String text)
    {
        listaFiltros.add(new FilterEntry<T,F,F2>(objectType, type, method, text));
    }

    public void addFilter(FilterEntry<?,?,?> entry)
    {
        listaFiltros.add(entry);
    }

    public <T,F,F2> List<T> evaluateFilter(T object, Extractor<T,F> extractor, Filter<F,F2> filter, F2 filterValue,boolean negate)
    {
        List<T> filtered = new ArrayList<>();

        for(T o : listFromType(object))
        {
            if (filter.evaluate(extractor.extractValue(o), filterValue) == !negate)
            {
                filtered.add(o);
            }
        }

        return filtered;
    }

    public <T> List<T> listFromType(T type)
    {
        if (type instanceof TipoAtividade)
        {
            return (List<T>) listaTipoAtividades;
        }
        else if (type instanceof TipoAlojamento)
        {
            return (List<T>) listaTipoAlojamentos;
        }
        else if (type instanceof Alojamento)
        {
            return (List<T>) listaAlojamentos;
        }
        else if (type instanceof Atividade)
        {
            return (List<T>) listaAtividades;
        }
        else if (type instanceof Local)
        {
            return (List<T>) listaLocais;
        }
        else if (type instanceof PacoteTurismo)
        {
            return (List<T>) pacoteTurismos;
        }

        return null;
    }

    public <T> List<FilterEntry<T,?,?>> getFiltersFor(T type)
    {
        List<FilterEntry<T,?,?>> filters = new ArrayList<>();

        for(FilterEntry<?,?,?> f : listaFiltros)
        {
            if (f.getObjectType().equals(type.getClass()))
            {
                filters.add((FilterEntry<T,?,?>) f);
            }
        }

        return filters;
    }
}