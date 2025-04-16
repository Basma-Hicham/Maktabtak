import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.*;

public class HomeInterface2 extends JFrame {

    private JPanel RightSidePanel;
    private ImageIcon Printer, Author, Book;
    private JLabel PrinterIconLabel, AuthorIconLabel, BookIconLabel , PrinterTextLabel , AuthorTextLabel , BookTextLabel;
    private Image cursorImage = Toolkit.getDefaultToolkit().getImage("custom_cursor.png");
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "customCursor");

    HomeInterface2() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.getContentPane().setBackground(new Color(0x625B49));
        this.setLayout(null);

        RightSidePanel = new JPanel();
        RightSidePanel.setBackground(new Color(0x312D24));
        RightSidePanel.setBounds(1818, 0, 102, 1080);


        Book = new ImageIcon(getClass().getResource("book12.png"));
        BookIconLabel = new JLabel();
        BookIconLabel.setIcon(Book);
        BookIconLabel.setBounds(131, 382, 316, 316);
        BookTextLabel = new JLabel("Book");
        BookTextLabel.setForeground(new Color(0xB6FFF7));
        BookTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        BookTextLabel.setBounds(208 , 698 , 165 , 83);
        BookTextLabel.setVisible(false);
        BookIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new BookSelectOrInsertInterface2();
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

        Printer = new ImageIcon(getClass().getResource("printer12.png"));
        PrinterIconLabel = new JLabel();
        PrinterIconLabel.setIcon(Printer);
        PrinterIconLabel.setBounds(720, 382, 316, 316);
        PrinterTextLabel = new JLabel("Printer");
        PrinterTextLabel.setForeground(new Color(0xF0D497));
        PrinterTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        PrinterTextLabel.setBounds(780 , 698 , 205 , 83);
        PrinterTextLabel.setVisible(false);
        PrinterIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new PrinterSelectOrInsertInterface2();
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
        AuthorIconLabel.setBounds(1336, 382, 316, 316);
        AuthorTextLabel = new JLabel("Author");
        AuthorTextLabel.setForeground(new Color(0xC9C6FF));
        AuthorTextLabel.setFont(new Font("K2D" , Font.PLAIN , 64));
        AuthorTextLabel.setBounds(1394 , 698 , 200 , 83);
        AuthorTextLabel.setVisible(false);
        AuthorIconLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new AuthorSelectOrInsertInterface2();
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

        this.add(BookTextLabel);
        this.add(AuthorTextLabel);
        this.add(PrinterTextLabel);
        this.setCursor(cursor);
        this.add(PrinterIconLabel);
        this.add(AuthorIconLabel);
        this.add(BookIconLabel);
        this.add(RightSidePanel);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HomeInterface2();
    }
}
