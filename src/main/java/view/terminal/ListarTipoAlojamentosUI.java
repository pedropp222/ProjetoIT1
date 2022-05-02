package view.terminal;

import controller.ListarTipoAlojamentosController;
import model.filtering.ui.UIOperations;

import java.util.List;

public class ListarTipoAlojamentosUI
{
    private final ListarTipoAlojamentosController contr;

    public ListarTipoAlojamentosUI()
    {
        contr = new ListarTipoAlojamentosController();
    }

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