package model.exception;

public class NomeInvalidoException extends RuntimeException
{
    public NomeInvalidoException()
    {
        super();
    }

    public NomeInvalidoException(String msg)
    {
        super(msg);
    }
}
