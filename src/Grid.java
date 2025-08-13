import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid {
    int rows;
    int columns;
    int[][] cells = new int[20][20];

    public Grid(){
        rows = 20;
        columns = 20;
        int x = 10;
        int y = 10;
        int size = 35;
        for (int i = 0; i < rows; i++){
             for (int j = 0; j < columns; j++){
                cells[i][j] = 1;
             }
        }
        System.out.println(cells[3][5]);
    }

    public void paintGrid(Graphics g){


        Cell a;

        int x = 10;
        int y = 10;
        int size = 35;
        for (int i = 0; i < 20; i++){
             for (int j = 0; j < 20; j++){
             a = new Cell(x, y, size);
             a.paintCell(g);
             y += 35;
             }
             y = 10;
             x += 35;
        }
    }
    
}
