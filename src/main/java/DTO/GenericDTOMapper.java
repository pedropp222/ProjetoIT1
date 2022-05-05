package DTO;

import DTO.object.GenericDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class GenericDTOMapper
{
    static Map<Class<?>, Supplier<GenericDTO<?>>> mappingActions = new HashMap<>();

    public static void addMapping(Class<?> key, Supplier<GenericDTO<?>> value)
    {
        mappingActions.put(key,value);
    }

    public static <T extends GenericDTO<T>, O> GenericDTO<T> convertObjectToDTO(Class<O> object)
    {
        Supplier<?> r = mappingActions.get(object);
        if (r != null)
        {
            return (GenericDTO<T>) r.get();
        }
        else
        {
            return null;
        }
    }
}
