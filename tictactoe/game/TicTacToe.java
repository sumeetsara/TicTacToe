package ca.cmpt213.asn4.tictactoe.game;

import ca.cmpt213.asn4.tictactoe.ui.MouseButtonHandler;
import ca.cmpt213.asn4.tictactoe.ui.MouseImageHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The TicTacToe class creates and runs the TicTacToe game
 * A 2D array holds the values of "x" and "o" corresponding to their cell locations
 * If a user gets 4 of their symbols in a row the game ends and the label of which user is outputted
 * The user can choose to play the game again by clicking the "New Game" button
 */

public class TicTacToe extends Application {
    private final GridPane gridpane = new GridPane();
    public final Label label = new Label();
    private final int ROW_LENGTH = 4;
    private final int COLUMN_LENGTH = 4;
    private final int DEFAULT_ARR_VALUE = 3;
    private final int NUMBER_OF_CELLS = 16;
    private final int VALUE_TO_FILL_CELL_WITH_X = 0;
    private final int VALUE_TO_FILL_CELL_WITH_O = 1;
    public final int[][] arrGrid = new int [ROW_LENGTH][COLUMN_LENGTH];
    public boolean isGameOver = false;
    public int whoIsGoingFirst = 0;

    public TicTacToe() {
        fillArrayWithDefault();
    }

    public void fillArrayWithDefault() {
        for(int i = 0; i < ROW_LENGTH; i++) {
            for(int j = 0; j < COLUMN_LENGTH; j++) {
                arrGrid[i][j] = DEFAULT_ARR_VALUE;
            }
        }
    }

    private boolean isThereAWinner(int arrVal) {
        if(arrGrid[0][0] == arrVal && arrGrid[1][1] == arrVal && arrGrid[2][2] == arrVal && arrGrid[3][3] == arrVal) {
            return true;
        } else if(arrGrid[3][0] == arrVal && arrGrid[2][1] == arrVal && arrGrid[1][2] == arrVal && arrGrid[0][3] == arrVal) {
            return true;
        } else if(arrGrid[0][0] == arrVal && arrGrid[1][0] == arrVal && arrGrid[2][0] == arrVal && arrGrid[3][0] == arrVal) {
            return true;
        } else if(arrGrid[0][1] == arrVal && arrGrid[1][2] == arrVal && arrGrid[2][1] == arrVal && arrGrid[3][1] == arrVal) {
            return true;
        } else if(arrGrid[0][2] == arrVal && arrGrid[1][2] == arrVal && arrGrid[2][2] == arrVal && arrGrid[3][2] == arrVal) {
            return true;
        } else if(arrGrid[0][3] == arrVal && arrGrid[1][3] == arrVal && arrGrid[2][3] == arrVal && arrGrid[3][3] == arrVal) {
            return true;
        } else if(arrGrid[0][0] == arrVal && arrGrid[0][1] == arrVal && arrGrid[0][2] == arrVal && arrGrid[0][3] == arrVal) {
            return true;
        } else if(arrGrid[1][0] == arrVal && arrGrid[1][1] == arrVal && arrGrid[1][2] == arrVal && arrGrid[1][3] == arrVal) {
            return true;
        } else if(arrGrid[2][0] == arrVal && arrGrid[2][1] == arrVal && arrGrid[2][2] == arrVal && arrGrid[2][3] == arrVal) {
            return true;
        } else if(arrGrid[3][0] == arrVal && arrGrid[3][1] == arrVal && arrGrid[3][2] == arrVal && arrGrid[3][3] == arrVal) {
            return true;
        }
        return false;
    }

    public boolean checkWhoWon(int turn) {
        boolean xWonTheGame = isThereAWinner(VALUE_TO_FILL_CELL_WITH_X);
        boolean oWonTheGame = isThereAWinner(VALUE_TO_FILL_CELL_WITH_O);
        if(xWonTheGame) {
            label.setText("X Won!");
            gridpane.add(label,3,5);
            return true;
        } else if(oWonTheGame) {
            label.setText("O Won!");
            gridpane.add(label,3,5);
            return true;
        } else if(turn == NUMBER_OF_CELLS - 1) {
            label.setText("It's a Tie!");
            gridpane.add(label,3,5);
            return true;
        }
        return false;
    }

    public void makeGrid() {
        for(int i = 0; i < ROW_LENGTH; i++) {
            for(int j = 0; j < COLUMN_LENGTH; j++) {
                ImageView defaultBack = new ImageView(new Image("file:src/ca/cmpt213/asn4/tictactoe/game/default.png"));
                defaultBack.setFitHeight(150);
                defaultBack.setFitWidth(150);
                gridpane.add(defaultBack,i,j);
                defaultBack.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseImageHandler(this,defaultBack));
            }
        }
    }

    public static void main(String[] args)
    {
        // Launch the application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
        gridpane.setHgap(20);
        gridpane.setVgap(20);
        gridpane.setAlignment(Pos.CENTER);
        Button button = new Button("New Game");
        button.setOnAction(new MouseButtonHandler(this));
        button.setPrefSize(100,25);
        gridpane.add(button,0,5);
        makeGrid();
        Scene scene = new Scene(gridpane, 750, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
