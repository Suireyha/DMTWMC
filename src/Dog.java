import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Dog extends Actor {

    public Dog(Cell location){
        super(Color.RED, location);
        this.location = location;
         this.colour = Color.RED;
         drawing();
    }

    public void drawing(){
        Polygon ear1 = new Polygon();
        ear1.addPoint(location.x + 5, location.y + 5);
        ear1.addPoint(location.x + 15, location.y + 5);
        ear1.addPoint(location.x + 5, location.y + 15);
        Polygon ear2 = new Polygon();
        ear2.addPoint(location.x + 20, location.y + 5);
        ear2.addPoint(location.x + 30, location.y + 5);
        ear2.addPoint(location.x + 30, location.y + 15);
        Polygon face = new Polygon();
        face.addPoint(location.x + 8, location.y + 7);
        face.addPoint(location.x + 27, location.y + 7);
        face.addPoint(location.x + 27, location.y + 25);
        face.addPoint(location.x + 8, location.y + 25);

        shape.add(ear1);
        shape.add(ear2);
        shape.add(face);
    }

    public void paint(Graphics g){
        super.paint(g, colour, location);
    }
}
