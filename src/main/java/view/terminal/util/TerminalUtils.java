package view.terminal.util;

import model.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TerminalUtils
{
    public static <E> boolean listarLista(List<E> lista)
    {
        if (lista.size() == 0)
        {
            return false;
        }

        for (int i = 0; i < lista.size(); i++)
        {
            System.out.println("[" + i + "] - " + lista.get(i));
        }

        return true;
    }

    public static void listarDiasSemana()
    {
        for(DiaSemana s : DiaSemana.values())
        {
            System.out.println("["+s.ordinal()+"] - "+s.getRepr());
        }
    }

    public static LocalDate populateData(Scanner sc) throws DateTimeException
    {
        System.out.print("Escreva o ano: ");
        int ano = sc.nextInt();
        System.out.print("Escreva o mes: ");
        int mes = sc.nextInt();
        System.out.print("Escreva o dia: ");
        int dia = sc.nextInt();

        return LocalDate.of(ano,mes,dia);
    }

    public static void criarDadosTeste()
    {
        TipoAtividade t = new TipoAtividade("tipoAtividade 1");
        Local l = new Local("porto","portugal","local 1");
        TipoAlojamento t1 = new TipoAlojamento("tipoAlojamento 1");

        Companhia.getInstance().gravarTipoAtividade(t);
        Companhia.getInstance().gravarLocal(l);
        Companhia.getInstance().gravarTipoAlojamento(t1);

        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 1",t1,l,5,10,DiaSemana.SEXTA,10f));

        Companhia.getInstance().gravarAtividade(new Atividade("at1",t,l,l,5,10,DiaSemana.SEXTA,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at2",t,l,l,10,12,DiaSemana.SABADO,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at3",t,l,l,6,9,DiaSemana.DOMINGO,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at4",t,l,l,12,18,DiaSemana.SABADO,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",t,l,l,15,17,DiaSemana.SEGUNDA,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",t,l,l,20,23,DiaSemana.TERCA,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",t,l,l,7,12,DiaSemana.QUARTA,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",t,l,l,6,11,DiaSemana.QUINTA,5f));
    }
}