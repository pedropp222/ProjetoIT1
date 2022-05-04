package view.terminal;

import controller.interfaces.ControllerLister;
import model.Local;
import model.filtering.ui.UIOperations;
import model.parsing.util.ControllerParserUtils;

import java.util.List;

public class ListarLocaisUI implements Runnable
{
    private final ControllerLister<Local> contr;

    public ListarLocaisUI()
    {
        contr = ControllerParserUtils.requestListControllerOfType(Local.class);
    }

    @Override
    public void run()
    {
        List<String> locais = contr.getList();

        if (locais.size() == 0)
        {
            System.out.println("Nao existem locais registados.");
        }
        else
        {
            UIOperations.listFilterUI(contr,locais);
        }
    }
}