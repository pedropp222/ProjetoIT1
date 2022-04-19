package view.terminal;

import controller.CriarAtividadeController;
import model.DiaSemana;
import view.terminal.util.TerminalUtils;

import java.util.List;
import java.util.Scanner;

public class CriarAtividadeUI implements Runnable
{
    private final CriarAtividadeController cnt;

    public CriarAtividadeUI()
    {
        cnt = new CriarAtividadeController();
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

        System.out.print("Atividade criada. Guardar? (Y/N): ");
        sc.nextLine();
        String esc = sc.nextLine();

        if (esc.equalsIgnoreCase("Y"))
        {
            if (cnt.gravarAtividade())
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

        if (!TerminalUtils.listarLista(cnt.getTiposAtividade()))
        {
            System.out.println("Lista de tipo atividades vazio.");
            return false;
        }

        System.out.print("Escolha o ID do tipo de atividade a escolher: ");
        int esc = sc.nextInt();

        if (!cnt.isTipoAtividadeValido(esc))
        {
            System.out.println("O ID do tipo que introduziu nao e valido.");
            return false;
        }

        if (!TerminalUtils.listarLista(cnt.getLocais()))
        {
            System.out.println("Lista de locais vazio.");
            return false;
        }

        System.out.print("Escolha o ID do local de partida: ");
        int loc1 = sc.nextInt();

        if(!cnt.isLocalValido(loc1))
        {
            System.out.println("O ID do local que introduziu nao e valido.");
            return false;
        }

        TerminalUtils.listarLista(cnt.getLocais());

        System.out.print("Escolha o ID do local de chegada: ");
        int loc2 = sc.nextInt();

        if(!cnt.isLocalValido(loc2))
        {
            System.out.println("O ID do local que introduziu nao e valido.");
            return false;
        }

        System.out.print("Hora de partida: ");

        int hora1 = sc.nextInt();

        System.out.print("Hora de chegada: ");

        int hora2 = sc.nextInt();

        TerminalUtils.listarDiasSemana();

        System.out.print("Escolha o numero do Dia da semana: ");

        int dia = sc.nextInt();

        DiaSemana ds = DiaSemana.values()[dia];

        System.out.print("Preco: ");

        float prec = sc.nextFloat();

        try
        {
            if (!cnt.criarAtividade(desg, esc, loc1,loc2,hora1,hora2,ds,prec))
            {
                System.out.println("Nao foi possivel validar atividade.");
                return false;
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Erro ao criar alojamento: "+e.getMessage());
            return false;
        }

        return true;
    }
}