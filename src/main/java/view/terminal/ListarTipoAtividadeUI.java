package view.terminal;

import controller.ListarTipoAtividadeController;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
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
            List<FilterEntry<TipoAtividade, ?,?>> filtrosDisponiveis = cnt.getFiltros();

            UIFilter f = TerminalUtils.popularFilterInfo(filtrosDisponiveis);

            if (f != null)
            {
                List<TipoAtividade> filtrado = cnt.filtrar(f.getExt(), f.getFiltro(), f.getValor());

                for (TipoAtividade t : filtrado)
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