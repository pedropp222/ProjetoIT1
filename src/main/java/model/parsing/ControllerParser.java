package model.parsing;

import controller.interfaces.ControllerLister;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerParser
{
    private static List<ControllerLister<?>> listControllerListers;

    public static void parseControllers()
    {
        if (listControllerListers == null)
        {
            listControllerListers = new ArrayList<>();
        }

        try(Scanner sc = new Scanner(new File("config.properties")))
        {
            while (sc.hasNextLine())
            {
                String[] tokens = sc.nextLine().split("\s*=\s*");

                //parsing list controllers
                if (tokens.length == 2 && tokens[0].equals("uiListController"))
                {
                    String className = tokens[1];
                    try
                    {
                        ControllerLister<?> controllerLister = (ControllerLister<?>) Class.forName(className).getConstructor().newInstance();
                        listControllerListers.add(controllerLister);
                    } catch (ClassCastException e)
                    {
                        System.out.println("Classe " + className + " nao extende ControllerLister");
                    } catch (ClassNotFoundException e)
                    {
                        System.out.println("Nao encontrou a classe " + className);
                    } catch (InstantiationException e)
                    {
                        System.out.println("Class nao e instanciavel: " + className);
                    } catch (IllegalAccessException e)
                    {
                        System.out.println("Class nao esta accessivel: " + className);
                    } catch (InvocationTargetException e)
                    {
                        System.out.println("Class nao invocavel: " + className);
                    } catch (NoSuchMethodException e)
                    {
                        System.out.println("Class nao tem construtor sem parametros: " + className);
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error opening/reading file: "+e.getMessage());
        }
    }

    public static List<ControllerLister<?>> getListControllerListers()
    {
        return listControllerListers;
    }
}
