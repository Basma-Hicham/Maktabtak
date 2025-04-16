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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Order_Insert_Interface extends JFrame {

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
        private ImageIcon HomeIcon , RadioButtonIcon , RadioButtonIconChecked;
        private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),"customCursor");
        private InnerRec InnerRec;
        private OuterRec OuterRec;
        private JLabel DateTextLabel , BookCodeTextLabel , BorrowTextLabel , BuyTextLabel , NextButtonLabel;
        private JLabel HomeIconLabel;
        private RoundJTextField DateTextField , BookCodeTextField;
        private RoundJButton NextButton;
        private JRadioButton BorrowRadioButton , BuyRadioButton;
        public static String Date = "";
        public static String BookCode = "";
        public static boolean BorrowSelected = false;
        public static boolean BuySelected = true;

        Order_Insert_Interface() {

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
                OrderInterface_Borrow.ID = "";
                OrderInterface_Borrow.FName = "";
                OrderInterface_Borrow.LName = "";
                OrderInterface_Borrow.EMail = "";
                OrderInterface_Borrow.BD = "";
                OrderInterface_Borrow.Phone = "";
                OrderInterface_Borrow.Street = "";
                OrderInterface_Borrow.City = "";
                OrderInterface_Borrow.PostalCode = "";
                OrderInterface_Borrow.BorrowDate = "";
                OrderInterface_Buy.ID = "";
                OrderInterface_Buy.FName = "";
                OrderInterface_Buy.LName = "";
                OrderInterface_Buy.EMail = "";
                OrderInterface_Buy.BD = "";
                OrderInterface_Buy.Phone = "";
                OrderInterface_Buy.Street = "";
                OrderInterface_Buy.City = "";
                OrderInterface_Buy.PostalCode = "";
                Date = "";
                BookCode = "";
                BorrowSelected = false;
                BuySelected = true; 
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

        DateTextLabel = new JLabel("Date");
        DateTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        DateTextLabel.setForeground(Color.WHITE);
        DateTextLabel.setBounds(275 , 170 , 272 , 58);

        DateTextField = new RoundJTextField(15);
        DateTextField.setText(Date);
        DateTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        DateTextField.setForeground(Color.darkGray);
        DateTextField.setBounds(905, 159, 613, 73);

        BookCodeTextLabel = new JLabel("Book Code");
        BookCodeTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        BookCodeTextLabel.setForeground(Color.WHITE);
        BookCodeTextLabel.setBounds(275 , 355+130 , 529 , 58);
        
        BookCodeTextField = new RoundJTextField(15);
        BookCodeTextField.setText(BookCode);
        BookCodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        BookCodeTextField.setForeground(Color.darkGray);
        BookCodeTextField.setBounds(905, 355+130, 613, 73);

        RadioButtonIcon = new ImageIcon("RadioButton.png");
        RadioButtonIconChecked = new ImageIcon("RadioButtonChecked.png");

        BorrowRadioButton = new JRadioButton();
        BorrowRadioButton.setIcon(RadioButtonIcon);
        BorrowRadioButton.setSelected(false);
        BorrowRadioButton.setOpaque(false);
        BorrowRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    BorrowRadioButton.setIcon(RadioButtonIconChecked);
                    BorrowSelected = true;
                    BuySelected = false;
                    BuyRadioButton.setSelected(false);
                } else {
                    BorrowSelected = false;
                    BorrowRadioButton.setIcon(RadioButtonIcon);
                }
            }
        });
        BorrowRadioButton.setBounds(190, 857, 60, 60);      

        BorrowTextLabel = new JLabel("Borrow");
        BorrowTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        BorrowTextLabel.setForeground(Color.WHITE);
        BorrowTextLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(!BorrowRadioButton.isSelected()){
                    if(BuyRadioButton.isSelected()){
                        BuySelected = false;
                        BuyRadioButton.setSelected(false);
                    }
                    BorrowSelected = true;
                    BorrowRadioButton.setSelected(true);
                }                
                else {
                    BorrowSelected = false;
                    BorrowRadioButton.setSelected(false);
                }

                if (BorrowRadioButton.isSelected()) {
                    if(!BorrowRadioButton.isSelected()) {
                        BorrowRadioButton.setIcon(RadioButtonIcon);
                    }

                    BorrowRadioButton.setIcon(RadioButtonIconChecked);
                }
                else {
                    BorrowRadioButton.setIcon(RadioButtonIcon);
                }
            }
        
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) { BorrowTextLabel.setForeground(Color.green); }
            @Override public void mouseExited(MouseEvent e) { BorrowTextLabel.setForeground(Color.WHITE); }
        
        });
        BorrowTextLabel.setBounds(246 , 853 , 173 , 67);

        BuyRadioButton = new JRadioButton();
        BuyRadioButton.setIcon(RadioButtonIconChecked);
        BuyRadioButton.setSelected(true);
        BuyRadioButton.setOpaque(false);
        BuyRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    BuyRadioButton.setIcon(RadioButtonIconChecked);
                    BuySelected = true;
                    BorrowSelected = false;
                    BorrowRadioButton.setSelected(false);
                } else {
                    BuySelected = false;
                    BuyRadioButton.setIcon(RadioButtonIcon);
                }
            }
        });
        BuyRadioButton.setBounds(519, 857, 60, 60);

        BuyTextLabel = new JLabel("Buy");
        BuyTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        BuyTextLabel.setForeground(Color.WHITE);
        BuyTextLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(!BuyRadioButton.isSelected()){
                    if(BorrowRadioButton.isSelected()) {
                        BorrowSelected = false;
                        BorrowRadioButton.setSelected(false);
                    }
                    BuySelected = true;
                    BuyRadioButton.setSelected(true);
                }                
                else {
                    BuySelected = false;
                    BuyRadioButton.setSelected(false);
                }
                if (BuyRadioButton.isSelected()) {
                    if(!BuyRadioButton.isSelected()) {
                        BuyRadioButton.setIcon(RadioButtonIcon);
                    }

                    BuyRadioButton.setIcon(RadioButtonIconChecked);
                }
                else {
                    BuyRadioButton.setIcon(RadioButtonIcon);
                }
            }
        
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) { BuyTextLabel.setForeground(Color.green); }
            @Override public void mouseExited(MouseEvent e) { BuyTextLabel.setForeground(Color.WHITE); }
        
        });
        BuyTextLabel.setBounds(519+56 , 853 , 90 , 67);

        NextButton = new RoundJButton();
        NextButton.setBackground(new Color(0x625B49));
        NextButton.setFocusable(false);
        NextButton.setBounds(1551, 989, 202, 45);
        NextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { 
                if (e.getSource().equals(NextButton)) {
                    Validation v = new Validation();
                    if(v.Date(DateTextField.getText().trim()) && v.ID(BookCodeTextField.getText().trim())) {
                        //hshof fe el database (Book) wla la
                        BookCode = BookCodeTextField.getText();
                        Date = DateTextField.getText();
                        if (BorrowSelected) {
                            new OrderInterface_Borrow();
                        }
                        else {
                            new OrderInterface_Buy();
                        }
                        // delay l el dispose
                        Timer timer = new Timer(2000, event -> {
                        dispose();
                        });
                    
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
            }

        });

        NextButtonLabel = new JLabel("Next");
        NextButtonLabel.setForeground(Color.WHITE);
        NextButtonLabel.setFont(new Font("Inter", Font.PLAIN, 38));
        NextButtonLabel.setBounds(1551 + 60, 987, 104, 45);

                        // get previous checked
                        if (BorrowSelected) {
                            BorrowRadioButton.setSelected(true);
                            BorrowRadioButton.setIcon(RadioButtonIconChecked);
                            BuySelected = false;
                            BuyRadioButton.setSelected(false);
                            BuyRadioButton.setIcon(RadioButtonIcon);
                        }
                        else if (BuySelected) {
                            BuyRadioButton.setSelected(true);
                            BuyRadioButton.setIcon(RadioButtonIconChecked);
                            BorrowSelected = false;
                            BorrowRadioButton.setSelected(false);
                            BorrowRadioButton.setIcon(RadioButtonIcon);
                        }
                        else {
                            BorrowSelected = false;
                            BorrowRadioButton.setIcon(RadioButtonIcon);
                            BorrowRadioButton.setSelected(false);
                            BuySelected = true;
                            BuyRadioButton.setIcon(RadioButtonIconChecked);
                            BuyRadioButton.setSelected(true);
                        }

        this.add(NextButtonLabel);
        this.add(NextButton);
        this.add(BuyTextLabel);
        this.add(BuyRadioButton);
        this.add(BorrowTextLabel);
        this.add(BorrowRadioButton);
        this.add(BookCodeTextField);
        this.add(BookCodeTextLabel);
        this.add(DateTextField);
        this.add(DateTextLabel);
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
        new Order_Insert_Interface();
    }

}
