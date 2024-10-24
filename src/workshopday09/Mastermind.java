package workshopday09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Mastermind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int triesLeft = 12;
        String secretNumber = generateRandomNumber();
        while (triesLeft > 0) {
            System.out.println("Tries left: " + triesLeft);
            System.out.print("Enter your guess (4 digits between 1 and 6): ");
            String userGuess = scanner.nextLine();

            if (!validateInput(userGuess)) {
                continue;
            }

            int correctPositionCount = 0;
            int wrongPositionCount = 0;

            for (int i = 0; i < 4; i++) {
                if (userGuess.charAt(i) == secretNumber.charAt(i)) {
                    correctPositionCount++;
                } else if (secretNumber.contains(String.valueOf(userGuess.charAt(i)))) {
                    wrongPositionCount++;
                }
            }

            System.out.println("Correct position count: " + correctPositionCount);
            System.out.println("Wrong position and number count: " + wrongPositionCount);

            if (correctPositionCount == 4) {
                System.out.println("Congratulations! You won!");
                break;
            }

            triesLeft--;
        }

        if (triesLeft == 0) {
            System.out.println("Sorry, you ran out of tries. The secret number was " + secretNumber);
        }

        playAgain();
    }

    private static String generateRandomNumber() {
        StringBuilder sb = new StringBuilder(4);

        while (sb.length() < 4) {
            int randomNum = (int) (Math.random() * 6) + 1;
            if (!sb.toString().contains(String.valueOf(randomNum))) {
                sb.append(randomNum);
            }
        }

        return sb.toString();
    }

    private static boolean validateInput(String input) {
        if (input.length() != 4 || !input.matches("[1-6]{4}")) {
            System.out.println("Please enter a 4-digit number between 1111 and 6666.");
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) > 6 || Character.getNumericValue(input.charAt(i)) < 1) {
                System.out.println("Please enter a number between 1 and 6.");
                return false;
            }
        }

        return true;
    }

    private static void playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.nextLine();

        if ("yes".equalsIgnoreCase(response)) {
            main(null);
        } else {
            System.out.println("Thanks for playing!");
        }
        scanner.close();
    }
}
