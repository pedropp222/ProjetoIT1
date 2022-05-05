package view.terminal.dto;

import DTO.AttributeType;
import DTO.DTOAttribute;
import model.DiaSemana;
import view.terminal.util.TerminalUtils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UIDTOForm
{
    public static boolean populateDTOValues(Scanner sc, Iterator<DTOAttribute<?>> it, List<String>... valueLists)
    {
        int currentList = 0;
        while (it.hasNext())
        {
            DTOAttribute<?> attr = it.next();

            if (attr.getType() == AttributeType.STRING)
            {
                DTOAttribute<String> at = (DTOAttribute<String>)attr;
                System.out.println(attr.getDescription());
                String v = sc.nextLine();
                at.setValue(v);
            }
            else if (attr.getType() == AttributeType.INTEGER)
            {
                DTOAttribute<Integer> at = (DTOAttribute<Integer>)attr;
                System.out.println(attr.getDescription());
                int v = sc.nextInt();
                sc.nextLine();
                at.setValue(v);
            }
            else if (attr.getType() == AttributeType.FLOAT)
            {
                DTOAttribute<Float> at = (DTOAttribute<Float>)attr;
                System.out.println(attr.getDescription());
                float v = sc.nextFloat();
                sc.nextLine();
                at.setValue(v);
            }
            else if (attr.getType() == AttributeType.WEEKDAY)
            {
                DTOAttribute<DiaSemana> at = (DTOAttribute<DiaSemana>)attr;
                TerminalUtils.listarDiasSemana();
                System.out.println(attr.getDescription());
                int v = sc.nextInt();
                DiaSemana ds = DiaSemana.values()[v];
                sc.nextLine();
                at.setValue(ds);
            }
            else if (attr.getType() == AttributeType.DATE)
            {
                DTOAttribute<LocalDate> at = (DTOAttribute<LocalDate>)attr;
                LocalDate ld = TerminalUtils.populateData(sc);
                sc.nextLine();
                at.setValue(ld);
            }
            else if (attr.getType() == AttributeType.DTO)
            {
                if(!TerminalUtils.listarLista(valueLists[currentList]))
                {
                    System.out.println("Nao existem dados para escolher.");
                    return false;
                }
                System.out.println(attr.getDescription());
                currentList++;
                DTOAttribute<Integer> at = (DTOAttribute<Integer>)attr;
                int v = sc.nextInt();
                sc.nextLine();
                at.setValue(v);
            }
        }

        return true;
    }

}
