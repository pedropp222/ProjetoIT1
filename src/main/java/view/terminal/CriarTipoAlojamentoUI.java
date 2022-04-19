package view.terminal;

import controller.CriarTipoAlojamentoController;
import model.exception.NomeInvalidoException;

import java.util.Scanner;

public class CriarTipoAlojamentoUI implements Runnable
{
    private final CriarTipoAlojamentoController contr;

    public CriarTipoAlojamentoUI()
    {
        contr = new CriarTipoAlojamentoController();
    }


    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Designacao do tipo de alojamento: ");

        String t = sc.nextLine();

        boolean sucesso;

        try
        {
            sucesso = contr.criarTipoAlojamento(t);
        }
        catch (NomeInvalidoException e)
        {
            System.out.println("Tipo de alojamento '"+ t +"' nao pode ser criado: "+e.getMessage());
            return;
        }

        if (sucesso)
        {
            System.out.print("Tipo de alojamento '"+t+"' criado. Guardar? (Y/N)");

            String esc = sc.nextLine();
            if (esc.equalsIgnoreCase("Y"))
            {
                if (contr.gravarTipoAlojamento())
                {
                    System.out.println("Operacao concluida com sucesso.");
                }
                else
                {
                    System.out.println("Operacao foi cancelada pois o tipo de alojamento ja existe.");
                }
            }
            else
            {
                System.out.println("Operacao cancelada.");
            }
        }
        else
        {
            System.out.println("Tipo de alojamento '"+ t +"' nao pode ser criado, pois ja existe.");
        }
    }
}