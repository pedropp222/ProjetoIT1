package view.terminal;

import controller.ListarTipoAtividadeController;

import java.util.List;

public class ListarTipoAtividadeUI implements Runnable
{
    ListarTipoAtividadeController cnt;

    public ListarTipoAtividadeUI()
    {
        cnt = new ListarTipoAtividadeController();
    }

    @Override
    public void run()
    {
        List<String> lista = cnt.getAtividades();

        if (lista.size() == 0)
        {
            System.out.println("Nao existem tipos de atividades registados.");
        }

        for (String t : lista)
        {
            System.out.println("- " + t);
        }
    }
}