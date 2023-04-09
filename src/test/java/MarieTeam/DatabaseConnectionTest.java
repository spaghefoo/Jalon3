package MarieTeam;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void getConnection() {

        DatabaseConnection dbtest = new DatabaseConnection();

        assertTrue(dbtest.getConnection() instanceof Connection);
        try {
            assertTrue(dbtest.getConnection().isValid(10));
        }
        catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    void closeConnection() {

        DatabaseConnection dbtest = new DatabaseConnection();

        dbtest.closeConnection();

        try {
            assertFalse(dbtest.getConnection().isValid(20));
        }
        catch(Exception e)
        {
            assertTrue(true, String.valueOf(false));
        }
    }
}