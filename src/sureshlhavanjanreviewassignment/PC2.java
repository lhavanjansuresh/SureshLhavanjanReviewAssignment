package sureshlhavanjanreviewassignment;

import java.util.Scanner;//Imports scanner class

/*
Assignment: PC2, Now I Know my ABC’s
Teacher/Course: Mr. Payne/ICS4U1-01
Created By: Lhavanjan Suresh
Date: September 9, 2022

A player inputs a sentence of their choice and the outputs displays the all the 
letters that have appeared at least once.
*/

public class PC2 {

    public static void main(String args[]) {
        //Variables
        String sentence1 = "";
        boolean endGame = false;
        boolean repromt;

        Scanner Keyboard = new Scanner(System.in); //Creates scanner class
        do {
            repromt = true; //Sets repromt to true
            //While repromt is equal to true
            while (repromt == true) {
                System.out.print("Input: ");
                sentence1 = Keyboard.nextLine(); //Saves player input to sentence1
                //If sentence1 is blank
                if (sentence1.equals("")) {
                    repromt = true; //Set repromt to true
                //Else if sentence1 equals to "stop"
                } else if (sentence1.equals("stop")) {
                    endGame = true; //Set endGame to true
                    repromt = false; //Set repromt to false
                } else {
                    endGame = false; //Set endGame to false
                    repromt = false; //Set repromt to false
                }
            }
            //While endGame is equal to false and repromt is equal to false
            while (endGame == false && repromt == false) {
                //Convert sentence1 to uppercase and save to sentence
                String sentence = sentence1.toUpperCase();
                //Convert sentence to char array and save to sentLetters
                char[] sentLetters = sentence.toCharArray();
                //Save Uppercase alphabet string to str
                String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                //Convert str to char array and save to alphabet
                char[] alphabet = str.toCharArray();
                //Set numofLetters integer array to str length
                int[] numOfLetters = new int[str.length()];
                
                //Set check to 0
                int check = 0;
                
                //This checks if the letters match and if so add one to the letter
                //Repeat while a is set to zero, a is less than length of str, Add one to a
                for (int a = 0; a < str.length(); a++) {
                    //Repeat while i is set to zero, i is less than length of sentence, Add one to i
                    for (int i = 0; i < sentence.length(); i++) {
                        //If alphabet[a] is equal to sentLetters[i]
                        if (alphabet[a] == sentLetters[i]) {
                            numOfLetters[a]++; //Add one to numOfLetters[a]
                        }
                    }
                }
                //Set firstIndex and lastIndex to -1
                int firstIndex = -1, lastIndex = -1;

                //Finding the last letter with value greater than 0
                //Repeat while g is set to zero, g is less than length of numOfLetters, Add one to g
                for (int g = 0; g < numOfLetters.length; g++) {
                    //If numOfLetters[g] is greater than 0 and firstIndex is equal to -1
                    if (numOfLetters[g] > 0 && firstIndex == -1) {
                        firstIndex = g; //Set firstIndex to g
                    }
                    //If numOfLetters[g] is greater than 0 and firstIndex is not equal to -1
                    if (numOfLetters[g] > 0 && firstIndex != -1) {
                        lastIndex = g; //Set lastIndex to g
                    }
                }
                System.out.print("Output: ");
                //Prints out the output where all the alphabet appear at least once
                //Repeat while x is set to zero, g is less than length of str, Add one to x
                for (int x = 0; x < str.length(); x++) {
                    //If numOfLetters[x] is greater than 0
                    if (numOfLetters[x] > 0) {
                        //Display the alphabet with dash and number of times it has appeared
                        System.out.print(alphabet[x] + "-" + numOfLetters[x]);
                        //If the lastIndex is greater than x
                        if (lastIndex > x) {
                            //Display the colon
                            System.out.print(":");
                        }
                    }
                }
                System.out.println(""); //New line
                repromt = true; //Set repromt to true
            }
        } while (endGame == false); //Do - while endGame is equal to false
    }
}
