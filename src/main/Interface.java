package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import board.Board;

class NumberedButton extends Button {
    public int number;
    public String label;
    NumberedButton(int number) {
        this.number = number;
        this.label = Integer.toString(number);
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
        StackPane root = new StackPane();
        
        for (int j=0; j < gridHeight; j++) {
            for (int i=0; i < gridWidth; i++) {
                NumberedButton btn = new NumberedButton(3*j + i + 1);
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
                root.getChildren().add(btn);
            }
        }
        primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));
        primaryStage.show();
    }

}
