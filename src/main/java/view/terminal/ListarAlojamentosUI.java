package view.terminal;

import controller.ListarAlojamentosController;
import model.filtering.ui.UIOperations;

import java.util.List;

public class ListarAlojamentosUI implements Runnable
{
    ListarAlojamentosController contr;

    public ListarAlojamentosUI()
    {
        contr = new ListarAlojamentosController();
    }

    @Override
    public void run()
    {
        List<String> lista = contr.getAlojamentos();

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