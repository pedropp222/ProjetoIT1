package controller;

import controller.interfaces.ControllerLister;
import model.*;
import model.filtering.Extractor;
import model.filtering.Filter;
import model.filtering.config.FilterEntry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListarPacoteController extends ControllerLister<PacoteTurismo>
{
    public ListarPacoteController()
    {
        super(Companhia.getInstance());
    }

    public <F,F2> List<PacoteTurismo> filtrar(Extractor<PacoteTurismo,F> extractor, Filter<F,F2> filtro, F2 valor,boolean negate)
    {
        return companhia.evaluateFilter(refObj,extractor,filtro,valor,negate);
    }

    public List<FilterEntry<PacoteTurismo,?,?>> getFiltros()
    {
        return companhia.getFiltersFor(refObj);
    }

    @Override
    public PacoteTurismo getRefObj()
    {
        if (refObj == null)
        {
            List<Reserva> r = new ArrayList<>();
            r.add( new Reserva(LocalDate.now(),new Atividade("aa",new TipoAtividade("aa"),new Local("aa","aa","aa"),new Local("aa","aa","aa"), 10,20,DiaSemana.DOMINGO,10f)));
            refObj = new PacoteTurismo(r);
        }

        return refObj;
    }
}