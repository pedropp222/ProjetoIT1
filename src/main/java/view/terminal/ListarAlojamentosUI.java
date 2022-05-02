package view.terminal;

import controller.ListarAlojamentosController;
import model.Alojamento;
import model.TipoAlojamento;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import model.filtering.ui.UIOperations;
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
            UIOperations.listFilterUI(contr,lista);
        }
    }
}