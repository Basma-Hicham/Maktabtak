import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Printer_Update_Interface2 extends JFrame {

    public class PrinterTableRec extends JPanel {
        private Shape shape;
        Color Color;

        public PrinterTableRec(Color Color) {
            this.Color = Color;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setColor(Color);
            g2D.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            super.paintComponent(g);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 10, getHeight() - 15, 80, 80);
            }
            return shape.contains(x, y);
        }

    }

    public class InnerRec extends JPanel {
        private Shape shape;
        Color Color;

        public InnerRec(Color Color) {
            this.Color = Color;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setColor(Color);
            g2D.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 15, 80, 80);
            //Draw Line ;D
            g2D.setColor(new Color(0xFEFFDE));
            g2D.setStroke(new BasicStroke(1));
            g2D.drawLine(0, 713, getWidth() - 11, 713);
            super.paintComponent(g);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 10, getHeight() - 15, 80, 80);
            }
            return shape.contains(x, y);
        }

    }

    public class OuterRec extends JPanel {
        private Shape shape;
        Color Color;

        public OuterRec(Color Color) {
            this.Color = Color;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(Color);
            g.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 15, 80, 80);
            super.paintComponent(g);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 10, getHeight() - 15, 80, 80);
            }
            return shape.contains(x, y);
        }

    }

    public class RoundJTextField extends JTextField {
        private Shape shape;

        public RoundJTextField(int size) {
            super(size);
            // cursor texetfeild el maktaba
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ImageIcon cursorImage = new ImageIcon("custom_cursor2.png");
                    Image cursorImageObj = cursorImage.getImage();
                    Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImageObj,
                            new Point(0, 0), "Custom Cursor");
                    setCursor(customCursor);
                }
            });
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(new Color(0, 0, 0, 50));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
            }
            return shape.contains(x, y);
        }
    }

    public class RoundJButton extends JButton {
        private Shape shape;

        public RoundJButton() {
            setOpaque(false);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(Color.black);
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(new Color(0x625B49));
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
            super.paintComponent(g);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 125, 25);
            }
            return shape.contains(x, y);
        }
    }

    private JPanel RightSidePanel;
    private Image cursorImage = Toolkit.getDefaultToolkit().getImage("custom_cursor.png");
    private ImageIcon HomeIcon, SelectIcon, InsertIcon , Star1Icon , Star2Icon , Star3Icon , Star4Icon , Star5Icon , StarIcon , StarIconClicked , RoundCheckBoxIcon , RoundCheckBoxIconChecked;
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),
            "customCursor");
    private InnerRec InnerRec;
    private OuterRec OuterRec;
    private JLabel HomeIconLabel, InsertIconLabel, Select_Or_UpdateIconLabel, BookCodeTextLabel, SelectButtonLabel;
    private JLabel UpdateButtonLabel, PrinterRowTextLabel , NumOfPrintingsTextLabel , EndOfPrintingDateTextLabel;
    private RoundJTextField BookCodeTextField , NumOfPrintingsTextField , EndOfPrintingDateTextField;
    private RoundJButton SelectButton, UpdateButton;
    private PrinterTableRec PrinterTableRec;

    Printer_Update_Interface2() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.getContentPane().setBackground(new Color(0xB5B1A8));
        this.setLayout(null);

        RightSidePanel = new JPanel();
        RightSidePanel.setBackground(new Color(0x625B49));
        RightSidePanel.setBounds(1790, 0, 130, 1080);

        HomeIcon = new ImageIcon("homeIcon.png");
        HomeIconLabel = new JLabel();
        HomeIconLabel.setIcon(HomeIcon);
        HomeIconLabel.setBounds(1809, 21, 91, 91);
        HomeIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new HomeInterface2();
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
                HomeIcon = new ImageIcon("HomeIconHovered.png");
                HomeIconLabel.setIcon(HomeIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                HomeIcon = new ImageIcon("HomeIcon.png");
                HomeIconLabel.setIcon(HomeIcon);
            }

        });

        InnerRec = new InnerRec(new Color(0x7F7A6E));
        InnerRec.setBounds(16 + 2, 11 + 2 + 8, 1762 - 6, 1058 - 6);
        OuterRec = new OuterRec(new Color(0xFEFFDE));
        OuterRec.setBounds(16 - 1, 11 - 1 + 8, 1762, 1058);

        BookCodeTextLabel = new JLabel("Book Code");
        BookCodeTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        BookCodeTextLabel.setForeground(Color.WHITE);
        BookCodeTextLabel.setBounds(96, 123, 220, 45);

        BookCodeTextField = new RoundJTextField(15);
        BookCodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        BookCodeTextField.setForeground(Color.darkGray);
        BookCodeTextField.setBounds(344, 125, 316, 47);

        SelectButton = new RoundJButton();
        SelectButton.setBackground(new Color(0x625B49));
        SelectButton.setFocusable(false);
        SelectButton.setBounds(724, 117, 308, 61);
        SelectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(SelectButton)) {
                    Validation v = new Validation();
                    if (v.ID(BookCodeTextField.getText().trim())) {
                        //hdwr fe el databse 3la el id
                        // w select el data
                    }
                }
            }
            
        });

        SelectButtonLabel = new JLabel("Select");
        SelectButtonLabel.setForeground(Color.white);
        SelectButtonLabel.setFont(new Font("K2D", Font.PLAIN, 51));
        SelectButtonLabel.setBounds(724 + 79, 118, 150, 56);

        UpdateButton = new RoundJButton();
        UpdateButton.setBackground(new Color(0x625B49));
        UpdateButton.setFocusable(false);
        UpdateButton.setBounds(1551, 989, 202, 45);
        UpdateButtonLabel = new JLabel("Update");
        UpdateButtonLabel.setForeground(Color.WHITE);
        UpdateButtonLabel.setFont(new Font("Inter", Font.PLAIN, 35));
        UpdateButtonLabel.setBounds(1551 + 45, 987, 134, 45);

        PrinterTableRec = new PrinterTableRec(new Color(0xD9D9D9));
        PrinterTableRec.setBounds(59 + 12, 251, 1638, 202);

        PrinterRowTextLabel = new JLabel("Request Row");
        PrinterRowTextLabel.setForeground(Color.BLACK);
        PrinterRowTextLabel.setFont(new Font("Inter", Font.PLAIN, 110));
        PrinterRowTextLabel.setBounds(557, 283, 683, 123);

        NumOfPrintingsTextLabel = new JLabel("Number Of Printings");
        NumOfPrintingsTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        NumOfPrintingsTextLabel.setForeground(Color.WHITE);
        NumOfPrintingsTextLabel.setBounds(379, 548, 602, 64);

        NumOfPrintingsTextField = new RoundJTextField(15);
        NumOfPrintingsTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        NumOfPrintingsTextField.setForeground(Color.darkGray);
        NumOfPrintingsTextField.setBounds(1029, 548, 512, 68);

        EndOfPrintingDateTextLabel = new JLabel("End Of Printing Date");
        EndOfPrintingDateTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        EndOfPrintingDateTextLabel.setForeground(Color.WHITE);
        EndOfPrintingDateTextLabel.setBounds(379, 840, 455, 49);

        EndOfPrintingDateTextField = new RoundJTextField(15);
        EndOfPrintingDateTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        EndOfPrintingDateTextField.setForeground(Color.darkGray);
        EndOfPrintingDateTextField.setBounds(1029, 840, 512, 68);

        this.add(EndOfPrintingDateTextField);
        this.add(EndOfPrintingDateTextLabel);
        this.add(NumOfPrintingsTextField);
        this.add(NumOfPrintingsTextLabel);
        this.add(BookCodeTextField);
        this.add(BookCodeTextLabel);
        this.add(PrinterRowTextLabel);
        this.add(PrinterTableRec);
        this.add(UpdateButtonLabel);
        this.add(UpdateButton);
        this.add(SelectButtonLabel);
        this.add(SelectButton);
        this.add(HomeIconLabel);
        this.add(InnerRec);
        this.add(OuterRec);
        this.add(RightSidePanel);
        this.setCursor(cursor);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Printer_Update_Interface2();
    }
}
