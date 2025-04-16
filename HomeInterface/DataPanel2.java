import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DataPanel2 extends JPanel {

    DataPanel2() {
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(0xFEFFDE));
        g2D.fillRoundRect(0 , 0  , 364 ,58 , 35 , 55);
    }
}