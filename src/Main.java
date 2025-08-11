import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) {
	g.setColor(java.awt.Color.BLACK);
  int x = 10;
  int y = 10;
  int size = 35;
  for (int i = 0; i < 20; i++){
    for (int j = 0; j < 20; j++){
      g.drawRect(x, y, size, size);
      y += 35;
    }
    y = 10;
    x += 35;
  }
 
	

      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
      }
    }
}
