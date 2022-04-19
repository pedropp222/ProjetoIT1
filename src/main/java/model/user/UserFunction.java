package model.user;

public class UserFunction
{
    private final String name;
    private final UserRole role;
    private final Runnable function;

    public UserFunction(UserRole role, String name, Runnable function)
    {
        this.role = role;
        this.function = function;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public UserRole getRole()
    {
        return role;
    }

    public Runnable getFunction()
    {
        return function;
    }
}
