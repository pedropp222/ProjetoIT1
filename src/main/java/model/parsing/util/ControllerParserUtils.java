package model.parsing.util;

import controller.interfaces.ControllerLister;
import model.parsing.ControllerParser;

import java.util.List;

public class ControllerParserUtils
{
    public static <T> ControllerLister<T> requestListControllerOfType(Class<T> type)
    {
        List<ControllerLister<?>> list = ControllerParser.getListControllerListers();

        for(ControllerLister<?> controller : list)
        {
            if (controller.getType() == null)
            {
                System.out.println("Controller "+controller+" HAS NULL GET TYPE");
            }
            else
            {
                if (controller.getType().getClass().equals(type))
                {
                    return (ControllerLister<T>) controller;
                }
            }
        }

        return null;
    }
}
