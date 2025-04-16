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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Customer_Update_Interface extends JFrame {

    public class CustomerTableRec extends JPanel {
        private Shape shape;
        Color Color;

        public CustomerTableRec(Color Color) {
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
    private ImageIcon HomeIcon, SelectIcon, InsertIcon;
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),
            "customCursor");
    private InnerRec InnerRec;
    private OuterRec OuterRec;
    private JLabel HomeIconLabel, InsertIconLabel, Select_Or_UpdateIconLabel, IDTextLabel, SelectButtonLabel;
    private JLabel UpdateButtonLabel, CustomerRowTextLabel , FNameLabel , LNameLabel , EMailLabel , BDLabel , StreetLabel , CityLabel , PostalCodeLabel;
    private RoundJTextField IDTextFeild , FNameTextField , LNameTextField , EMailTextField , BDTextField , StreetTextField , CityTextField , PostalCodeTextField;
    private RoundJButton SelectButton, UpdateButton;
    private CustomerTableRec CustomerTableRec;

    Customer_Update_Interface() {

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

        InnerRec = new InnerRec(new Color(0x7F7A6E));
        InnerRec.setBounds(16 + 2, 11 + 2 + 8, 1762 - 6, 1058 - 6);
        OuterRec = new OuterRec(new Color(0xFEFFDE));
        OuterRec.setBounds(16 - 1, 11 - 1 + 8, 1762, 1058);

        IDTextLabel = new JLabel("ID");
        IDTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        IDTextLabel.setForeground(Color.WHITE);
        IDTextLabel.setBounds(96, 123, 220, 45);

        IDTextFeild = new RoundJTextField(15);
        IDTextFeild.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        IDTextFeild.setForeground(Color.darkGray);
        IDTextFeild.setBounds(344, 125, 316, 47);

        SelectButton = new RoundJButton();
        SelectButton.setBackground(new Color(0x625B49));
        SelectButton.setFocusable(false);
        SelectButton.setBounds(724, 117, 308, 61);
        SelectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(SelectButton)) {
                    Validation v = new Validation();
                    if (v.ID(IDTextFeild.getText().trim())) {
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

        CustomerTableRec = new CustomerTableRec(new Color(0xD9D9D9));
        CustomerTableRec.setBounds(59 + 12, 251, 1638, 202);

        CustomerRowTextLabel = new JLabel("Customer Row");
        CustomerRowTextLabel.setForeground(Color.BLACK);
        CustomerRowTextLabel.setFont(new Font("Inter", Font.PLAIN, 110));
        CustomerRowTextLabel.setBounds(497, 294, 762, 100);

        FNameLabel = new JLabel("First Name");
        FNameLabel.setForeground(Color.WHITE);
        FNameLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        FNameLabel.setBounds(58 , 511 , 224 , 45);
        FNameTextField = new RoundJTextField(15);
        FNameTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        FNameTextField.setForeground(Color.darkGray);
        FNameTextField.setBounds(396, 503, 265, 62);

        LNameLabel = new JLabel("Last Name");
        LNameLabel.setForeground(Color.WHITE);
        LNameLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        LNameLabel.setBounds(963 , 511 , 217 , 45);
        LNameTextField = new RoundJTextField(15);
        LNameTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        LNameTextField.setForeground(Color.darkGray);
        LNameTextField.setBounds(1311, 503, 265, 62);

        EMailLabel = new JLabel("E-mail");
        EMailLabel.setForeground(Color.WHITE);
        EMailLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        EMailLabel.setBounds(58 , 611 , 135 , 45);
        EMailTextField = new RoundJTextField(15);
        EMailTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        EMailTextField.setForeground(Color.darkGray);
        EMailTextField.setBounds(396, 603, 265, 62);

        BDLabel = new JLabel("Birth Date");
        BDLabel.setForeground(Color.WHITE);
        BDLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        BDLabel.setBounds(963 , 611 , 213 , 45);
        BDTextField = new RoundJTextField(15);
        BDTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        BDTextField.setForeground(Color.darkGray);
        BDTextField.setBounds(1311, 603, 265, 62);

        StreetLabel = new JLabel("Street");
        StreetLabel.setForeground(Color.WHITE);
        StreetLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        StreetLabel.setBounds(963 , 711 , 131 , 45);
        StreetTextField = new RoundJTextField(15);
        StreetTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        StreetTextField.setForeground(Color.darkGray);
        StreetTextField.setBounds(1311, 703, 265, 62);

        CityLabel = new JLabel("City");
        CityLabel.setForeground(Color.WHITE);
        CityLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        CityLabel.setBounds(58 , 711 , 88 , 65);
        CityTextField = new RoundJTextField(15);
        CityTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        CityTextField.setForeground(Color.darkGray);
        CityTextField.setBounds(396, 703, 265, 62);

        PostalCodeLabel = new JLabel("Postal Code");
        PostalCodeLabel.setForeground(Color.WHITE);
        PostalCodeLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        PostalCodeLabel.setBounds( 58  , 811 , 249 , 45);
        PostalCodeTextField = new RoundJTextField(15);
        PostalCodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PostalCodeTextField.setForeground(Color.darkGray);
        PostalCodeTextField.setBounds(396, 803, 265, 63);

        this.add(FNameLabel);
        this.add(FNameTextField);
        this.add(LNameLabel);
        this.add(LNameTextField);
        this.add(EMailLabel);
        this.add(EMailTextField);
        this.add(BDLabel);
        this.add(BDTextField);
        this.add(StreetLabel);
        this.add(StreetTextField);
        this.add(CityLabel);
        this.add(CityTextField);
        this.add(CustomerRowTextLabel);
        this.add(CustomerTableRec);
        this.add(UpdateButtonLabel);
        this.add(UpdateButton);
        this.add(SelectButtonLabel);
        this.add(SelectButton);
        this.add(IDTextFeild);
        this.add(IDTextLabel);
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
        new Customer_Update_Interface();
    }
}
