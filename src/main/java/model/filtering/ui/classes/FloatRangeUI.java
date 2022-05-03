package model.filtering.ui.classes;

import model.filtering.config.Range;
import model.filtering.ui.UIError;
import model.filtering.ui.UIMapper;
import model.filtering.ui.UIResult;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FloatRangeUI implements UIMapper<Range<Float>>
{
    @Override
    public UIResult<Range<Float>> run()
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Escreva o numero real minimo do intervalo:");
            float min = sc.nextFloat();
            System.out.println("Escreva o numero real maximo do intervalo:");
            float max = sc.nextFloat();
            Range<Float> range = new Range<>(min, max);
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
