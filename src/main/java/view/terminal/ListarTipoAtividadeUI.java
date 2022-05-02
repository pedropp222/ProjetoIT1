package view.terminal;

import controller.ListarTipoAtividadeController;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import model.filtering.ui.UIOperations;
import view.terminal.util.TerminalUtils;

import java.util.List;
import java.util.Scanner;

public class ListarTipoAtividadeUI implements Runnable
{
    ListarTipoAtividadeController cnt;

    public ListarTipoAtividadeUI()
    {
        cnt = new ListarTipoAtividadeController();
    }

    @Override
    public void run()
    {
        List<String> lista = cnt.getAtividades();

        if (lista.size() == 0)
        {
            System.out.println("Nao existem tipos de atividades registados.");
        } else
        {
            UIOperations.listFilterUI(cnt,lista);
        }
    }
}