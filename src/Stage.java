import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Point;

public class Stage {
  Grid grid;
  ArrayList<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0)));
    actors.add(new Dog(grid.cellAtColRow(0, 15)));
    actors.add(new Bird(grid.cellAtColRow(12, 9)));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(int i = 0; i < actors.size(); i++){
        actors.get(i).paint(g);
    }
  }
}
