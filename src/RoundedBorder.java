import java.awt.*;
import javax.swing.border.Border;

public class RoundedBorder implements Border{
    //The Border interface demands we write functionality for isBorderOpaque,getBorderInsets and paintBorder
    public int width;
    boolean hover = false;
    RoundedBorder(int w){
        this.width = w - 30; //I'm adding the -5 because I want the shape to be slightly smaller so that the border will actually fit within the object space
    }
    RoundedBorder(int w, boolean h){ //h is for hovering
        this.width = w - 30;
        hover = h;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
        Graphics2D g2d = (Graphics2D) g; //Cast the Graphics object (g) into a Graphics2D object (I need this for setStroke();
        int variableWidth;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Adds anti aliasing so that the shape is drawn smoothly :)
        g2d.setStroke(new BasicStroke(3));
        if(hover){
            g2d.setStroke(new BasicStroke(4));
            variableWidth = this.width + 2;
        }
        else {
            variableWidth = this.width;
        }
        g2d.drawRoundRect(10, 10, variableWidth, variableWidth, variableWidth, variableWidth);
    }

    @Override
    public Insets getBorderInsets(Component c){
        if(hover){
            return new Insets(1,3,8,9);
        }
        return new Insets(0,0,8,9); //This is like css padding, this says to pad 8px from the top and 5px from the right
    }

    @Override
    public boolean isBorderOpaque(){
        return true;
    }
    

}