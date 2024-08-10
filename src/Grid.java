import java.awt.*;

public class Grid {
    private Cell[][] cells;

    public Grid(int r, int c, int s, int offset) {
        cells = new Cell[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = offset + j * s;
                int y = offset + i * s;
                cells[i][j] = new Cell(x, y, s);
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].paint(g);
            }
        }
    }

    public void highlightCell(int mouseX, int mouseY) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].containsPoint(mouseX, mouseY)) {
                    cells[i][j].setHighlighted(true);
                } else {
                    cells[i][j].setHighlighted(false);
                }
            }
        }
    }
}
