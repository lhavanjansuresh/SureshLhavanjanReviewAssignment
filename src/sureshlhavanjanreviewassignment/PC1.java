package sureshlhavanjanreviewassignment;

import java.util.Scanner; //Imports scanner class
import java.util.StringTokenizer; //Imports StringTokenizer class

/*
Assignment: PC1, Rock, Paper, Scissors
Teacher/Course: Mr. Payne/ICS4U1-01
Created By: Lhavanjan Suresh
Date: September 9, 2022

A player inputted game with P1 is the first letter and P2 is the second letter. 
Whoever reaches 2 wins first wins the round. (Ex. player input: RP SS RP RS PR)
*/

public class PC1 {

    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in); //Creates scanner class

        //Variables
        boolean endGame = false;
        boolean restart = false;

        do {
            restart = false; //Sets restart to false
            int p1 = 0, p2 = 0, tie = 0; //Sets p1, p2 and tie to 0
            String str = Keyboard.nextLine(); //Saves player input to str

            //If str is equal to Q
            if (str.equals("Q")) {
                endGame = true; //Sets endGame to true
            }

            //If endGame is equal to false
            if (endGame == false) {
                
                //Tokenize str with the delimiter of " " to st
                StringTokenizer st = new StringTokenizer(str, " ");

                //Sets x to the amount of tokens in st
                int x = st.countTokens();
                //Sets tokens array to the amount of tokens
                String tokens[] = new String[x];

                //Sets b to 0
                int b = 0;

                //While st has more elements and restart is equal to false
                while (st.hasMoreElements() && restart == false) {
                    tokens[b] = st.nextElement().toString(); //Convert st to string and saves into tokens array
                    //If tokens[b] is a string and returns true
                    if (typeVerify(tokens[b], 's')) {
                        b++; //Add one to b
                    } else {
                        restart = true; //Set restart to true
                        System.out.println("Please write a vaild response.");
                    }
                }
                //If restart is equal to false
                if (restart == false) {
                    /*Repeat while i is set to zero, i is less than x and p1 is 
                    less than two and p2 is less than 2, Add one to i*/
                    for (int i = 0; i < x && p1 < 2 && p2 < 2; i++) {
                        //If tokens[i] is equal to RR or PP or SS
                        if (tokens[i].equals("RR") || tokens[i].equals("PP") || tokens[i].equals("SS")) {
                            tie++; //Add one to tie
                        //Else if tokens[i] is equal to RP or PS or SR
                        } else if (tokens[i].equals("RP") || tokens[i].equals("PS") || tokens[i].equals("SR")) {
                            p2++; //Add one to p2
                        //Else if tokens[i] is equal to RS or PR or SP
                        } else if (tokens[i].equals("RS") || tokens[i].equals("PR") || tokens[i].equals("SP")) {
                            p1++; //Add one to p1
                        }
                    }
                    //If p2 is equal to 2 and restart is equal to false
                    if (p2 == 2 && restart == false) {
                        System.out.println("PLAYER TWO " + tie); //Display winner and tie
                    //Else if p1 is equal to 2 and restart is equal to false
                    } else if (p1 == 2 && restart == false) {
                        System.out.println("PLAYER ONE " + tie); //Display winner and tie
                    //Else if p1 is equal to p2 and tie is greater than 0 and restart is equal to false
                    } else if (p1 == p2 && tie > 0 && restart == false) {
                        System.out.println("TIE " + tie); //Display tie
                    }
                }

            }
        } while (endGame == false); //Do - while endGame is equal to false
    }

    public static boolean typeVerify(String token, char type) {
        boolean verified = true;
        if (type == 's') {
            for (int a = 0; token.length() > a; a++) {
                if (token.charAt(a) == 80 || token.charAt(a) == 82 || token.charAt(a) == 83) {
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
