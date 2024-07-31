import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Main extends JFrame{
    public static void main(String[] args) throws Exception {
        Main window=new Main();
    }

    class Canvas extends JPanel {
        private Grid grid;

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            grid = new Grid(20, 20, 35, 10); 
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    grid.highlightCell(e.getX(), e.getY());
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            grid.paint(g);
        }
    }

    

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
}