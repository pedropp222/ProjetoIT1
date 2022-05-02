package model.filtering.ui.classes;

import model.filtering.ui.UIError;
import model.filtering.ui.UIMapper;
import model.filtering.ui.UIResult;

import java.util.Scanner;

public class IntegerUI implements UIMapper<Integer>
{
    @Override
    public UIResult<Integer> run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva um número inteiro:");
        String input = scanner.nextLine();
        try
        {
            return new UIResult<>(Integer.parseInt(input));
        }
        catch (NumberFormatException e)
        {
            return new UIResult<>(new UIError("Número inválido"));
        }
    }
}