package exception;

import java.sql.SQLException;

public class SqlQueryException extends RuntimeException{
    public SqlQueryException(SQLException message) {
        super(message);
    }
}
