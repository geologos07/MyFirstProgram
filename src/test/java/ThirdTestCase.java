import java.sql.*;

public class ThirdTestCase {

    private static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/dexautomation";

    private static final String USER = "dexautomation";
    private static final String PASSWORD = "dexautomation";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;


        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Prepare statement...");
        String sql1 = "insert into Students (id, age, firstName, lastName, phone) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setInt(1, 2);
        preparedStatement.setInt(2, 28);
        preparedStatement.setString(3, "Sergey");
        preparedStatement.setString(4, "Shklyaev");
        preparedStatement.setString(5, "89524083622");

        int rows = preparedStatement.executeUpdate();

        System.out.println("rows added:" + rows);

        System.out.println("Creating statement...");
        statement = connection.createStatement();

        String sql2 = "select * from Students";

        boolean isRetrieved = statement.execute(sql2);

        System.out.println("Is data retrieved: " + isRetrieved);

        System.out.println("Displaying retrieved data:");
        ResultSet resultSet = statement.executeQuery(sql2);

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            String phone = resultSet.getString("phone");

            System.out.println("id: " + id);
            System.out.println("firstName: " + firstName);
            System.out.println("lastName: " + lastName);
            System.out.println("age: " + age);
            System.out.println("phone: " + phone);
            System.out.println("\n===================\n");
        }

        System.out.println("Closing connection and releasing resources...");

        try {
            resultSet.close();
            statement.close();
            connection.close();
        }finally {
            statement.close();
            connection.close();
        }
        System.out.println("Thank You.");
    }
}
