package Database;

import main.JDBC;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * A class container functions for making SQL Database Queries
 * @author xavierloeraflores
 */
public class DAO {


    /**
     * Function to make SQL database queries
     * @param sql the string value sql string query
     * @return [result] ResultSet value representing the result of the query
     */
    public static ResultSet query(String sql){
        ResultSet result =null;
        try{
            Statement SQLStatement= JDBC.getConnection().createStatement();
                result= SQLStatement.executeQuery(sql);
            return result;
        } catch(Exception error){
            System.out.println("Error: "+ error);
        }
        return result;
    }

    /**
     * Function to make SQL database updates
     * @param sql the string value sql string query
     */
    public static void update(String sql){
        try{
            Statement SQLStatement= JDBC.getConnection().createStatement();
                SQLStatement.executeUpdate(sql);
        } catch(Exception error){
            System.out.println("Error: "+ error);
        }
    }



}