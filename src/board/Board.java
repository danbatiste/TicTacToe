package board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public int HEIGHT = 3;
    public int WIDTH = 3;
    public boolean xTurn = true;
    public String winner = "";
    
    public Board(int HEIGHT, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
    }
    
    public Symbol nothing = new Symbol("");
    public Symbol o = new Symbol("O");
    public Symbol x = new Symbol("X");
    
    public Symbol[][] layout = {
            {nothing, nothing, nothing},
            {nothing, nothing, nothing},
            {nothing, nothing, nothing}
    };
    
    public String getTurn() {
        if (xTurn) {
            return x.value;
        } else {
            return o.value;
        }
    }
    
    public List<List<Symbol>> layoutAsList() {
        List<List<Symbol>> layoutListList = new ArrayList<List<Symbol>>();
        for (Symbol[] row : layout) {
            layoutListList.add(Arrays.asList(row));
        }
        return layoutListList;
    }
    
    private boolean isAWinningRow(List<Symbol> row) {
        Symbol firstElement = row.get(0);
        for (Symbol s : row) {
            if ((s.value != firstElement.value) || (s.value == nothing.value)) {
                return false;
            }
        }
        return true;
    }
    
    private List<List<Symbol>> getRows() {
        List<List<Symbol>> allRows = new ArrayList<List<Symbol>>();
        // Gets horizontal rows
        for (int j=0; j < HEIGHT; j++) {
            List<Symbol> hRow = new ArrayList<Symbol>();
            for (int i=0; i < WIDTH; i++) {
                hRow.add(layout[i][j]);
            }
            allRows.add(hRow);
        }
        // Gets vertical rows
        for (int i=0; i < WIDTH; i++) {
            List<Symbol> vRow = new ArrayList<Symbol>();
            for (int j=0; j < HEIGHT; j++) {
                vRow.add(layout[i][j]);
            }
            allRows.add(vRow);
        }
        //Gets diagonal rows
        List<Symbol> dRow1 = new ArrayList<Symbol>();
        int j = 0;
        for (int i=0; i < WIDTH && j < HEIGHT; i++) {
            dRow1.add(layout[i][j]);
            j++;
        }
        allRows.add(dRow1);
        
        List<Symbol> dRow2 = new ArrayList<Symbol>();
        j = HEIGHT-1;
        for (int i=0; i < WIDTH && j >=0; i++) {
            dRow2.add(layout[i][j]);
            j--;
        }
        allRows.add(dRow2);
        return allRows;
    }

    public boolean hasWinner() {
        if (this.winner != "") {
            System.out.println(this.winner + " is the winner!");
            return true;
        }
        for (List<Symbol> row : this.getRows()) {
            if (isAWinningRow(row)) {
                System.out.println(row.get(0).value + " is the winner!");
                this.winner = row.get(0).value;
                return true;
            }
        }
        return false;
    }
    
    
    public boolean isOccupied(int i, int j) {
        return !(layout[i][j].value == nothing.value);
    }
    
    
    public String chooseGrid(int i, int j) {
       String toReturn;
       if (!isOccupied(i, j)) {
           if (xTurn) {
               layout[i][j] = x;
               toReturn = x.value;
           } else {
               layout[i][j] = o;
               toReturn = o.value;
           }
           this.xTurn = !xTurn;
           return toReturn;
       }
       return nothing.value;
    }
    
    // Returns title of the game window
    public String print() {
        System.out.println();
        for (int j=0; j < HEIGHT; j++) {
            for (int i=0; i < WIDTH; i++) {
                System.out.print(layout[i][j].value);
                System.out.print(' ');
            }
            System.out.println('\n');
        }
        if (this.hasWinner()) {
            return winner + " wins!";
        } else {
            return getTurn() + "'s turn";
        }
        
    }
    
}