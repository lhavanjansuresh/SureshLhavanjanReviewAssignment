package sureshlhavanjanreviewassignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PC4 {

    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in);

        double F = 0, D = 0, C = 0, S = 0;
        int attempt = 0;
        double finalDistClimb = 0;
        boolean restart;
        do {
            do {
                restart = false;
                System.out.print("Please enter D C S F: ");
                String str = Keyboard.nextLine();

                //String str = "10 4 1 120";
                if (str.equals("")) {
                    restart = true;
                }

                if (restart == false) {
                    StringTokenizer st = new StringTokenizer(str, " ");

                    if (!(st.countTokens() == 4)) {
                        restart = true;
                        System.out.println("Please enter 4 values.");
                    }

                    if (restart == false) {

                        String dStr = st.nextElement().toString();
                        String cStr = st.nextElement().toString();
                        String sStr = st.nextElement().toString();
                        String fStr = st.nextElement().toString();

                        if (typeVerify(dStr, 'd') == true) {
                            D = Double.parseDouble(dStr);
                        }
                        if (typeVerify(cStr, 'd') == true && typeVerify(dStr, 'd') == true) {
                            C = Double.parseDouble(cStr);
                        }
                        if (typeVerify(sStr, 'd') == true && typeVerify(cStr, 'd') == true
                                && typeVerify(dStr, 'd') == true) {
                            S = Double.parseDouble(sStr);
                        }
                        if (typeVerify(fStr, 'd') == true && typeVerify(sStr, 'd') == true
                                && typeVerify(cStr, 'd') == true && typeVerify(dStr, 'd') == true) {
                            F = Double.parseDouble(fStr);
                        } else if (typeVerify(dStr, 'd') == false || typeVerify(cStr, 'd') == false
                                || typeVerify(dStr, 'd') == false || typeVerify(fStr, 'd') == false) {
                            System.out.println("Please write values 1 - 100 inclusive.");
                            restart = true;
                        }
                    }
                }
            } while (restart == true);

            double fatigue = (F / 100) * C;

            while (finalDistClimb >= 0 && finalDistClimb <= D) {
                if (C - (fatigue * attempt) > 0) {
                    finalDistClimb = (C - fatigue * attempt) + finalDistClimb;
                }
                finalDistClimb = finalDistClimb - S;
                attempt++;
            }
            if (finalDistClimb < 0) {
                System.out.println("FAILURE ON ATTEMPT " + attempt);
                restart = true;
            } else {
                attempt--;
                System.out.println("SUCCESS ON ATTEMPT " + attempt);
                restart = true;
            }
            attempt = 0;
            finalDistClimb = 0;
        } while (restart == true);
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
