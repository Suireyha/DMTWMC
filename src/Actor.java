import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Polygon;
import java.util.ArrayList;

public class Actor {
  List<Polygon> shape = new ArrayList<>();
  Color colour;
  Cell location;


    public Actor(Color c, Cell l){
        this.colour = c;
        this.location = l;
    }   

    public void paint(Graphics g, Color colour, Cell cell) {
        g.setColor(colour);
        
        for(Polygon features: shape){
        g.drawPolygon(features);
        }
   
    }

}
