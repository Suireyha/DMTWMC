import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
  // fields
  Cell[][] cells = new Cell[20][20];
  
  // constructors
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(10+Cell.size*i, 10+Cell.size*j, i, j);
      }
    }
  }
  // methods
  public void paint(Graphics g, Point mousePos) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }

  public Optional<Cell> cellAtPoint(Point p){
    Optional<Cell> location = Optional.empty();
    for(Cell[] cellRow: cells){
      for(Cell cell: cellRow){
        if(cell.contains(p)){
          location = Optional.of(cell);
          return location; 
        }
      }
    }

    return location;
  }

}
