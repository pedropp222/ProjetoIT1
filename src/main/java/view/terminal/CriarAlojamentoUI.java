package view.terminal;

import DTO.DTOAttribute;
import DTO.GenericDTOMapper;
import DTO.object.AlojamentoDTO;
import DTO.object.GenericDTO;
import controller.CriarAlojamentoController;
import model.Alojamento;
import model.exception.NomeInvalidoException;
import view.terminal.dto.UIDTOForm;

import java.util.Iterator;
import java.util.Scanner;

public class CriarAlojamentoUI implements Runnable
{
    private final CriarAlojamentoController contr;

    public CriarAlojamentoUI()
    {
        contr = new CriarAlojamentoController();
    }

    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);

        boolean sucesso;

        try
        {
            sucesso = preencherValores(sc);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ocorreu um problema: "+e.getMessage());
            return;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("O numero que introduziu nao e valido.");
            return;
        }

        if (!sucesso)
        {
            return;
        }

        System.out.print("Alojamento criado. Guardar? (Y/N): ");
        sc.nextLine();
        String esc = sc.nextLine();

        if (esc.equalsIgnoreCase("Y"))
        {
            if (contr.guardarAlojamento())
            {
                System.out.println("Operacao concluida com sucesso.");
            }
            else
            {
                System.out.println("Nao foi possivel guardar o alojamento.");
            }
        }
        else
        {
            System.out.println("Operacao cancelada.");
        }

    }

    private boolean preencherValores(Scanner sc) throws NumberFormatException, ArrayIndexOutOfBoundsException
    {
        GenericDTO<?> workingDTO = GenericDTOMapper.convertObjectToDTO(Alojamento.class);

        if (workingDTO instanceof AlojamentoDTO)
        {
            Iterator<DTOAttribute<?>> it = workingDTO.getAttributeList();

            if (!UIDTOForm.populateDTOValues(sc, it,contr.getTiposAlojamento(),contr.getLocais()))
            {
                return false;
            }

            try
            {
                if (!contr.criarAlojamento((AlojamentoDTO) workingDTO))
                {
                    System.out.println("Nao foi possivel validar alojamento.");
                    return false;
                }
            }
            catch (NomeInvalidoException | IllegalArgumentException e)
            {
                System.out.println("Erro ao criar alojamento: "+e.getMessage());
                return false;
            }

            return true;
        }
        return false;
    }
}