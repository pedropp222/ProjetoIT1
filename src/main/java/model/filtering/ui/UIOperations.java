package model.filtering.ui;

import controller.Filterable;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UIOperations
{
    private static final Map<Class<?>, UIMapper> UIMap = new HashMap<>();

    public static void addMap(Class<?> clazz, UIMapper mapper)
    {
        UIMap.put(clazz, mapper);
    }

    public static <T> void listFilterUI(Filterable<T> contr,List<String> originalList)
    {
        List<FilterEntry<T, ?,?>> filtrosDisponiveis = contr.getFiltros();

        UIFilter f = popularFilterInfo(filtrosDisponiveis);

        if (f != null)
        {
            List<T> filtrado = contr.filtrar(f.getExt(), f.getFiltro(), f.getValor(),f.isNegate());

            for (T t : filtrado)
            {
                System.out.println("- " + t);
            }
        }
        else
        {
            for (String t : originalList)
            {
                System.out.println("- " + t);
            }
        }
    }

    public static <T,F,F2> UIFilter popularFilterInfo(List<FilterEntry<T,?,?>> filtrosDisponiveis)
    {
        System.out.println("Selecione um dos Filtros disponiveis.");
        System.out.println("Escreva ! antes da escolha para inverter o filtro.");

        Scanner sc = new Scanner(System.in);

        System.out.println("0 - Nenhum filtro");
        int i = 0;
        for (FilterEntry<?, ?,?> filt : filtrosDisponiveis)
        {
            i++;
            System.out.println(i + " - " + filt.getText());
        }

        System.out.print("Escolha o filtro: ");

        boolean negateFilter = false;
        int escolha = 0;

        String esc = sc.nextLine().trim();
        if (esc.startsWith("!"))
        {
            negateFilter = true;
            escolha = Integer.parseInt(esc.substring(1));
        }
        else
        {
            escolha = Integer.parseInt(esc);
        }

        if (escolha > 0 && escolha <= filtrosDisponiveis.size())
        {
            FilterEntry<T, ?,?> filter = filtrosDisponiveis.get(escolha - 1);
            return createUIFilter(filter,negateFilter);
        }

        return null;
    }

    private static <T,F,F2> UIFilter<T,F,F2> createUIFilter(FilterEntry<T,?,?> filter, boolean negate)
    {
        Extractor<T, ?> ext = filter.getExtratorMethod();
        Filter<?, ?> filtro = filter.getFilterClass();

        UIMapper mapper = UIMap.get(filter.getFilterClass().getSecondType());
        if (mapper != null)
        {
            UIResult result = mapper.run();
            if (result.isSuccessful())
            {
                return new UIFilter(result.getResult(),ext,filtro,negate);
            }
            else
            {
                System.out.println("Ocorreu um erro ao escrever valores: "+result.getErrorMessage());
            }
        }
        else
        {
            System.out.println("Ainda nao ta implementado comparar "+filter.getFilterClass().getType()+" - "+filter.getFilterClass().getSecondType());
        }

        return null;
    }
}
