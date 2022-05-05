package view.terminal;

import DTO.AttributeType;
import DTO.DTOAttribute;
import DTO.GenericDTOMapper;
import DTO.object.GenericDTO;
import DTO.object.LocalDTO;
import controller.CriarLocalController;
import model.Local;
import model.exception.NomeInvalidoException;
import view.terminal.dto.UIDTOForm;

import java.util.Iterator;
import java.util.Scanner;

public class CriarLocalUI implements Runnable
{
    private final CriarLocalController contr;

    public CriarLocalUI()
    {
        contr = new CriarLocalController();
    }

    @Override
    public void run()
    {
        GenericDTO<?> workingDTO = GenericDTOMapper.convertObjectToDTO(Local.class);

        if (workingDTO instanceof LocalDTO)
        {
            Scanner sc = new Scanner(System.in);
            Iterator<DTOAttribute<?>> it = workingDTO.getAttributeList();

            if (!UIDTOForm.populateDTOValues(sc,it))
            {
                return;
            }

            boolean sucesso;

            try
            {
                sucesso = contr.criarLocal((LocalDTO) workingDTO);
            }
            catch (NomeInvalidoException e)
            {
                System.out.println("Nao foi possivel criar local: "+e.getMessage());
                return;
            }

            if (sucesso)
            {
                System.out.print("Local criado com sucesso. Guardar? (Y/N)");
                String ch = sc.nextLine();

                if (ch.equalsIgnoreCase("Y"))
                {
                    if (contr.gravarLocal())
                    {
                        System.out.println("Operacao concluida com sucesso.");
                    }
                    else
                    {
                        System.out.println("Nao foi possivel guardar local, pois ja existe.");
                    }
                }
                else
                {
                    System.out.println("Operacao cancelada.");
                }
            }
            else
            {
                System.out.println("Nao foi possivel criar local, pois ja existe.");
            }
        }
        else
        {
            System.out.println("ERRO!! working DTO nao e do tipo LocalDTO, mas sim "+workingDTO.getClass());
        }
    }
}
