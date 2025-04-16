import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.net.IDN;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Author_Insert_Interface extends JFrame {

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
            g2D.drawLine(0, 628, getWidth() - 10, 628);
            super.paintComponent(g);        }

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
    private ImageIcon HomeIcon, SelectIcon, InsertIcon;
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),
            "customCursor");
    private InnerRec InnerRec;
    private OuterRec OuterRec;
    private JLabel HomeIconLabel, InsertIconLabel, Select_Or_UpdateIconLabel, IDTextLabel;
    private JLabel InsertButtonLabel , FNameLabel , LNameLabel , EMailLabel , BDLabel , HisBooksLabel , AddBookButtonLabel;
    private RoundJTextField IDTextFeild , FNameTextField , LNameTextField , EMailTextField , BDTextField , HisBooksTextField;
    private RoundJButton InsertButton , AddBookButton;
    public static String ID = "";
    public static String FName = "";
    public static String LName = "";
    public static String EMail = "";
    public static String BD = "";
    public static String Book = "";


    Author_Insert_Interface() {

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
                Author_Select_Or_Update_Interface.ID = "";
                ID = "";
                FName = "";
                LName = "";
                EMail = "";
                BD = "";
                Book = "";
                new HomeInterface();
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
                ID = IDTextFeild.getText();
                FName = FNameTextField.getText();
                LName = LNameTextField.getText();
                EMail = EMailTextField.getText();
                BD = BDTextField.getText();
                Book = HisBooksTextField.getText();
                new Author_Select_Or_Update_Interface();
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
        InsertIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
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
        InsertIconLabel.setBounds(1821, 556, 72, 72);

        InnerRec = new InnerRec(new Color(0x7F7A6E));
        InnerRec.setBounds(16 + 2, 11 + 2 + 8, 1762 - 6, 1058 - 6);
        OuterRec = new OuterRec(new Color(0xFEFFDE));
        OuterRec.setBounds(16 - 1, 11 - 1 + 8, 1762, 1058);

        IDTextLabel = new JLabel("ID");
        IDTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        IDTextLabel.setForeground(Color.WHITE);
        IDTextLabel.setBounds(580, 120, 220, 45);

        IDTextFeild = new RoundJTextField(15);
        IDTextFeild.setText(ID);
        IDTextFeild.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        IDTextFeild.setForeground(Color.darkGray);
        IDTextFeild.setBounds(805, 120, 316, 47);

        InsertButton = new RoundJButton();
        InsertButton.setBackground(new Color(0x625B49));
        InsertButton.setFocusable(false);
        InsertButton.setBounds(1551, 989, 202, 45);
        InsertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(InsertButton)) {
                    Validation v = new Validation();
                    if (v.ID(IDTextFeild.getText().trim()) && v.f_name(FNameTextField.getText().trim()) 
                    && v.l_name(LNameTextField.getText().trim()) && v.email(EMailTextField.getText().trim()) 
                    && v.BD(BDTextField.getText().trim())) {
                        // afdy el textfields
                        IDTextFeild.setText("");
                        FNameTextField.setText("");
                        LNameTextField.setText("");
                        EMailTextField.setText("");
                        BDTextField.setText("");
                        //fadel el books
                    }
                }
        }});

        InsertButtonLabel = new JLabel("Insert");
        InsertButtonLabel.setForeground(Color.WHITE);
        InsertButtonLabel.setFont(new Font("Inter", Font.PLAIN, 35));
        InsertButtonLabel.setBounds(1551 + 57, 987, 134, 45);

        FNameLabel = new JLabel("First Name");
        FNameLabel.setForeground(Color.WHITE);
        FNameLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        FNameLabel.setBounds(61 , 324 , 224 , 45);

        FNameTextField = new RoundJTextField(15);
        FNameTextField.setText(FName);
        FNameTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        FNameTextField.setForeground(Color.darkGray);
        FNameTextField.setBounds(399, 316, 265, 62);

        LNameLabel = new JLabel("Last Name");
        LNameLabel.setForeground(Color.WHITE);
        LNameLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        LNameLabel.setBounds(966 , 324 , 217 , 45);

        LNameTextField = new RoundJTextField(15);
        LNameTextField.setText(LName);
        LNameTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        LNameTextField.setForeground(Color.darkGray);
        LNameTextField.setBounds(1314, 316, 265, 62);

        EMailLabel = new JLabel("E-mail");
        EMailLabel.setForeground(Color.WHITE);
        EMailLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        EMailLabel.setBounds(61 , 479 , 135 , 45);

        EMailTextField = new RoundJTextField(15);
        EMailTextField.setText(EMail);
        EMailTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        EMailTextField.setForeground(Color.darkGray);
        EMailTextField.setBounds(396, 471, 265, 62);

        BDLabel = new JLabel("Birth Date");
        BDLabel.setForeground(Color.WHITE);
        BDLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        BDLabel.setBounds(963 , 484 , 213 , 45);

        BDTextField = new RoundJTextField(15);
        BDTextField.setText(BD);
        BDTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        BDTextField.setForeground(Color.darkGray);
        BDTextField.setBounds(1311, 471, 265, 62);

        HisBooksLabel = new JLabel("His Books");
        HisBooksLabel.setForeground(Color.WHITE);
        HisBooksLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        HisBooksLabel.setBounds(580 , 729 , 260 , 45);

        HisBooksTextField = new RoundJTextField(15);
        HisBooksTextField.setText(Book);
        HisBooksTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        HisBooksTextField.setForeground(Color.darkGray);
        HisBooksTextField.setBounds(805, 721, 265+157, 47);
        
        AddBookButton = new RoundJButton();
        AddBookButton.setBackground(new Color(0x625B49));
        AddBookButton.setFocusable(false);
        AddBookButton.setBounds(876, 828, 256, 45);
        AddBookButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // a3mel add ll phone
            }});

        AddBookButtonLabel = new JLabel("Add Book");
        AddBookButtonLabel.setForeground(Color.WHITE);
        AddBookButtonLabel.setFont(new Font("K2D" , Font.PLAIN , 35));
        AddBookButtonLabel.setBounds(930, 827, 169, 45);

        this.add(AddBookButtonLabel);
        this.add(AddBookButton);
        this.add(HisBooksTextField);
        this.add(HisBooksLabel);
        this.add(FNameLabel);
        this.add(FNameTextField);
        this.add(LNameLabel);
        this.add(LNameTextField);
        this.add(EMailLabel);
        this.add(EMailTextField);
        this.add(BDLabel);
        this.add(BDTextField);
        this.add(InsertButtonLabel);
        this.add(InsertButton);
        this.add(IDTextFeild);
        this.add(IDTextLabel);
        this.add(Select_Or_UpdateIconLabel);
        this.add(InsertIconLabel);
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
        Author_Insert_Interface A = new Author_Insert_Interface();
    }
}
