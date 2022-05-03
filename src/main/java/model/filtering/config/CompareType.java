package model.filtering.config;

public enum CompareType
{
    EQUAL,
    LESS,
    MORE,
    LESSEQUAL,
    MOREEQUAL;

    public static CompareType getCompare(String character)
    {
        return switch (character)
                {
                    case "<" -> CompareType.LESS;
                    case ">" -> CompareType.MORE;
                    case "=" -> CompareType.EQUAL;
                    case "<=" -> CompareType.LESSEQUAL;
                    case ">=" -> CompareType.MOREEQUAL;
                    default -> null;
                };
    }
}