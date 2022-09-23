package sureshlhavanjanreviewassignment;

import java.util.Scanner; //Imports scanner class

/*
Assignment: PC0, Transistor Gain
Teacher/Course: Mr. Payne/ICS4U1-01
Created By: Lhavanjan Suresh
Date: September 9, 2022

A transistor’s current gain calculator.
*/

public class SureshLhavanjanReviewAssignment {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); //Creates scanner class
        
        //Variables
        double collectorCurDou = 0, baseCurDou = 0;
        boolean restart;

        do {
            restart = true; //Sets restart to true
            do {
                System.out.print("Enter Collector Current, Base Current, seperated by "
                        + "a comma: ");
                String value = keyboard.nextLine(); //Sets player input to value
                int commaLoc = value.indexOf(","); //Finds the location of the comma
                
                //If value is blank or there is no comma in commaLoc
                if (value.equals("") || (commaLoc == -1)) {
                    restart = true; //Sets restart to true
                } else {
                    restart = false; //Sets restart to false
                }
                //If restart is equal to false
                if (restart == false) {
                    //Saves string to collectorCurStr from beginning of value to the the commaLoc
                    String collectorCurStr = value.substring(0, commaLoc); 
                    //Saves string to baseCurStr from beginning of one after commaLoc to the end of the string value
                    String baseCurStr = value.substring(commaLoc + 1, value.length()); 
                    //If collectorCurStr and baseCurStr goes through verification method and returns true
                    if (typeVerify(collectorCurStr, 'd') == true && typeVerify(baseCurStr, 'd') == true) {
                        collectorCurDou = Double.parseDouble(collectorCurStr); //Parse string into double
                        baseCurDou = Double.parseDouble(baseCurStr); //Parse string into double
                        restart = false; //Sets restart to false
                    } else {
                        restart = true; //Sets restart to true
                    }
                }
            } while (restart == true); //do - while restart is equal to true

            //If baseCurDou is greater than 0
            if (baseCurDou > 0) { 
                //Calculates the integer value of transistor current gain by dividing collectorCurDou to baseCurDou
                int tranCurGain = (int) (collectorCurDou / baseCurDou);
                //Displays transistor current gain
                System.out.println("The transistor current gain is " + tranCurGain + ".");
            } else {
                System.out.println("The transistor current gain is infinity.");
            }
        } while (collectorCurDou != 0); //do - while collectorCurDou is not equal to 0
    }

    public static boolean typeVerify(String token, char type) {
        boolean verified = true;
        if (type == 's') {
            for (int a = 0; token.length() > a; a++) {
                if (token.charAt(a) >= 65 && token.charAt(a) <= 122) {
                    verified = true;
                } else {
                    verified = false;
                    a = token.length();
                }
            }
        } else if (type == 'i') {
            try {
                Integer.parseInt(token);
                verified = true;
            } catch (NumberFormatException e) {
                verified = false;
            }
        } else if (type == 'd') {
            try {
                Double.parseDouble(token);
                verified = true;
            } catch (NumberFormatException e) {
                verified = false;
            }
        }
        return verified;
    }
}
