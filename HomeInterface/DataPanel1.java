import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DataPanel1 extends JPanel {

    DataPanel1() {
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(0xFEFFDE));
        g2D.fillRoundRect(0 , 0 , 422, 58 , 35 , 55);
    }
}