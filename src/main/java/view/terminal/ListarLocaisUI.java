package view.terminal;

import controller.ListarLocaisController;
import model.filtering.ui.UIOperations;

import java.util.List;

public class ListarLocaisUI implements Runnable
{
    private final ListarLocaisController contr;

    public ListarLocaisUI()
    {
        contr = new ListarLocaisController();
    }

    @Override
    public void run()
    {
        List<String> locais = contr.getLocais();

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