package view.terminal;

import controller.ListarTipoAtividadeController;
import model.filtering.ui.UIOperations;

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
        } else
        {
            UIOperations.listFilterUI(cnt,lista);
        }
    }
}