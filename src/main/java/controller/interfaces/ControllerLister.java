package controller.interfaces;
import model.Companhia;

import java.util.ArrayList;
import java.util.List;

public abstract class ControllerLister<T> implements Filterable<T>
{
    protected Companhia companhia;
    protected T refObj;

    public ControllerLister(Companhia companhia)
    {
        this.companhia = companhia;
        this.refObj = getRefObj();
    }

    public abstract T getRefObj();

    public List<String> getList()
    {
        List<String> lst = new ArrayList<>();

        for(T entry : companhia.listFromType(refObj))
        {
            lst.add(entry.toString());
        }

        return lst;
    }

    public T getType()
    {
        return refObj;
    }
}