import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    public final int CELL_SIZE = 200;

    public final int CANVAS_WIDTH = CELL_SIZE * 8;
    public final int CANVAS_HEIGHT = CELL_SIZE * 4;


    public Main() {

        setSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Panel p = new Panel();
        setTitle("Math Logo");
        this.getContentPane().add(p);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new Main();
            }
        });
    }
}
