package DTO.object;

import DTO.DTOAttribute;
import model.Local;

import java.util.Iterator;
import java.util.List;

public class LocalDTO extends GenericDTO<Class<Local>>
{
    private final List<DTOAttribute<?>> attributeList;

    public LocalDTO(List<DTOAttribute<?>> attributeList)
    {
        this.attributeList = attributeList;
    }

    @Override
    public Iterator<DTOAttribute<?>> getAttributeList()
    {
        return attributeList.iterator();
    }
}