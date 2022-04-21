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
        setDataNascimento(dataNascimento);
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) throws NomeInvalidoException
    {
        if (nome == null || nome.isBlank()) throw new NomeInvalidoException("Nome invalido.");
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) throws NomeInvalidoException
    {
        if (email == null || email.isBlank()) throw new NomeInvalidoException("Email invalido.");
        this.email = email;
    }

    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) throws IllegalArgumentException
    {
        if (dataNascimento == null) throw new IllegalArgumentException("Data nascimento nao pode ser null.");
        this.dataNascimento = dataNascimento;
    }
}
