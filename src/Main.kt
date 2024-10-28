/**
 * ------------------------------------------------------------------------
 * PROJECT NAME HERE
 * Level 2 programming project
 *
 * by HARRY STRINGER
 *
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */

import kotlin.random.Random

var name1 = ""
var name2 = ""


var boardSize = 20

fun main() {

    /* _ = empty | X = stone | $ = gold */

    var won = false

    getStartingInfo() 

    var currentPlayer = name1

    val boardLayout = generateNewGame() // Starts the game by setting the board layout

    while (!won) {
        showGameBoard(boardLayout) // Displays the current board layout
        won = getInput(boardLayout, currentPlayer)
        if (!won) {
            currentPlayer = switchPlayer(currentPlayer)
        }
    }

    println("Congrats $currentPlayer, You won!")

}

fun getStartingInfo(){
    println("===========================================")
    println("            WELCOME TO OLD GOLD")
    println("===========================================")

    while (true) {
        print("Howdy there partners! Is this your first time playing Old Gold? (Y/N) :")
        val playedBefore = readln().capitalize()
        if (playedBefore == "Y") {
            print("The aim of the game is to be the player that removes the gold coin, represented by ")
            println("$".yellow())
            println("In order to do this, you can move any of the pieces on the board to the left.")
            println("You can move pieces as far as you like, but pieces can't jump over other pieces.")
            print("Obstacle pieces are represented by ")
            println("X".red())
            println("Once a piece is at the left most position, it can be removed.")
            println("You'll get the hang of it pretty quick - it's easy to learn, but hard to master.")
            println("Don't worry, if you make an error I'll correct you.")
            println("Have fun!")
            break
        }
        else if (playedBefore == "N") {
            println("OK, let's get right into playing!")
            break
        }
        else {
            println("Please just type 'Y' for yes or 'N' for no")
        }
    }

    while (true) {
        print("What is your name?, player one? :")
        name1 = readln().capitalize()
        if (name1 == "") {
            println("Your name can't be empty!")
        } else {break}
    }

    while (true) {
        print("And what is your name, player two? :")
        name2 = readln().capitalize()
        if (name2 == "") {
        println("Your name can't be empty!")
        }
        else if (name2 == name1) {
            println("You can't both have the same name!")
        } else {break}
    }

    println("How big do you want your board to be? Minimum of 10, Maximum of 30. I recommend 20.")

    while (true) {
        try {
            print("What size do you want? :")
            boardSize = readln().toInt()
        } catch (e: Exception) {
            println("Please enter a valid number!")
            continue
        }
        if (boardSize > 30) {
            println("The board cannot be longer than 30!")
            continue
        }
        else if (boardSize < 10) {
            println("The board cannot be smaller than 10")
            continue
        }
        return
    }
}

fun generateNewGame(): MutableList<Char> {

    val boardLayout = MutableList(boardSize){'_'}

    var xNo = 0
    var goldPlaced = false

    while (xNo < 5) {
        val index = Random.nextInt(boardSize)
        if(boardLayout[index] == '_') {
            boardLayout[index] = 'X'
            xNo++
        }
    }

    while (!goldPlaced) {
        val index = Random.nextInt(boardSize)
        if(boardLayout[index] == '_') {
            boardLayout[index] = '$'
            goldPlaced = true
        }
    }

    return boardLayout
}

fun showGameBoard(boardLayout: MutableList<Char> ) {

    //Build the top line
    var x = 1
    print("╤════".repeat(boardSize))
    println("╤")

    //Show the index number
    for (item in boardLayout) {
        print("│ %-2d ".format(x))
        x++
    }
    println("│")

    //Build the middle line
    print("╪════".repeat(boardSize))
    println("╪")

    //Show the pieces on the board
    for (item in boardLayout) {

        val colouredItem = when (item) {
            'X' -> item.toString().red()
            '$' -> item.toString().yellow()
            else -> item.toString().grey()
        }

        print("│ %-2s  ".format(colouredItem))
        x++
    }
    println("│")

    //Build the bottom line
    print("╧════".repeat(boardSize))
    println("╧")
}

fun getInput(boardLayout: MutableList<Char>, currentPlayer: String): Boolean {

    var pieceToMove = -1
    var validPieceToMove = false
    while (!validPieceToMove) { //Checks that there is a piece when the player tries to move

        try { //Guarantees that the player inputs a number
            print("$currentPlayer's turn: What piece would you like to move? ")
            pieceToMove = readln().toInt() - 1 // Old pos of piece (-1 as index starts at 0 not 1)


            if (pieceToMove > boardSize) {
                println("nope")
            }
            else if (boardLayout[pieceToMove] == '_') {
                println("Sorry, there's no piece there!")
            }
            else if ( pieceToMove != 0 && boardLayout[pieceToMove-1] != '_' ) {
                println("That piece has no valid moves!")
            }
            else {
                validPieceToMove = true
            }
        }
        catch (e: NumberFormatException) {
            println("Please enter a number!")
        }
    }

    //If player is removing a piece
    if (pieceToMove == 0) {
        println("$currentPlayer removed piece 1!")

        if (boardLayout[0] == '$') {
            return true// Sets won to true
        }
        else {
            boardLayout[0] = '_'
        }
    }

    //If player is moving a piece
    else {

        var validLocationPicked = false

        while (!validLocationPicked) {
            print("Where do you want piece ${pieceToMove+1} to go? ")
            val pieceNewLocation = readln().toInt()  -1// New pos of piece (-1 as index starts at 0 not 1)

            if (pieceNewLocation >= pieceToMove) {
                println("You must move the piece to the left!")
            }
            else if (boardLayout[pieceNewLocation] != '_') {
                println("There is already a piece there!")
            }
            else {
                //Checks that there are no Xs blocking the path
                var canMoveWithoutJumping = true
                for (i in (pieceNewLocation + 1)..<pieceToMove) {
                    if (boardLayout[i] != '_') {  // If any position between new and old isn't empty
                        canMoveWithoutJumping = false
                        break
                    }
                }
                if (!canMoveWithoutJumping) {
                    println("You cannot jump over other pieces!")
                }
                else {
                    validLocationPicked = true
                    boardLayout[pieceNewLocation] = boardLayout[pieceToMove]
                    boardLayout[pieceToMove] = '_'

                }
            }
        }
    }

    return false//didn't win, so won is false

}

fun switchPlayer(currentPlayer: String):String {

    return if (currentPlayer == name1) {
        name2
    } else {
        name1
    }
}