package model.filtering.ui.classes;

import model.filtering.ui.UIError;
import model.filtering.ui.UIMapper;
import model.filtering.ui.UIResult;

import java.util.Scanner;

public class FloatUI implements UIMapper<Float>
{
    @Override
    public UIResult<Float> run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva um número real:");
        String input = scanner.nextLine();
        try
        {
            return new UIResult<>(Float.parseFloat(input));
        }
        catch (NumberFormatException e)
        {
            return new UIResult<>(new UIError("Número inválido"));
        }
    }
}
