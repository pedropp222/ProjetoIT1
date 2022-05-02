package model.filtering.ui.classes;

import model.filtering.config.Range;
import model.filtering.ui.UIError;
import model.filtering.ui.UIMapper;
import model.filtering.ui.UIResult;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerRangeUI implements UIMapper<Range<Integer>>
{
    @Override
    public UIResult<Range<Integer>> run()
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.println("Escreva o numero minimo do intervalo:");
            int min = scanner.nextInt();
            System.out.println("Escreva o numero maximo do intervalo:");
            int max = scanner.nextInt();
            Range<Integer> range = new Range<>(min, max);
            return new UIResult<>(range);
        }
        catch (InputMismatchException e)
        {
            return new UIResult<>(new UIError("O valor introduzido nao e um numero"));
        }
        catch (IllegalArgumentException e)
        {
            return new UIResult<>(new UIError(e.getMessage()));
        }
    }
}
