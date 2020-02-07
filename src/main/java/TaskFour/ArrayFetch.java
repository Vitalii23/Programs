package TaskFour;

import java.sql.*;
import java.util.Scanner;

public class ArrayFetch {

    private DbConnection dbConnection = new DbConnection();

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public void insert(int[] number){
        String query = "INSERT INTO sample.test (number) VALUES (?)";
        try {
            connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < number.length; i++){
                preparedStatement.setInt(1, number[i]);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { preparedStatement.close(); } catch (SQLException se) { se.getMessage(); }
        }
    }

    public void selectNumber(){
        String query = "SELECT * FROM sample.test";
        try {
            connection = dbConnection.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String numbers = resultSet.getString(2);
                System.out.print("Number: ");
                System.out.print(numbers);
                System.out.println("\n");
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { statement.close(); } catch (SQLException se) { se.getMessage(); }
            try { resultSet.close(); } catch (SQLException se) { se.getMessage(); }
        }
    }

    public void selectMissedNumber(){
        String query = "SELECT\n" +
                "  CASE\n" +
                "  WHEN number2 IS NULL\n" +
                "    THEN CONCAT( number1, '...' )\n" +
                "  WHEN number1 = number2\n" +
                "    THEN number1\n" +
                "  ELSE CONCAT( number1, ',', number2 )\n" +
                "  END number\n" +
                "FROM (\n" +
                "       SELECT number + 1 number1, (\n" +
                "                           SELECT MIN( number ) - 1\n" +
                "                           FROM sample.test t2\n" +
                "                           WHERE t2.number > t1.number\n" +
                "                         )number2\n" +
                "       FROM sample.test t1\n" +
                "       UNION\n" +
                "       SELECT 1 , MIN( number ) -1\n" +
                "       FROM sample.test t3\n" +
                "     )t\n" +
                "WHERE number1 <= number2\n" +
                "      OR number2 IS NULL\n" +
                "ORDER BY number1";
        try {
            connection = dbConnection.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String numbers = resultSet.getString(1);
                System.out.println("Missed numbers: " + numbers);
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { statement.close(); } catch (SQLException se) { se.getMessage(); }
            try { resultSet.close(); } catch (SQLException se) { se.getMessage(); }
        }
    }

    public void delete(){
        String query = "DELETE FROM sample.test WHERE id";
        try {
            connection = dbConnection.getConnect();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { statement.close(); } catch (SQLException se) { se.getMessage(); }
        }
    }

}
