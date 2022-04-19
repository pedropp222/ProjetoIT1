package model;

public enum DiaSemana
{
    SEGUNDA("Segunda-Feira"),
    TERCA("Terca-Feira"),
    QUARTA("Quarta-Feira"),
    QUINTA("Quinta-Feira"),
    SEXTA("Sexta-Feira"),
    SABADO("Sabado"),
    DOMINGO("Domingo");

    private final String repr;

    DiaSemana(String r)
    {
        this.repr = r;
    }

    public String getRepr()
    {
        return repr;
    }
}