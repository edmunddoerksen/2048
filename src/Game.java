/**
 * Name: Edmund Doerksen
 * Execution: java Game
 * <p>
 * Description: This program runs a game of 2048
 **/
public class Game {
    public static void main(String[] args) {

        /* instantiates gameboard, generates starting tiles, and then displays the
         * gameboard
         */
        Gameboard newGame = new Gameboard();
        newGame.addNumberedTiles();
        newGame.draw();

        //Game Loop: runs continuously if gameover conditions are not met
        while (!newGame.isGameOver()) {
            if (StdDraw.hasNextKeyTyped()) {

                /* stores the user's key press and creates a deep copy of the
                 * gameboard's present state for comparison to the gameboard after
                 * one of the four shifting functions is called
                 */
                char pressedKey = StdDraw.nextKeyTyped();
                Gameboard beforeMove = new Gameboard(newGame);

                //'w' key press corresponds to an upward shift of the numbered tiles
                if (pressedKey == 'w') {
                    newGame.moveUp();
                    /* Game does not update unless the player's move has actually
                     * caused at least one tile to move. The same condition applies
                     * for all four valid key presses
                     */
                    if (!newGame.compareGameboard(beforeMove)) {
                        newGame.generateNewTile();
                        newGame.draw();
                    }
                }

                //'a' key press is a leftward shift
                if (pressedKey == 'a') {
                    newGame.moveLeft();
                    if (!newGame.compareGameboard(beforeMove)) {
                        newGame.generateNewTile();
                        newGame.draw();
                    }
                }

                //'s' key press is a downward shift
                if (pressedKey == 's') {
                    newGame.moveDown();
                    if (!newGame.compareGameboard(beforeMove)) {
                        newGame.generateNewTile();
                        newGame.draw();
                    }
                }

                //'d' key press is a rightward shift
                if (pressedKey == 'd') {
                    newGame.moveRight();
                    if (!newGame.compareGameboard(beforeMove)) {
                        newGame.generateNewTile();
                        newGame.draw();
                    }
                }
            }
        }
    }
}
