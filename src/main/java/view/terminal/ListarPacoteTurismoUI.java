package view.terminal;

import controller.ListarPacoteController;
import model.filtering.ui.UIOperations;

import java.util.List;

public class ListarPacoteTurismoUI implements Runnable
{
    private final ListarPacoteController contr;

    public ListarPacoteTurismoUI()
    {
        contr = new ListarPacoteController();
    }

    @Override
    public void run()
    {
        List<String> locais = contr.getLocais();

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
