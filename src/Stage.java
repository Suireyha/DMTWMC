import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Stage {
    Grid GridA = new Grid();
    List <Actor> actors = new ArrayList<>();
    
    
    public Stage(){
        GridA = new Grid();
        actors.add(new Cat(GridA.cells[15][12]));
        actors.add(new Bird(GridA.cells[2][4]));
        actors.add(new Dog(GridA.cells[5][8]));
        
    }

    public void paint(Graphics g, Point mousePos){
        GridA.paint(g, mousePos);
        
        for(Actor actor: actors){
            actor.paint(g, actor.colour, actor.location);
        }
        

        if(mousePos != null){
            g.drawString("Current Cell: " + GridA.toString(), 720, 200);
        }else{
            g.drawString("Out of bounds idiot", 720, 200);
        }
    }

}
