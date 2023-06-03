# 2048
Java implementation of 2048 game

## Instructions

Setup: StdDraw (https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html#square-double-double-double-) must be added to the classpath.

Execution: java Game

The Game class runs 2048. Typing this execution in the command line begins a new 
game. To restart, repeat the execution in the command line.

Use wasd keys to shift and merge the tiles. If the 2048 tile is achieved, the game is won. If the board has filled with tiles and no merges are possible, the game is lost. Total number of moves made by the player are tracked and displayed once a game over condition is reached.

## Information on Java Files                                        
 
 Tile- defines the Tile object, which represents one of the squares in the 4x4 grid
 of 2048 
 
 Gameboard- defines the 2048 gameboard, which is represented as a 2D array of Tiles. 
 This class also tracks the number of moves made by the user
 
 Game- The program that actually runs the game. Instantiates a new Gameboard and 
 perpetuates the game through a loop and the detection of key presses.
 
 
