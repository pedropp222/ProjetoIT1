package view.terminal;

import controller.ListarLocaisController;
import model.Local;
import model.TipoAlojamento;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import view.terminal.util.TerminalUtils;

import java.util.List;

public class ListarLocaisUI
{
    private final ListarLocaisController contr;

    public ListarLocaisUI()
    {
        contr = new ListarLocaisController();
    }

    public void run()
    {
        List<String> locais = contr.getLocais();

        if (locais.size() == 0)
        {
            System.out.println("Nao existem locais registados.");
        }
        else
        {
            List<FilterEntry<Local, ?,?>> filtrosDisponiveis = contr.getFiltros();

            UIFilter f = TerminalUtils.popularFilterInfo(filtrosDisponiveis);

            if (f != null)
            {
                List<Local> filtrado = contr.filtrar(f.getExt(), f.getFiltro(), f.getValor());

                for (Local t : filtrado)
                {
                    System.out.println("- " + t);
                }
            }
            else
            {
                for (String t : locais)
                {
                    System.out.println("- " + t);
                }
            }
        }
    }
}