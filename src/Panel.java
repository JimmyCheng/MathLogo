import java.awt.*;
import javax.swing.JPanel;

public class Panel extends JPanel {
    public final int CELL_SIZE = 100;
    public final Color LOGO_COLOR = Color.BLUE;
    public final Color GRID_COLOR = Color.lightGray;
    public final int THICK = (int)Math.round(CELL_SIZE*0.382);

    public final int CANVAS_WIDTH = CELL_SIZE * 8;
    public final int CANVAS_HEIGHT = CELL_SIZE * 4;

    public final int CIRCLE_LEFT_X = CELL_SIZE * 2;
    public final int CIRCLE_LEFT_Y = CELL_SIZE * 2;
    public final int CIRCLE_RIGHT_X = CELL_SIZE * 6;
    public final int CIRCLE_RIGHT_Y = CELL_SIZE * 2;
    public final int CIRCLE_RADIUS = (int)Math.round(Math.sqrt(2) * CELL_SIZE + THICK/2);
    public final int INNER_CIRCLE_RADIUS = CIRCLE_RADIUS - THICK;

    public final int RECT_X = CELL_SIZE * 4;
    public final int RECT_Y = CELL_SIZE * 2;
    public final int RECT_H_WIDTH = (int)Math.round(Math.sqrt(2) * CELL_SIZE * 2 *0.9);
    public final int RECT_H_HEIGHT = THICK;

    public final int RECT_V_WIDTH = THICK;
    public final int RECT_V_HEIGHT =(int)Math.round(Math.sqrt(2) * CELL_SIZE * 2 *0.9);

    public  void drawCircle(Graphics2D g, int x, int y, int radius) {
        int diameter = radius * 2;

        //shift x and y by the radius of the circle in order to correctly center it
        g.fillOval(x - radius, y - radius, diameter, diameter);
    }

    public  void drawArc(Graphics2D g, int x, int y, int radius, int startAngel, int arcAngle) {
        int diameter = radius * 2;

        //shift x and y by the radius of the circle in order to correctly center it
        g.fillArc(x - radius, y - radius, diameter, diameter, startAngel, arcAngle );
    }

    public void drawRect(Graphics2D g, int x, int y, int width, int height) {
        g.fillRect(x - width / 2 , y - height / 2, width, height );
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        g2.setColor(LOGO_COLOR);
        drawArc(g2, CIRCLE_LEFT_X, CIRCLE_LEFT_Y, CIRCLE_RADIUS, 45, 270);
        drawArc(g2, CIRCLE_RIGHT_X, CIRCLE_RIGHT_Y, CIRCLE_RADIUS, 225, 270);

        g2.setColor(this.getBackground());
        drawArc(g2, CIRCLE_LEFT_X, CIRCLE_LEFT_Y, INNER_CIRCLE_RADIUS, 45, 270);
        drawArc(g2, CIRCLE_RIGHT_X, CIRCLE_RIGHT_Y, INNER_CIRCLE_RADIUS, 225, 271);


        g2.setColor(LOGO_COLOR);
        g2.rotate(Math.toRadians(45), CELL_SIZE*4, CELL_SIZE * 2);
        drawRect(g2, RECT_X, RECT_Y, RECT_H_WIDTH, RECT_H_HEIGHT);

        drawRect(g2, RECT_X, RECT_Y, RECT_V_WIDTH, RECT_V_HEIGHT);

        g2.rotate(Math.toRadians(-45), CELL_SIZE*4, CELL_SIZE * 2);

        //g2.setStroke(new BasicStroke(3));
        float[] dash1 = { 2f, 0f, 2f };
        BasicStroke bs1 = new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash1,
                2f);
        g2.setStroke(bs1);

        //draw the grid. vertical line
        g2.setColor(GRID_COLOR);
        for(int i = 1; i<= CANVAS_WIDTH / CELL_SIZE * 5; i++ ) {
            int x1 = (int)Math.round((i * CELL_SIZE / 5));
            int y1 = 0;
            int x2 = x1;
            int y2 = CANVAS_HEIGHT;
            g2.drawLine(x1, y1, x2, y2);
        }

        for(int i = 1; i<= CANVAS_HEIGHT / CELL_SIZE * 5; i++ ) {
            int x1 = 0;
            int y1 = (int)Math.round((i * CELL_SIZE / 5));
            int x2 = CANVAS_WIDTH;
            int y2 = y1;
            g2.drawLine(x1, y1, x2, y2);
        }

        float[] dash2 = { 2f, 0f, 2f };
        BasicStroke bs2 = new BasicStroke(2,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash1,
                2f);
        g2.setStroke(bs2);

        //draw the grid.  vertical line
        for(int i = 1; i<= CANVAS_WIDTH / CELL_SIZE; i++ ) {
            int x1 = (int)Math.round((i * CELL_SIZE ));
            int y1 = 0;
            int x2 = x1;
            int y2 = CANVAS_HEIGHT;
            g2.drawLine(x1, y1, x2, y2);
        }

        for(int i = 1; i<= CANVAS_HEIGHT / CELL_SIZE; i++ ) {
            int x1 = 0;
            int y1 = (int)Math.round((i * CELL_SIZE));
            int x2 = CANVAS_WIDTH;
            int y2 = y1;
            g2.drawLine(x1, y1, x2, y2);
        }


    }
}
