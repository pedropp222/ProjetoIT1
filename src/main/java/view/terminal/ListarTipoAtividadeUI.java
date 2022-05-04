package view.terminal;

import controller.interfaces.ControllerLister;
import model.TipoAtividade;
import model.filtering.ui.UIOperations;
import model.parsing.util.ControllerParserUtils;

import java.util.List;

public class ListarTipoAtividadeUI implements Runnable
{
    private final ControllerLister<TipoAtividade> cnt;

    public ListarTipoAtividadeUI()
    {
        cnt = ControllerParserUtils.requestListControllerOfType(TipoAtividade.class);
    }

    @Override
    public void run()
    {
        if (cnt == null)
        {
            System.out.println("Nao existe controller para esta classe.");
            return;
        }
        List<String> lista = cnt.getList();

        if (lista.size() == 0)
        {
            System.out.println("Nao existem tipos de atividades registados.");
        } else
        {
            UIOperations.listFilterUI(cnt,lista);
        }
    }
}