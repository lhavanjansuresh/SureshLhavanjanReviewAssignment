package sureshlhavanjanreviewassignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PC1 {

    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in);

        boolean endGame = false;
        boolean restart = false;

        do {
            restart = false;
            int p1 = 0, p2 = 0, tie = 0;
            String str = Keyboard.nextLine();

            if (str.equals("Q")) {
                endGame = true;
            }

            if (endGame == false) {
                StringTokenizer st = new StringTokenizer(str, " ");

                int x = st.countTokens();
                String tokens[] = new String[x];

                int b = 0;

                while (st.hasMoreElements() && restart == false) {
                    tokens[b] = st.nextElement().toString();
                    if (typeVerify(tokens[b], 's')) {
                        b++;
                    } else {
                        restart = true;
                        System.out.println("Please write a vaild response.");
                    }

                }
                if (restart == false) {
                    for (int i = 0; i < x && p1 < 2 && p2 < 2; i++) {
                        if (tokens[i].equals("RR") || tokens[i].equals("PP") || tokens[i].equals("SS")) {
                            tie++;
                        } else if (tokens[i].equals("RP") || tokens[i].equals("PS") || tokens[i].equals("SR")) {
                            p2++;
                        } else if (tokens[i].equals("RS") || tokens[i].equals("PR") || tokens[i].equals("SP")) {
                            p1++;
                        }
                    }
                    if (p2 == 2 && restart == false) {
                        System.out.println("PLAYER TWO " + tie);
                    } else if (p1 == 2 && restart == false) {
                        System.out.println("PLAYER ONE " + tie);
                    } else if (p1 == p2 && tie > 0 && restart == false) {
                        System.out.println("TIE " + tie);
                    }
                }

            }
        } while (endGame == false);
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
