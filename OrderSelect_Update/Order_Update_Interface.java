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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order_Update_Interface extends JFrame {

    public class OrderTableRec extends JPanel {
        private Shape shape;
        Color Color;

        public OrderTableRec(Color Color) {
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
            g2D.drawLine(0, 546, getWidth() - 11, 546);
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
    private JLabel HomeIconLabel, InsertIconLabel, Select_Or_UpdateIconLabel, OrderCodeTextLabel, SelectButtonLabel;
    private JLabel UpdateButtonLabel, OrderRowTextLabel , PaymentMethodLabel , AddressLabel;
    private RoundJTextField OrderCodeTextField , PaymentMethodTextField , AddressTextField;
    private RoundJButton SelectButton, UpdateButton;
    private OrderTableRec OrderTableRec;

    Order_Update_Interface() {

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

        OrderCodeTextLabel = new JLabel("Code");
        OrderCodeTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        OrderCodeTextLabel.setForeground(Color.WHITE);
        OrderCodeTextLabel.setBounds(96, 123, 220, 45);

        OrderCodeTextField = new RoundJTextField(15);
        OrderCodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        OrderCodeTextField.setForeground(Color.darkGray);
        OrderCodeTextField.setBounds(344, 125, 316, 47);

        SelectButton = new RoundJButton();
        SelectButton.setBackground(new Color(0x625B49));
        SelectButton.setFocusable(false);
        SelectButton.setBounds(724, 117, 308, 61);
        SelectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(SelectButton)) {
                    Validation v = new Validation();
                    if (v.ID(OrderCodeTextField.getText().trim())) {
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

        OrderTableRec = new OrderTableRec(new Color(0xD9D9D9));
        OrderTableRec.setBounds(59 + 12, 251, 1638, 202);
        
        OrderRowTextLabel = new JLabel("   Order Row");
        OrderRowTextLabel.setForeground(Color.BLACK);
        OrderRowTextLabel.setFont(new Font("Inter", Font.PLAIN, 110));
        OrderRowTextLabel.setBounds(497, 294, 762, 100);

        PaymentMethodLabel = new JLabel("Payment Method");
        PaymentMethodLabel.setForeground(Color.WHITE);
        PaymentMethodLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        PaymentMethodLabel.setBounds(163 , 664 , 350 , 45);
        PaymentMethodTextField = new RoundJTextField(15);
        PaymentMethodTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PaymentMethodTextField.setForeground(Color.darkGray);
        PaymentMethodTextField.setBounds(632, 656, 265, 62);

        AddressLabel = new JLabel("Address");
        AddressLabel.setForeground(Color.WHITE);
        AddressLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        AddressLabel.setBounds(1054, 664, 168, 45);
        AddressTextField = new RoundJTextField(15);
        AddressTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        AddressTextField.setForeground(Color.darkGray);
        AddressTextField.setBounds(1396, 656, 265, 62);

        this.add(PaymentMethodLabel);
        this.add(PaymentMethodTextField);
        this.add(AddressLabel);
        this.add(AddressTextField);
        this.add(OrderRowTextLabel);
        this.add(OrderTableRec);
        this.add(UpdateButtonLabel);
        this.add(UpdateButton);
        this.add(SelectButtonLabel);
        this.add(SelectButton);
        this.add(OrderCodeTextField);
        this.add(OrderCodeTextLabel);
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
        Order_Update_Interface u = new Order_Update_Interface();
    }
}
