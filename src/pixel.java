import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pixel extends JButton{

    int pxID;
    boolean painted = false;
    boolean erasing = false;
    Color activeColor;

    public void setUp(int width, int height){
        
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setSize(width, height);
        this.setBorderPainted(false);
        this.setFocusPainted(true);
        this.setBackground( new Color(255, 255, 255));
        this.activeColor = new Color(0, 0, 0);

        this.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            System.out.println("Pixel ID " + pxID + " clicked!");
            if(!erasing){
                setBackground(activeColor);
            }
            else{
                setBackground(new Color(255, 255, 255));
            }
         }
            
        });

        //This is the mouseDown listener bs so you can do brush actual strokes
        this.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                Point parentPoint = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), getParent());
                Component comp = getParent().getComponentAt(parentPoint);
                if(comp instanceof pixel && comp != e.getSource()){
                ((pixel) comp).doClick(); 
                }
            }
        
        });
    }

    //WARNING!!!!! Prefer not to use these two since they don't give pixels and ID
    public pixel(){
        super("");
        setUp(50, 50);
    }
    public pixel(int w, int h){
        super("");
        setUp(w, h);
    }

    //PREFER THESE TWO!!! ID is important
    public pixel(int id){
        super("");
        setUp(50, 50);
        pxID = id;
    }
    public pixel(int w, int h, int id){
        super("");
        setUp(w, h);
        pxID = id;
    }
    

}   

