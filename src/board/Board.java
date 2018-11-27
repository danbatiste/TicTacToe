package board;

public class Board {
    public int HEIGHT = 3;
    public int WIDTH = 3;
    public boolean xTurn = true;
    
    public Board(int HEIGHT, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
    }
    
    Symbol nothing = new Symbol("---");
    Symbol o = new Symbol(" O ");
    Symbol x = new Symbol(" X ");
    
    public Symbol[][] layout = {
            {nothing, nothing, nothing},
            {nothing, nothing, nothing},
            {nothing, nothing, nothing}
    };
    
    public boolean isOccupied(int i, int j) {
        return !(layout[i][j].value == "---");
    }
    
    public void chooseGrid(int i, int j) {
       if (!isOccupied(i, j)) {
           if (xTurn) {
               layout[i][j] = x;
           } else {
               layout[i][j] = o;
           }
           this.xTurn = !xTurn;
       }
    }
    
    public void print() {
        System.out.println();
        for (int j=0; j < HEIGHT; j++) {
            for (int i=0; i < WIDTH; i++) {
                System.out.print(layout[i][j].value);
                System.out.print(' ');
            }
            System.out.println('\n');
        }
    }
    
}