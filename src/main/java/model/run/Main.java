package model.run;

import model.Companhia;
import model.factories.MegaFactory;
import model.filtering.config.FilterEntry;
import model.filtering.config.Range;
import model.filtering.parse.ConfigParser;
import model.filtering.ui.UIOperations;
import model.filtering.ui.classes.FloatUI;
import model.filtering.ui.classes.IntegerRangeUI;
import model.filtering.ui.classes.IntegerUI;
import model.filtering.ui.classes.StringUI;
import model.user.UserFunction;
import model.user.UserRole;
import view.terminal.*;
import view.terminal.util.TerminalUtils;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Companhia c = new Companhia(new MegaFactory());

        //TODO: remover isto
        TerminalUtils.criarDadosTeste();

        //c.addFilter(new TipoAtividade("ref"),new StringFilterContains(), TipoAtividade::getDesignacao,"Filtrar denominacao contem");

        UIOperations.addMap(Integer.class,new IntegerUI());
        UIOperations.addMap(Float.class,new FloatUI());
        UIOperations.addMap(String.class,new StringUI());
        UIOperations.addMap(new Range<Integer>(0,1).getClass(),new IntegerRangeUI());


        List<FilterEntry<?,?,?>> filters = ConfigParser.parseConfig();

        for (FilterEntry<?,?,?> f : filters)
        {
            c.addFilter(f);
        }

        boolean run;

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
            ListarAtividadesUI ui = new ListarAtividadesUI();
            ui.run();
        }));

        functionList.add(new UserFunction(UserRole.CLIENTE, "Criar Pacote de Turismo", () ->
        {
            CriarPacoteUI cl = new CriarPacoteUI();
            cl.run();
        }));
        functionList.add(new UserFunction(UserRole.CLIENTE, "Listar Pacotes de Turismo", () ->
        {
            ListarPacoteTurismoUI cl = new ListarPacoteTurismoUI();
            cl.run();
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