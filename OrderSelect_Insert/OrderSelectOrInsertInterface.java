import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OrderSelectOrInsertInterface extends JFrame {

    JLabel Select_Or_UpdateIconLabel, Select_Or_UpdateText, DataText;
    ImageIcon Select_Or_UpdateIcon;
    JLabel InsertIconLabel, InsertDataText;
    ImageIcon InsertIcon;
    private JPanel RightSidePanel;
    private Image cursorImage = Toolkit.getDefaultToolkit().getImage("custom_cursor.png"); // Change "cursor.png" to
                                                                                           // your cursor image file
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),
            "customCursor");

    OrderSelectOrInsertInterface() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.getContentPane().setBackground(new Color(0x625B49));
        this.setLayout(null);

        RightSidePanel = new JPanel();
        RightSidePanel.setBackground(new Color(0x847E6F));
        RightSidePanel.setBounds(0, 0, 102, 1080);

        Select_Or_UpdateIcon = new ImageIcon("Select_Update.png");
        Select_Or_UpdateIconLabel = new JLabel();
        Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
        Select_Or_UpdateIconLabel.setBounds(279, 218, 450, 485);
        Select_Or_UpdateIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Order_Select_Or_Update_Interface();
                // delay l el dispose
                Timer timer = new Timer(2000, event -> {
                    dispose();
                });
            
                timer.setRepeats(false);
                timer.start();            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Select_Or_UpdateIcon = new ImageIcon("Select_UpdateHovered.png");
                Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
                Select_Or_UpdateText.setForeground(new Color(0x4682BF));
                DataText.setForeground(new Color(0x4682BF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Select_Or_UpdateIcon = new ImageIcon("Select_Update.png");
                Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
                Select_Or_UpdateText.setForeground(Color.WHITE);
                DataText.setForeground(Color.WHITE);
            }

        });

        Select_Or_UpdateText = new JLabel("Select / Update");
        Select_Or_UpdateText.setForeground(Color.WHITE);
        Select_Or_UpdateText.setFont(new Font("K2D", Font.BOLD, 70));
        Select_Or_UpdateText.setBounds(259, 700, 540, 70);
        Select_Or_UpdateText.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Order_Select_Or_Update_Interface();
                // delay l el dispose
                Timer timer = new Timer(2000, event -> {
                    dispose();
                });
            
                timer.setRepeats(false);
                timer.start();            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Select_Or_UpdateIcon = new ImageIcon("Select_UpdateHovered.png");
                Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
                Select_Or_UpdateText.setForeground(new Color(0x4682BF));
                DataText.setForeground(new Color(0x4682BF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Select_Or_UpdateIcon = new ImageIcon("Select_Update.png");
                Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
                Select_Or_UpdateText.setForeground(Color.WHITE);
                DataText.setForeground(Color.WHITE);
            }

        });

        DataText = new JLabel("Data");
        DataText.setForeground(Color.WHITE);
        DataText.setFont(new Font("K2D", Font.BOLD, 70));
        DataText.setBounds(418, 770, 160, 70);
        DataText.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Order_Select_Or_Update_Interface();
                // delay l el dispose
                Timer timer = new Timer(2000, event -> {
                    dispose();
                });
            
                timer.setRepeats(false);
                timer.start();            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Select_Or_UpdateIcon = new ImageIcon("Select_UpdateHovered.png");
                Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
                Select_Or_UpdateText.setForeground(new Color(0x4682BF));
                DataText.setForeground(new Color(0x4682BF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Select_Or_UpdateIcon = new ImageIcon("Select_Update.png");
                Select_Or_UpdateIconLabel.setIcon(Select_Or_UpdateIcon);
                Select_Or_UpdateText.setForeground(Color.WHITE);
                DataText.setForeground(Color.WHITE);
            }

        });

        InsertIcon = new ImageIcon("Insert.png");
        InsertIconLabel = new JLabel();
        InsertIconLabel.setIcon(InsertIcon);
        InsertIconLabel.setBounds(1259, 218, 450, 485);
        InsertIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Order_Insert_Interface();
                // delay l el dispose
                Timer timer = new Timer(2000, event -> {
                    dispose();
                });
            
                timer.setRepeats(false);
                timer.start();            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                InsertIcon = new ImageIcon("InsertHovered.png");
                InsertIconLabel.setIcon(InsertIcon);
                InsertDataText.setForeground(new Color(0x2FDF84));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                InsertIcon = new ImageIcon("Insert.png");
                InsertIconLabel.setIcon(InsertIcon);
                InsertDataText.setForeground(Color.WHITE);
            }

        });

        InsertDataText = new JLabel("Insert Data");
        InsertDataText.setForeground(Color.WHITE);
        InsertDataText.setFont(new Font("K2D", Font.BOLD, 70));
        InsertDataText.setBounds(1316, 700, 382, 70);
        InsertDataText.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Order_Insert_Interface();
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                InsertIcon = new ImageIcon("InsertHovered.png");
                InsertIconLabel.setIcon(InsertIcon);
                InsertDataText.setForeground(new Color(0x2FDF84));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                InsertIcon = new ImageIcon("Insert.png");
                InsertIconLabel.setIcon(InsertIcon);
                InsertDataText.setForeground(Color.WHITE);
            }

        });

        this.setCursor(cursor);
        this.add(InsertDataText);
        this.add(InsertIconLabel);
        this.add(DataText);
        this.add(RightSidePanel);
        this.add(Select_Or_UpdateText);
        this.add(Select_Or_UpdateIconLabel);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
