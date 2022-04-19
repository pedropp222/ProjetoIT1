package view.terminal;

import controller.CriarAlojamentoController;
import model.DiaSemana;
import model.exception.NomeInvalidoException;
import view.terminal.util.TerminalUtils;

import java.util.List;
import java.util.Scanner;

public class CriarAlojamentoUI implements Runnable
{
    private final CriarAlojamentoController contr;

    public CriarAlojamentoUI()
    {
        contr = new CriarAlojamentoController();
    }

    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);

        boolean sucesso;

        try
        {
            sucesso = preencherValores(sc);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ocorreu um problema: "+e.getMessage());
            return;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("O numero que introduziu nao e valido.");
            return;
        }

        if (!sucesso)
        {
            return;
        }

        System.out.print("Alojamento criado. Guardar? (Y/N): ");
        sc.nextLine();
        String esc = sc.nextLine();

        if (esc.equalsIgnoreCase("Y"))
        {
            if (contr.guardarAlojamento())
            {
                System.out.println("Operacao concluida com sucesso.");
            }
            else
            {
                System.out.println("Nao foi possivel guardar o alojamento.");
            }
        }
        else
        {
            System.out.println("Operacao cancelada.");
        }

    }

    private boolean preencherValores(Scanner sc) throws NumberFormatException, ArrayIndexOutOfBoundsException
    {
        System.out.print("Designacao: ");
        String desg = sc.nextLine();

       if(!TerminalUtils.listarLista(contr.getTiposAlojamento()))
       {
           System.out.println("Nao existem tipos de alojamentos registados.");
           return false;
       }

        System.out.print("Escolha o ID do tipo de alojamento a escolher: ");
        int esc = sc.nextInt();

        if (!contr.isTipoAlojamentoValido(esc))
        {
            System.out.println("O ID do tipo que introduziu nao e valido.");
            return false;
        }

        if (!TerminalUtils.listarLista(contr.getLocais()))
        {
            System.out.println("Nao existem locais registados");
            return false;
        }

        System.out.print("Escolha o ID do local a escolher: ");
        int loc = sc.nextInt();

        if (!contr.isLocalValido(loc))
        {
            System.out.println("O ID do local que introduziu nao e valido.");
        }

        System.out.print("Numero minimo de pessoas: ");

        int mn = sc.nextInt();

        System.out.print("Numero maximo de pessoas: ");

        int max = sc.nextInt();

        TerminalUtils.listarDiasSemana();

        System.out.print("Indique o numero do Dia da semana: ");

        int sem = sc.nextInt();

        DiaSemana ds = DiaSemana.values()[sem];

        System.out.print("Preco: ");

        float preco = sc.nextFloat();

        try
        {
            if (!contr.criarAlojamento(desg, esc, loc, mn, max, ds, preco))
            {
                System.out.println("Nao foi possivel validar alojamento.");
                return false;
            }
        }
        catch (NomeInvalidoException | IllegalArgumentException e)
        {
            System.out.println("Erro ao criar alojamento: "+e.getMessage());
            return false;
        }

        return true;
    }
}