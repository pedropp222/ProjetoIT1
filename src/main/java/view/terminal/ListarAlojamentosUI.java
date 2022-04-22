package view.terminal;

import controller.ListarAlojamentosController;
import model.Alojamento;
import model.TipoAlojamento;
import model.filtering.filter.AlojamentoDenominacaoFilter;
import model.filtering.filter.AlojamentoPrecoFilter;
import model.filtering.filter.AlojamentoPrecoRangeFilter;
import model.filtering.filter.TipoAlojamentoDenominacaoFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            Scanner sc = new Scanner(System.in);


            int escolha = selecionarAlojamentoFilter();



            List<Alojamento> listaAlojamento = new ArrayList<>();

            if (escolha == 1)
            {
                AlojamentoDenominacaoFilter alojamentoFilter = readAlojamentoFilter();
                System.out.println("Valor a filtrar: ");
                String valor = sc.nextLine();
                listaAlojamento = contr.filtrarDenominacao(alojamentoFilter, valor);
            }
            else if (escolha == 2)
            {
                System.out.println("Filtrar por range? [0,1]");
                int esc = sc.nextInt();
                sc.nextLine();

                if (esc == 0)
                {
                    AlojamentoPrecoFilter alojamentoPreco = readPrecoFilter();
                    System.out.println("Valor a filtrar: ");
                    String valor = sc.nextLine();
                    listaAlojamento = contr.filtrarPreco(alojamentoPreco, Float.parseFloat(valor));
                }
                else
                {
                    AlojamentoPrecoRangeFilter alojamentoPreco = readPrecoRangeFilter();
                    System.out.println("Valor min a filtrar: ");
                    float valor = sc.nextFloat();
                    System.out.println("Valor max a filtrar: ");
                    float valor2 = sc.nextFloat();
                    listaAlojamento = contr.filtrarPrecoRange(alojamentoPreco, valor,valor2);

                }
            }



            System.out.println("\nLista de Alojamento filtrada:\n");
            for (Alojamento ta : listaAlojamento) {
                System.out.println(ta.toString() + "\n");
            }
        }
    }

    private int selecionarAlojamentoFilter()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione o filtro de alojamento:\n");
        System.out.println("1 - Denominacao\n");
        System.out.println("2 - Preco\n");
        System.out.println("0 - Voltar\n");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    private AlojamentoDenominacaoFilter readAlojamentoFilter()
    {
        List<AlojamentoDenominacaoFilter> lstAlojamentoFilters = contr.getAlojamentoDenominacaoFilters();

        Scanner sc = new Scanner(System.in);

        int nIndex = 0;
        do {
            int i = 0;
            for (AlojamentoDenominacaoFilter tipoAlojamentoFilter : lstAlojamentoFilters) {
                i++;
                System.out.println(i + ". " + tipoAlojamentoFilter.getName() );
            }

            System.out.println("Tipo Alojamento Filter: ");
            String sTipoAlojamentoFilter = sc.nextLine();

            nIndex = Integer.parseInt(sTipoAlojamentoFilter );

            if( nIndex <= lstAlojamentoFilters.size() )
                return lstAlojamentoFilters.get( nIndex - 1 );
        }
        while ( nIndex !=0 );

        return null;
    }

    private AlojamentoPrecoFilter readPrecoFilter()
    {
        List<AlojamentoPrecoFilter> lstAlojamentoFilters = contr.getAlojamentoPrecoFilters();

        Scanner sc = new Scanner(System.in);

        int nIndex = 0;
        do {
            int i = 0;
            for (AlojamentoPrecoFilter tipoAlojamentoFilter : lstAlojamentoFilters) {
                i++;
                System.out.println(i + ". " + tipoAlojamentoFilter.getName() );
            }

            System.out.println("Tipo Alojamento Filter: ");
            String sTipoAlojamentoFilter = sc.nextLine();

            nIndex = Integer.parseInt(sTipoAlojamentoFilter );

            if( nIndex <= lstAlojamentoFilters.size() )
                return lstAlojamentoFilters.get( nIndex - 1 );
        }
        while ( nIndex !=0 );

        return null;
    }

    private AlojamentoPrecoRangeFilter readPrecoRangeFilter()
    {
        List<AlojamentoPrecoRangeFilter> lstAlojamentoFilters = contr.getAlojamentoPrecoRangeFilters();

        Scanner sc = new Scanner(System.in);

        int nIndex = 0;
        do {
            int i = 0;
            for (AlojamentoPrecoRangeFilter tipoAlojamentoFilter : lstAlojamentoFilters) {
                i++;
                System.out.println(i + ". " + tipoAlojamentoFilter.getName() );
            }

            System.out.println("Tipo Alojamento Filter: ");
            String sTipoAlojamentoFilter = sc.nextLine();

            nIndex = Integer.parseInt(sTipoAlojamentoFilter );

            if( nIndex <= lstAlojamentoFilters.size() )
                return lstAlojamentoFilters.get( nIndex - 1 );
        }
        while ( nIndex !=0 );

        return null;
    }
}
