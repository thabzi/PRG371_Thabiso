/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catering.Classes;

/**
 *
 * @author A243934
 */
public class ValidateBooking {

    public static boolean isValid(String description, java.util.Date eventDate,
                                   int numKids, int numAdults, String venue, String bookingType) {
        // Implement your validation logic here
        // You can add conditions to check if the values are valid
        // For example, simple validation for demonstration purposes:
        
        return !(description.isEmpty() || eventDate == null || numKids < 0 || numAdults < 0 || venue.isEmpty() || bookingType.isEmpty());
    }
    }
