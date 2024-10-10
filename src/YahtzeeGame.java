import java.util.Scanner;

/**
 * HW-07 - Yahtzee
 *
 *
 * @author Kevin Tang, Lab 4
 *
 * @version October 10, 2024
 *
 */

public class YahtzeeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Yahtzee!");

        System.out.println("Enter the number of rolls for each player in the game");
        int numRolls = scanner.nextInt();
        scanner.nextLine();
        int[][] playerOneRollResults = new int[numRolls][5];
        int[][] playerTwoRollResults = new int[numRolls][5];

        for (int i = 1; i <= numRolls; i++) {
            System.out.println("Enter the roll results separated by commas for roll " + i + " for player 1.");
            String playerOneCurr = scanner.nextLine();
            for (int j = 0; j < playerOneCurr.length(); j += 2) {
                playerOneRollResults[i - 1][j / 2] = Integer.parseInt(playerOneCurr.substring(j, j + 1));
            }
            System.out.println("Enter the roll results separated by commas for roll " + i + " for player 2.");
            String playerTwoCurr = scanner.nextLine();
            for (int j = 0; j < playerTwoCurr.length(); j += 2) {
                playerTwoRollResults[i - 1][j / 2] = Integer.parseInt(playerTwoCurr.substring(j, j + 1));
            }
        }

        YahtzeePlayer playerOne = new YahtzeePlayer(playerOneRollResults);
        YahtzeePlayer playerTwo = new YahtzeePlayer(playerTwoRollResults);
        playerOne.checkFourOfAKind();
        playerTwo.checkFourOfAKind();
        playerOne.checkFullHouse();
        playerTwo.checkFullHouse();
        playerOne.checkLargeStraight();
        playerTwo.checkLargeStraight();
        playerOne.checkYahtzee();
        playerTwo.checkYahtzee();
        playerOne.calculateTotal();
        playerTwo.calculateTotal();
        int playerOneTotal = playerOne.getTotal();
        int playerTwoTotal = playerTwo.getTotal();

        String playerOneCombinations = "";
        String playerTwoCombinations = "";
        if (playerOne.getFourOfAKindTotal() > 0) {
            playerOneCombinations += "Four of a Kind, ";
        }
        if (playerOne.hasFullHouse()) {
            playerOneCombinations += "Full House, ";
        }
        if (playerOne.hasLargeStraight()) {
            playerOneCombinations += "Large Straight, ";
        }
        if (playerOne.hasYahtzee()) {
            playerOneCombinations += "Yahtzee";
        }

        if (playerOneCombinations.length() > 0 &&
                playerOneCombinations.substring(playerOneCombinations.length() - 2).equals(", ")) {
            playerOneCombinations = playerOneCombinations.substring(0, playerOneCombinations.length() - 2);
        }
        if (playerTwo.getFourOfAKindTotal() > 0) {
            playerTwoCombinations += "Four of a Kind, ";
        }
        if (playerTwo.hasFullHouse()) {
            playerTwoCombinations += "Full House, ";
        }
        if (playerTwo.hasLargeStraight()) {
            playerTwoCombinations += "Large Straight, ";
        }
        if (playerTwo.hasYahtzee()) {
            playerTwoCombinations += "Yahtzee";
        }

        if (playerTwoCombinations.length() > 0 &&
                playerTwoCombinations.substring(playerTwoCombinations.length() - 2).equals(", ")) {
            playerTwoCombinations = playerTwoCombinations.substring(0, playerTwoCombinations.length() - 2);
        }

        if (playerOneCombinations.length() > 0) {
            System.out.println("Player 1 scored the following: ");
            System.out.println(playerOneCombinations);
        } else {
            System.out.println("Player 1 did not score any points");
        }
        if (playerTwoCombinations.length() > 0) {
            System.out.println("Player 2 scored the following: ");
            System.out.println(playerTwoCombinations);
        } else {
            System.out.println("Player 2 did not score any points");
        }

        if (playerOneTotal > playerTwoTotal) {
            System.out.println("Player 1 is the winner by a score of " + playerOne.getTotal() + "-");
            System.out.println(playerTwo.getTotal() + "!");
        } else {
            System.out.println("Player 2 is the winner by a score of " + playerTwo.getTotal() + "-");
            System.out.println(playerOne.getTotal() + "!");
        }
    }
}
