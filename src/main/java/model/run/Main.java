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

        //TODO: remover isto
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
            System.out.println("[5] - Criar Atividade");
            System.out.println("[6] - Criar Pacote Turismo");
            System.out.println("[7] - Listar Locais");
            System.out.println("[8] - Listar Tipos de Alojamento");
            System.out.println("[9] - Listar Tipos de Atividade");
            System.out.println("[10] - Listar Alojamentos");
            System.out.println("[11] - Listar Atividades");
            System.out.println("[12] - Listar Pacotes Turismo");
            int esc = sc.nextInt();

            switch (esc)
            {
                case 0 -> run = false;
                case 1 -> {
                    CriarLocalUI cl = new CriarLocalUI();
                    cl.run();
                }
                case 2 -> {
                    CriarTipoAlojamentoUI ct = new CriarTipoAlojamentoUI();
                    ct.run();
                }
                case 3 -> {
                    CriarAlojamentoUI cr = new CriarAlojamentoUI();
                    cr.run();
                }
                case 4 -> {
                    CriarTipoAtividadeUI cta = new CriarTipoAtividadeUI();
                    cta.run();
                }
                case 5 -> {
                    CriarAtividadeUI ca = new CriarAtividadeUI();
                    ca.run();
                }
                case 6 -> {
                    CriarPacoteUI criarPacoteUI = new CriarPacoteUI();
                    criarPacoteUI.run();
                }
                case 7 -> {
                    ListarLocaisUI lc = new ListarLocaisUI();
                    lc.run();
                }
                case 8 -> {
                    ListarTipoAlojamentosUI la = new ListarTipoAlojamentosUI();
                    la.run();
                }
                case 9 -> {
                    ListarTipoAtividadeUI la = new ListarTipoAtividadeUI();
                    la.run();
                }
                case 10 -> TerminalUtils.listarLista(c.getListaAlojamentos());
                case 11 -> TerminalUtils.listarLista(c.getListaAtividades());
                case 12 -> TerminalUtils.listarLista(c.getPacoteTurismos());
            }
        }
    }
}