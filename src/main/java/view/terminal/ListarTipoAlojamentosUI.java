package view.terminal;

import controller.ListarTipoAlojamentosController;
import controller.interfaces.ControllerLister;
import model.TipoAlojamento;
import model.filtering.ui.UIOperations;
import model.parsing.util.ControllerParserUtils;

import java.util.List;

public class ListarTipoAlojamentosUI implements Runnable
{
    private final ControllerLister<TipoAlojamento> contr;

    public ListarTipoAlojamentosUI()
    {
        contr = ControllerParserUtils.requestListControllerOfType(TipoAlojamento.class);
    }

    @Override
    public void run()
    {
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