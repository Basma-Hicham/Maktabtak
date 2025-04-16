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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Book_Insert_Interface extends JFrame {

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
                g2D.drawLine(0, 646, getWidth() - 11, 646);
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
        private ImageIcon HomeIcon , SelectIcon , InsertIcon , StarIconClicked , StarIcon , Star1Icon , Star2Icon , Star3Icon , Star4Icon , Star5Icon , RoundCheckBoxIcon , RoundCheckBoxIconChecked;
        private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),"customCursor");
        private InnerRec InnerRec;
        private OuterRec OuterRec;
        private JLabel CodeTextLabel , PriceTextLabel , TypeTextLabel , LanguageTextLabel , TitleTextLabel , BookRateTextLabel , AvailableTextLabel , UnavailableTextLabel , InsertButtonLabel;
        private JLabel HomeIconLabel , InsertIconLabel , Select_Or_UpdateIconLabel , Star1IconLabel , Star2IconLabel , Star3IconLabel , Star4IconLabel , Star5IconLabel;
        private RoundJTextField CodeTextField , PriceTextField , TypeTextField , LanguageTextField , TitleTextField;
        private RoundJButton InsertButton;
        private static int BookRateValue = 1;
        private JCheckBox AvailableCheckBox , UnavailableCheckBox;
        public static String Code = "";
        public static String Price = "";
        public static String Type = "";
        public static String Language = "";
        public static String Title = "";
        public static boolean AvailableChecked = false;
        public static boolean UnavailableChecked = false;

        Book_Insert_Interface() {

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
                Book_Select_Or_Update_Interface.BookCode = "";
                Code = "";
                Price = "";
                Type = "";
                Language = "";
                Title = "";
                AvailableChecked = false;
                UnavailableChecked = false;
                BookRateValue = 1;
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
        
        SelectIcon = new ImageIcon("SelectButton.png");
        Select_Or_UpdateIconLabel = new JLabel();
        Select_Or_UpdateIconLabel.setIcon(SelectIcon);
        Select_Or_UpdateIconLabel.setBounds(1811, 346, 91, 91);
        Select_Or_UpdateIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                Code = CodeTextField.getText();
                Price = PriceTextField.getText();
                Type = TypeTextField.getText();
                Language = LanguageTextField.getText();
                Title = TitleTextField.getText();
                new Book_Select_Or_Update_Interface();
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

        CodeTextLabel = new JLabel("Code");
        CodeTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        CodeTextLabel.setForeground(Color.WHITE);
        CodeTextLabel.setBounds(42 , 117 , 120 , 45);

        CodeTextField = new RoundJTextField(15);
        CodeTextField.setText(Code);
        CodeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        CodeTextField.setForeground(Color.darkGray);
        CodeTextField.setBounds(243, 109, 316, 62);

        PriceTextLabel = new JLabel("Price");
        PriceTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        PriceTextLabel.setForeground(Color.WHITE);
        PriceTextLabel.setBounds(45 , 248 , 120 , 45);

        PriceTextField = new RoundJTextField(15);
        PriceTextField.setText(Price);
        PriceTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        PriceTextField.setForeground(Color.darkGray);
        PriceTextField.setBounds(377, 240, 265, 62);

        TypeTextLabel = new JLabel("Type");
        TypeTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        TypeTextLabel.setForeground(Color.WHITE);
        TypeTextLabel.setBounds(903 , 230 , 120 , 65);
        
        TypeTextField = new RoundJTextField(15);
        TypeTextField.setText(Type);
        TypeTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        TypeTextField.setForeground(Color.darkGray);
        TypeTextField.setBounds(1181, 240, 265, 62);

        LanguageTextLabel = new JLabel("Language");
        LanguageTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        LanguageTextLabel.setForeground(Color.WHITE);
        LanguageTextLabel.setBounds(45 , 334 , 230 , 65);
        
        LanguageTextField = new RoundJTextField(15);
        LanguageTextField.setText(Language);
        LanguageTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        LanguageTextField.setForeground(Color.darkGray);
        LanguageTextField.setBounds(377, 340, 265, 62);

        TitleTextLabel = new JLabel("Title");
        TitleTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        TitleTextLabel.setForeground(Color.WHITE);
        TitleTextLabel.setBounds(903 , 334 , 120 , 65);
        
        TitleTextField = new RoundJTextField(15);
        TitleTextField.setText(Title);
        TitleTextField.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 35));
        TitleTextField.setForeground(Color.darkGray);
        TitleTextField.setBounds(1181, 340, 265, 62);

        BookRateTextLabel = new JLabel("Book Rate");
        BookRateTextLabel.setFont(new Font("K2D" , Font.PLAIN , 45));
        BookRateTextLabel.setForeground(Color.WHITE);
        BookRateTextLabel.setBounds(45 , 510 , 210 , 65);

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
        Star1IconLabel.setBounds(377 , 507 , 67 , 65);

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
        Star2IconLabel.setBounds(529 , 507 , 67 , 65);

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
        Star3IconLabel.setBounds(678 , 507 , 67 , 65);

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
        Star4IconLabel.setBounds(827 , 507 , 67 , 65);

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
        Star5IconLabel.setBounds(961 , 507 , 67 , 65);

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
        AvailableCheckBox.setOpaque(false);
        AvailableCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    AvailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                    AvailableChecked = true;
                    UnavailableChecked = false;
                    UnavailableCheckBox.setSelected(false);
                } else {
                    AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                    AvailableChecked = false;
                }
            }
        });
        AvailableCheckBox.setBounds(271, 746, 60, 60);      

        AvailableTextLabel = new JLabel("Available");
        AvailableTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        AvailableTextLabel.setForeground(Color.WHITE);
        AvailableTextLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(!AvailableCheckBox.isSelected()){
                    if(UnavailableCheckBox.isSelected()) UnavailableCheckBox.setSelected(false);
                    AvailableCheckBox.setSelected(true);
                }                
                else AvailableCheckBox.setSelected(false);

                if (AvailableCheckBox.isSelected()) {
                    if(!AvailableCheckBox.isSelected()) {
                        AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                    }

                    AvailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                }
                else {
                    AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                }
            }
        
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) { AvailableTextLabel.setForeground(Color.green); }
            @Override public void mouseExited(MouseEvent e) { AvailableTextLabel.setForeground(Color.WHITE); }
        
        });
        AvailableTextLabel.setBounds(359 , 746 , 253 , 67);

        UnavailableCheckBox = new JCheckBox();
        UnavailableCheckBox.setOpaque(false);
        UnavailableCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    UnavailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                    UnavailableChecked = true;
                    AvailableChecked = false;
                    AvailableCheckBox.setSelected(false);
                } else {
                    UnavailableCheckBox.setIcon(RoundCheckBoxIcon);
                    UnavailableChecked = false;
                }
            }
        });
        UnavailableCheckBox.setBounds(972, 746, 60, 60);

        UnavailableTextLabel = new JLabel("Unavailable");
        UnavailableTextLabel.setFont(new Font("K2D" , Font.PLAIN , 50));
        UnavailableTextLabel.setForeground(Color.WHITE);
        UnavailableTextLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(!UnavailableCheckBox.isSelected()){
                    if(AvailableCheckBox.isSelected()) AvailableCheckBox.setSelected(false);
                    UnavailableCheckBox.setSelected(true);
                }                
                else UnavailableCheckBox.setSelected(false);

                if (UnavailableCheckBox.isSelected()) {
                    if(!UnavailableCheckBox.isSelected()) {
                        UnavailableCheckBox.setIcon(RoundCheckBoxIcon);
                    }

                    UnavailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                }
                else {
                    UnavailableCheckBox.setIcon(RoundCheckBoxIcon);
                }
            }
        
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) { UnavailableTextLabel.setForeground(Color.green); }
            @Override public void mouseExited(MouseEvent e) { UnavailableTextLabel.setForeground(Color.WHITE); }
        
        });
        UnavailableTextLabel.setBounds(1061 , 746 , 281 , 67);

                // get previous checked
                if (AvailableChecked) {
                    AvailableCheckBox.setSelected(true);
                    AvailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                    UnavailableChecked = false;
                    UnavailableCheckBox.setSelected(false);
                    UnavailableCheckBox.setIcon(RoundCheckBoxIcon);
                }
                else if (UnavailableChecked) {
                    UnavailableCheckBox.setSelected(true);
                    UnavailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                    AvailableChecked = false;
                    AvailableCheckBox.setSelected(false);
                    AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                }
                else {
                    AvailableChecked = false;
                    AvailableCheckBox.setIcon(RoundCheckBoxIcon);
                    AvailableCheckBox.setSelected(false);
                    UnavailableChecked = true;
                    UnavailableCheckBox.setIcon(RoundCheckBoxIconChecked);
                    UnavailableCheckBox.setSelected(true);
                }

        InsertButton = new RoundJButton();
        InsertButton.setBackground(new Color(0x625B49));
        InsertButton.setFocusable(false);
        InsertButton.setBounds(1551, 989, 202, 45);
        InsertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(InsertButton)) {
                    Validation v = new Validation();
                    if (v.ID(CodeTextField.getText().trim()) && v.price(PriceTextField.getText().trim()) 
                    && v.type(TypeTextField.getText().trim()) && v.language(LanguageTextField.getText().trim())
                    && v.title(TitleTextField.getText().trim()) && v.availablility(AvailableChecked , UnavailableChecked)) {
                        //hdwr fe el databse 3la el id
                        CodeTextField.setText("");
                        PriceTextField.setText("");
                        TypeTextField.setText("");
                        LanguageTextField.setText("");
                        TitleTextField.setText("");
                        //select el data
                    }
                }
            }
            
        });

        InsertButtonLabel = new JLabel("Insert");
        InsertButtonLabel.setForeground(Color.WHITE);
        InsertButtonLabel.setFont(new Font("Inter", Font.PLAIN, 38));
        InsertButtonLabel.setBounds(1551 + 50, 987, 104, 45);

        this.add(InsertButtonLabel);
        this.add(InsertButton);
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
        new Book_Insert_Interface();
    }
}
