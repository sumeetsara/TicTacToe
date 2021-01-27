package ca.cmpt213.asn4.tictactoe.ui;

import ca.cmpt213.asn4.tictactoe.game.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *  MouseButtonHandler class is in charge of the button to start a new game
 *  If the user clicks the new game button, the action is handeled by resting all fields to default and calling the makingGrid() method to play the game
 */

public class MouseButtonHandler implements EventHandler<ActionEvent> {
    private TicTacToe game;
    public MouseButtonHandler(TicTacToe ticTacToe) {
        game = ticTacToe;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        game.whoIsGoingFirst = 0;
        game.isGameOver = false;
        game.label.setText("");
        game.fillArrayWithDefault();
        game.makeGrid();
    }
}
