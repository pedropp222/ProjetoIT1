package view.terminal;

import controller.ListarTipoAlojamentosController;

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

        for (String t : lista)
        {
            System.out.println("- " + t);
        }
    }
}