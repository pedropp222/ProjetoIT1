package model.user;

public enum UserRole
{
    ADMIN
            {
                @Override
                public String toString()
                {
                    return "Administrador";
                }
            },
    FORNECEDOR
            {
                @Override
                public String toString()
                {
                    return "Fornecedor";
                }
            },
    CLIENTE
            {
                @Override
                public String toString()
                {
                    return "Cliente";
                }
            }
}