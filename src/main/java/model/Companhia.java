package model;

import model.exception.NomeInvalidoException;
import model.factories.MegaFactory;
import model.filtering.classes.alojamento.AlojamentoFilterIncludes;
import model.filtering.classes.alojamento.AlojamentoFilterPrecoMaior;
import model.filtering.filter.AlojamentoDenominacaoFilter;
import model.filtering.filter.AlojamentoPrecoFilter;
import model.filtering.filter.AlojamentoPrecoRangeFilter;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

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

    private MegaFactory factory;

    private static Companhia instance = null;

    private List<TipoAlojamentoDenominacaoFilter> tipoAlojamentoDenominacaoFilters;

    private List<AlojamentoDenominacaoFilter> alojamentoDenominacaoFilters;
    private List<AlojamentoPrecoFilter> alojamentoPrecoFilters;
    private List<AlojamentoPrecoRangeFilter> alojamentoPrecoRangeFilters;

    public Companhia(MegaFactory factory, List<String> tipoAlojamentoDenominacaoFiltersList, List<String> alojamentoFilters, List<String> precoRangeFilters) throws IllegalArgumentException
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

        tipoAlojamentoDenominacaoFilters = criarListaTipoAlojamentoDenominacao(tipoAlojamentoDenominacaoFiltersList);

        alojamentoPrecoFilters = criarListaAlojamentoPreco(alojamentoFilters);
        alojamentoDenominacaoFilters = criarListaAlojamentoDenominacao(alojamentoFilters);
        alojamentoPrecoRangeFilters = criarListaAlojamentoPrecoRange(precoRangeFilters);
    }

    private List<TipoAlojamentoDenominacaoFilter> criarListaTipoAlojamentoDenominacao(List<String> lista)
    {
        List<TipoAlojamentoDenominacaoFilter> lTipoAlojamentoFilters = new ArrayList<>();

        for (String strClassTipoAlojamentoFilter : lista)
        {
            try
            {
                TipoAlojamentoDenominacaoFilter oTipoAlojamentoFilter = (TipoAlojamentoDenominacaoFilter) Class.forName(strClassTipoAlojamentoFilter).getDeclaredConstructor().newInstance();
                lTipoAlojamentoFilters.add(oTipoAlojamentoFilter);
            } catch (Exception e)
            {
                //System.out.println(e.getMessage());
            }
        }

        return lTipoAlojamentoFilters;
    }

    private List<AlojamentoDenominacaoFilter> criarListaAlojamentoDenominacao(List<String> lista)
    {
        List<AlojamentoDenominacaoFilter> lTipoAlojamentoFilters = new ArrayList<>();

        for (String strClassTipoAlojamentoFilter : lista)
        {
            try
            {
                AlojamentoDenominacaoFilter oTipoAlojamentoFilter = (AlojamentoDenominacaoFilter) Class.forName(strClassTipoAlojamentoFilter).getDeclaredConstructor().newInstance();
                lTipoAlojamentoFilters.add(oTipoAlojamentoFilter);
            } catch (Exception e)
            {
                //System.out.println(e.getMessage());
            }
        }

        return lTipoAlojamentoFilters;
    }

    private List<AlojamentoPrecoFilter> criarListaAlojamentoPreco(List<String> lista)
    {
        List<AlojamentoPrecoFilter> lTipoAlojamentoFilters = new ArrayList<>();

        for (String strClassTipoAlojamentoFilter : lista)
        {
            try
            {
                AlojamentoPrecoFilter oTipoAlojamentoFilter = (AlojamentoPrecoFilter) Class.forName(strClassTipoAlojamentoFilter).getDeclaredConstructor().newInstance();
                lTipoAlojamentoFilters.add(oTipoAlojamentoFilter);
            } catch (Exception e)
            {
                //System.out.println(e.getMessage());
            }
        }

        return lTipoAlojamentoFilters;
    }

    private List<AlojamentoPrecoRangeFilter> criarListaAlojamentoPrecoRange(List<String> lista)
    {
        List<AlojamentoPrecoRangeFilter> lTipoAlojamentoFilters = new ArrayList<>();

        for (String strClassTipoAlojamentoFilter : lista)
        {
            try
            {
                AlojamentoPrecoRangeFilter oTipoAlojamentoFilter = (AlojamentoPrecoRangeFilter) Class.forName(strClassTipoAlojamentoFilter).getDeclaredConstructor().newInstance();
                lTipoAlojamentoFilters.add(oTipoAlojamentoFilter);
            } catch (Exception e)
            {
                //System.out.println(e.getMessage());
            }
        }

        return lTipoAlojamentoFilters;
    }


    public Local criarLocal(String cidade, String pais, String desc) throws NomeInvalidoException
    {
        return factory.criarLocal(cidade, pais, desc);
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

    public List<TipoAlojamentoDenominacaoFilter> getTipoAlojamentoDenominacaoFilters()
    {
        return new ArrayList<>(tipoAlojamentoDenominacaoFilters);
    }

    public List<AlojamentoDenominacaoFilter> getAlojamentoDenominacaoFilters()
    {
        return new ArrayList<>(alojamentoDenominacaoFilters);
    }

    public List<AlojamentoPrecoFilter> getAlojamentoPrecoFilters()
    {
        return new ArrayList<>(alojamentoPrecoFilters);
    }

    public List<AlojamentoPrecoRangeFilter> getAlojamentoPrecoRangeFilters()
    {
        return new ArrayList<>(alojamentoPrecoRangeFilters);
    }

    public List<TipoAlojamento> filtrarTiposAlojamentoDenominacao(TipoAlojamentoDenominacaoFilter filtro, String string)
    {

        List<TipoAlojamento> listaFiltrada = new ArrayList<>();

        for (TipoAlojamento oTipoAlojamento : listaTipoAlojamentos)
        {

            if (filtro.complies(oTipoAlojamento, string))
                listaFiltrada.add(oTipoAlojamento);
        }
        return listaFiltrada;
    }

    public List<Alojamento> filtrarAlojamentoDenominacao(AlojamentoDenominacaoFilter filtro, String string)
    {

        List<Alojamento> listaFiltrada = new ArrayList<>();

        for (Alojamento oTipoAlojamento : listaAlojamentos)
        {

            if (filtro.complies(oTipoAlojamento, string))
                listaFiltrada.add(oTipoAlojamento);
        }
        return listaFiltrada;
    }

    public List<Alojamento> filtrarAlojamentoPreco(AlojamentoPrecoFilter filtro, float preco)
    {
        List<Alojamento> listaFiltrada = new ArrayList<>();

        for (Alojamento oTipoAlojamento : listaAlojamentos)
        {

            if (filtro.complies(oTipoAlojamento, preco))
                listaFiltrada.add(oTipoAlojamento);
        }
        return listaFiltrada;
    }

    public List<Alojamento> filtrarAlojamentoPrecoRange(AlojamentoPrecoRangeFilter filtro, float valorMin, float valorMax)
    {
        List<Alojamento> listaFiltrada = new ArrayList<>();

        for (Alojamento oTipoAlojamento : listaAlojamentos)
        {

            if (filtro.complies(oTipoAlojamento, valorMin,valorMax))
                listaFiltrada.add(oTipoAlojamento);
        }
        return listaFiltrada;

    }


}