# Yahtzee Game Homework

For this Homework, you will be implementing two classes: `YahtzeePlayer` and `YahtzeeGame`. Your solution will calculate the score and winner for a modified version of the board game Yahtzee. No prior knowledge of the game is required.

**Note**: 5 points of your Challenge grade are based on Coding Style. You will need to follow the standards described on Brightspace. Use the "Run" button to check your Coding Style without using a submission.

## Important Notes
- **Scanner declaration and instantiation**: Permitted only once in the `main` method.
- **Static fields**: Modifiable static fields are not allowed.

Failure to follow these rules will lead to failed test cases.

## Yahtzee Game Overview
Yahtzee is a dice game involving five dice and a scorecard. Points are scored by rolling certain combinations of dice. For this assignment, the game will be played between two players, though typically, it can involve more players.

### Differences from the Regular Game:
1. **Number of Rolls**: The game is typically played with 13 rolls per player. In our version, the number of rolls can vary.
2. **Combinations**: Our version will only include Four of a Kind, Full House, Large Straight, and Yahtzee.
3. **Yahtzee**: Points will only be given for one Yahtzee. Additional Yahtzees will not provide extra points.

### Game Objective:
The player who has more points after all rolls are over wins.

## Class Descriptions

### 1. YahtzeePlayer
This class contains attributes associated with the game results and combinations for a certain player.

#### Fields
| Name | Type | Modifiers | Description |
| ---- | ---- | --------- | ----------- |
| `rollResults` | `int[][]` | `private` | The roll results for the player. |
| `total` | `int` | `private` | The total number of points scored by the player in the game. |
| `fourOfAKindTotal` | `int` | `private` | Points earned from scoring a Four of a Kind. |
| `fullHouse` | `boolean` | `private` | Whether the player rolled a Full House. |
| `largeStraight` | `boolean` | `private` | Whether the player rolled a Large Straight. |
| `yahtzee` | `boolean` | `private` | Whether the player rolled a Yahtzee. |

#### Constructor
| Parameters | Modifier | Description |
| ---------- | -------- | ----------- |
| `int[][] rollResults` | `public` | Initializes the fields with appropriate values. |

#### Methods
| Name | Return Type | Parameters | Modifier | Description |
| ---- | ----------- | ---------- | -------- | ----------- |
| `getFourOfAKindTotal` | `int` | None | `public` | Returns the player's Four of a Kind total. |
| `hasFullHouse` | `boolean` | None | `public` | Returns if the player has a Full House. |
| `hasLargeStraight` | `boolean` | None | `public` | Returns if the player has a Large Straight. |
| `hasYahtzee` | `boolean` | None | `public` | Returns if the player has a Yahtzee. |
| `getTotal` | `int` | None | `public` | Returns the total points scored. |
| `checkFourOfAKind` | `void` | None | `public` | Checks and assigns Four of a Kind points. |
| `checkFullHouse` | `void` | None | `public` | Checks for a Full House and sets boolean. |
| `checkLargeStraight` | `void` | None | `public` | Checks for a Large Straight and sets boolean. |
| `checkYahtzee` | `void` | None | `public` | Checks for a Yahtzee and sets boolean. |
| `calculateTotal` | `void` | None | `public` | Calculates the total score for the player. |

### 2. YahtzeeGame
This class gathers the roll results from the game and prints information about the results. It is implemented for you. While you can make changes for debugging, do not change its overall functionality.

### Game Flow:
1. The number of rolls is collected for each player.
2. Two 2D arrays are created to store the roll results for both players.
3. A `YahtzeePlayer` object is created for each player, using the roll results.
4. The game checks for each player's dice combinations and calculates their total score.
5. The results are printed, showing the combinations each player rolled and determining the winner.

## Sample Outputs

### Sample 1
