package view.terminal;

import controller.ListarLocaisController;

import java.util.List;

public class ListarLocaisUI
{
    private final ListarLocaisController contr;

    public ListarLocaisUI()
    {
        contr = new ListarLocaisController();
    }

    public void run()
    {
        List<String> locais = contr.getLocais();

        if (locais.size() == 0)
        {
            System.out.println("Nao existem locais registados.");
        }

        for (String l : locais)
        {
            System.out.println("- " + l);
        }
    }
}