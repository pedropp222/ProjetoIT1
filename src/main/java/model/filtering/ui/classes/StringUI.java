package model.filtering.ui.classes;

import model.filtering.ui.UIMapper;
import model.filtering.ui.UIResult;

import java.util.Scanner;

public class StringUI implements UIMapper<String>
{
    @Override
    public UIResult<String> run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva um valor de texto:");
        System.out.println("Escreva # no inicio para ignorar capitalizacao");
        String value = scanner.nextLine();
        return new UIResult<>(value);
    }
}