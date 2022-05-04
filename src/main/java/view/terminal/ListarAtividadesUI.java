package view.terminal;

import controller.interfaces.ControllerLister;
import model.Atividade;
import model.filtering.ui.UIOperations;
import model.parsing.util.ControllerParserUtils;

import java.util.List;

public class ListarAtividadesUI implements Runnable
{
    ControllerLister<Atividade> contr;

    public ListarAtividadesUI()
    {
        contr = ControllerParserUtils.requestListControllerOfType(Atividade.class);
    }

    @Override
    public void run()
    {
        List<String> lista = contr.getList();

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