package model.filtering.ui;

public class UIResult<T>
{
    private final T result;
    private final UIError errorMessage;

    public UIResult(T result)
    {
        this.result = result;
        this.errorMessage = null;
    }

    public UIResult(UIError errorMessage)
    {
        this.result = null;
        this.errorMessage = errorMessage;
    }

    public T getResult()
    {
        return result;
    }

    public String getErrorMessage()
    {
        if (errorMessage != null)
        {
            return errorMessage.getError();
        }
        return "No error message";
    }

    public boolean isSuccessful()
    {
        return result != null;
    }
}
