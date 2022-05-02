package view.terminal;

import controller.ListarAtividadesController;
import model.Alojamento;
import model.Atividade;
import model.filtering.config.FilterEntry;
import model.filtering.ui.UIFilter;
import model.filtering.ui.UIOperations;
import view.terminal.util.TerminalUtils;

import java.util.List;

public class ListarAtividadesUI implements Runnable
{
    ListarAtividadesController contr;

    public ListarAtividadesUI()
    {
        contr = new ListarAtividadesController();
    }

    @Override
    public void run()
    {
        List<String> lista = contr.getAtividades();

        if (lista.size() == 0)
        {
            System.out.println("Nao existem atividades registadas.");
        }
        else
        {
            UIOperations.listFilterUI(contr,lista);
        }
    }
}