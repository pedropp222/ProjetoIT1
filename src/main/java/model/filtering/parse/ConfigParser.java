package model.filtering.parse;

import model.TipoAlojamento;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigParser
{
    public static boolean debug = false;

    public static List<FilterEntry<?, ?>> parseConfig()
    {
        List<FilterEntry<?, ?>> entries = new ArrayList<>();

        try
        {
            Scanner sc = new Scanner(new File("config.properties"));

            while (sc.hasNextLine())
            {
                String[] tokens = sc.nextLine().split("\s*=\s*");

                if (tokens.length != 4)
                {
                    System.out.println("Invalid line found");
                } else
                {
                    //token 0 = class name, token 1 = filter class, token 2 = extractor method, token 3 = filter text

                    if (isClass(tokens[0]))
                    {
                        if (debug) System.out.println("Loading class " + tokens[0]);

                        Class<?> clazz = Class.forName(tokens[0]);

                        if (debug) System.out.println("Class loaded");

                        Class<?> filter = Class.forName(tokens[1]);

                        if (debug) System.out.println("Filter class loaded");

                        //check if filter class extends Filter
                        if (Filter.class.isAssignableFrom(filter))
                        {
                            if (methodExists(clazz, tokens[2]))
                            {
                                Filter<?> f = (Filter<?>) filter.getDeclaredConstructor().newInstance();

                                if (debug) System.out.println("Filter created");

                                //create extractor lambda expression using clazz method
                                Extractor<?, ?> ext = (Extractor<?, ?>) (Object o) ->
                                {
                                    try
                                    {
                                        return clazz.getDeclaredMethod(tokens[2]).invoke(o);
                                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
                                    {
                                        System.out.println("Error invoking method: " + e.getMessage());
                                    }
                                    return o;
                                };

                                if (debug) System.out.println("Extractor created");

                                FilterEntry<?, ?> entry = new FilterEntry(clazz, f, ext, tokens[3]);

                                if (debug) System.out.println("Filter entry created");

                                entries.add(entry);
                            } else
                            {
                                System.out.println("Invalid method " + tokens[2] + " found in class " + tokens[0]);
                            }
                        } else
                        {
                            System.out.println("Class " + tokens[1] + " does not extend Filter");
                        }
                    } else
                    {
                        System.out.println("Invalid class " + tokens[0] + " found");
                    }
                }
            }
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        return entries;
    }

    private static boolean isClass(String s)
    {
        //try and find class s using reflection
        try
        {
            Class.forName(s);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    private static boolean methodExists(Class<?> clazz, String methodName)
    {
        //try and find methodName in clazz using reflection
        try
        {
            clazz.getDeclaredMethod(methodName);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

}