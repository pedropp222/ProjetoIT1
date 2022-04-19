package view.terminal;

import controller.CriarTipoAtividadeController;
import model.exception.NomeInvalidoException;

import java.util.Scanner;

public class CriarTipoAtividadeUI implements Runnable
{
    private final CriarTipoAtividadeController contr;

    public CriarTipoAtividadeUI()
    {
        contr = new CriarTipoAtividadeController();
    }

    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Designacao do tipo de atividade: ");

        String t = sc.nextLine();

        boolean sucesso;

        try
        {
            sucesso = contr.criarTipoAtividade(t);
        }
        catch (NomeInvalidoException e)
        {
            System.out.println("Tipo de atividade '"+ t +"' nao pode ser criado: "+e.getMessage());
            return;
        }

        if (sucesso)
        {
            System.out.print("Tipo de atividade '"+t+"' criado. Guardar? (Y/N)");

            String esc = sc.nextLine();
            if (esc.equalsIgnoreCase("Y"))
            {
                if (contr.gravarTipoAtividade())
                {
                    System.out.println("Operacao concluida com sucesso.");
                }
                else
                {
                    System.out.println("Operacao foi cancelada pois o tipo de atividade ja existe.");
                }
            }
            else
            {
                System.out.println("Operacao cancelada.");
            }
        }
        else
        {
            System.out.println("Tipo de atividade '"+ t +"' nao pode ser criado, pois ja existe.");
        }
    }
}