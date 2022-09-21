package sureshlhavanjanreviewassignment;

import java.util.Scanner;

public class PC5 {

    public static void main(String args[]) {

        Scanner Keyboard = new Scanner(System.in);

        boolean contGame = false;
        int n = 0, m = 0;
        while (contGame == false) {
            System.out.print("How many adjectives? ");
            String nStr = Keyboard.nextLine();

            if (typeVerify(nStr, 'i') == true) {
                n = Integer.parseInt(nStr);
                contGame = true;
            } else {
                System.out.println("Please type a vaild integer.");
                contGame = false;
            }
        }
        while (contGame == true) {
            System.out.print("How many nouns? ");

            String mStr = Keyboard.nextLine();

            if (typeVerify(mStr, 'i') == true) {
                m = Integer.parseInt(mStr);
                contGame = false;
            } else {
                System.out.println("Please type a vaild integer.");
                contGame = true;
            }
        }
        String[] adjectives = new String[n];
        String[] nouns = new String[m];

        for (int a = 0; a < n; a++) {
            adjectives[a] = Keyboard.next();
            if (typeVerify(adjectives[a], 's') == false) {
                System.out.println("Please type a vaild adjective.");
                a--;
            }
        }
        for (int b = 0; b < m; b++) {
            nouns[b] = Keyboard.next();
            if (typeVerify(nouns[b], 's') == false) {
                System.out.println("Please type a vaild noun.");
                b--;
            }
        }
        for (int c = 0; c < n; c++) {

            for (int d = 0; d < m; d++) {
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
