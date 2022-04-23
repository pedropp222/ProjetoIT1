package view.terminal;

import controller.ListarTipoAlojamentosController;
import model.TipoAlojamento;

import java.util.ArrayList;
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

            System.out.println("Valor a filtrar: ");
            String v = sc.nextLine();

            List<TipoAlojamento> listaTipoAlojamento = new ArrayList<>();

            System.out.println("\nLista de Tipo de Alojamento filtrada:\n");
            for (TipoAlojamento ta : listaTipoAlojamento) {
                System.out.println(ta.toString() + "\n");
            }
        }
    }
}