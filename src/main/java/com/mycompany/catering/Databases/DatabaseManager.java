/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catering.Databases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author A243934
 */
public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Catering";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Solutions@2024";
    

    public static boolean verifyLogin(String username, String password){
        try{
         Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         String query = "SELECT * FROM Client WHERE username = ? AND password = ?";
         PreparedStatement statement = connection.prepareStatement(query);
         statement.setString(1, username);
         statement.setString(2, password);

         ResultSet resultSet = statement.executeQuery();
         boolean isValid = resultSet.next();

         resultSet.close();
         statement.close();
         connection.close();

         return isValid;
        }catch (SQLException e){
          e.printStackTrace();
          return false;
        }
    }

    public void insertBooking(String bookingType, java.util.Date eventDate, String description,
                               int nbrKids, int nbrAdults, String venue) {
        try {
            // Establish a database connection (Replace with your connection details)
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Prepare the SQL insert statement
            String query1 = "INSERT INTO Booking (Booking_type, Date, Description, Number_of_kids, Number_of_adults, Venue) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query1);
            
            // Set parameters for the insert statement
            statement.setString(1, bookingType);  // Replace with the actual booking type
            statement.setDate(2, new java.sql.Date(eventDate.getTime()));
            statement.setString(3, description);
            statement.setInt(4, nbrKids);
            statement.setInt(5, nbrAdults);
            statement.setString(6, venue);
            
            // Execute the insert statement
            statement.executeUpdate();
            
            // Close resources
            statement.close();
            connection.close();
            
            System.out.println("Booking added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   





}
