package model.run;

import DTO.AttributeType;
import DTO.DTOAttribute;
import DTO.GenericDTOMapper;
import DTO.object.AlojamentoDTO;
import DTO.object.GenericDTO;
import DTO.object.LocalDTO;
import model.Alojamento;
import model.Companhia;
import model.DiaSemana;
import model.Local;
import model.factories.MegaFactory;
import model.filtering.config.FilterEntry;
import model.filtering.config.NumberCompare;
import model.filtering.config.Range;
import model.filtering.parse.ConfigParser;
import model.filtering.ui.UIOperations;
import model.filtering.ui.classes.*;
import model.parsing.ControllerParser;
import model.user.UserFunction;
import model.user.UserRole;
import view.terminal.util.TerminalUtils;

import java.util.*;
import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
        Companhia c = new Companhia(new MegaFactory());

        //TODO: remover isto
        TerminalUtils.criarDadosTeste();

        //DTO Mapping operations

        GenericDTOMapper.addMapping(Local.class, o ->
        {
            Local l = o instanceof Local ? (Local)o : null;

            List<DTOAttribute<?>> attributeList = new ArrayList<>();
            attributeList.add(new DTOAttribute<String>("Pais", AttributeType.STRING, l==null?null:l.getPais()));
            attributeList.add(new DTOAttribute<String>("Cidade", AttributeType.STRING, l==null?null:l.getCidade()));
            attributeList.add(new DTOAttribute<String>("Descricao", AttributeType.STRING, l==null?null:l.getDesignacao()));

            return new LocalDTO(attributeList);
        });

        GenericDTOMapper.addMapping(Alojamento.class, (o) ->
        {
            Alojamento l = o instanceof Alojamento ? (Alojamento) o : null;

            List<DTOAttribute<?>> attributeList = new ArrayList<>();
            attributeList.add(new DTOAttribute<String>("Designacao:", AttributeType.STRING, l==null?null:l.getDesignacao()));
            attributeList.add(new DTOAttribute<Integer>("Escolha o ID do tipo de alojamento a escolher:", AttributeType.DTO, 0));
            attributeList.add(new DTOAttribute<Integer>("Escolha o ID do local a escolher: ", AttributeType.DTO, 0));
            attributeList.add(new DTOAttribute<Integer>("Numero minimo de pessoas:", AttributeType.INTEGER, l==null?0:l.getMinPessoas()));
            attributeList.add(new DTOAttribute<Integer>("Numero maximo de pessoas:", AttributeType.INTEGER, l==null?0:l.getMaxPessoas()));
            attributeList.add(new DTOAttribute<DiaSemana>("Indique o numero do Dia da semana:", AttributeType.WEEKDAY, l==null?null:l.getDiaSemana()));
            attributeList.add(new DTOAttribute<Float>("Preco:", AttributeType.FLOAT, l==null?0f:l.getPreco()));

            return new AlojamentoDTO(attributeList);
        });

        //Controller operations

        ControllerParser.parseControllers();

        System.out.println("Controllers carregados: " + ControllerParser.getListControllerListers().size());

        //Filtering operations

        //c.addFilter(new TipoAtividade("ref"),new StringFilterContains(), TipoAtividade::getDesignacao,"Filtrar denominacao contem");

        UIOperations.addMap(Integer.class, new IntegerUI());
        UIOperations.addMap(Float.class, new FloatUI());
        UIOperations.addMap(String.class, new StringUI());
        UIOperations.addMap(new Range<Integer>(0, 1).getClass(), new IntegerRangeUI());
        UIOperations.addMap(new Range<Float>(0f, 1f).getClass(), new FloatRangeUI());
        UIOperations.addMap(new NumberCompare<Integer>(null, null).getClass(), new IntegerCompareUI());
        UIOperations.addMap(new NumberCompare<Float>(null, null).getClass(), new FloatCompareUI());

        List<FilterEntry<?, ?, ?>> filters = ConfigParser.parseFilterConfig();

        for (FilterEntry<?, ?, ?> f : filters)
        {
            c.addFilter(f);
        }

        System.out.println("Filtros carregados: " + filters.size());

        boolean run;

        Scanner sc = new Scanner(System.in);

        List<UserFunction> functionList = ConfigParser.parseUIFunctions();

        UserRole currentUser = UserRole.CLIENTE;
        HashMap<Integer, UserFunction> options = createOpcoes(currentUser, functionList);


        boolean user = true;

        while (user)
        {
            System.out.println("Selecionar User: ");
            for (UserRole r : UserRole.values())
            {
                System.out.println("[" + (r.ordinal() + 1) + "] - " + r);
            }

            int n = sc.nextInt();

            if (n <= 0 || n > UserRole.values().length)
            {
                user = false;
                run = false;
            } else
            {
                currentUser = UserRole.values()[n - 1];
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