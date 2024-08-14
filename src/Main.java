import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.LinkedList;

public class Main extends JFrame {
  private Main() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Canvas canvas = new Canvas();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
  }
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }
    public void run() {
      while(true) {
        repaint();
      }
    }
    class Canvas extends JPanel {
      Grid grid = new Grid();
      LinkedList<Point> mouseTrail = new LinkedList<>();
      int maxTrail=100;
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) {
        Point mousePos = getMousePosition();
        grid.paint(g, getMousePosition());
          
        if (mousePos != null) {
          if (mouseTrail.size() >= maxTrail) {
            mouseTrail.removeFirst();
          }
          mouseTrail.add(mousePos);
          for (Point point : mouseTrail) {
            g.setColor(new Color(192,192,192,90));
            g.fillOval(point.x - 10, point.y - 10, 10, 10);
            
          }
        }
        

    }
  }
}
