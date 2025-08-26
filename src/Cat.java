import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Cat extends Actor {

    public Cat(Cell location){
        super(Color.BLACK, location);
        this.location = location;
        this.colour = Color.BLACK;
        drawing();
    }

    public void drawing(){
        Polygon ear1 = new Polygon();
        ear1.addPoint(location.x + 11, location.y + 5);
        ear1.addPoint(location.x + 15, location.y + 15);
        ear1.addPoint(location.x + 7, location.y + 15);
        Polygon ear2 = new Polygon();
        ear2.addPoint(location.x + 22, location.y + 5);
        ear2.addPoint(location.x + 26, location.y + 15);
        ear2.addPoint(location.x + 18, location.y + 15);
        Polygon face = new Polygon();
        face.addPoint(location.x + 5, location.y + 15);
        face.addPoint(location.x + 29, location.y + 15);
        face.addPoint(location.x + 17, location.y + 30);

        shape.add(ear1);
        shape.add(ear2);
        shape.add(face);
    }

    public void paint(Graphics g){
        super.paint(g, colour, location);
    }
}
