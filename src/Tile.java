/**
 * Name: Edmund Doerksen
 * Execution: java Tile
 * <p>
 * Description: defines the attributes and methods that can be performed on tiles,
 * which are the individual squares of the 2048 game
 **/
public class Tile {

    //instance variables
    private int number;  //the number on the tile

    // Constructor: Creates a new blank tile.
    public Tile() {
        this.number = 0;
    }

    /**
     * Constructor: Creates a new tile with a specific number value. If the input is
     * zero, then the tile will be blank
     * Inputs: integer number value
     */
    public Tile(int number) {
        this.number = number;
    }

    /**
     * Inputs: tile
     * Outputs: none
     * Description: merges the argument tile into the calling tile
     */
    public void merge(Tile t) {

        //updates the number of the calling tile
        this.number += t.number;

        //turns the merged argument tile blank
        t.number = 0;
    }

    /**
     * Inputs: none
     * Outputs: integer number value of the calling tile
     * Description: returns the number value of the calling tile
     */
    public int getNumber() {
        return this.number;
    }

    // sets the tile's number value to be the given input
    public void setNumber(int value) {
        this.number = value;
    }
}
