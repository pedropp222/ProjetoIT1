package model.filtering.parse;

import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;
import model.user.UserFunction;
import model.user.UserRole;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConfigParser
{
    public static boolean debug = false;

    public static List<FilterEntry<?, ?,?>> parseFilterConfig()
    {
        List<FilterEntry<?, ?,?>> entries = new ArrayList<>();

        try(Scanner sc = new Scanner(new File("config.properties")))
        {
            while (sc.hasNextLine())
            {
                String[] tokens = sc.nextLine().split("\s*=\s*");

                if (tokens.length == 4)
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
                                Filter<?,?> f = (Filter<?,?>) filter.getDeclaredConstructor().newInstance();

                                if (debug) System.out.println("Filter created");

                                //create extractor lambda expression using clazz method
                                Extractor<?, ?> ext = (Object o) ->
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

                                FilterEntry<?, ?,?> entry = new FilterEntry(clazz, f, ext, tokens[3]);

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

    public static <T extends Runnable> List<UserFunction> parseUIFunctions()
    {
        List<UserFunction> functions = new ArrayList<>();

        String[] tokens = new String[0];

        try (Scanner sc = new Scanner(new File("config.properties")))
        {
            while (sc.hasNextLine())
            {
                tokens = sc.nextLine().split("\s*=\s*");

                if (tokens.length == 3)
                {
                    //token 0 = user ID, token 1 = function description, token 2 = UI class

                    UserRole role = getRole(tokens[0]);
                    if (role == null)
                    {
                        if (debug) System.out.println("Invalid user ID " + tokens[0] + " found");
                        continue;
                    }
                    String desc = tokens[1];
                    if (isClass(tokens[2]))
                    {
                        T clazz = (T) Class.forName(tokens[2]).getConstructor().newInstance();
                        functions.add(new UserFunction(role, desc, clazz));
                    }
                    else
                    {
                        if (debug) System.out.println("Invalid class " + tokens[2] + " found");
                    }
                }
            }
        } catch (FileNotFoundException | ClassNotFoundException e)
        {
            System.out.println("Error reading file (ui functions): " + e.getMessage());
        } catch (InvocationTargetException e)
        {
            System.out.println("Invocation error (ui functions): "+e.getMessage()+"\n"+Arrays.toString(tokens)+" - "+e.getCause());
        } catch (InstantiationException e)
        {
            System.out.println("Class instantiation error (ui functions): "+e.getMessage());
        } catch (IllegalAccessException e)
        {
            System.out.println("Illegal acess error (ui functions): "+e.getMessage());
        } catch (NoSuchMethodException e)
        {
            System.out.println("Invalid method (ui functions): "+e.getMessage());
        }

        return functions;
    }

    private static UserRole getRole(String role)
    {
        try
        {
            return UserRole.values()[Integer.parseInt(role)];
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException e)
        {
            System.out.println("Invalid user ID found: " + role);
            return null;
        }
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