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

var currentPlayer = ""

var won = false

fun main() {

    /* 0 = empty | X = stone | $ = gold */

    getStartingInfo()

    val boardLayout = generateNewGame() // Starts the game by setting the board layout

    while (!won) {
        showGameBoard(boardLayout) // Displays the current board layout
        getInput(boardLayout)
        switchPlayer()
    }

    switchPlayer() //Must switch player back as after input is received player is switched automatically
    println("Congrats $currentPlayer, You won!")

}

fun getStartingInfo(){
    println("===========================================")
    println("            WELCOME TO OLD GOLD")
    println("===========================================")

    print("Howdy there partners! What is your name?, player one? :")
    name1 = readln()

    print("And what is your name, player two? :")
    name2 = readln()

    println("How big do you want the board to be? :")

    return

}

fun generateNewGame(): MutableList<Char> {

    val boardLayout = MutableList(20){'0'}

    currentPlayer = name1

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

    var pieceToMove = -1
    var validPieceToMove = false
    while (!validPieceToMove) { //Checks that there is a piece when the player tries to move

        print("$currentPlayer's turn: What piece would you like to move? ")
        pieceToMove = readln().toInt() -1 // Old pos of piece (-1 as index starts at 0 not 1)

        if (boardLayout[pieceToMove] == '0') {
            println("Sorry, there's no piece there!")
        }
        else {
            validPieceToMove = true
        }
    }

    if (pieceToMove == 0) {
        println("$currentPlayer removed piece 1!")

        if (boardLayout[0] == '$') {
            won = true
        }
    }

    else {
        print("Where do you want piece ${pieceToMove+1} to go? ")
        val pieceNewLocation = readln().toInt() -1 // New pos of piece (-1 as index starts at 0 not 1)

        if (boardLayout[pieceNewLocation] != '0') {
            println("Sorry partner, there is already a piece there!")
        }

        boardLayout[pieceNewLocation] = boardLayout[pieceToMove]
    }

    boardLayout[pieceToMove] = '0'

}

fun switchPlayer() {

    if (currentPlayer == name1) {
        currentPlayer = name2
    }
    else {
        currentPlayer = name1
    }
}