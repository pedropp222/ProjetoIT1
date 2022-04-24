package view.terminal;

import controller.ListarTipoAtividadeController;
import model.TipoAtividade;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.util.List;
import java.util.Scanner;

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
            Scanner sc = new Scanner(System.in);

            System.out.println("Filtros disponiveis:");

            List<FilterEntry<TipoAtividade, ?>> filtrosDisponiveis = cnt.getFiltros();

            int i = 0;
            for (FilterEntry<TipoAtividade, ?> filt : filtrosDisponiveis)
            {
                i++;
                System.out.println(i + " - " + filt.getText());
            }

            System.out.print("Escolha o filtro: ");

            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha > 0 && escolha <= filtrosDisponiveis.size())
            {

                FilterEntry<TipoAtividade, ?> filter = filtrosDisponiveis.get(escolha - 1);

                if (filter.getFilterClass().getType().equals(String.class))
                {
                    System.out.print("Introduza o valor: ");

                    String valor = sc.nextLine();

                    Extractor<TipoAtividade, String> ext = (Extractor<TipoAtividade, String>) filter.getExtratorMethod();

                    Filter<String> filtro = (Filter<String>) filter.getFilterClass();

                    List<TipoAtividade> filtrado = cnt.filtrar(ext, filtro, valor);

                    for (TipoAtividade t : filtrado)
                    {
                        System.out.println("- " + t);
                    }
                }


            }
        }
    }
}