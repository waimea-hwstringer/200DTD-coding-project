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

var currentPlayer = 1

fun main() {

    println("===================")
    println("WELCOME TO OLD GOLD")
    println("===================")

    /* 0 = empty | X = stone | $ = gold */

    val boardLayout = generateNewGame() // Starts the game by setting the board layout

    showGameBoard(boardLayout) // Displays the current board layout in the table

    getInput(boardLayout)

}

fun generateNewGame(): MutableList<Char> {

    val boardLayout = MutableList(20){'0'}

    currentPlayer = 1

    var xNo = 0
    var goldPlaced = false



    while (xNo < 5) {
        val index = Random.nextInt(20)
        if(boardLayout[index] == '0') {
            boardLayout[index] = 'X'
            xNo++
        }
    }

    while (!goldPlaced) {
        val index = Random.nextInt(20)
        if(boardLayout[index] == '0') {
            boardLayout[index] = '$'
            goldPlaced = true
        }
    }

    return boardLayout
}

fun showGameBoard(boardLayout: MutableList<Char> ) {

    //Build the top line
    var x = 1
    print("╤════".repeat(boardLayout.size))
    println("╤")

    //Show the index number
    for (item in boardLayout) {
        print("│ %-2d ".format(x))
        x++
    }
    println("│")

    //Build the middle line
    print("╪════".repeat(boardLayout.size))
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
    print("╧════".repeat(boardLayout.size))
    println("╧")
}

fun getInput(boardLayout: MutableList<Char>) {

    print("Player $currentPlayer's turn: What piece would you like to move? ")
    val pieceToMove = readln().toInt() -1 // Old pos of piece (-1 as index starts at 0 not 1)

    print("Where do you want piece $pieceToMove to go? ")
    val pieceNewLocation = readln().toInt() -1 // New pos of piece (-1 as index starts at 0 not 1)


    val temp = boardLayout[pieceNewLocation]

    boardLayout[pieceNewLocation] = boardLayout[pieceToMove]

    boardLayout[pieceToMove] = temp

}