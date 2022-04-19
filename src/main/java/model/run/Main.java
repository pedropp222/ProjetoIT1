package model.run;

import model.Companhia;
import view.terminal.*;
import view.terminal.util.TerminalUtils;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Companhia c = new Companhia();

        TerminalUtils.criarDadosTeste();

        boolean run = true;

        Scanner sc = new Scanner(System.in);

        while (run)
        {
            System.out.println("Escolher opcao: ");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Criar Local");
            System.out.println("[2] - Criar Tipo Alojamento");
            System.out.println("[3] - Criar Alojamento");
            System.out.println("[4] - Criar Tipo Atividade");
            System.out.println("[5] - Listar Locais");
            System.out.println("[6] - Listar Tipos de Alojamento");
            System.out.println("[7] - Criar Atividade");
            System.out.println("[8] - Criar Pacote Turismo");
            System.out.println("[9] - Listar Alojamentos");
            System.out.println("[10] - Listar Atividades");
            System.out.println("[11] - Listar Pacotes Turismo");
            int esc = sc.nextInt();

            switch (esc)
            {
                case 0:
                    run = false;
                    break;
                case 1:
                    CriarLocalUI cl = new CriarLocalUI();
                    cl.run();
                    break;
                case 2:
                    CriarTipoAlojamentoUI ct = new CriarTipoAlojamentoUI();
                    ct.run();
                    break;
                case 3:
                    CriarAlojamentoUI cr = new CriarAlojamentoUI();
                    cr.run();
                    break;
                case 4:
                    CriarTipoAtividadeUI cta = new CriarTipoAtividadeUI();
                    cta.run();
                    break;
                case 5:
                    ListarLocaisUI ll = new ListarLocaisUI();
                    ll.run();
                    break;
                case 6:
                    ListarTipoAlojamentosUI lt = new ListarTipoAlojamentosUI();
                    lt.run();
                    break;
                case 7:
                    CriarAtividadeUI ca = new CriarAtividadeUI();
                    ca.run();
                    break;
                case 8:
                    CriarPacoteUI criarPacoteUI = new CriarPacoteUI();
                    criarPacoteUI.run();
                    break;
                case 9:
                    TerminalUtils.listarLista(Companhia.getInstance().getListaAlojamentos());
                    break;
                case 10:
                    TerminalUtils.listarLista(Companhia.getInstance().getListaAtividades());
                    break;
                case 11:
                    TerminalUtils.listarLista(Companhia.getInstance().getPacoteTurismos());
                    break;
            }
        }
    }
}