package DTO.object;

import DTO.DTOAttribute;
import model.Alojamento;
import model.Local;

import java.util.Iterator;
import java.util.List;

public class AlojamentoDTO extends GenericDTO<Class<Alojamento>>
{
    private final List<DTOAttribute<?>> attributeList;

    public AlojamentoDTO(List<DTOAttribute<?>> attributeList)
    {
        this.attributeList = attributeList;
    }

    @Override
    public Iterator<DTOAttribute<?>> getAttributeList()
    {
        return attributeList.iterator();
    }
}