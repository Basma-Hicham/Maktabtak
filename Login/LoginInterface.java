import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class LoginInterface extends JFrame {

    final String adminID = "admin";
    final String adminPassword = "admin";
    final String publisherID = "publisher";
    final String publisherPassword = "publisher";
    final String LibraryName = "Maktabtak";

    // Nested Classes
    public class Line1 extends JPanel {

        Line1() {
            this.setPreferredSize(new Dimension(1920, 1080));
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(2));
            g2D.drawLine(0, 111, 1920, 111);
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

    public class RoundJPasswordField extends JPasswordField {
        private Shape shape;

        public RoundJPasswordField(int size) {
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
            g.setColor(new Color(0x938D6D));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
        }

        protected void paintComponent(Graphics g) {
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

    public class LoginForm extends JPanel {

        public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setPaint(new Color(0xFEFFDE));
            g2D.fillRoundRect(0, 0, 1094, 570, 35, 55);
        }

    }

    public class LoginFormShadow extends JPanel {

        public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setPaint(new Color(0, 0, 0, 25));
            g2D.fillRoundRect(0, 0, 1094, 570, 35, 55);
        }

    }

    public class OutlineLabel extends JPanel {
        private JLabel textLabel;
        private JLabel outlineLabel;
    
        public OutlineLabel() {
            this("MAKTABTAK", new Font("ZCOOL KuaiLe", Font.BOLD, 40), new Color(0x625B49), Color.WHITE, 2);
        }
    
        public OutlineLabel(String text, Font font, Color textColor, Color outlineColor, int outlineThickness) {
            setLayout(new OverlayLayout(this));
            
            textLabel = new JLabel(text);
            textLabel.setFont(font);
            textLabel.setForeground(textColor);
            textLabel.setAlignmentX(0.5f);
            textLabel.setAlignmentY(0.5f);
            add(textLabel);
            
            outlineLabel = new JLabel(text);
            outlineLabel.setFont(font);
            outlineLabel.setForeground(outlineColor);
            outlineLabel.setAlignmentX(0.5f);
            outlineLabel.setAlignmentY(0.5f);
            outlineLabel.setBorder(BorderFactory.createEmptyBorder(outlineThickness, outlineThickness, outlineThickness, outlineThickness));
            outlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
            outlineLabel.setVerticalAlignment(SwingConstants.CENTER);
            outlineLabel.setSize(textLabel.getPreferredSize());
            add(outlineLabel);
        }
    }

    private Line1 Line1;
    private JPanel RightSidePanel;
    private JLabel Help, HelpIconLabel, LibraryIconLabel, LoginButtonLabel;
    private ImageIcon HelpIcon, LibraryIcon, showPasswordIcon;
    private JLabel HazemData = new JLabel("Hazem Attia:12400584:C2");
    private JLabel BasmaData = new JLabel("Basma Hisham:12400712:C2");
    private DataPanel1 DataPanel1;
    private DataPanel2 DataPanel2;
    private LoginForm LoginFrom;
    private LoginFormShadow LoginFormShadow;
    private JLabel ID, Password;
    private JLabel LibraryNameLabel;
    private RoundJTextField IDTextField = null;
    private LoginInterface.RoundJPasswordField PasswordField = null;
    private RoundJButton LoginButton;
    private JCheckBox showPasswordCheckBox;
    private boolean CorrectID = false;
    private boolean CorrectPassword = false;

    LoginInterface() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setBackground(new Color(0x625B49));

        // Icons
        LibraryIcon = new ImageIcon("Untitled-1.png");
        HelpIcon = new ImageIcon("Untitled-2.png");
        showPasswordIcon = new ImageIcon("Show Password.png");

        // Labels
        LibraryIconLabel = new JLabel();
        LibraryIconLabel.setIcon(LibraryIcon);
        LibraryIconLabel.setBounds(1380, 138, 160, 148);

        DataPanel1 = new DataPanel1();
        DataPanel1.setBounds(466, 964, 420, 58);

        DataPanel2 = new DataPanel2();
        DataPanel2.setBounds(929, 964, 400, 58);

        HazemData.setFont(new Font("Inter", Font.PLAIN, 29));
        BasmaData.setFont(new Font("Inter", Font.PLAIN, 29));

        HazemData.setBounds(945, 974, 361, 35);
        BasmaData.setBounds(484, 974, 394, 35);

        HelpIconLabel = new JLabel();
        HelpIconLabel.setIcon(HelpIcon);
        HelpIconLabel.setBounds(211, 15, 82, 82);

        Help = new JLabel("Help");
        Help.setFont(new Font("Kadwa", Font.PLAIN, 50));
        Help.setForeground(Color.white);
        Help.setBounds(55, 31, 113, 50);

        ID = new JLabel("ID");
        ID.setForeground(new Color(0x928971));
        ID.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 40));
        ID.setBounds(520, 393, 31, 52);

        Password = new JLabel("Password");
        Password.setForeground(new Color(0x928971));
        Password.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 40));
        Password.setBounds(520, 521, 140, 52);

        LibraryNameLabel = new JLabel("MAKTABTAK");
        LibraryNameLabel.setForeground(new Color(0x625B49));
        LibraryNameLabel.setFont(new Font("ZCOOL KuaiLe", Font.BOLD, 40));
        LibraryNameLabel.setBounds(784, 253, 280, 52);

        LoginButtonLabel = new JLabel("Login");
        LoginButtonLabel.setForeground(Color.white);
        LoginButtonLabel.setFont(new Font("Inter", Font.PLAIN, 36));
        LoginButtonLabel.setBounds(857, 663, 217, 101);

        // Panels

        Line1 = new Line1();
        RightSidePanel = new JPanel();
        RightSidePanel.setBackground(new Color(0x312D24));
        RightSidePanel.setBounds(1818, 0, 102, 1080);

        LoginFrom = new LoginForm();
        LoginFrom.setBounds(354, 226, 1094, 570);

        LoginFormShadow = new LoginFormShadow();
        LoginFormShadow.setBounds(389, 277, 1094, 570);

        // Text Fields
        IDTextField = new RoundJTextField(15);
        IDTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        IDTextField.setForeground(Color.darkGray);
        IDTextField.setBounds(771, 400, 539, 47);

        PasswordField = new RoundJPasswordField(15);
        PasswordField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PasswordField.setForeground(Color.darkGray);
        PasswordField.setEchoChar('*');
        PasswordField.setBounds(771, 528, 539, 47);

        // Buttons
        LoginButton = new RoundJButton();
        LoginButton.setBackground(new Color(0x938D6D));
        LoginButton.setFocusable(false);
        LoginButton.setBounds(838, 690, 126, 48);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == LoginButton) {
                    String password = PasswordField.getText();
                    String id = IDTextField.getText();
                    if (isPublisher(id, password)) {
                        new HomeInterface2();
                        // delay l el dispose
                        Timer timer = new Timer(2000, event -> {
                            dispose();
                        });
                    
                        timer.setRepeats(false);
                        timer.start();
                    }
                    else if (isEmployee(id, password)) {
                        new HomeInterface1();
                        // delay l el dispose
                        Timer timer = new Timer(2000, event -> {
                            dispose();
                        });
                    
                        timer.setRepeats(false);
                        timer.start();
                    }
                    else {
                        ImageIcon erroricon = new ImageIcon("error.gif");
                        JOptionPane.showMessageDialog(null,"Please enter valid data", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                    }
                }
            }
        });

        // yezher el password
        showPasswordCheckBox = new JCheckBox();
        showPasswordCheckBox.setIcon(showPasswordIcon);
        showPasswordCheckBox.setOpaque(false);
        showPasswordCheckBox.setBounds(1325, 528, 50, 50);
        showPasswordCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PasswordField.setEchoChar(showPasswordCheckBox.isSelected() ? '\0' : '*');
            }
        });

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

        // fe moshkela fe el TextFeild
        this.add(LibraryNameLabel);
        this.add(showPasswordCheckBox);
        this.add(LoginButtonLabel);
        this.add(LoginButton);
        this.add(HazemData);
        this.add(BasmaData);
        this.add(HelpIconLabel);
        this.add(Help);
        this.add(DataPanel1);
        this.add(DataPanel2);
        this.add(RightSidePanel);
        this.add(ID);
        this.add(Password);
        this.add(IDTextField);
        this.add(PasswordField);
        this.add(LoginFrom);
        this.add(LibraryIconLabel);
        this.add(LoginFormShadow);
        this.add(Line1);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public boolean isPublisher(String id , String pass) {
        return (id.equals(publisherID) && pass.equals(publisherPassword));
    }

    public boolean isEmployee(String id , String pass) {
        return (id.equals(adminID) && pass.equals(adminPassword));
    }

    public static void main(String[] args) {

        new LoginInterface();

    }
}
