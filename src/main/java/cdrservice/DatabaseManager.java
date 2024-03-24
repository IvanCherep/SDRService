package cdrservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:h2:./test";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void saveTransaction(String phoneNumber, long startTime, long endTime) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO transactions (phone_number, start_time, end_time) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setLong(2, startTime);
            preparedStatement.setLong(3, endTime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
