package sureshlhavanjanreviewassignment;

import java.util.Scanner; //Imports scanner class

/*
Assignment: PC5, Smile with similes
Teacher/Course: Mr. Payne/ICS4U1-01
Created By: Lhavanjan Suresh
Date: September 9, 2022

A player chooses how many nouns and adjectives they want, then provides with 
all the nouns and adjectives to finally recieve all the similies. As a result, 
everyone is happy.
*/

public class PC5 {

    public static void main(String args[]) {

        Scanner Keyboard = new Scanner(System.in); //Creates scanner class

        boolean contGame = false; //Set contGame to false
        int n = 0, m = 0; //set n and m to 0
        //While contGamee is equal to false
        while (contGame == false) {
            System.out.print("How many adjectives? ");
            String nStr = Keyboard.nextLine(); //Grab players input and save to nStr
            //If nStr is an integer and returns true
            if (typeVerify(nStr, 'i') == true) {
                n = Integer.parseInt(nStr); //Parse into integer and save to n
                contGame = true; //Set contGame to true
            } else {
                System.out.println("Please type a vaild integer.");
                contGame = false; //Set contGame to false
            }
        }
        //While contGame is equal to true
        while (contGame == true) {
            System.out.print("How many nouns? ");
            String mStr = Keyboard.nextLine(); //Grab players input and save to mStr
            //If mStr is an integer and returns true
            if (typeVerify(mStr, 'i') == true) {
                m = Integer.parseInt(mStr); //Parse into an integer and save to m
                contGame = false; //Set contGame to false
            } else {
                System.out.println("Please type a vaild integer.");
                contGame = true; //Set contGame to true
            }
        }
        //Sets string arrays to the number of adjectives and nouns
        String[] adjectives = new String[n];
        String[] nouns = new String[m];

        //To save all the adjectives into an array
        //Repeat while a is set to zero, a is less than n, Add one to a
        for (int a = 0; a < n; a++) {
            adjectives[a] = Keyboard.next(); //Save players input to adjective[a]
            //If adjectives[a] is not a string and returns false 
            if (typeVerify(adjectives[a], 's') == false) {
                System.out.println("Please type a vaild adjective.");
                a--; //Subtract one from a
            }
        }
        //To save all the nouns into an array
        //Repeat while b is set to zero, b is less than m, Add one to b
        for (int b = 0; b < m; b++) {
            nouns[b] = Keyboard.next(); //Save players input to nouns[b]
            //If nouns[b] is not a string and returns false
            if (typeVerify(nouns[b], 's') == false) {
                System.out.println("Please type a vaild noun.");
                b--; //Subtract one from b
            }
        }
        //To write the similies
        //Repeat while c is set to zero, c is less than n, Add one to c
        for (int c = 0; c < n; c++) {
            //Repeat while d is set to zero, d is less than m, Add one to d
            for (int d = 0; d < m; d++) {
                //Display the similies
                System.out.println(adjectives[c] + " as " + nouns[d]);
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
