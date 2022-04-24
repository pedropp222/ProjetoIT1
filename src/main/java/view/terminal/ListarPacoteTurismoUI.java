package view.terminal;

import controller.ListarLocaisController;
import controller.ListarPacoteController;
import model.Local;
import model.PacoteTurismo;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import view.terminal.util.TerminalUtils;

import java.util.List;

public class ListarPacoteTurismoUI
{
    private final ListarPacoteController contr;

    public ListarPacoteTurismoUI()
    {
        contr = new ListarPacoteController();
    }

    public void run()
    {
        List<String> locais = contr.getLocais();

        if (locais.size() == 0)
        {
            System.out.println("Nao existem pacotes de turismo registados.");
        }
        else
        {
            List<FilterEntry<PacoteTurismo, ?>> filtrosDisponiveis = contr.getFiltros();

            UIFilter f = TerminalUtils.popularFilterInfo(filtrosDisponiveis);

            if (f != null)
            {
                List<PacoteTurismo> filtrado = contr.filtrar(f.getExt(), f.getFiltro(), f.getValor());

                for (PacoteTurismo t : filtrado)
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
