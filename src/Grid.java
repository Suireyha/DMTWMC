import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
  Cell[][] cells = new Cell[20][20];
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(10+Cell.size*i, 10+Cell.size*j);
      }
    }
  }

  public void paint(Graphics g, Point mousePos) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
    Cell cellFound = cellAtPoint(mousePos).get();
    String cellPos = cellFound.x + ", " + cellFound.y;
    g.drawString(cellPos, 750, 360);
  }

  public Cell cellAtColRow(int c, int r) {
    return cells[c][r];
  }

  public Optional<Cell> cellAtPoint(Point p){
    Optional<Cell> location = Optional.empty();
    if(p != null){
      if(p.getX() >= 10 && p.getX() <= 710){
        if(p.getY() >= 10 && p.getY() <= 710){
          int cellX = (int)(p.getX() / 35);
          int cellY = (int)(p.getY() / 35);
          location = Optional.of(cellAtColRow(cellX, cellY));
        }
      }
    }
    return location;
  }
}
