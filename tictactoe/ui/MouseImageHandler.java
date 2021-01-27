package ca.cmpt213.asn4.tictactoe.ui;

import ca.cmpt213.asn4.tictactoe.game.TicTacToe;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *  The MouseImageHandler is in charge of the mouse clicks on the grid cells when the user is playing the game
 *  First the turn is determined when the user clicks on a grid cell to always output an "x" first then a "o"
 *  If the first user("x") clicks on a cell, that cell goes from a blank cell to a cell filled with an "x". The array location is filled with a 0
 *  If the second user("o") clicks on a cell, that cell goes from a blank cell to a cell filled with an "o". The array location is filled with a 1
 *  After the user clicks on a cell, the cell is now locked meaning it can not change images
 *  The moment someone wins the game, the game ends and the user can not click on any cell
 */

public class MouseImageHandler implements EventHandler<MouseEvent> {
    private TicTacToe game;
    private ImageView defaultBackGround;
    public MouseImageHandler(TicTacToe ticTacToe, ImageView backGround) {
        game = ticTacToe;
        defaultBackGround = backGround;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(game.isGameOver) {
            return;
        }
        // https://stackoverflow.com/questions/31095954/how-to-get-gridpane-row-and-column-ids-on-mouse-entered-in-each-cell-of-grid-in
        ImageView source = (ImageView)mouseEvent.getSource();
        int columnIndex = GridPane.getColumnIndex(source);
        int rowIndex = GridPane.getRowIndex(source);

        if(game.whoIsGoingFirst % 2 == 0) {
            ((ImageView)mouseEvent.getSource()).setImage(new Image("file:src/ca/cmpt213/asn4/tictactoe/game/x.png"));
            game.arrGrid[rowIndex][columnIndex] = 0;
        } else {
            ((ImageView)mouseEvent.getSource()).setImage(new Image("file:src/ca/cmpt213/asn4/tictactoe/game/o.png"));
            game.arrGrid[rowIndex][columnIndex] = 1;
        }
        defaultBackGround.setDisable(true);
        if(game.checkWhoWon(game.whoIsGoingFirst)) {
            game.isGameOver = true;
        }
        game.whoIsGoingFirst++;
    }
}
