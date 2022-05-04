package view.terminal;

import controller.interfaces.ControllerLister;
import model.PacoteTurismo;
import model.filtering.ui.UIOperations;
import model.parsing.util.ControllerParserUtils;

import java.util.List;

public class ListarPacoteTurismoUI implements Runnable
{
    private final ControllerLister<PacoteTurismo> contr;

    public ListarPacoteTurismoUI()
    {
        contr = ControllerParserUtils.requestListControllerOfType(PacoteTurismo.class);
    }

    @Override
    public void run()
    {
        List<String> locais = contr.getList();

        if (locais.size() == 0)
        {
            System.out.println("Nao existem pacotes de turismo registados.");
        }
        else
        {
            UIOperations.listFilterUI(contr,locais);
        }
    }
}