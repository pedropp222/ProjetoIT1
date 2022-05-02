package view.terminal;

import controller.ListarAlojamentosController;
import model.Alojamento;
import model.TipoAlojamento;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import view.terminal.util.TerminalUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListarAlojamentosUI implements Runnable
{
    ListarAlojamentosController contr;

    public ListarAlojamentosUI()
    {
        contr = new ListarAlojamentosController();
    }

    @Override
    public void run()
    {
        List<String> lista = contr.getAlojamentos();

        if (lista.size() == 0)
        {
            System.out.println("Nao existem tipos de alojamento registados.");
        }
        else
        {
            List<FilterEntry<Alojamento, ?,?>> filtrosDisponiveis = contr.getFiltros();

            UIFilter f = TerminalUtils.popularFilterInfo(filtrosDisponiveis);

            if (f != null)
            {
                List<Alojamento> filtrado = contr.filtrar(f.getExt(), f.getFiltro(), f.getValor());

                for (Alojamento t : filtrado)
                {
                    System.out.println("- " + t);
                }
            }
            else
            {
                for (String t : lista)
                {
                    System.out.println("- " + t);
                }
            }
        }
    }
}