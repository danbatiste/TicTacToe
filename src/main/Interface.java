package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import board.Board;

class LabeledButton extends Button {
    public String label;
    LabeledButton(String label) {
        this.label = label;
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
                LabeledButton btn = new LabeledButton(Integer.toString(3*j + i + 1));
                btn.setText(btn.label);
                
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println();
                        for (board.Symbol[] ss : board.layout) { 
                            for (board.Symbol s : ss) {
                                System.out.print(s.value);
                                System.out.print(' ');
                            }
                            System.out.println('\n');
                        }
                    }
                });
                
                root.getChildren().add(btn);
            }
        }
        primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));
        primaryStage.show();
    }

}
