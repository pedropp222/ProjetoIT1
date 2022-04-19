package model;

import model.exception.NomeInvalidoException;

import java.time.LocalDate;

public class Cliente
{
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    private Cliente()
    {
        nome = "";
        email = "";
        dataNascimento = LocalDate.now();
    }

    public Cliente(String nome, String email, LocalDate dataNascimento) throws NomeInvalidoException
    {
        setNome(nome);
        setEmail(email);
        this.dataNascimento = dataNascimento;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) throws NomeInvalidoException
    {
        if (nome.isEmpty()) throw new NomeInvalidoException("Nome invalido.");
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) throws NomeInvalidoException
    {
        if (email.isEmpty()) throw new NomeInvalidoException("Email invalido.");
        this.email = email;
    }

    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }
}
