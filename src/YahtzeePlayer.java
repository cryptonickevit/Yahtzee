/**
 * HW-07 - Yahtzee
 *
 * @author Kevin Tang, Lab 4
 *
 * @version October 10, 2024
 */

public class YahtzeePlayer {
    private int[][] rollResults;
    private int total;
    private boolean fullHouse;
    private boolean largeStraight;
    private int fourOfAKindTotal;
    private boolean yahtzee;

    public YahtzeePlayer(int[][] rollResults) {
        this.rollResults = rollResults;
        this.total = 0;
        this.fourOfAKindTotal = 0;
        this.fullHouse = false;
        this.largeStraight = false;
        this.yahtzee = false;
    }

    public int getFourOfAKindTotal() {
        return this.fourOfAKindTotal;
    }

    public boolean hasFullHouse() {
        return this.fullHouse;
    }

    public boolean hasLargeStraight() {
        return this.largeStraight;
    }

    public boolean hasYahtzee() {
        return this.yahtzee;
    }

    public int getTotal() {
        return this.total;
    }

    public void checkFourOfAKind() {
        for (int[] roll : rollResults) {
            int[] frequency = new int[7]; // Since dice numbers are 1-6
            for (int die : roll) {
                frequency[die]++;
            }
            for (int i = 1; i < frequency.length; i++) {
                if (frequency[i] == 4) { // Check for four of a kind
                    fourOfAKindTotal = 0; // Reset before calculating
                    for (int die : roll) {
                        fourOfAKindTotal += die; // Add all five dice
                    }
                    return; // Award points only for the first Four of a Kind
                }
            }
        }
    }

    public void checkFullHouse() {
        for (int[] row : rollResults) {
            int[] frequency = new int[7]; // Track frequency of each dice number
            for (int die : row) {
                frequency[die]++;
            }
            boolean threeOfAKind = false;
            boolean twoOfAKind = false;
            for (int count : frequency) {
                if (count == 3) {
                    threeOfAKind = true;
                } else if (count == 2) {
                    twoOfAKind = true;
                }
            }
            if (threeOfAKind && twoOfAKind) {
                fullHouse = true;
                return; // Stop after finding the first Full House
            }
        }
        fullHouse = false; // If no Full House found
    }

    public void checkLargeStraight() {
        for (int[] rollResult : rollResults) {
            boolean isLargeStraight = true;
            for (int j = 0; j < rollResult.length - 1; j++) {
                if (rollResult[j] + 1 != rollResult[j + 1]) {
                    isLargeStraight = false;
                    break;
                }
            }
            if (isLargeStraight) {
                largeStraight = true;
                return;
            }
        }
        largeStraight = false; // If no Large Straight is found
    }

    public void checkYahtzee() {
        for (int[] rollResult : rollResults) {
            int constantValue = rollResult[0]; // Initialize with the first value of the row
            boolean isYahtzee = true;
            for (int j = 1; j < rollResult.length; j++) {
                if (rollResult[j] != constantValue) {
                    isYahtzee = false;
                    break; // No need to continue if one value is different
                }
            }
            if (isYahtzee) {
                yahtzee = true;
                return;
            }
        }
    }

    public void calculateTotal() {
        total = 0; // Reset total before calculating
        total += fourOfAKindTotal;
        if (fullHouse) total += 25;
        if (largeStraight) total += 40;
        if (yahtzee) total += 50;
    }
}
