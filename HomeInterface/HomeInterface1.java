import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.*;

public class HomeInterface1 extends JFrame {

    private JPanel RightSidePanel;
    private ImageIcon Order, Printer, Author, Book, Customer;
    private JLabel OrderIconLabel, PrinterIconLabel, AuthorIconLabel, BookIconLabel, CustomerIconLabel , OrderTextLabel , PrinterTextLabel , AuthorTextLabel , BookTextLabel , CustomerTextLabel;
    private Image cursorImage = Toolkit.getDefaultToolkit().getImage("custom_cursor.png");
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "customCursor");

    HomeInterface1() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.getContentPane().setBackground(new Color(0x625B49));
        this.setLayout(null);

        RightSidePanel = new JPanel();
        RightSidePanel.setBackground(new Color(0x312D24));
        RightSidePanel.setBounds(1818, 0, 102, 1080);

        Order = new ImageIcon(getClass().getResource("order12.png"));
        OrderIconLabel = new JLabel();
        OrderIconLabel.setIcon(Order);
        OrderIconLabel.setBounds(131, 94, 316, 316);
        OrderTextLabel = new JLabel("Order");
        OrderTextLabel.setForeground(new Color(0x9BFFBA));
        OrderTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        OrderTextLabel.setBounds(208 , 410 , 165 , 83);
        OrderTextLabel.setVisible(false);
        OrderIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new OrderSelectOrInsertInterface();
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
                Order = new ImageIcon(getClass().getResource("order.png"));
                OrderIconLabel.setIcon(Order);
                OrderTextLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Order = new ImageIcon(getClass().getResource("order12.png"));
                OrderIconLabel.setIcon(Order);
                OrderTextLabel.setVisible(false);
            }

        });

        Printer = new ImageIcon(getClass().getResource("printer12.png"));
        PrinterIconLabel = new JLabel();
        PrinterIconLabel.setIcon(Printer);
        PrinterIconLabel.setBounds(720, 94, 316, 316);
        PrinterTextLabel = new JLabel("Printer");
        PrinterTextLabel.setForeground(new Color(0xF0D497));
        PrinterTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        PrinterTextLabel.setBounds(780 , 410 , 205 , 83);
        PrinterTextLabel.setVisible(false);
        PrinterIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new PrinterSelectOrInsertInterface();
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
                Printer = new ImageIcon(getClass().getResource("printer.png"));
                PrinterIconLabel.setIcon(Printer);
                PrinterTextLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Printer = new ImageIcon(getClass().getResource("printer12.png"));
                PrinterIconLabel.setIcon(Printer);
                PrinterTextLabel.setVisible(false);
            }

        });

        Author = new ImageIcon(getClass().getResource("author12.png"));
        AuthorIconLabel = new JLabel();
        AuthorIconLabel.setIcon(Author);
        AuthorIconLabel.setBounds(1336, 94, 316, 316);
        AuthorTextLabel = new JLabel("Author");
        AuthorTextLabel.setForeground(new Color(0xC9C6FF));
        AuthorTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        AuthorTextLabel.setBounds(1394 , 410 , 200 , 83);
        AuthorTextLabel.setVisible(false);
        AuthorIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new AuthorSelectOrInsertInterface();
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
                Author = new ImageIcon(getClass().getResource("author.png"));
                AuthorIconLabel.setIcon(Author);
                AuthorTextLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Author = new ImageIcon(getClass().getResource("author12.png"));
                AuthorIconLabel.setIcon(Author);
                AuthorTextLabel.setVisible(false);
            }

        });

        Book = new ImageIcon(getClass().getResource("book12.png"));
        BookIconLabel = new JLabel();
        BookIconLabel.setIcon(Book);
        BookIconLabel.setBounds(300, 599, 316, 316);
        BookTextLabel = new JLabel("Book");
        BookTextLabel.setForeground(new Color(0xB6FFF7));
        BookTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        BookTextLabel.setBounds(379 , 915 , 145 , 83);
        BookTextLabel.setVisible(false);
        BookIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new BookSelectOrInsertInterface();
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
                Book = new ImageIcon(getClass().getResource("book.png"));
                BookIconLabel.setIcon(Book);
                BookTextLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Book = new ImageIcon(getClass().getResource("book12.png"));
                BookIconLabel.setIcon(Book);
                BookTextLabel.setVisible(false);
            }

        });

        Customer = new ImageIcon(getClass().getResource("customer12.png"));
        CustomerIconLabel = new JLabel();
        CustomerIconLabel.setIcon(Customer);
        CustomerIconLabel.setBounds(1100, 599, 316, 316);
        CustomerTextLabel = new JLabel("Customer");
        CustomerTextLabel.setForeground(new Color(0xFCADAD));
        CustomerTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        CustomerTextLabel.setBounds(1125 , 915 , 280 , 83);
        CustomerTextLabel.setVisible(false);
        CustomerIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Customer_Select_Or_Update_Interface();
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
                Customer = new ImageIcon(getClass().getResource("customer.png"));
                CustomerIconLabel.setIcon(Customer);
                CustomerTextLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Customer = new ImageIcon(getClass().getResource("customer12.png"));
                CustomerIconLabel.setIcon(Customer);
                CustomerTextLabel.setVisible(false);
            }

        });

        this.add(CustomerTextLabel);
        this.add(BookTextLabel);
        this.add(AuthorTextLabel);
        this.add(PrinterTextLabel);
        this.add(OrderTextLabel);
        this.setCursor(cursor);
        this.add(OrderIconLabel);
        this.add(PrinterIconLabel);
        this.add(AuthorIconLabel);
        this.add(BookIconLabel);
        this.add(CustomerIconLabel);
        this.add(RightSidePanel);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HomeInterface1();
    }
}
