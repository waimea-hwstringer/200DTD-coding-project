# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.

BRIEF DESCRIPTION OF GAME HERE
BRIEF DESCRIPTION OF GAME HERE
BRIEF DESCRIPTION OF GAME HERE

### Game Features and Rules

The game has the following features and/or rules:

- Players can choose their own names at the start
- The size of the board can be picked from the start
- Pieces can be removed from the board once they are in the left-most position
- Pieces can only be moved left
- Pieces cannot jump over other pieces
- Players take turns moving pieces. The player can only move one piece per turn
- The player that removes the gold coin ($) wins the game

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- Valid player names
- Valid board size
- Initial board setup/generation
- Player chose a valid piece to move
- Removing pieces
- Player is moving a piece to a valid location

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Valid player names

This tests that players have valid names. 

#### Test Data / Actions to Use

Enter an empty name
Both players enter the same name
Enter valid names

#### Expected Outcome
If the names are valid, the program will move on.
Otherwise the program will explain what the user did wrong and repeat the request


### Valid board size

The program should check that the size of the board is between 10-30.
This is because there are six pieces on the board, so we don't want the board to be
too cluttered or too empty.

#### Test Data / Actions to Use

Enter no board size
Enter a board size greater than 30
Enter 30
Enter 20
Enter 10
Enter <10
Enter a string of random text

#### Expected Outcome

When 30, 20 & 10 are entered this should be valid board size

For all other options tried, the program should say what the user did wrong and repeat the question


### Initial board setup/generation

This is the state of the board before players have made any moves

#### Test Data / Actions to Use

Check that the board size is what the player entered
Rerun the code three times to check that the board is different each time

#### Expected Outcome

The board should be the size that the player entered, with 5 obstacles and 1 gold
It should be different each game


### Player chose a valid piece to move

This checks that the player has selected a valid piece to move

#### Test Data / Actions to Use

Choose an empty position
Choose a position that is greater than the size of the board
Choose a negative number
Input text instead of a number
Choose a position that contains a valid piece (X or $)
Enter nothing

#### Expected Outcome

If the player chose a position that contained either X or $, the position is valid and the program should move on
Otherwise the program should state the error and ask again


### Removing pieces

After ensuring that the user chose a valid piece to move, we check if they chose the left most piece.
This is because this piece cannot be moved left, instead it is removed from the board.

#### Test Data / Actions to Use

The program will remove the piece that is in the left most position on the board.

#### Expected Outcome

The piece is removed
If an obstacle (X) is removed, the game continues and the current player is switched
If the gold ($) is removed, the current player wins the game


### Player is moving a piece to a valid location

If the player is not removing a piece, they are moving a piece to a new location.
Pieces can only be moved to the left and cannot jump over other pieces

#### Test Data / Actions to Use

Enter text instead of a new location number
Enter the number that the piece is already in
Enter a location that has a piece between it and the moving piece (trying to jump a piece over another one)
Enter a number that is greater than the moving piece's location (trying to move it to the right)
Enter a negative number
Enter nothing
Choose a location that the piece can actually go

#### Expected Outcome

If a valid location is chosen, the selected piece should move to the new location.
Otherwise the program will state what went wrong and repeat the question


### TEST NAME HERE

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

TEST DATA TO USE DETAILED HERE

#### Expected Outcome

EXPECTED OUTCOME DETAILED HERE

---


## Evidence / Results of Testing

### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE

