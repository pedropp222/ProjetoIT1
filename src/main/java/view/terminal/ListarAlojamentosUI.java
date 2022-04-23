package view.terminal;

import controller.ListarAlojamentosController;
import model.Alojamento;

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
}
