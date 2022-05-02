package view.terminal.util;

import model.*;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;
import model.filtering.config.Pair;
import model.filtering.ui.UIFilter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TerminalUtils
{
    public static <E> boolean listarLista(List<E> lista)
    {
        if (lista.size() == 0)
        {
            return false;
        }

        for (int i = 0; i < lista.size(); i++)
        {
            System.out.println("[" + i + "] - " + lista.get(i));
        }

        return true;
    }

    public static void listarDiasSemana()
    {
        for(DiaSemana s : DiaSemana.values())
        {
            System.out.println("["+s.ordinal()+"] - "+s.getRepr());
        }
    }

    public static LocalDate populateData(Scanner sc) throws DateTimeException
    {
        System.out.print("Escreva o ano: ");
        int ano = sc.nextInt();
        System.out.print("Escreva o mes: ");
        int mes = sc.nextInt();
        System.out.print("Escreva o dia: ");
        int dia = sc.nextInt();

        return LocalDate.of(ano,mes,dia);
    }

    public static void criarDadosTeste()
    {
        TipoAtividade ti1 = new TipoAtividade("tipoAtividade 1");
        TipoAtividade ti2 = new TipoAtividade("atividade fixe");
        TipoAtividade ti3 = new TipoAtividade("canoagem");
        TipoAtividade ti4 = new TipoAtividade("tiro ao alvo");
        TipoAtividade ti5 = new TipoAtividade("escalada");
        TipoAtividade ti6 = new TipoAtividade("escavação");

        Local l = new Local("porto","portugal","local 1");
        TipoAlojamento t1 = new TipoAlojamento("tipoAlojamento 1");
        TipoAlojamento t2 = new TipoAlojamento("hotel 1");
        TipoAlojamento t3 = new TipoAlojamento("sitio 1");

        Companhia.getInstance().gravarTipoAtividade(ti1);
        Companhia.getInstance().gravarTipoAtividade(ti2);
        Companhia.getInstance().gravarTipoAtividade(ti3);
        Companhia.getInstance().gravarTipoAtividade(ti4);
        Companhia.getInstance().gravarTipoAtividade(ti5);
        Companhia.getInstance().gravarTipoAtividade(ti6);

        Companhia.getInstance().gravarLocal(l);
        Companhia.getInstance().gravarTipoAlojamento(t1);
        Companhia.getInstance().gravarTipoAlojamento(t2);
        Companhia.getInstance().gravarTipoAlojamento(t3);

        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 0",t1,l,1,1,DiaSemana.SEXTA,5f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 1",t1,l,5,10,DiaSemana.SABADO,10f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 2",t1,l,1,2,DiaSemana.DOMINGO,15f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 3",t2,l,1,4,DiaSemana.TERCA,20f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 4",t3,l,2,7,DiaSemana.SEXTA,30f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 5",t3,l,4,10,DiaSemana.SEGUNDA,40f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 6",t3,l,3,12,DiaSemana.QUINTA,50f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 7",t3,l,5,20,DiaSemana.QUARTA,60f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 8",t3,l,2,8,DiaSemana.SABADO,70f));


        Companhia.getInstance().gravarAtividade(new Atividade("at1",ti1,l,l,5,10,DiaSemana.SEXTA,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at2",ti3,l,l,10,12,DiaSemana.SABADO,15f));
        Companhia.getInstance().gravarAtividade(new Atividade("at3",ti4,l,l,6,9,DiaSemana.DOMINGO,20f));
        Companhia.getInstance().gravarAtividade(new Atividade("at4",ti3,l,l,12,18,DiaSemana.SABADO,8f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti1,l,l,15,17,DiaSemana.SEGUNDA,4f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti6,l,l,20,23,DiaSemana.TERCA,9f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti2,l,l,7,12,DiaSemana.QUARTA,25f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti5,l,l,6,11,DiaSemana.QUINTA,10f));
    }

    public static <T,F,F2> UIFilter popularFilterInfo(List<FilterEntry<T,?,?>> filtrosDisponiveis)
    {
        System.out.println("Filtros disponiveis:");

        Scanner sc = new Scanner(System.in);

        System.out.println("0 - Nenhum filtro");
        int i = 0;
        for (FilterEntry<?, ?,?> filt : filtrosDisponiveis)
        {
            i++;
            System.out.println(i + " - " + filt.getText());
        }

        System.out.print("Escolha o filtro: ");

        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha > 0 && escolha <= filtrosDisponiveis.size())
        {
            FilterEntry<T, ?,?> filter = filtrosDisponiveis.get(escolha - 1);

            if (filter.getFilterClass().getType().equals(filter.getFilterClass().getSecondType()))
            {
                return simpleFilter(filter);
            }
            else
            {
                return advancedFilter(filter);
            }
        }

        return null;
    }

    private static <T,F,F2> UIFilter<T,F,F2> advancedFilter(FilterEntry<T,?,?> filter)
    {
        Scanner sc = new Scanner(System.in);
        if (filter.getFilterClass().getSecondType().equals(Pair.class))
        {
            System.out.println("Introduza o minimo:");
            int min = sc.nextInt();
            System.out.println("Introduza o maximo:");
            int max = sc.nextInt();

            Extractor<T, Integer> ext = (Extractor<T, Integer>) filter.getExtratorMethod();
            Filter<Integer, Pair<Integer>> filtro = (Filter<Integer, Pair<Integer>>) filter.getFilterClass();

            return (UIFilter<T, F, F2>) new UIFilter<T, Integer, Pair<Integer>>(new Pair<Integer>(min,max), ext, filtro);
        }
        else
        {
            System.out.println("Ainda nao ta implementado comparar "+filter.getFilterClass().getType()+" - "+filter.getFilterClass().getSecondType());
        }

        return null;
    }

    private static <T,F,F2> UIFilter<T,F,F2> simpleFilter(FilterEntry<T, ?,?> filter)
    {
        Scanner sc = new Scanner(System.in);
        if (filter.getFilterClass().getType().equals(Float.class))
        {
            System.out.print("Introduza o numero: ");

            float valor = sc.nextFloat();

            Extractor<T, Float> ext = (Extractor<T, Float>) filter.getExtratorMethod();
            Filter<Float, Float> filtro = (Filter<Float, Float>) filter.getFilterClass();

            return (UIFilter<T, F, F2>) new UIFilter<T, Float, Float>(valor, ext, filtro);
        }
        else if (filter.getFilterClass().getType().equals(Integer.class))
        {
            System.out.print("Introduza o numero: ");

            int valor = sc.nextInt();

            Extractor<T, Integer> ext = (Extractor<T, Integer>) filter.getExtratorMethod();
            Filter<Integer, Integer> filtro = (Filter<Integer, Integer>) filter.getFilterClass();

            return (UIFilter<T, F, F2>) new UIFilter<T, Integer, Integer>(valor, ext, filtro);
        }
        else if (filter.getFilterClass().getType().equals(String.class))
        {
            System.out.print("Introduza o texto: ");

            String valor = sc.nextLine();

            Extractor<T, String> ext = (Extractor<T, String>) filter.getExtratorMethod();
            Filter<String, String> filtro = (Filter<String, String>) filter.getFilterClass();

            return (UIFilter<T, F, F2>) new UIFilter<T, String, String>(valor, ext, filtro);
        }
        else
        {
            System.out.println("Ainda nao ta implementado comparar "+filter.getFilterClass().getType());
        }

        return null;
    }
}