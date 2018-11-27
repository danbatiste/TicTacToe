package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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
    public void start(Stage primaryStage) {
        primaryStage.setTitle(board.getTurn() + "'s turn");
        GridPane root = new GridPane();
        //  Sets column width
        for (int n=0; n < gridWidth; n++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100/gridHeight);
            root.getColumnConstraints().add(column);
        }   
        //  Sets row height
        for (int n=0; n < gridHeight; n++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100/gridHeight);
            root.getRowConstraints().add(row);
        } 
        List<NumberedButton> Buttons = new ArrayList<NumberedButton>();
        for (int j=0; j < gridHeight; j++) {
            for (int i=0; i < gridWidth; i++) {
                NumberedButton btn = new NumberedButton(i, j);
                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                Buttons.add(btn);
                btn.setText(board.nothing.value);
                int x = i;
                int y = j;
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        btn.setText(board.chooseGrid(x, y));
                        primaryStage.setTitle(board.print());
                    }
                }); 
                root.add(btn, btn.i, btn.j, 1, 1);
            }
        }
        primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));
        primaryStage.show();
    }

}
