package model.run;

import model.Companhia;
import model.factories.MegaFactory;
import model.user.UserFunction;
import model.user.UserRole;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import view.terminal.*;
import view.terminal.util.TerminalUtils;

import java.io.File;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String[] tipoAlojamentoFilters = {};
        String[] alojamentoFilters = {};
        String[] alojamentoRangeFilters = {};

        Configurations configs = new Configurations();
        try
        {
            Configuration config = configs.properties(new File("config.properties"));

            // access configuration properties
            tipoAlojamentoFilters = config.getStringArray("filters.tipoalojamento");
            alojamentoFilters = config.getStringArray("filters.alojamento");
            alojamentoRangeFilters = config.getStringArray("filters.alojamento");
        }
        catch (ConfigurationException cex)
        {
            System.out.println("Erro a carregar ficheiro de configuracao: "+cex.getMessage());
            return;
        }

        Companhia c = new Companhia(new MegaFactory(), Arrays.asList(tipoAlojamentoFilters),Arrays.asList(alojamentoFilters),Arrays.asList(alojamentoRangeFilters));

        //TODO: remover isto
        TerminalUtils.criarDadosTeste();


        boolean run = true;

        Scanner sc = new Scanner(System.in);

        List<UserFunction> functionList = new ArrayList<>();
        functionList.add(new UserFunction(UserRole.ADMIN, "Criar Tipo Alojamento", () ->
        {
            CriarTipoAlojamentoUI ct = new CriarTipoAlojamentoUI();
            ct.run();
        }));
        functionList.add(new UserFunction(UserRole.ADMIN, "Criar Tipo Atividade", () ->
        {
            CriarTipoAtividadeUI cl = new CriarTipoAtividadeUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.ADMIN, "Listar Tipo Alojamento", () ->
        {
            ListarTipoAlojamentosUI cl = new ListarTipoAlojamentosUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.ADMIN, "Listar Tipo Atividades", () ->
        {
            ListarTipoAtividadeUI cl = new ListarTipoAtividadeUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.ADMIN, "Criar Local", () ->
        {
            CriarLocalUI cl = new CriarLocalUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.ADMIN, "Listar Locais", () ->
        {
            ListarLocaisUI cl = new ListarLocaisUI();
            cl.run();
        }));

        functionList.add(new UserFunction(UserRole.FORNECEDOR, "Criar Novo Alojamento", () ->
        {
            CriarAlojamentoUI cl = new CriarAlojamentoUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.FORNECEDOR, "Listar Alojamentos", () ->
        {
            ListarAlojamentosUI ui = new ListarAlojamentosUI();
            ui.run();
        }));
        functionList.add(new UserFunction(UserRole.FORNECEDOR, "Criar Nova Atividade", () ->
        {
            CriarAtividadeUI cl = new CriarAtividadeUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.FORNECEDOR, "Listar Atividades", () ->
        {
            TerminalUtils.listarLista(c.getListaAtividades());
        }));

        functionList.add(new UserFunction(UserRole.CLIENTE, "Criar Pacote de Turismo", () ->
        {
            CriarPacoteUI cl = new CriarPacoteUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.CLIENTE, "Listar Pacotes de Turismo", () ->
        {
            TerminalUtils.listarLista(c.getPacoteTurismos());
        }));


        UserRole currentUser = UserRole.CLIENTE;
        HashMap<Integer, UserFunction> options = createOpcoes(currentUser, functionList);


        boolean user = true;

        while (user)
        {
            System.out.println("Selecionar User: ");
            for(UserRole r : UserRole.values())
            {
                System.out.println("["+(r.ordinal()+1)+"] - "+r);
            }

            int n = sc.nextInt();

            if (n <= 0 || n > UserRole.values().length)
            {
                user=false;
                run = false;
            }
            else
            {
                currentUser = UserRole.values()[n-1];
                options = createOpcoes(currentUser, functionList);
                run = true;
            }

            while (run)
            {
                System.out.println("Utilizador: " + currentUser);
                System.out.println("Escolher opcao: ");
                System.out.println("[0] - Sair");
                for (Map.Entry<Integer, UserFunction> op : options.entrySet())
                {
                    System.out.println("[" + op.getKey() + "] - " + op.getValue().getName());
                }

                int esc = sc.nextInt();

                if (esc == 0)
                {
                    run = false;
                } else
                {
                    if (!options.containsKey(esc))
                    {
                        System.out.println("Opcao invalida!");
                    } else
                    {
                        options.get(esc).getFunction().run();
                    }
                }
            }
        }
    }

    public static HashMap<Integer, UserFunction> createOpcoes(UserRole role, List<UserFunction> functions)
    {
        int index = 1;

        HashMap<Integer, UserFunction> options = new HashMap<>();

        for (UserFunction f : functions)
        {
            if (f.getRole().equals(role))
            {
                options.put(index, f);
                index++;
            }
        }

        return options;
    }
}