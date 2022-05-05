package DTO;

public class DTOAttribute<T>
{
    private final String description;
    private final AttributeType type;
    private T value;

    public DTOAttribute(String description, AttributeType type, T value)
    {
        this.description = description;
        this.type = type;
        this.value = value;
    }

    public String getDescription()
    {
        return description;
    }

    public AttributeType getType()
    {
        return type;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }
}