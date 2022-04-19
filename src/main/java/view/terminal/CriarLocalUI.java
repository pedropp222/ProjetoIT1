package view.terminal;

import controller.CriarLocalController;
import model.exception.NomeInvalidoException;

import java.util.Scanner;

public class CriarLocalUI implements Runnable
{
    private final CriarLocalController contr;

    public CriarLocalUI()
    {
        contr = new CriarLocalController();
    }

    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cidade: ");

        String c = sc.nextLine();

        System.out.print("Pais: ");

        String p = sc.nextLine();

        System.out.print("Descricao: ");

        String d = sc.nextLine();

        boolean sucesso;

        try
        {
            sucesso = contr.criarLocal(c,p,d);
        }
        catch (NomeInvalidoException e)
        {
            System.out.println("Nao foi possivel criar local: "+e.getMessage());
            return;
        }

        if (sucesso)
        {
            System.out.print("Local criado com sucesso. Guardar? (Y/N)");
            String ch = sc.nextLine();

            if (ch.equalsIgnoreCase("Y"))
            {
                if (contr.gravarLocal())
                {
                    System.out.println("Operacao concluida com sucesso.");
                }
                else
                {
                    System.out.println("Nao foi possivel guardar local, pois ja existe.");
                }
            }
            else
            {
                System.out.println("Operacao cancelada.");
            }
        }
        else
        {
            System.out.println("Nao foi possivel criar local, pois ja existe.");
        }
    }
}
