import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cell extends java.awt.Rectangle {
  // fields
  int x;
  int y;
  int row;
  int col;
  static int size = 35;

  // constructors
  public Cell(int inX, int inY, int r, int c) {
    super(inX, inY, size, size);
    x = inX;
    y = inY;
    this.row = r;
    this.col = c;
  }

  // methods
  public void paint(Graphics g, Point mousePos) {
    if(mousePos != null && super.contains(mousePos)){
      g.setColor(Color.GRAY);
    }
    else {
      g.setColor(Color.WHITE);
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
    
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }

  @Override
  public String toString(){
    return row + "," + col;
  }

}
