package board;

public class Board {
    public int HEIGHT = 3;
    public int WIDTH = 3;
    public boolean xTurn = true;
    
    public Board(int HEIGHT, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
    }
    
    Symbol nothing = new Symbol(null);
    Symbol o = new Symbol(" O ");
    Symbol x = new Symbol(" X ");
    
    public Symbol[][] layout = {
            {nothing, nothing, nothing},
            {nothing, nothing, nothing},
            {nothing, nothing, nothing}
    };
    
    public void takeTurn() {
        
    }
    
}