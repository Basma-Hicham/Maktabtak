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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class OrderInterface_Buy extends JFrame {

        // nested classes
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
            g2D.drawLine(0, 603, getWidth() - 10, 603);
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
            g.setColor(new Color(0, 0, 0 , 75));
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
            g.setColor(Color.BLACK);
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

    private ImageIcon HomeIcon , OrderInfoIcon, OrderInfoIconHovered , CustomerInfoIcon , CustomerInfoIconHovered , VisaRadioButtonIcon , CashRadioButtonIcon , VisaIcon , CashIcon;
    private JLabel IDLabel , FNameLabel , LNameLabel , EMailLabel , BDLabel , PhoneLabel , StreetLabel , CityLabel , PostalCodeLabel , AddPhoneButtonLabel , OrderButtonLabel;
    private JLabel HomeIconLabel , OrderInfoIconLabel , CustomerInfoIconLabel , VisaIconLabel , CashIconLabel;
    private JPanel RightSidePanel;
    private InnerRec InnerRec;
    private OuterRec OuterRec;
    private RoundJTextField IDTextField , FNameTextField , LNameTextField , EMailTextField , BDTextField , PhoneTextField , StreetTextField ,
    CityTextField , PostalCodeTextField; 
    private RoundJButton AddPhoneButton , OrderButton;
    private JRadioButton VisaRadioButton , CashRadioButton;
    public static String ID = "";
    public static String FName = "";
    public static String LName = "";
    public static String EMail = "";
    public static String BD = "";
    public static String Phone = "";
    public static String Street = "";
    public static String City = "";
    public static String PostalCode = "";
    public static boolean CashChecked = true;
    public static boolean VisaChecked = false;

    OrderInterface_Buy() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.getContentPane().setBackground(new Color(0x99958C));
        this.setLayout(null);

        // Border
        InnerRec = new InnerRec(new Color(0x7F7A6E));
        InnerRec.setBounds(16+2, 11+2+8, 1762-6, 1058-6);
        OuterRec = new OuterRec(new Color(0xFEFFDE));
        OuterRec.setBounds(16-1, 11-1+8, 1762, 1058);

        RightSidePanel = new JPanel();
        RightSidePanel.setBackground(new Color(0x625B49));
        RightSidePanel.setBounds(1790, 0, 130, 1080);

        HomeIcon = new ImageIcon("homeIcon.png");
        HomeIconLabel = new JLabel();
        HomeIconLabel.setIcon(HomeIcon);
        HomeIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ID = "";
                FName = "";
                LName = "";
                EMail = "";
                BD = "";
                Phone = "";
                Street = "";
                City = "";
                PostalCode = "";
                MainOrderInterface.Date = "";
                MainOrderInterface.BookCode = "";
                MainOrderInterface.BorrowSelected = false;
                MainOrderInterface.BuySelected = true;
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
        HomeIconLabel.setBounds(1809 , 21 , 91 , 91);


        OrderInfoIcon = new ImageIcon("orderInfo.png");
        OrderInfoIconHovered = new ImageIcon("orderInfoHovered.png");
        OrderInfoIconLabel = new JLabel();
        OrderInfoIconLabel.setIcon(OrderInfoIcon);
        OrderInfoIconLabel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                ID = IDTextField.getText();
                FName = FNameTextField.getText();
                LName = LNameTextField.getText();
                EMail = EMailTextField.getText();
                BD = BDTextField.getText();
                Phone = PhoneTextField.getText();
                Street = StreetTextField.getText();
                City = CityTextField.getText();
                PostalCode = PostalCodeTextField.getText();
                new Order_Insert_Interface();
                // delay l el dispose
                Timer timer = new Timer(2000, event -> {
                    dispose();
                });
            
                timer.setRepeats(false);
                timer.start();   
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                OrderInfoIconLabel.setIcon(OrderInfoIconHovered);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                OrderInfoIconLabel.setIcon(OrderInfoIcon);
            }
        });
        OrderInfoIconLabel.setBounds(1815 , 494 , 91 , 91);

        IDLabel = new JLabel("ID");
        IDLabel.setForeground(Color.WHITE);
        IDLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        IDLabel.setBounds(42 , 48 , 44 , 90);
        IDTextField = new RoundJTextField(15);
        IDTextField.setText(ID);
        IDTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        IDTextField.setForeground(Color.darkGray);
        IDTextField.setBounds(153, 75, 409, 47);

        FNameLabel = new JLabel("First Name");
        FNameLabel.setForeground(Color.WHITE);
        FNameLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        FNameLabel.setBounds(42 , 156 , 224 , 45);
        FNameTextField = new RoundJTextField(15);
        FNameTextField.setText(FName);
        FNameTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        FNameTextField.setForeground(Color.darkGray);
        FNameTextField.setBounds(380, 161, 265+157, 47);

        LNameLabel = new JLabel("Last Name");
        LNameLabel.setForeground(Color.WHITE);
        LNameLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        LNameLabel.setBounds(944 , 156 , 217 , 45);
        LNameTextField = new RoundJTextField(15);
        LNameTextField.setText(LName);
        LNameTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        LNameTextField.setForeground(Color.darkGray);
        LNameTextField.setBounds(1277, 161, 265+157, 47);

        EMailLabel = new JLabel("E-mail");
        EMailLabel.setForeground(Color.WHITE);
        EMailLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        EMailLabel.setBounds(42 , 256 , 135 , 45);
        EMailTextField = new RoundJTextField(15);
        EMailTextField.setText(EMail);
        EMailTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        EMailTextField.setForeground(Color.darkGray);
        EMailTextField.setBounds(380, 258, 265+157, 47);

        BDLabel = new JLabel("Birth Date");
        BDLabel.setForeground(Color.WHITE);
        BDLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        BDLabel.setBounds(944 , 256 , 213 , 45);
        BDTextField = new RoundJTextField(15);
        BDTextField.setText(BD);
        BDTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        BDTextField.setForeground(Color.darkGray);
        BDTextField.setBounds(1277, 258, 265+157, 47);

        StreetLabel = new JLabel("Street");
        StreetLabel.setForeground(Color.WHITE);
        StreetLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        StreetLabel.setBounds(42 , 356 , 131 , 45);
        StreetTextField = new RoundJTextField(15);
        StreetTextField.setText(Street);
        StreetTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        StreetTextField.setForeground(Color.darkGray);
        StreetTextField.setBounds(380, 355, 265+157, 47);

        CityLabel = new JLabel("City");
        CityLabel.setForeground(Color.WHITE);
        CityLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        CityLabel.setBounds(944 , 337 , 88 , 65);
        CityTextField = new RoundJTextField(15);
        CityTextField.setText(City);
        CityTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        CityTextField.setForeground(Color.darkGray);
        CityTextField.setBounds(1277, 355, 265+157, 47);

        PostalCodeLabel = new JLabel("Postal Code");
        PostalCodeLabel.setForeground(Color.WHITE);
        PostalCodeLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        PostalCodeLabel.setBounds(42 , 452 , 249 , 45);
        PostalCodeTextField = new RoundJTextField(15);
        PostalCodeTextField.setText(PostalCode);
        PostalCodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PostalCodeTextField.setForeground(Color.darkGray);
        PostalCodeTextField.setBounds(380, 452, 265+157, 47);

        PhoneLabel = new JLabel("Phone");
        PhoneLabel.setForeground(Color.WHITE);
        PhoneLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        PhoneLabel.setBounds(161 , 703 , 130 , 45);
        PhoneTextField = new RoundJTextField(15);
        PhoneTextField.setText(Phone);
        PhoneTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PhoneTextField.setForeground(Color.darkGray);
        PhoneTextField.setBounds(420, 695, 265+157, 47);
        
        AddPhoneButton = new RoundJButton();
        AddPhoneButton.setBackground(new Color(0x625B49));
        AddPhoneButton.setFocusable(false);
        AddPhoneButton.setBounds(420+83, 780, 256, 45);
        AddPhoneButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // a3mel add ll phone
            }});

        AddPhoneButtonLabel = new JLabel("Add Phone");
        AddPhoneButtonLabel.setForeground(Color.WHITE);
        AddPhoneButtonLabel.setFont(new Font("K2D" , Font.PLAIN , 35));
        AddPhoneButtonLabel.setBounds(420+83+43, 780, 169, 45);

        VisaRadioButtonIcon = new ImageIcon("RadioButton.png");
        VisaRadioButton = new JRadioButton();
        VisaRadioButton.setOpaque(false);
        VisaRadioButton.setSelected(false);
        VisaRadioButton.setIcon(VisaRadioButtonIcon);
        VisaRadioButton.setBounds(86, 975, 27, 27);
        VisaRadioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(VisaRadioButton)) {
                    if(VisaRadioButton.isSelected()) VisaRadioButton.setSelected(false);
                    else VisaRadioButton.setSelected(true);
                }
            }
            
        });

        CashRadioButtonIcon = new ImageIcon("RadioButtonChecked.png");
        CashRadioButton = new JRadioButton();
        CashRadioButton.setOpaque(false);
        CashRadioButton.setSelected(true);
        CashRadioButton.setIcon(CashRadioButtonIcon);
        CashRadioButton.setBounds(86+287, 975, 27, 27);
        CashRadioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(CashRadioButton)) {
                    if(CashRadioButton.isSelected()){
                        CashChecked = false;
                        CashRadioButton.setSelected(false);
                    }
                    else {
                        CashChecked = true;
                        CashRadioButton.setSelected(true);
                    }
                }
            }
            
        });
        
        VisaIcon = new ImageIcon("Visa.png");
        VisaIconLabel = new JLabel();
        VisaIconLabel.setIcon(VisaIcon);
        VisaIconLabel.setBounds(86+56, 945, 87, 87);
        VisaIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if(!VisaRadioButton.isSelected()){
                    if(CashRadioButton.isSelected()){
                        CashChecked = false;
                        CashRadioButton.setSelected(false);
                    }
                    VisaChecked = true;
                    VisaRadioButton.setSelected(true);
                }
                else {
                    VisaChecked = false;
                    VisaRadioButton.setSelected(false);
                }

                if (VisaRadioButton.isSelected()) {
                    if(!CashRadioButton.isSelected()) {
                        CashRadioButtonIcon = new ImageIcon("RadioButton.png");
                        CashRadioButton.setIcon(CashRadioButtonIcon);
                    }

                    VisaRadioButtonIcon = new ImageIcon("RadioButtonChecked.png");
                    VisaRadioButton.setIcon(VisaRadioButtonIcon);
                }
                else {
                    VisaRadioButtonIcon = new ImageIcon("RadioButton.png");
                    VisaRadioButton.setIcon(VisaRadioButtonIcon);
                }

            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {} 
            @Override public void mouseExited(MouseEvent e) {}
            
        });
        
        CashIcon = new ImageIcon("Cash.png");
        CashIconLabel = new JLabel();
        CashIconLabel.setIcon(CashIcon);
        CashIconLabel.setBounds(86+287+56, 935, 102, 102);
        CashIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!CashRadioButton.isSelected()){
                    if(VisaRadioButton.isSelected()){
                        VisaChecked = false;
                        VisaRadioButton.setSelected(false);
                    }
                    CashChecked = true;
                    CashRadioButton.setSelected(true);
                }                
                else {
                    CashChecked = false;
                    CashRadioButton.setSelected(false);
                }

                if (CashRadioButton.isSelected()) {
                    if(!VisaRadioButton.isSelected()) {
                        VisaRadioButtonIcon = new ImageIcon("RadioButton.png");
                        VisaRadioButton.setIcon(VisaRadioButtonIcon);
                    }

                    CashRadioButtonIcon = new ImageIcon("RadioButtonChecked.png");
                    CashRadioButton.setIcon(CashRadioButtonIcon);
                }
                else {
                    CashRadioButtonIcon = new ImageIcon("RadioButton.png");
                    CashRadioButton.setIcon(CashRadioButtonIcon);
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {} 
            @Override public void mouseExited(MouseEvent e) {}
            
        });

        OrderButton = new RoundJButton();
        OrderButton.setBackground(new Color(0x625B49));
        OrderButton.setFocusable(false);
        OrderButton.setBounds(1551, 989, 202, 45);
        OrderButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(OrderButton)) {
                    Validation v = new Validation();
                    if (v.ID(IDTextField.getText().trim()) && v.f_name(FNameTextField.getText().trim()) && v.l_name(LNameTextField.getText().trim())
                        && v.email(EMailTextField.getText().trim()) && v.BD(BDTextField.getText().trim()) 
                        && v.street(StreetTextField.getText().trim()) && v.city(CityTextField.getText().trim()) 
                        && v.postal(PostalCodeTextField.getText().trim()) && v.payment(VisaChecked, CashChecked)) {
                        // afdy el textfields w neb3t ll Database
                        IDTextField.setText("");
                        FNameTextField.setText("");
                        LNameTextField.setText("");
                        EMailTextField.setText("");
                        BDTextField.setText("");
                        StreetTextField.setText("");
                        CityTextField.setText("");
                        PostalCodeTextField.setText("");
                        //fadel el phone
                    }
                }
        }});

        OrderButtonLabel = new JLabel("Order");
        OrderButtonLabel.setForeground(Color.WHITE);
        OrderButtonLabel.setFont(new Font("K2D" , Font.PLAIN , 35));
        OrderButtonLabel.setBounds(1551+57, 987, 88, 45);
        
        // cursor frame el maktaba
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon cursorImage = new ImageIcon("custom_cursor.png");
                Image cursorImageObj = cursorImage.getImage();
                Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImageObj, new Point(0, 0),
                        "Custom Cursor");
                setCursor(customCursor);
            }
        });

                // get previous checked
                if (VisaChecked) {
                    VisaRadioButton.setSelected(true);
                    VisaRadioButtonIcon = new ImageIcon("RadioButtonChecked.png");
                    VisaRadioButton.setIcon(VisaRadioButtonIcon);
                    CashChecked = false;
                    CashRadioButton.setSelected(false);
                    CashRadioButtonIcon = new ImageIcon("RadioButton.png");
                    CashRadioButton.setIcon(CashRadioButtonIcon);
                }
                else if (CashChecked) {
                    CashRadioButton.setSelected(true);
                    CashRadioButtonIcon = new ImageIcon("RadioButtonChecked.png");
                    CashRadioButton.setIcon(CashRadioButtonIcon);
                    VisaChecked = false;
                    VisaRadioButton.setSelected(false);
                    VisaRadioButtonIcon = new ImageIcon("RadioButton.png");
                    VisaRadioButton.setIcon(VisaRadioButtonIcon);
                }
                else {
                    VisaChecked = false;
                    VisaRadioButton.setSelected(false);
                    VisaRadioButtonIcon = new ImageIcon("RadioButton.png");
                    VisaRadioButton.setIcon(VisaRadioButtonIcon);
                    CashChecked = true;
                    CashRadioButton.setSelected(true);
                    CashRadioButtonIcon = new ImageIcon("RadioButtonChecked.png");
                    CashRadioButton.setIcon(CashRadioButtonIcon);
                }

        this.add(OrderButtonLabel);
        this.add(OrderButton);
        this.add(CashIconLabel);
        this.add(VisaIconLabel);
        this.add(CashRadioButton);
        this.add(VisaRadioButton);
        this.add(AddPhoneButtonLabel);
        this.add(AddPhoneButton);
        this.add(PhoneTextField);
        this.add(PhoneLabel);
        this.add(PostalCodeTextField);
        this.add(PostalCodeLabel);
        this.add(CityTextField);
        this.add(CityLabel);
        this.add(StreetTextField);
        this.add(StreetLabel);
        this.add(BDTextField);
        this.add(BDLabel);
        this.add(EMailTextField);
        this.add(EMailLabel);
        this.add(LNameTextField);
        this.add(LNameLabel);
        this.add(FNameTextField);
        this.add(FNameLabel);
        this.add(IDTextField);
        this.add(IDLabel);
        this.add(HomeIconLabel);
        this.add(OrderInfoIconLabel);
        this.add(RightSidePanel);
        this.add(InnerRec);
        this.add(OuterRec);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        OrderInterface_Buy b = new OrderInterface_Buy();
    }
}
