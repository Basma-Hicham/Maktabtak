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
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Printer_Insert_Interface2 extends JFrame {

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
                //Draw Line1 ;D
                g2D.setColor(new Color(0xFEFFDE));
                g2D.setStroke(new BasicStroke(1));
                g2D.drawLine(0, 355, getWidth() - 11, 355);
                //Draw Line2 ;D
                g2D.setColor(new Color(0xFEFFDE));
                g2D.setStroke(new BasicStroke(1));
                g2D.drawLine(0, 648, getWidth() - 11, 648);
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
        private ImageIcon HomeIcon , SelectIcon , InsertIcon;
        private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),"customCursor");
        private InnerRec InnerRec;
        private OuterRec OuterRec;
        private JLabel BookCodeTextLabel , NumOfPrintingsTextLabel , EndOfPrintingDateTextLabel , InsertButtonLabel;
        private JLabel HomeIconLabel , InsertIconLabel , Select_Or_UpdateIconLabel;
        private RoundJTextField BookCodeTextField , NumOfPrintingsTextField , EndOfPrintingDateTextField;
        private RoundJButton InsertButton;
        public static String BookCode = "";
        public static String NumOfPrintings = "";
        public static String EndOfPrintingDate = "";

        Printer_Insert_Interface2() {

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
                BookCode = "";
                NumOfPrintings = "";
                EndOfPrintingDate = "";
                Printer_Select_Or_Update_Interface2.BookCode = "";
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
        
        SelectIcon = new ImageIcon("SelectButton.png");
        Select_Or_UpdateIconLabel = new JLabel();
        Select_Or_UpdateIconLabel.setIcon(SelectIcon);
        Select_Or_UpdateIconLabel.setBounds(1811, 346, 91, 91);
        Select_Or_UpdateIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                BookCode = BookCodeTextField.getText();
                NumOfPrintings = NumOfPrintingsTextField.getText();
                EndOfPrintingDate = EndOfPrintingDateTextField.getText();
                new Printer_Select_Or_Update_Interface2();
                // delay l el dispose
                Timer timer = new Timer(2000, event -> {
                    dispose();
                });
            
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                SelectIcon = new ImageIcon("SelectButtonHovered.png");
                Select_Or_UpdateIconLabel.setIcon(SelectIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SelectIcon = new ImageIcon("SelectButton.png");
                Select_Or_UpdateIconLabel.setIcon(SelectIcon);
            }

        });

        InsertIcon = new ImageIcon("InsertButton.png");
        InsertIconLabel = new JLabel();
        InsertIconLabel.setIcon(InsertIcon);
        InsertIconLabel.setBounds(1821, 556, 72, 72);
        InsertIconLabel.addMouseListener(new MouseListener() {

            @Override public void mouseClicked(MouseEvent e) {}

            @Override public void mousePressed(MouseEvent e) {}

            @Override public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                InsertIcon = new ImageIcon("InsertButtonHovered.png");
                InsertIconLabel.setIcon(InsertIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                InsertIcon = new ImageIcon("InsertButton.png");
                InsertIconLabel.setIcon(InsertIcon);
            }

        });
        
        InnerRec = new InnerRec(new Color(0x7F7A6E));
        InnerRec.setBounds(16 + 2, 11 + 2 + 8, 1762 - 6, 1058 - 6);
        OuterRec = new OuterRec(new Color(0xFEFFDE));
        OuterRec.setBounds(16 - 1, 11 - 1 + 8, 1762, 1058);

        BookCodeTextLabel = new JLabel("Book Code");
        BookCodeTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        BookCodeTextLabel.setForeground(Color.WHITE);
        BookCodeTextLabel.setBounds(275 , 170 , 272 , 58);

        BookCodeTextField = new RoundJTextField(15);
        BookCodeTextField.setText(BookCode);
        BookCodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        BookCodeTextField.setForeground(Color.darkGray);
        BookCodeTextField.setBounds(905, 159, 613, 73);

        NumOfPrintingsTextLabel = new JLabel("Num Of Printings");
        NumOfPrintingsTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        NumOfPrintingsTextLabel.setForeground(Color.WHITE);
        NumOfPrintingsTextLabel.setBounds(275 , 355+130 , 529 , 58);

        NumOfPrintingsTextField = new RoundJTextField(15);
        NumOfPrintingsTextField.setText(NumOfPrintings);
        NumOfPrintingsTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        NumOfPrintingsTextField.setForeground(Color.darkGray);
        NumOfPrintingsTextField.setBounds(905, 355+130, 613, 73);

        EndOfPrintingDateTextLabel = new JLabel("End Of Printing Date");
        EndOfPrintingDateTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        EndOfPrintingDateTextLabel.setForeground(Color.WHITE);
        EndOfPrintingDateTextLabel.setBounds(275 , 648+130 , 529 , 58);

        EndOfPrintingDateTextField = new RoundJTextField(15);
        EndOfPrintingDateTextField.setText(EndOfPrintingDate);
        EndOfPrintingDateTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        EndOfPrintingDateTextField.setForeground(Color.darkGray);
        EndOfPrintingDateTextField.setBounds(905, 648+130, 613, 73);

        InsertButton = new RoundJButton();
        InsertButton.setBackground(new Color(0x625B49));
        InsertButton.setFocusable(false);
        InsertButton.setBounds(1551, 989, 202, 45);
        InsertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(InsertButton)) {
                    Validation v = new Validation();
                    if (v.ID(BookCodeTextField.getText().trim()) 
                    && v.NumOfPrintings(NumOfPrintingsTextField.getText().trim()) 
                    && v.EndOfPrintingDate(EndOfPrintingDateTextField.getText().trim())) {
                        // afdy el textfields
                        BookCodeTextField.setText("");
                        NumOfPrintingsTextField.setText("");
                        EndOfPrintingDateTextField.setText("");
                    }
                }
        }});

        InsertButtonLabel = new JLabel("Insert");
        InsertButtonLabel.setForeground(Color.WHITE);
        InsertButtonLabel.setFont(new Font("Inter", Font.PLAIN, 38));
        InsertButtonLabel.setBounds(1551 + 50, 987, 104, 45);

        this.add(InsertButtonLabel);
        this.add(InsertButton);
        this.add(EndOfPrintingDateTextField);
        this.add(EndOfPrintingDateTextLabel);
        this.add(NumOfPrintingsTextField);
        this.add(NumOfPrintingsTextLabel);
        this.add(BookCodeTextField);
        this.add(BookCodeTextLabel);
        this.add(HomeIconLabel);
        this.add(InsertIconLabel);
        this.add(Select_Or_UpdateIconLabel);
        this.add(InnerRec);
        this.add(OuterRec);
        this.add(RightSidePanel);
        this.setCursor(cursor);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Printer_Insert_Interface2 p = new Printer_Insert_Interface2();
    }
}
