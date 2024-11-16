# OLD GOLD

### Level 2 Programming Project by HARRY STRINGER

This project is assessed against [AS91896](https://www.nzqa.govt.nz/nqfdocs/ncea-resource/achievements/2019/as91896.pdf)

## Project Description

Old Gold is a two-player, turn-based strategy game where the goal is to remove a gold coin from a one-dimensional grid. 
Players take turns moving coins to the left, following simple rules: they cannot jump over other coins, and only the coin at the leftmost position can be removed.
The game is easy to learn but challenging to master, as players must think strategically to position the gold coin for removal.
Each game can vary in grid size and obstacle placement, keeping gameplay dynamic and adding layers of difficulty to this deceptively simple puzzle.

## Source Code

The project is written in [Kotlin](https://kotlinlang.org/)

The main source file is [Main.kt](src/Main.kt)


## Documentation

Evidence of testing can be found in [testing.md](testing.md)


## Running the Program

You can either clone this whole repo, open it using [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) and run from source; or you can run the compiled program:

1. Install the [Java runtime (JRE)](https://www.java.com/en/download/) installed to run the program.
2. Go to the [out/artifacts](out/artifacts) folder
3. Locate and download the compiled **JAR file** (e.g. FILENAME.jar)
4. Run the following command:
    ```bash
    java -jar FILENAME.jar
    ```
