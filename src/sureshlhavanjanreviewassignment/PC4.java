package sureshlhavanjanreviewassignment;

import java.util.Scanner; //Imports scanner class
import java.util.StringTokenizer; //Imports StringTokenizer class

/*
Assignment: PC4, Nicholas Loves Tobogganing
Teacher/Course: Mr. Payne/ICS4U1-01
Created By: Lhavanjan Suresh
Date: September 25, 2022

Player is to input D, C, S and F wheren D is the distance to the top of the hill
in metres, C is the distance in metres that Nicholas can climb during his first 
attempt, S is the distance in metres that he slides down after he falls, and F 
is the fatigue factor expressed as a percentage. The program will go through all
the attempts and output successful or failure on which attempt.
*/

public class PC4 {

    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in); //Creates scanner class

        //Variables
        double F = 0, D = 0, C = 0, S = 0;
        int attempt = 0;
        double finalDistClimb = 0;
        boolean restart;
        do {
            do {
                restart = false; //Set restart to false
                System.out.print("Please enter D C S F: ");
                String str = Keyboard.nextLine(); //Set players input to str

                //If str is blank
                if (str.equals("")) {
                    restart = true; //Set restart to true
                }
                
                //If restart is set to false
                if (restart == false) {
                    //Tokenize str with the delimiter of " " to st
                    StringTokenizer st = new StringTokenizer(str, " ");

                    //If st does not have 4 tokens
                    if (!(st.countTokens() == 4)) {
                        restart = true; //Set restart to true
                        System.out.println("Please enter 4 values.");
                    }
                    //If restart is set to false
                    if (restart == false) {

                        //Save the tokens of st to the variables below
                        String dStr = st.nextElement().toString();
                        String cStr = st.nextElement().toString();
                        String sStr = st.nextElement().toString();
                        String fStr = st.nextElement().toString();

                        //If dStr is a double
                        if (typeVerify(dStr, 'd') == true) {
                            //Parse dStr into double and save to D
                            D = Double.parseDouble(dStr);
                        }
                        //If cStr and dStr are a double
                        if (typeVerify(cStr, 'd') == true && typeVerify(dStr, 'd') == true) {
                            //Parse cStr into double and save to C
                            C = Double.parseDouble(cStr);
                        }
                        //If cStr, dStr and sStr are a double
                        if (typeVerify(sStr, 'd') == true && typeVerify(cStr, 'd') == true
                                && typeVerify(dStr, 'd') == true) {
                            //Parse sStr into double and save to S
                            S = Double.parseDouble(sStr);
                        }
                        //If cStr, dStr, fStr and sStr are a double
                        if (typeVerify(fStr, 'd') == true && typeVerify(sStr, 'd') == true
                                && typeVerify(cStr, 'd') == true && typeVerify(dStr, 'd') == true) {
                            //Parse fStr into double and save to F
                            F = Double.parseDouble(fStr);
                        //Else if cStr, dStr, fStr and sStr are not a double
                        } else if (typeVerify(dStr, 'd') == false || typeVerify(cStr, 'd') == false
                                || typeVerify(dStr, 'd') == false || typeVerify(fStr, 'd') == false) {
                            System.out.println("Please write values 1 - 100 inclusive.");
                            restart = true; //Set restart to true
                        }
                    }
                }
            } while (restart == true); //Do-While restart is set to true
            
            //Save fatigue factor into fatigue variable
            double fatigue = (F / 100) * C;

            /*While finalDistClimb is greater than or equal to 0 and 
            finalDistClimb is less than or equal to D*/
            while (finalDistClimb >= 0 && finalDistClimb <= D) {
                //If Distance climbed is greater than 0
                if (C - (fatigue * attempt) > 0) {
                    //Set finalDistClimb to distance climbed plus finalDistClimb
                    finalDistClimb = (C - fatigue * attempt) + finalDistClimb;
                }
                //Set finalDistClimb to the final distance after sliding
                finalDistClimb = finalDistClimb - S;
                //Add one to the attempt
                attempt++;
            }
            //If the finalDistClimb is less than 0
            if (finalDistClimb < 0) {
                //Display failure message with attempt
                System.out.println("FAILURE ON ATTEMPT " + attempt);
                restart = true; //Set restart to true
            } else {
                attempt--; //Subtract one from the attempt
                //Display success message with attempt
                System.out.println("SUCCESS ON ATTEMPT " + attempt);
                restart = true; //Set restart to true
            }
            attempt = 0; //Reset attempt and set to 0
            finalDistClimb = 0; //Reset finalDistClimb and set to 0
        } while (restart == true); //Do-while restart is set to true
    }

    public static boolean typeVerify(String token, char type) {
        boolean verified = true;
        double x = 0;
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
                x = Double.parseDouble(token);
                verified = true;
            } catch (NumberFormatException e) {
                verified = false;
            }
            if (verified == true) {
                if (x >= 1 && x <= 100) {
                    verified = true;
                } else {
                    verified = false;
                }
            }
        }
        return verified;
    }
}
