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
        TipoAtividade ti1 = new TipoAtividade("tipoAtividade 1");
        TipoAtividade ti2 = new TipoAtividade("atividade fixe");
        TipoAtividade ti3 = new TipoAtividade("canoagem");
        TipoAtividade ti4 = new TipoAtividade("tiro ao alvo");
        TipoAtividade ti5 = new TipoAtividade("escalada");
        TipoAtividade ti6 = new TipoAtividade("escavação");

        Local l = new Local("porto","portugal","local 1");
        Local l2 = new Local("braga","portugal","local 2");
        Local l3 = new Local("madrid","espanha","local 3");
        TipoAlojamento t1 = new TipoAlojamento("tipoAlojamento 1");
        TipoAlojamento t2 = new TipoAlojamento("hotel 1");
        TipoAlojamento t3 = new TipoAlojamento("sitio 1");

        Companhia.getInstance().gravarTipoAtividade(ti1);
        Companhia.getInstance().gravarTipoAtividade(ti2);
        Companhia.getInstance().gravarTipoAtividade(ti3);
        Companhia.getInstance().gravarTipoAtividade(ti4);
        Companhia.getInstance().gravarTipoAtividade(ti5);
        Companhia.getInstance().gravarTipoAtividade(ti6);

        Companhia.getInstance().gravarLocal(l);
        Companhia.getInstance().gravarLocal(l2);
        Companhia.getInstance().gravarLocal(l3);
        Companhia.getInstance().gravarTipoAlojamento(t1);
        Companhia.getInstance().gravarTipoAlojamento(t2);
        Companhia.getInstance().gravarTipoAlojamento(t3);

        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 0",t1,l,1,1,DiaSemana.SEXTA,5f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 1",t1,l,5,10,DiaSemana.SABADO,10f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 2",t1,l,1,2,DiaSemana.DOMINGO,15f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 3",t2,l,1,4,DiaSemana.TERCA,20f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 4",t3,l,2,7,DiaSemana.SEXTA,30f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 5",t3,l,4,10,DiaSemana.SEGUNDA,40f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 6",t3,l,3,12,DiaSemana.QUINTA,50f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 7",t3,l,5,20,DiaSemana.QUARTA,60f));
        Companhia.getInstance().gravarAlojamento(new Alojamento("alojamento 8",t3,l,2,8,DiaSemana.SABADO,70f));


        Companhia.getInstance().gravarAtividade(new Atividade("at1",ti1,l,l,5,10,DiaSemana.SEXTA,5f));
        Companhia.getInstance().gravarAtividade(new Atividade("at2",ti3,l,l,10,12,DiaSemana.SABADO,15f));
        Companhia.getInstance().gravarAtividade(new Atividade("at3",ti4,l,l,6,9,DiaSemana.DOMINGO,20f));
        Companhia.getInstance().gravarAtividade(new Atividade("at4",ti3,l,l,12,18,DiaSemana.SABADO,8f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti1,l,l,15,17,DiaSemana.SEGUNDA,4f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti6,l,l,20,23,DiaSemana.TERCA,9f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti2,l,l,7,12,DiaSemana.QUARTA,25f));
        Companhia.getInstance().gravarAtividade(new Atividade("at5",ti5,l,l,6,11,DiaSemana.QUINTA,10f));
    }
}