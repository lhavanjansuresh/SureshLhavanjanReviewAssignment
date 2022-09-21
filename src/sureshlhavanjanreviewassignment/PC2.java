package sureshlhavanjanreviewassignment;

import java.util.Scanner;

public class PC2 {

    public static void main(String args[]) {
        String sentence1 = "";
        boolean endGame = false;
        boolean repromt;

        Scanner Keyboard = new Scanner(System.in);
        do {
            repromt = true;
            while (repromt == true) {
                System.out.print("Input: ");
                sentence1 = Keyboard.nextLine();
                if (sentence1.equals("")) {
                    repromt = true;
                } else if (sentence1.equals("stop")) {
                    endGame = true;
                    repromt = false;
                } else {
                    endGame = false;
                    repromt = false;
                }
            }
            while (endGame == false && repromt == false) {
                String sentence = sentence1.toUpperCase();
                char[] sentLetters = sentence.toCharArray();
                String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char[] alphabet = str.toCharArray();
                int[] numOfLetters = new int[str.length()];
                for (int c = 0; c < sentence.length(); c++) {
                    sentLetters[c] = sentence.charAt(c);
                }
                int check = 0;
                for (int a = 0; a < str.length(); a++) {

                    for (int i = 0; i < sentence.length(); i++) {

                        if (alphabet[a] == sentLetters[i]) {
                            numOfLetters[a]++;
                        }
                    }
                    if (numOfLetters[a] > 0) {
                        check++;
                    }
                }
                int firstIndex = -1, lastIndex = -1;

                //finding last letter with value greater than 0
                for (int g = 0; g < numOfLetters.length; g++) {
                    if (numOfLetters[g] > 0 && firstIndex == -1) {
                        firstIndex = g;
                    }
                    if (numOfLetters[g] > 0 && firstIndex != -1) {
                        lastIndex = g;
                    }
                }
                System.out.print("Output: ");
                for (int x = 0; x < str.length(); x++) {

                    if (numOfLetters[x] > 0) {

                        System.out.print(alphabet[x] + "-" + numOfLetters[x]);
                        if (lastIndex > x) {
                            System.out.print(":");
                            check--;
                        }
                    }
                }
                System.out.println("");
                repromt = true;
            }
        } while (endGame == false);
    }
}
