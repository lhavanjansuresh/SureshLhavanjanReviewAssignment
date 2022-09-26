package sureshlhavanjanreviewassignment;

import java.util.Scanner; //Imports scanner class
import java.util.StringTokenizer; //Imports StringTokenizer class

/*
Assignment: PC3, Basketball Statistics
Teacher/Course: Mr. Payne/ICS4U1-01
Created By: Lhavanjan Suresh
Date: September 25, 2022

A player inputs name, shots taken and shots made for 4 people which then 
displays each players average and finally states who has the best average.
*/

public class PC3 {

    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in); //Creates scanner class

        //Variables
        String name, input = "", bestAvgName = "";
        double shotsTaken = 0, shotsMade = 0, shotAverage, bestAverage = 0;
        boolean showAvg, restart = true;
        StringTokenizer st = new StringTokenizer(input, " ");

        //Takes input for the 4 players
        //Repeat while a is set to zero, g is less than 4, Add one to a
        for (int a = 0; a < 4; a++) {
            restart = true; //Set restart to true
            //While restart is set to true
            while (restart == true) {
                input = Keyboard.nextLine(); //Save players input to input
                //If input is blank
                if (input.equals("")) {
                    restart = true; //Set restart to true
                } else {
                    restart = false; //Set restart to false
                }
                //Tokenize input with the delimiter of " " to st
                st = new StringTokenizer(input, " ");
                //If st does not equal 3
                if (!(st.countTokens() == 3)) {
                    restart = true; //Set restart to true
                    System.out.println("Please write as: Name(Letters) ShotsTaken(numbers) ShotsMade(numbers).");
                }
            }
            //Convert st next element to string and save to name
            name = st.nextElement().toString();
            //Convert st next element to string and save to shotsTakenStr
            String shotsTakenStr = st.nextElement().toString();

            //If shotsTakenStr is a double and returns true
            if (typeVerify(shotsTakenStr, 'd') == true) {
                //Parse shotsTakenStr to double and save to shotsTaken
                shotsTaken = Double.parseDouble(shotsTakenStr);
            }
            //Convert st next element to string and save to shotsMadeStr
            String shotsMadeStr = st.nextElement().toString();

            //If shotsMadeStr and shotsTakenStr are a double and name is a string
            if (typeVerify(shotsMadeStr, 'd') == true && typeVerify(shotsTakenStr, 'd')
                    == true && typeVerify(name, 's') == true) {
                //Parse shotsMadeStr into double and save to shotsMade
                shotsMade = Double.parseDouble(shotsMadeStr);
                showAvg = true; //Set showAvg to true
            } else {
                System.out.println("Please write as: Name(Letters) ShotsTaken(numbers) ShotsMade(numbers).");
                a--; //Subtract one from a
                showAvg = false; //Set showAvg to false
            }
            //Calculate average and round to nearest hundredths. Save to shotAverage variable
            shotAverage = Math.round((shotsMade / shotsTaken * 100) * 100.0) / 100.0;
            //If showAvg is set to true
            if (showAvg == true) {
                //Display name and the shotAverage
                System.out.println(name + "-" + shotAverage);
            }
            //If the shotAverage is greater than the bestAverage
            if (shotAverage > bestAverage) {
                bestAverage = shotAverage; //Set bestAverage to shotAverage
                bestAvgName = name; //Set bestAvgName to name
            }
            //If a is equal to 3 and showAvg is set to true
            if (a == 3 && showAvg == true) {
                //Display the best average's players name
                System.out.println(bestAvgName + " is the best player.");
            }
        }
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
