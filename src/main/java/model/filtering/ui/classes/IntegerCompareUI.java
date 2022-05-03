package model.filtering.ui.classes;

import model.filtering.config.CompareType;
import model.filtering.config.NumberCompare;
import model.filtering.ui.UIError;
import model.filtering.ui.UIMapper;
import model.filtering.ui.UIResult;

import java.util.Scanner;

public class IntegerCompareUI implements UIMapper<NumberCompare<Integer>>
{
    @Override
    public UIResult<NumberCompare<Integer>> run()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva um sinal de comparacao seguido de um numero inteiro:");
        System.out.println("Sinais disponiveis: < = > <= >=");

        String input = scanner.nextLine();

        input = input.replace(" ","");

        if (isNumber(input))
        {
            int num = Integer.parseInt(input);
            return new UIResult<>(new NumberCompare<>(num, CompareType.EQUAL));
        }
        else
        {
            int maxSplit = input.contains("<=") || input.contains(">=") ? 2 : 1;
            CompareType type = CompareType.getCompare(input.substring(0,maxSplit));

            if (type == null)
            {
                return new UIResult<>(new UIError("Sinal invalido introduzido"));
            }

            int num = Integer.parseInt(input.substring(maxSplit));
            return new UIResult<>(new NumberCompare<>(num,type));
        }
    }

    private boolean isNumber(String t)
    {
        try
        {
            Integer.parseInt(t);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
