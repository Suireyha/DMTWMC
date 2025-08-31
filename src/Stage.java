import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Point;

/*!!IMPORTANT NOTE FROM MARVIN:
* Wherever we handle mouse position to meet some end, we need to remove the offset I've made
* Take a look at the third and fourth variable in the class gridOffset- that's how the offset is calculated.
* If we change the window size, pixel size, or number of pixels we need to change that variable here and
* in Cell.java.
* You can see me adding the offset in this file in the paint function.
*/
public class Stage {
  Grid grid;
  ArrayList<Actor> actors;
  double gridOffsetX = (900/2) - (35*20)/2; //Currently the window is Window = 900px, Cells = 35px, #OfCells = 20; 
  double gridOffsetY = gridOffsetX; //We'll use these two variables for drawing the grid at the correct offset to center it. Just make sure to update this if we ever change the number of cells, cell size or window size!!!
  
  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0)));
    actors.add(new Dog(grid.cellAtColRow(0, 15)));
    actors.add(new Bird(grid.cellAtColRow(12, 9)));
  }

  public void paint(Graphics g, Point mouseLoc) {
    Graphics2D g2d = (Graphics2D) g; //Casting the graphics object to graphics2d so I can offset everything
    g2d.translate(gridOffsetX, gridOffsetY); //Offset everything
    grid.paint(g, mouseLoc);
    for(int i = 0; i < actors.size(); i++){
      actors.get(i).paint(g2d); //I changed this to a g2d
    }
  }
}
