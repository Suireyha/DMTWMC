import java.awt.*;
import java.awt.event.*;

public class Clear extends btn{

    Clear(boolean transparent, String name, int id){
        super(transparent, name, id);

        this.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            System.out.println("Clicked!");
            selected = !selected;
            changeSelectColour(selected);
         }
            
        });


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                //Mouse is hovering button
                changeHoverColour(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                //Mouse has left button
                changeHoverColour(false);
            }
        });
    }

    public void changeHoverColour(boolean hover){
        if(hover){
            this.setForeground(new Color(255, 39, 42));
        }
        else{
            this.setForeground(lightGrey);
        }
    }

    

}