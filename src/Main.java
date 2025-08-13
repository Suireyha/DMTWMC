import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      //Program starts here
      Main window = new Main(); //Reaches Test 3
      window.run(); //Reaches Test 4
      //This point is never reached
    }

    class Canvas extends JPanel {
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) {

        //System.out.println("Test 1");
        Grid a = new Grid();
        a.paintGrid(g);
        System.out.println("..");

 
	

      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      System.out.println("Test 3");
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
      
    }

    

    public void run() {
      System.out.println("Test 4");
      while(true) {
        repaint(); //Loop starts here
      }
    }
}
