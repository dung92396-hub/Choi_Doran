import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USER = "root";
    private static final String PASSWORD = "Hp672005";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Connect to database...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected!");

            statement = connection.createStatement();

            String query = "CREATE TABLE ANIMAL (" +
                    "ID VARCHAR(10)," +
                    "NAME VARCHAR(255)," +
                    "WEIGHT INT," +
                    "PRIMARY KEY (ID)" +
                    ");";
            statement.execute(query);
//            resultSet = statement.executeQuery(query);

//            while (resultSet.next()) {
//                String id = resultSet.getString("id");
//                String name = resultSet.getString("name");
//                int salary = resultSet.getInt("salary");
//
//                System.out.println(id + ", " + name + ", " + salary);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Resource closed");
        }
    }
}
