import java.awt.*;

public class Cell {
    private int x, y, size;
    private boolean isHighlighted;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.isHighlighted = false;
    }

    public void setHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }

    public void paint(Graphics g) {
        if (isHighlighted) {
            g.setColor(Color.RED);
            g.fillRect(x, y, size, size);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, size, size);
        }
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    public boolean containsPoint(int mx, int my) {
        return mx >= x && mx < x + size && my >= y && my < y + size;
    }
}
