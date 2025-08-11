import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cell {
    int x;
    int y;
    int size;

    public Cell(){
        x = 0;
        y = 0;
        size = 0;
    }

    public Cell(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }


    public void paintCell(Graphics g){
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
