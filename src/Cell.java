import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Graphics2D; //Imported by Marvin to edit stroke value of cell borders

public class Cell extends Rectangle {
  Color gridColor = new Color(57, 58, 59);
  Color highlighted = new Color(127, 128, 129);
  static int size = 35;

  public Cell(int x, int y) {
    super(x, y, size, size);
  }

  public void paint(Graphics g, Point mousePos) {
    if(contains(mousePos)) {
      g.setColor(highlighted);
    } else {
      g.setColor(Color.WHITE);
    }

    g.fillRect(x, y, size, size);

    Graphics2D g2d = (Graphics2D) g; //Casting our graphics object to a g2d so we can add stroke below

    g2d.setColor(gridColor); //Colour of the grid borders
    g2d.setStroke(new BasicStroke(1.5f));
    g2d.drawRect(x, y, size, size);
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
}
