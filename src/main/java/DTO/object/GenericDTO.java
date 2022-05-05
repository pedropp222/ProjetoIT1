package DTO.object;


import DTO.DTOAttribute;

import java.util.Iterator;
import java.util.List;

public abstract class GenericDTO<T>
{
    public abstract Iterator<DTOAttribute<?>> getAttributeList();
}
