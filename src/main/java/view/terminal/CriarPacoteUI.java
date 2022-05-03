package view.terminal;

import controller.CriarPacoteController;
import model.Alojamento;
import model.Atividade;
import model.Reserva;
import view.terminal.util.TerminalUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriarPacoteUI implements Runnable
{
    private final CriarPacoteController contr;
    private final Scanner sc = new Scanner(System.in);

    public CriarPacoteUI()
    {
        contr = new CriarPacoteController();
    }

    @Override
    public void run()
    {
        menuLoop();
    }

    private void menuLoop()
    {
        int esc;
        do
        {
            System.out.println("[1] - Adicionar Alojamento");
            System.out.println("[2] - Adicionar Atividade");
            System.out.println("[3] - Remover Alojamento");
            System.out.println("[4] - Remover Atividade");
            System.out.println("[5] - Listar Servicos");
            System.out.println("[6] - Finalizar Pacote");
            System.out.println("[0] - Sair");

            esc = sc.nextInt();

            switch (esc)
            {
                case 1:
                    adicionarAlojamento();
                    break;
                case 2:
                    adicionarAtividade();
                    break;
                case 3:
                    removerAlojamento();
                    break;
                case 4:
                    removerAtividade();
                    break;
                case 5:
                    listarServicos();
                    break;
                case 6:
                    if (criarPacote())
                    {
                        esc = 0;
                    }
                    break;
                case 0:
                    break;
            }
        }
        while (esc != 0);
    }

    private void removerAtividade()
    {
        if (!TerminalUtils.listarLista(contr.getServicosAtividade()))
        {
            System.out.println("Nao existem atividades no pacote.");
            return;
        }

        System.out.print("Escolha a atividade a remover: ");

        Scanner sc = new Scanner(System.in);
        int esc = sc.nextInt();

        if (contr.removerAtividade(esc))
        {
            System.out.println("Atividade foi removida com sucesso!");
        } else
        {
            System.out.println("Nao conseguiu remover com sucesso.");
        }
    }

    private void removerAlojamento()
    {
        if (!TerminalUtils.listarLista(contr.getServicosAlojamento()))
        {
            System.out.println("Nao existem alojamentos no pacote.");
            return;
        }

        System.out.print("Escolha o alojamento a remover: ");

        Scanner sc = new Scanner(System.in);
        int esc = sc.nextInt();

        if (contr.removerAlojamento(esc))
        {
            System.out.println("Alojamento foi removida com sucesso!");
        } else
        {
            System.out.println("Nao conseguiu remover com sucesso.");
        }
    }

    private void listarServicos()
    {
        if (!TerminalUtils.listarLista(contr.getListaServicos()))
        {
            System.out.println("Nao existem servicos agendados.");
        } else
        {
            float total = 0f;
            for (Reserva c : contr.getListaServicos())
            {
                total += c.getEscolha().getPreco();
            }
            System.out.printf("Total a pagar: %.2f\n", total);
        }
    }

    private void adicionarAlojamento()
    {
        LocalDate dataAlojamento;

        try
        {
            dataAlojamento = TerminalUtils.populateData(sc);
        } catch (DateTimeException e)
        {
            System.out.println("Data que introduziu nao e valida.");
            return;
        }

        List<Alojamento> lst = getAlojamentosData(dataAlojamento);

        if (!TerminalUtils.listarLista(lst))
        {
            System.out.println("Nao existem alojamentos nesse dia da semana");
            return;
        }

        System.out.print("Selecione um alojamento da lista: ");

        int esc = sc.nextInt();

        if (esc < 0 || esc > lst.size() - 1)
        {
            System.out.println("Numero que introduziu nao e valido.");
            return;
        }

        if (contr.criarServico(lst.get(esc), dataAlojamento))
        {
            System.out.println("Alojamento agendado com sucesso!");
        } else
        {
            System.out.println("Alojamento nao foi agendado.");
        }
    }

    private void adicionarAtividade()
    {
        LocalDate data;

        try
        {
            data = TerminalUtils.populateData(sc);
        } catch (DateTimeException e)
        {
            System.out.println("Data que introduziu nao e valida.");
            return;
        }

        List<Atividade> lst = getAtividadesData(data);

        if (!TerminalUtils.listarLista(lst))
        {
            System.out.println("Nao existem atividades nesse dia da semana");
            return;
        }

        System.out.print("Selecione uma atividade da lista: ");
        int escAt = sc.nextInt();
        if (escAt < 0 || escAt > lst.size() - 1)
        {
            System.out.println("Numero que introduziu nao e valido.");
            return;
        }

        if (contr.criarServico(lst.get(escAt), data))
        {
            System.out.println("Atividade agendada com sucesso!");
        } else
        {
            System.out.println("Atividade nao foi agendada.");
        }
    }

    private boolean criarPacote()
    {
        if (contr.criarPacoteTurismo())
        {
            System.out.println("Pacote de turismo criado com sucesso!");
            return true;
        } else
        {
            System.out.println("Pacote de turismo nao foi criado com sucesso.");
            return false;
        }
    }

    private List<Atividade> getAtividadesData(LocalDate ld)
    {
        List<Atividade> lst = new ArrayList<>();

        for (Atividade at : contr.getAtividades())
        {
            if (ld.getDayOfWeek().getValue() == at.getDiaSemana().ordinal() + 1)
            {
                lst.add(at);
            }
        }

        return lst;
    }

    private List<Alojamento> getAlojamentosData(LocalDate ld)
    {
        List<Alojamento> lst = new ArrayList<>();

        for (Alojamento at : contr.getAlojamentos())
        {
            if (ld.getDayOfWeek().getValue() == at.getDiaSemana().ordinal() + 1)
            {
                lst.add(at);
            }
        }

        return lst;
    }
}