package sureshlhavanjanreviewassignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PC3 {

    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in);

        String name, input = "", bestAvgName = "";
        double shotsTaken = 0, shotsMade = 0, shotAverage, bestAverage = 0;
        boolean showAvg, restart = true;
        StringTokenizer st = new StringTokenizer(input, " ");

        //String input = "KATIE 34 19";
        for (int a = 0; a < 4; a++) {
            restart = true;
            while (restart == true) {
                input = Keyboard.nextLine();

                if (input.equals("")) {
                    restart = true;
                } else {
                    restart = false;
                }

                st = new StringTokenizer(input, " ");
                if (!(st.countTokens() == 3)) {
                    restart = true;
                    System.out.println("Please write as: Name(Letters) ShotsTaken(numbers) ShotsMade(numbers).");
                }
            }
            name = st.nextElement().toString();

            String shotsTakenStr = st.nextElement().toString();

            if (typeVerify(shotsTakenStr, 'd') == true) {
                shotsTaken = Double.parseDouble(shotsTakenStr);
            }
            String shotsMadeStr = st.nextElement().toString();

            if (typeVerify(shotsMadeStr, 'd') == true && typeVerify(shotsTakenStr, 'd')
                    == true && typeVerify(name, 's') == true) {
                shotsMade = Double.parseDouble(shotsMadeStr);
                showAvg = true;
            } else {
                System.out.println("Please write as: Name(Letters) ShotsTaken(numbers) ShotsMade(numbers).");
                a--;
                showAvg = false;
            }

            shotAverage = Math.round((shotsMade / shotsTaken * 100) * 100.0) / 100.0;
            if (showAvg == true) {
                System.out.println(name + "-" + shotAverage);
            }
            if (shotAverage > bestAverage) {
                bestAverage = shotAverage;
                bestAvgName = name;
            }

            if (a == 3 && showAvg == true) {
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
