package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import board.Board;

class NumberedButton extends Button {
    public int i;
    public int j;
    public String label;
    NumberedButton(int i, int j) {
        this.i = i;
        this.j = j;
        this.label = Integer.toString(3*j + i + 1);
    }
}

public class Interface extends Application {
    
    public static int sceneHeight = 300;
    public static int sceneWidth = 300;
    public static int gridHeight = 3;
    public static int gridWidth = 3;
    
    public Board board = new Board(gridHeight, gridWidth);
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage ) {
        primaryStage.setTitle("TicTacToe");
        GridPane root = new GridPane();
        
        for (int j=0; j < gridHeight; j++) {
            for (int i=0; i < gridWidth; i++) {
                NumberedButton btn = new NumberedButton(i, j);
                btn.setText(btn.label);
                int x = i;
                int y = j;
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        board.chooseGrid(x, y);
                        board.print();
                    }
                }); 
                root.add(btn, btn.i, btn.j, 1, 1);
            }
        }
        primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));
        primaryStage.show();
    }

}
