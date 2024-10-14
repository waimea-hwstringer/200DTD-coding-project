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

fun main() {

    println("===================")
    println("WELCOME TO OLD GOLD")
    println("===================")
    /* 0 = empty | X = stone | $ = gold */

    generateNewGame()

    showGameBoard()
}

fun generateNewGame(): MutableList<Char> {

    val boardLayout = MutableList(20){'0'}

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

    //Build the top
    var x = 1
    print("╤═══".repeat(boardLayout.size))
    println("╤")

    //Show the index number
    for (item in boardLayout) {
        print("│ %-1d ".format(x))
        x++
    }
    println("│")

    //Build the middle
    print("╪═══".repeat(boardLayout.size))
    println("╪")

    //Show the pets
    for (item in boardLayout) {
        print("│ %s ".format(item))
        x++
    }
    println("│")

    //Build the bottom
    print("╧═══".repeat(boardLayout.size))
    println("╧")
}