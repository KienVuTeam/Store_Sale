/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author HP
 */
public class Test_DateTime {

    public static void main(String[] args) {
//        Long datetime = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(datetime);
//        System.out.println("Current Time Stamp: " + timestamp);

        //
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//        System.out.println(formatter.format(date));
        //
//        long millis = System.currentTimeMillis();
//
//        // creating a new object of the class Date  
//        java.sql.Date date = new java.sql.Date(millis);
//         System.out.println("ngay giờ hiện hành: "+date);   
//         //
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("ngày và giờ hiện tại: " + dtf.format(now));
        System.out.println("----------------");
        
        //Getting the current time value
//        LocalTime time = LocalTime.now();
//        System.out.println("Current time: " + time);
//        System.out.println("--------");
      
//        LocalTime timeObj = LocalTime.now();
//        String currentTime = timeObj.toString();
//        System.out.println(currentTime);
     
        //date time stamp
//         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        System.out.println("Current Time Stamp: "+timestamp);
    }
}
