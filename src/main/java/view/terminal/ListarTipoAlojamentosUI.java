package view.terminal;

import controller.ListarTipoAlojamentosController;
import model.TipoAlojamento;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

import java.util.List;
import java.util.Scanner;

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
            Scanner sc = new Scanner(System.in);

            TipoAlojamentoDenominacaoFilter filtro = readTipoAlojamentoFilter();

            System.out.println("Valor a filtrar: ");
            String v = sc.nextLine();

            List<TipoAlojamento> listaTipoAlojamento = contr.filtrarDenominacao(filtro, v);

            System.out.println("\nLista de Tipo de Alojamento filtrada:\n");
            for (TipoAlojamento ta : listaTipoAlojamento) {
                System.out.println(ta.toString() + "\n");
            }
        }
    }

    private TipoAlojamentoDenominacaoFilter readTipoAlojamentoFilter()
    {
        List<TipoAlojamentoDenominacaoFilter> lstTipoAlojamentoFilters = contr.getTipoAlojamentoDenominacaoFilters();

        Scanner sc = new Scanner(System.in);

        int nIndex = 0;
        do {
            int i = 0;
            for (TipoAlojamentoDenominacaoFilter tipoAlojamentoFilter : lstTipoAlojamentoFilters) {
                i++;
                System.out.println(i + ". " + tipoAlojamentoFilter.getName() );
            }

            System.out.println("Tipo Alojamento Filter: ");
            String sTipoAlojamentoFilter = sc.nextLine();

            nIndex = Integer.parseInt(sTipoAlojamentoFilter );

            if( nIndex <= lstTipoAlojamentoFilters.size() )
                return lstTipoAlojamentoFilters.get( nIndex - 1 );
        }
        while ( nIndex !=0 );

        return null;
    }
}