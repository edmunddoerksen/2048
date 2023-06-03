import java.awt.*;

/**
 * Name: Edmund Doerksen
 * Execution: java Gameboard
 * <p>
 * Description: defines the attributes of and methods that can be performed on the
 * 2048 gameboard
 **/
public class Gameboard {

    //instance variables
    private Tile[][] board; //2D array representation of the game
    private int numMoves; //tracks the number of moves the player has made

    /**
     * Constructor: Creates a blank gameboard and initializes the move count
     */
    public Gameboard() {

        //create 2D array to store game
        board = new Tile[4][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile(0);
            }
        }

        //sets move count to zero
        numMoves = 0;
    }

    /**
     * Constructor: Creates a deep copy of the inputted gameboard. This functionality
     * is used in the Game class to check whether a player's moves have caused any
     * tiles to shift
     * Input: gameboard
     */
    public Gameboard(Gameboard g) {
        board = new Tile[4][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile(g.board[i][j].getNumber());
            }
        }
    }

    /*
     * Inputs: a gameboard
     * Output: true if gameboards have the same tile arrangement; false otherwise
     * Description: returns true if the calling gameboard is identical to the
     * argument gameboard. Two gameboards are considered to be identical if their 2D
     * tile arrays have identical contents. move count is irrelevant
     */
    public boolean compareGameboard(Gameboard g) {
        for (int i = 0; i < g.board.length; i++) {
            for (int j = 0; j < g.board[i].length; j++) {
                if (this.board[i][j].getNumber() != g.board[i][j].getNumber()) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Inputs: none
     * Output: true if a game ending condition is met; false otherwise
     * Description: returns true if the game is over. There are two game ending
     * conditions: either the 2048 tile has been generated or the board is full
     * and tile mergers cannot be made to alter the board. Additionally, if a game
     * ending condition is met, text announcing the fact is displayed on the game
     * screen.
     */
    public boolean isGameOver() {

        //Defines win condition: 2048 tile has been generated
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getNumber() == 2048) {

                    /* Iterates through board array. If 2048 tile is found, game
                     * is immediately ended and a win message is displayed on screen
                     */
                    StdDraw.text(0.5, 0.5, "Congrats, you beat 2048!");
                    StdDraw.text(0.5, 0.25, "Move count: " + numMoves);
                    return true;
                }
            }
        }

        /* Defines the opposite of the loss condition: board is not full and
         * is still alterable via tile mergers
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {

                /* This is an OR boolean operator. Function will return false
                 * (i.e. the game has not been lost) if there are blank tiles OR
                 * there are still possible merges (i.e. two adjacent tiles in any
                 * row or column have the same number value)
                 */
                if ((board[i][j].getNumber() == 0 || board[i][j + 1].getNumber() ==
                        0) || (board[i][j].getNumber() == board[i][j + 1].getNumber() ||
                        board[j][i].getNumber() == board[j + 1][i].getNumber())) {
                    return false;
                }
            }
        }

        /* The game is deemed to be lost if neither the win condition nor the
         * not-lost condition have been met
         */
        StdDraw.text(0.5, 0.5, "Sorry, you lost.");
        StdDraw.text(0.5, 0.25, "Move count: " + numMoves);
        return true;
    }

    /*
     * Description: displays the present condition of the game
     */
    public void draw() {

        //clears the canvas and makes the font of readable size
        StdDraw.clear();
        Font font = new Font("Arial", Font.PLAIN, 32);
        StdDraw.setFont(font);

        //draws the game grid

        StdDraw.line(0, 0, 0, 1);
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(0, 0.25, 1, 0.25);
        StdDraw.line(0, 0.5, 1, 0.5);
        StdDraw.line(0, 0.75, 1, 0.75);
        StdDraw.line(0.25, 0, 0.25, 1);
        StdDraw.line(0.5, 0, 0.5, 1);
        StdDraw.line(0.75, 0, 0.75, 1);
        StdDraw.line(1, 0, 1, 1);
        StdDraw.line(0, 1, 1, 1);

        //sets initial coordinates for drawing the numbered Tile labels
        double xCoord = 0.125;
        double yCoord = 0.875;

        //iterates through the 2D Tile array to draw the Tile labels
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                /* Tile label is not drawn if its number value is zero. This allows
                 * for a zero number value to simulate a blank tile.
                 * For nonzero-valued tiles, tile color depends on the specific value
                 */
                int value = board[i][j].getNumber();
                if (value != 0) {
                    if (value == 2) {
                        StdDraw.setPenColor(255, 230, 204);
                    }
                    if (value == 4) {
                        StdDraw.setPenColor(251, 206, 177);
                    }
                    if (value == 8) {
                        StdDraw.setPenColor(255, 153, 102);
                    }
                    if (value == 16) {
                        StdDraw.setPenColor(232, 172, 65);
                    }
                    if (value == 32) {
                        StdDraw.setPenColor(255, 128, 0);
                    }
                    if (value == 64) {
                        StdDraw.setPenColor(191, 87, 0);
                    }
                    if (value == 128) {
                        StdDraw.setPenColor(195, 176, 145);
                    }
                    if (value == 256) {
                        StdDraw.setPenColor(192, 192, 192);
                    }
                    if (value == 512) {
                        StdDraw.setPenColor(255, 215, 0);
                    }
                    if (value == 1024) {
                        StdDraw.setPenColor(85, 172, 165);
                    }
                    StdDraw.filledSquare(xCoord, yCoord, 0.124);
                    StdDraw.setPenColor(Color.BLACK);
                    /* Tile text is drawn after color shading is added so as not to be obscured
                     * by filled square
                     */
                    String displayedText = "" + value;
                    StdDraw.text(xCoord, yCoord, displayedText);
                }
                xCoord += 0.25;
            }
            xCoord = 0.125;
            yCoord -= 0.25;
        }
    }

    /*
     * Inputs: 1D tile array representing a row or column of the 2D board array
     * Outputs: none
     * Description: shifts blank tiles one space towards the right of a row if they
     * are located to the left of a numbered tile
     */
    public static void gatherNumbers(Tile[] tileRow) {
        for (int i = 0; i < tileRow.length - 1; i++) {
            if (tileRow[i].getNumber() == 0 || tileRow[i + 1].getNumber() == 0) {
                tileRow[i].merge(tileRow[i + 1]);
            }
        }
    }

    /*
     * Inputs: 1D tile array representing a row or column of the 2D board array
     * Outputs: none
     * Description: shifts the numbered tiles towards the left of a row. Merges tiles
     * as necessary
     */
    public static void shiftRowLeft(Tile[] tileRow) {

        /* Shfits all numbered tiles to the left of a row and all blank tiles to the
         * right. gatherNumbers must be called a minimum of three times to accomplish
         * this.
         */
        gatherNumbers(tileRow);
        gatherNumbers(tileRow);
        gatherNumbers(tileRow);

        /* Merges number tiles that are adjacent and identical. If three identical
         * tiles are found in a row, the leftmost two will merge with the third
         * remaining unchanged. If four identical tiles are in a row, the first and
         * second merge, and the third and fourth merge.
         */
        for (int i = 0; i < tileRow.length - 1; i++) {
            if (tileRow[i].getNumber() == tileRow[i + 1].getNumber()) {
                tileRow[i].merge(tileRow[i + 1]);
            }
        }

        /* Shifts blank tiles to the right (and numbered tiles to the left) if any
         * blank tiles appear to the left of any numbered tiles as a result of the
         * merges.
         */
        gatherNumbers(tileRow);
    }

    /*
     * Description: updates the board array when its numbers are shifted to the left
     */
    public void moveLeft() {
        for (int i = 0; i < board.length; i++) {
            shiftRowLeft(board[i]);
        }
    }

    /*
     * Description: updates the board array when its numbers are shifted to the right
     */
    public void moveRight() {

        /* reverses board array rows so that a right shift on the original array can
         * be simulated via a left shift on the reversed array
         */
        Tile[][] shiftRightHelper = new Tile[4][4];
        for (int i = 0; i < shiftRightHelper.length; i++) {
            for (int j = 0; j < shiftRightHelper[i].length; j++) {
                shiftRightHelper[i][j] = board[i][shiftRightHelper[i].length -
                        1 - j];
            }
        }

        //runs left shift function on each row of the reversed array
        for (int i = 0; i < board.length; i++) {
            shiftRowLeft(shiftRightHelper[i]);
        }

        //reverses array again to produce new right shifted gameboard
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = shiftRightHelper[i][board[i].length - 1 - j];
            }
        }
    }

    /*
     * Description: updates the board array when its numbers are shifted down
     */
    public void moveDown() {

        //rotates array 90 degrees clockwise
        Tile[][] shiftDownHelper = new Tile[4][4];
        for (int i = 0; i < shiftDownHelper.length; i++) {
            for (int j = 0; j < shiftDownHelper[i].length; j++) {
                shiftDownHelper[i][j] = board[shiftDownHelper[i].length - 1 - j][i];
            }
        }

        //runs left shift function on the rows of the rotated array
        for (int i = 0; i < shiftDownHelper.length; i++) {
            shiftRowLeft(shiftDownHelper[i]);
        }

        //undos array rotation to produce new down shifted gameboard
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = shiftDownHelper[j][board[i].length - 1 - i];
            }
        }
    }

    /*
     * Description: updates the board array when its numbers are shifted up
     */
    public void moveUp() {

        //reverses array and rotates 90 degrees counterclockwise
        Tile[][] shiftUpHelper = new Tile[4][4];
        for (int i = 0; i < shiftUpHelper.length; i++) {
            for (int j = 0; j < shiftUpHelper[i].length; j++) {
                shiftUpHelper[i][j] = board[j][i];
            }
        }

        //runs left shift function on the rows of the altered array
        for (int i = 0; i < shiftUpHelper.length; i++) {
            shiftRowLeft(shiftUpHelper[i]);
        }

        //undos array reversal and rotation to produce new up shifted gameboard
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = shiftUpHelper[j][i];
            }
        }
    }

    /*
     * Description: puts two numbered tiles on the board at the start of the game
     */
    public void addNumberedTiles() {
        int generationIndex = (int) (Math.random() * 16);
        int generationIndex2 = (int) (Math.random() * 16);

        //ensures that the locations of the numbered tiles will be different
        while (generationIndex2 == generationIndex) {
            generationIndex2 = (int) (Math.random() * 16);
        }

        //inserts the numbered tiles on the board
        int targetIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getNumber() == 0 && (targetIndex ==
                        generationIndex || targetIndex == generationIndex2)) {
                    board[i][j].setNumber(randomTileValue());
                    targetIndex++;
                } else if (board[i][j].getNumber() == 0) {
                    targetIndex++;
                }
            }
        }
    }

    /*
     * Description: changes the value of an empty tile to be either 2 or 4 and
     * increments the move count by one
     */
    public void generateNewTile() {

        //counts the number of empty tiles
        int emptyTileCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getNumber() == 0) {
                    emptyTileCount++;
                }
            }
        }

        /* Iterates through the 2048 board, inserting the numbered tile at the
         * (n+1)th blank tile that the program comes across, where n is a randomly
         * generated index
         */
        int generationIndex = (int) (Math.random() * emptyTileCount);
        int targetIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getNumber() == 0 && (targetIndex ==
                        generationIndex)) {
                    board[i][j].setNumber(randomTileValue());
                    targetIndex++;
                } else if (board[i][j].getNumber() == 0) {
                    targetIndex++;
                }
            }
        }

        //increments the move count by one
        numMoves++;
    }

    /*
     * Inputs: none
     * Outputs: integer tile number value
     * Description: When a new tile is generated in 2048, this function ensures that
     * its numerical value has a 90% chance of being 2, and a 10% chance of being 4
     */
    public static int randomTileValue() {
        double randomNum = Math.random();
        if (randomNum > 0.9) {
            return 4;
        } else {
            return 2;
        }
    }
}
