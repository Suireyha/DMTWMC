import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get()));    
  }

  public Stage(List<String> coords) {
    grid = new Grid();
    actors = new ArrayList<Actor>();

    System.out.println("Test 1");

    try{
        for(int i = 0; i < coords.size(); i++){
            String temp = coords.get(i).substring(0, coords.get(i).indexOf("=")); //Extract the coordinates
            int row = Integer.parseInt(temp.substring(1, temp.length())); //Save row

            char col = temp.charAt(0); //Save collumn
            String actor = coords.get(i).substring(coords.get(i).indexOf("=") + 1, coords.get(i).length()); //Save the actor

            switch(actor){
                case "cat":
                    actors.add(new Cat(grid.cellAtColRow(col, row).get()));
                    break;
                case "dog":
                    actors.add(new Dog(grid.cellAtColRow(col, row).get()));
                    break;
                case "bird":
                    actors.add(new Bird(grid.cellAtColRow(col, row).get()));
                    break;
                default:
                    System.out.println("This is not a valid actor");
                    break;
            }

        }


    }
    catch(NullPointerException e){
        System.out.println("Failed :(");
    }
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(Actor a: actors) {
      a.paint(g);
    }
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }
  }
}
