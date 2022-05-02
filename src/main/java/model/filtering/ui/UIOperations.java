package model.filtering.ui;

import controller.Filterable;
import model.filtering.config.FilterEntry;
import view.terminal.util.TerminalUtils;

import java.util.List;

public class UIOperations
{
    public static <T> void listFilterUI(Filterable<T> contr,List<String> originalList)
    {
        List<FilterEntry<T, ?,?>> filtrosDisponiveis = contr.getFiltros();

        UIFilter f = TerminalUtils.popularFilterInfo(filtrosDisponiveis);

        if (f != null)
        {
            List<T> filtrado = contr.filtrar(f.getExt(), f.getFiltro(), f.getValor());

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
}
