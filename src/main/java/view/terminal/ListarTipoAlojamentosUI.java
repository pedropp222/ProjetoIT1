package view.terminal;

import controller.ListarTipoAlojamentosController;
import model.TipoAlojamento;
import model.TipoAtividade;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import model.filtering.ui.UIOperations;
import view.terminal.util.TerminalUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListarTipoAlojamentosUI
{
    private final ListarTipoAlojamentosController contr;

    public ListarTipoAlojamentosUI()
    {
        contr = new ListarTipoAlojamentosController();
    }

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