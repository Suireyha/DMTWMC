import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Graphics2D; //Imported by Marvin to edit stroke value of cell borders

/*!!IMPORTANT NOTE FROM MARVIN:
* Wherever we handle mouse position to meet some end, we need to remove the offset I've made
* Take a look at the third variable in the class gridOffset- that's how the offset is calculated.
* If we change the window size, pixel size, or number of pixels we need to change that variable here and
* in Stage.java.
* To remove the offset so we can get the actual mousePos, take a look at what's happening in the first line of paint();
*/
public class Cell extends Rectangle {
  Color gridColor = new Color(57, 58, 59);
  Color highlighted = new Color(127, 128, 129);
  double gridOffset = (900/2) - (35*20)/2; //Currently the window is Window = 900px, Cells = 35px, #OfCells = 20;
  static int size = 35;

  public Cell(int x, int y) {
    super(x, y, size, size);
  }

  public void paint(Graphics g, Point mousePos) {
    Point offsetMousePos = new Point(mousePos); //This is the ACTUAL mouse position obtained by removing the offset.
    offsetMousePos.x -= gridOffset;
    offsetMousePos.y -= gridOffset;
    if(contains(offsetMousePos)) {
      g.setColor(highlighted);
    } else {
      g.setColor(Color.WHITE);
    }

    g.fillRect(x, y, size, size);

    Graphics2D g2d = (Graphics2D) g; //Casting our graphics object to a g2d so we can add stroke and offset below

    g2d.setColor(gridColor); //Colour of the grid borders
    g2d.setStroke(new BasicStroke(1.5f)); //1.5px border thickness
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
