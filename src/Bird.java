import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Bird extends Actor {

    public Bird(Cell location){
        super(Color.BLUE, location);
        this.location = location;
        this.colour = Color.BLUE;
        drawing();
    }

    public void drawing(){
        Polygon wing1 = new Polygon();
        wing1.addPoint(location.x + 5, location.y + 5);
        wing1.addPoint(location.x + 15, location.y + 17);
        wing1.addPoint(location.x + 5, location.y + 17);
        Polygon wing2 = new Polygon();
        wing2.addPoint(location.x + 30, location.y + 5);
        wing2.addPoint(location.x + 20, location.y + 17);
        wing2.addPoint(location.x + 30, location.y + 17);
        Polygon body = new Polygon();
        body.addPoint(location.x + 15, location.y + 10);
        body.addPoint(location.x + 20, location.y + 10);
        body.addPoint(location.x + 20, location.y + 25);
        body.addPoint(location.x + 15, location.y + 25); 

        shape.add(wing1);
        shape.add(wing2);
        shape.add(body);
    }

    public void paint(Graphics g){
        super.paint(g, colour, location);
    }
}
