package sureshlhavanjanreviewassignment;

import java.util.Scanner;

public class SureshLhavanjanReviewAssignment {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double collectorCurDou = 0, baseCurDou = 0;
        boolean restart;

        do {
            restart = true;
            do {
                System.out.print("Enter Collector Current, Base Current, seperated by "
                        + "a comma: ");
                String value = keyboard.nextLine();
                int commaLoc = value.indexOf(",");
                if (value.equals("") || (commaLoc == -1)) {
                    restart = true;
                } else {
                    restart = false;
                }
                if (restart == false) {
                    String collectorCurStr = value.substring(0, commaLoc);
                    String baseCurStr = value.substring(commaLoc + 1, value.length());
                    if (typeVerify(collectorCurStr, 'd') == true && typeVerify(baseCurStr, 'd') == true) {
                        collectorCurDou = Double.parseDouble(collectorCurStr);
                        baseCurDou = Double.parseDouble(baseCurStr);
                        restart = false;
                    } else {
                        restart = true;
                    }
                }
            } while (restart == true);

            if (baseCurDou > 0) {
                int tranCurGain = (int) (collectorCurDou / baseCurDou);
                System.out.println("The transistor current gain is " + tranCurGain + ".");
            } else {
                System.out.println("The transistor current gain is infinity.");
            }
        } while (collectorCurDou != 0);
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
