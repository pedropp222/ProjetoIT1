package view.terminal;

import controller.interfaces.ControllerLister;
import model.Alojamento;
import model.filtering.ui.UIOperations;
import model.parsing.util.ControllerParserUtils;

import java.util.List;

public class ListarAlojamentosUI implements Runnable
{
    ControllerLister<Alojamento> contr;

    public ListarAlojamentosUI()
    {
        contr = ControllerParserUtils.requestListControllerOfType(Alojamento.class);
    }

    @Override
    public void run()
    {
        if (contr == null)
        {
            System.out.println("Nao existe controlador para este UI");
            return;
        }

        List<String> lista = contr.getList();

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