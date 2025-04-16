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

public class Book_Update_Interface extends JFrame {

    public class BookTableRec extends JPanel {
        private Shape shape;
        Color Color;

        public BookTableRec(Color Color) {
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
            g2D.drawLine(0, 510+166+40+100, getWidth() - 11, 510+166+40+100);
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
    private JLabel HomeIconLabel, InsertIconLabel, Select_Or_UpdateIconLabel, CodeTextLabel, SelectButtonLabel;
    private JLabel UpdateButtonLabel, BookRowTextLabel , PriceTextLabel , TypeTextLabel , LanguageTextLabel , TitleTextLabel , BookRateTextLabel , UnavailableTextLabel , AvailableTextLabel;
    private JLabel Star1IconLabel , Star2IconLabel , Star3IconLabel , Star4IconLabel , Star5IconLabel;
    private RoundJTextField CodeTextField , PriceTextField , TypeTextField , LanguageTextField , TitleTextField;
    private RoundJButton SelectButton, UpdateButton;
    private BookTableRec BookTableRec;
    private static int BookRateValue = 1;
    private JCheckBox AvailableCheckBox , UnavailableCheckBox;

    Book_Update_Interface() {

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

        CodeTextLabel = new JLabel("Code");
        CodeTextLabel.setFont(new Font("K2D", Font.PLAIN, 45));
        CodeTextLabel.setForeground(Color.WHITE);
        CodeTextLabel.setBounds(96, 123, 220, 45);

        CodeTextField = new RoundJTextField(15);
        CodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        CodeTextField.setForeground(Color.darkGray);
        CodeTextField.setBounds(344, 125, 316, 47);

        SelectButton = new RoundJButton();
        SelectButton.setBackground(new Color(0x625B49));
        SelectButton.setFocusable(false);
        SelectButton.setBounds(724, 117, 308, 61);
        SelectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(SelectButton)) {
                    Validation v = new Validation();
                    if (v.ID(CodeTextField.getText().trim())) {
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

        BookTableRec = new BookTableRec(new Color(0xD9D9D9));
        BookTableRec.setBounds(59 + 12, 251, 1638, 202);

        BookRowTextLabel = new JLabel("Book Row");
        BookRowTextLabel.setForeground(Color.BLACK);
        BookRowTextLabel.setFont(new Font("Inter", Font.PLAIN, 110));
        BookRowTextLabel.setBounds(641, 300, 522, 97);

        PriceTextLabel = new JLabel("Price");
        PriceTextLabel.setForeground(Color.WHITE);
        PriceTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        PriceTextLabel.setBounds(58 , 511 , 224 , 45);
        PriceTextField = new RoundJTextField(15);
        PriceTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PriceTextField.setForeground(Color.darkGray);
        PriceTextField.setBounds(396, 503, 265, 62);

        TypeTextLabel = new JLabel("Type");
        TypeTextLabel.setForeground(Color.WHITE);
        TypeTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        TypeTextLabel.setBounds(963 , 511-10 , 217 , 62);
        TypeTextField = new RoundJTextField(15);
        TypeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        TypeTextField.setForeground(Color.darkGray);
        TypeTextField.setBounds(1311, 503 , 265, 62);

        LanguageTextLabel = new JLabel("Language");
        LanguageTextLabel.setForeground(Color.WHITE);
        LanguageTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        LanguageTextLabel.setBounds(58 , 611-10 , 205 , 62);
        LanguageTextField = new RoundJTextField(15);
        LanguageTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        LanguageTextField.setForeground(Color.darkGray);
        LanguageTextField.setBounds(396, 603, 265, 62);

        TitleTextLabel = new JLabel("Title");
        TitleTextLabel.setForeground(Color.WHITE);
        TitleTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        TitleTextLabel.setBounds(963 , 611 , 213 , 45);
        TitleTextField = new RoundJTextField(15);
        TitleTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        TitleTextField.setForeground(Color.darkGray);
        TitleTextField.setBounds(1311, 603, 265, 62);

        BookRateTextLabel = new JLabel("Book Rate");
        BookRateTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        BookRateTextLabel.setForeground(Color.WHITE);
        BookRateTextLabel.setBounds(58 , 510+166+40 , 210 , 65);

        StarIcon = new ImageIcon("StarIcon.png");
        StarIconClicked = new ImageIcon("StarIconClicked.png");
        Star1Icon = new ImageIcon("StarIcon.png");
        Star2Icon = new ImageIcon("StarIcon.png");
        Star3Icon = new ImageIcon("StarIcon.png");
        Star4Icon = new ImageIcon("StarIcon.png");
        Star5Icon = new ImageIcon("StarIcon.png");

        Star1IconLabel = new JLabel();
        Star1IconLabel.setIcon(StarIconClicked);
        Star1IconLabel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                Star1Icon = new ImageIcon("StarIconClicked.png");
                Star2Icon = new ImageIcon("StarIcon.png");
                Star3Icon = new ImageIcon("StarIcon.png");
                Star4Icon = new ImageIcon("StarIcon.png");
                Star5Icon = new ImageIcon("StarIcon.png");
                Star1IconLabel.setIcon(Star1Icon);
                Star2IconLabel.setIcon(Star2Icon);
                Star3IconLabel.setIcon(Star3Icon);
                Star4IconLabel.setIcon(Star4Icon);
                Star5IconLabel.setIcon(Star5Icon);
                BookRateValue = 1;
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        Star1IconLabel.setBounds(417-27 , 507+166+40 , 67 , 65);

        Star2IconLabel = new JLabel();
        Star2IconLabel.setIcon(Star2Icon);
        Star2IconLabel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                Star1Icon = new ImageIcon("StarIconClicked.png");
                Star2Icon = new ImageIcon("StarIconClicked.png");
                Star3Icon = new ImageIcon("StarIcon.png");
                Star4Icon = new ImageIcon("StarIcon.png");
                Star5Icon = new ImageIcon("StarIcon.png");
                Star1IconLabel.setIcon(Star1Icon);
                Star2IconLabel.setIcon(Star2Icon);
                Star3IconLabel.setIcon(Star3Icon);
                Star4IconLabel.setIcon(Star4Icon);
                Star5IconLabel.setIcon(Star5Icon);
                BookRateValue = 2;
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        Star2IconLabel.setBounds(569-27 , 507+166+40 , 67 , 65);

        Star3IconLabel = new JLabel();
        Star3IconLabel.setIcon(Star3Icon);
        Star3IconLabel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                Star1Icon = new ImageIcon("StarIconClicked.png");
                Star2Icon = new ImageIcon("StarIconClicked.png");
                Star3Icon = new ImageIcon("StarIconClicked.png");
                Star4Icon = new ImageIcon("StarIcon.png");
                Star5Icon = new ImageIcon("StarIcon.png");
                Star1IconLabel.setIcon(Star1Icon);
                Star2IconLabel.setIcon(Star2Icon);
                Star3IconLabel.setIcon(Star3Icon);
                Star4IconLabel.setIcon(Star4Icon);
                Star5IconLabel.setIcon(Star5Icon);
                BookRateValue = 3;
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        Star3IconLabel.setBounds(718-27 , 507+166+40 , 67 , 65);

        Star4IconLabel = new JLabel();
        Star4IconLabel.setIcon(Star4Icon);
        Star4IconLabel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                Star1Icon = new ImageIcon("StarIconClicked.png");
                Star2Icon = new ImageIcon("StarIconClicked.png");
                Star3Icon = new ImageIcon("StarIconClicked.png");
                Star4Icon = new ImageIcon("StarIconClicked.png");
                Star5Icon = new ImageIcon("StarIcon.png");
                Star1IconLabel.setIcon(Star1Icon);
                Star2IconLabel.setIcon(Star2Icon);
                Star3IconLabel.setIcon(Star3Icon);
                Star4IconLabel.setIcon(Star4Icon);
                Star5IconLabel.setIcon(Star5Icon);
                BookRateValue = 4;
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        Star4IconLabel.setBounds(867-27 , 507+166+40 , 67 , 65);

        Star5IconLabel = new JLabel();
        Star5IconLabel.setIcon(Star5Icon);
        Star5IconLabel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                Star1Icon = new ImageIcon("StarIconClicked.png");
                Star2Icon = new ImageIcon("StarIconClicked.png");
                Star3Icon = new ImageIcon("StarIconClicked.png");
                Star4Icon = new ImageIcon("StarIconClicked.png");
                Star5Icon = new ImageIcon("StarIconClicked.png");
                Star1IconLabel.setIcon(Star1Icon);
                Star2IconLabel.setIcon(Star2Icon);
                Star3IconLabel.setIcon(Star3Icon);
                Star4IconLabel.setIcon(Star4Icon);
                Star5IconLabel.setIcon(Star5Icon);
                BookRateValue = 5;
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        Star5IconLabel.setBounds(1001-27 , 507+166+40 , 67 , 65);

                //previous bookrate 
                switch (BookRateValue) {
                    case 1:
                        Star1Icon = new ImageIcon("StarIconClicked.png");
                        Star2Icon = new ImageIcon("StarIcon.png");
                        Star3Icon = new ImageIcon("StarIcon.png");
                        Star4Icon = new ImageIcon("StarIcon.png");
                        Star5Icon = new ImageIcon("StarIcon.png");
                        Star1IconLabel.setIcon(Star1Icon);
                        Star2IconLabel.setIcon(Star2Icon);
                        Star3IconLabel.setIcon(Star3Icon);
                        Star4IconLabel.setIcon(Star4Icon);
                        Star5IconLabel.setIcon(Star5Icon);
                        break;
                
                    case 2:
                    Star1Icon = new ImageIcon("StarIconClicked.png");
                    Star2Icon = new ImageIcon("StarIconClicked.png");
                    Star3Icon = new ImageIcon("StarIcon.png");
                    Star4Icon = new ImageIcon("StarIcon.png");
                    Star5Icon = new ImageIcon("StarIcon.png");
                    Star1IconLabel.setIcon(Star1Icon);
                    Star2IconLabel.setIcon(Star2Icon);
                    Star3IconLabel.setIcon(Star3Icon);
                    Star4IconLabel.setIcon(Star4Icon);
                    Star5IconLabel.setIcon(Star5Icon);
                        break;
                
                    case 3:
                    Star1Icon = new ImageIcon("StarIconClicked.png");
                    Star2Icon = new ImageIcon("StarIconClicked.png");
                    Star3Icon = new ImageIcon("StarIconClicked.png");
                    Star4Icon = new ImageIcon("StarIcon.png");
                    Star5Icon = new ImageIcon("StarIcon.png");
                    Star1IconLabel.setIcon(Star1Icon);
                    Star2IconLabel.setIcon(Star2Icon);
                    Star3IconLabel.setIcon(Star3Icon);
                    Star4IconLabel.setIcon(Star4Icon);
                    Star5IconLabel.setIcon(Star5Icon);
                        break;
                
                    case 4:
                    Star1Icon = new ImageIcon("StarIconClicked.png");
                    Star2Icon = new ImageIcon("StarIconClicked.png");
                    Star3Icon = new ImageIcon("StarIconClicked.png");
                    Star4Icon = new ImageIcon("StarIconClicked.png");
                    Star5Icon = new ImageIcon("StarIcon.png");
                    Star1IconLabel.setIcon(Star1Icon);
                    Star2IconLabel.setIcon(Star2Icon);
                    Star3IconLabel.setIcon(Star3Icon);
                    Star4IconLabel.setIcon(Star4Icon);
                    Star5IconLabel.setIcon(Star5Icon);
                        break;
                
                    case 5:
                    Star1Icon = new ImageIcon("StarIconClicked.png");
                    Star2Icon = new ImageIcon("StarIconClicked.png");
                    Star3Icon = new ImageIcon("StarIconClicked.png");
                    Star4Icon = new ImageIcon("StarIconClicked.png");
                    Star5Icon = new ImageIcon("StarIconClicked.png");
                    Star1IconLabel.setIcon(Star1Icon);
                    Star2IconLabel.setIcon(Star2Icon);
                    Star3IconLabel.setIcon(Star3Icon);
                    Star4IconLabel.setIcon(Star4Icon);
                    Star5IconLabel.setIcon(Star5Icon);
                        break;
                    default:
                        break;
                }

                RoundCheckBoxIcon = new ImageIcon("CheckBox.png");
                RoundCheckBoxIconChecked = new ImageIcon("CheckBoxChecked.png");
        
                AvailableCheckBox = new JCheckBox();
                AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                AvailableCheckBox.setSelected(false);
                AvailableCheckBox.setOpaque(false);
                AvailableCheckBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            AvailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                            UnavailableCheckBox.setSelected(false);
                        } else {
                            AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                        }
                    }
                });
                AvailableCheckBox.setBounds(271, 896, 60, 60);      
        
                AvailableTextLabel = new JLabel("Available");
                AvailableTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
                AvailableTextLabel.setForeground(Color.WHITE);
                AvailableTextLabel.setBounds(359 , 896 , 253 , 67);
        
                UnavailableCheckBox = new JCheckBox();
                UnavailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                UnavailableCheckBox.setSelected(true);
                UnavailableCheckBox.setOpaque(false);
                UnavailableCheckBox.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            UnavailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                            AvailableCheckBox.setSelected(false);
                        } else {
                            UnavailableCheckBox.setIcon(RoundCheckBoxIcon);
                        }
                    }
                });
                UnavailableCheckBox.setBounds(972, 896, 60, 60);
        
                UnavailableTextLabel = new JLabel("Unavailable");
                UnavailableTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
                UnavailableTextLabel.setForeground(Color.WHITE);
                UnavailableTextLabel.setBounds(1061 , 896 , 281 , 67);

        this.add(UnavailableTextLabel);
        this.add(UnavailableCheckBox);
        this.add(AvailableTextLabel);
        this.add(AvailableCheckBox);
        this.add(Star5IconLabel);
        this.add(Star4IconLabel);
        this.add(Star3IconLabel);
        this.add(Star2IconLabel);
        this.add(Star1IconLabel);
        this.add(BookRateTextLabel);
        this.add(TitleTextField);
        this.add(TitleTextLabel);
        this.add(LanguageTextField);
        this.add(LanguageTextLabel);
        this.add(TypeTextField);
        this.add(TypeTextLabel);
        this.add(PriceTextField);
        this.add(PriceTextLabel);
        this.add(CodeTextField);
        this.add(CodeTextLabel);
        this.add(BookRowTextLabel);
        this.add(BookTableRec);
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
        new Book_Update_Interface();
    }
}
