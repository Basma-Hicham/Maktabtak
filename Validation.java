import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

    public class Validation {

    private final int max_phone=11;  
    private final int phonearray=2;   
    private final int max_postal=5;
    private final int max_id=8;
    private final int max_street=50; 
    private final int max_fname=10;   
    private final int max_lname=10;  
    private final int max_city=20;
    List<String> phones = new ArrayList<>(phonearray);

//******************************ICONS **************************************//

ImageIcon limiticon1 = new ImageIcon("limit exceed.gif");  ImageIcon limiticon2 = new ImageIcon("less limit.gif");
ImageIcon inserticon = new ImageIcon("peen.gif");
ImageIcon erroricon = new ImageIcon("error.gif");
ImageIcon emailicon = new ImageIcon("email.gif");
ImageIcon stringicon = new ImageIcon("string only.gif");
ImageIcon inticon = new ImageIcon("int only.gif");





//hazem
    public boolean isNum(String text) {
        return text.matches("[0-9]+");
    }

    public boolean isString(String text) {
        String regex = "^[a-zA-Z]+$";
        return text.matches(regex);
    } 

    public boolean isStringWithSpaces(String text) {
        String regex = "^[a-zA-Z ]+$";
        return text.matches(regex);
    } 

    public boolean isValidDate(String dateString) {
        try {
            LocalDate.parse(dateString);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:yahoo|gmail)\\.(?:com)$";
        return email.matches(regex) && !email.contains(" ");
    }

    public static boolean isPostalCode(String text) {
        // el postal code fe masr 7 arqam
        String regex = "^\\d{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

//hazem


//******************************JOption **************************************//

public void error_msg() {
    ImageIcon erroricon = new ImageIcon("error.gif");
    JOptionPane.showMessageDialog(null,"input may contain space ,special chars or string", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
}

//----------------------------------------------------------------------------------------------------------------//

    public void limiterror(){
        JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);

}

//----------------------------------------------------------------------------------------------------------------//

public void only2phones(){
    JOptionPane.showMessageDialog(null,"only two phone numbers allowed", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
}

//----------------------------------------------------------------------------------------------------------------//

public void invalidEmail(){
    JOptionPane.showMessageDialog(null,"Invalid Email,must be (yahoo , gmail) only", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
}

//----------------------------------------------------------------------------------------------------------------//

public void invalidDATE(){
    JOptionPane.showMessageDialog(null,"Invalid Date , Enter date in (yyyy-mm-dd) format", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
}

//******************************PHONE **************************************//

    public void phoneISnum(String text,JTextField t1){
        if(!text.isEmpty()) {
            if(!text.matches("\\d+")){error_msg();return;}
            if(text.matches("\\d+")){
                if (text.length() > max_phone) {
                    limiterror();
                }
                else  if (text.length() < max_phone) {
                    JOptionPane.showMessageDialog(null,"Insert 11 digits", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon2);
                }
                else {
                    if (phones.size() < phonearray) {
                        phones.add(text);
                        System.out.println("added phone" + text);
                        t1.setText("");
                    }
                    else only2phones();
                }
            }
        } 
        else {JOptionPane.showMessageDialog(null,"insert phone number", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
}

//******************************BIRTH-DATE **************************************//

        /*basma */

    // public boolean BDate(String text, JFormattedTextField f2){
    //     if(!text.isEmpty()) {
    //         int current_year=LocalDate.now().getYear();
    //         text = f2.getText(); // "12-12-2024"
    //         String dateparts[] = text.split("-") ;  //["10","12","2024"]
    //         int day = Integer.parseInt(dateparts[0]);
    //         int month = Integer.parseInt(dateparts[1]);
    //         int year = Integer.parseInt(dateparts[2]);
    //         if( year >= 1700 && year <= current_year && day > 0 && day <= 31 && month > 0 && month <= 12) {
    //             System.out.println(text); 
    //             return true;
    //         }
    //         else invalidDATE(); 
    //     }
    //     else {JOptionPane.showMessageDialog(null,"Birth Date is Empty or Incomplete", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);}
    //     return false;
    // }

        /*basma */

            /*hazem */
            public boolean BD(String text){
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Birth Date is Empty or Incomplete", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                    return false;
                }
                else if (!isValidDate(text)) {
                    invalidDATE();
                    return false;
                }
                return true;        
            }
            /*hazem */

//******************************DATE **************************************//

        /*basma */

    // public boolean Date(String text){
    //     if(!text.isEmpty()) {
    //         int current_year=LocalDate.now().getYear(); // "12-12-2024"
    //         String dateparts[] = text.split("-") ;  //["10","12","2024"]
    //         int day = Integer.parseInt(dateparts[0]);
    //         int month = Integer.parseInt(dateparts[1]);
    //         int year = Integer.parseInt(dateparts[2]);
    //         if( year == current_year && day > 0 && day <= 31 && month > 0 && month <= 12) {
    //             System.out.println(text); 
    //             return true;
    //         }
    //         else {invalidDATE();}
    //     }
    //     else {JOptionPane.showMessageDialog(null,"Date is Empty or Incomplete , Enter date in (dd-mm-yyyy) format", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);}
    //     return false;
    // }    
    
            /*basma */

        /*hazem */
        public boolean Date(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Date is Empty or Incomplete , Enter date in (yyyy-mm-dd) format", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isValidDate(text)) {
                invalidDATE();
                return false;
            }
            return true;        
        }
        /*hazem */

//******************************EMAIL **************************************//

    /*basma*/

    // public void email(String text,JTextField f3){
    //     if(!text.isEmpty()){
    //             String emailparts[] =text.split("@");
    //             String name = emailparts[0];
    //             if (text.contains(" ") || !text.contains("@") || !text.contains(".com") || !text.contains("yahoo") || !text.contains("gmail") || name.matches("\\d+")) {
    //                 invalidEmail();
    //             }
    //             else {
    //                 System.out.println(text);
    //                 f3.setText("");
    //             }
    //         }
    //     else {JOptionPane.showMessageDialog(null,"Insert Email", "Error Message", JOptionPane.ERROR_MESSAGE,emailicon);}
    // }

    /*basma*/

    /*hazem*/
        public boolean email(String text) {
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Insert Email", "Error Message", JOptionPane.ERROR_MESSAGE,emailicon);
                return false;
            }
            else if (!isEmail(text)) {
                invalidEmail();
                return false;
            }
            return true;
        }
    /*hazem*/

//******************************BOOK **************************************//

    public void book(String text,JTextField f4){
        if(!text.isEmpty()){
            if (text.matches("\\d+")) {JOptionPane.showMessageDialog(null,"Book name must contain characters", "Error Message", JOptionPane.ERROR_MESSAGE,stringicon);} 
            else {
                List<String> books=new ArrayList<>();
                books.add(text);
                System.out.println("added book is " + text);
                System.out.println("you can add another");
                f4.setText("");
            }
        }
        else {JOptionPane.showMessageDialog(null,"insert book name", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
    }

//******************************STREET **************************************//

    /*basma*/

    // public void street(String text,JTextField f5){
    //     if(!text.isEmpty()){
    //         if(text.contains("#")||text.contains("!")||text.contains("$")||text.contains("%")||text.contains("@")) {
    //             JOptionPane.showMessageDialog(null,"Characters like (# , $ , % , @ ,!) aren't allowed", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
    //         }
    //         else if (text.matches("\\d+")) {
    //             JOptionPane.showMessageDialog(null,"Address must contain characters", "Error Message", JOptionPane.ERROR_MESSAGE,stringicon);
    //         }
    //         else {
    //             if (text.length()>max_street) {JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);}
    //             else {System.out.println(text); f5.setText("");}
    //         }
    //     }
    //     else {JOptionPane.showMessageDialog(null,"insert address", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
    // }

    /*basma*/

    /*hazem*/
    public boolean street(String text){
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null,"insert address(street)", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
            return false;
        }
        else if (!isStringWithSpaces(text)) {
            JOptionPane.showMessageDialog(null,"street must be letters without special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
            return false;
        }
        return true;
    }
    /*hazem*/

//******************************POSTAL**************************************//

        /*basma*/

    // public void postal(String text, JTextField f6){
    //     if(!text.isEmpty()){
    //         Pattern pattern = Pattern.compile("[^a-zA-Z0-9]"); 
    //         Matcher matcher = pattern.matcher(text);
    //         if (!text.matches("\\d+")||matcher.find()||f6.getText().contains(" ")) {
    //             JOptionPane.showMessageDialog(null,"input may contain space ,special chars or string", "Error Message", JOptionPane.ERROR_MESSAGE,inticon);
    //         }
    //         else {
    //             int postal = Integer.parseInt(text);
    //             if (text.length() > max_postal) {
    //                 JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);
    //             }
    //             else if (text.length() < max_postal) {
    //                 JOptionPane.showMessageDialog(null,"Insert 5 digits", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon2);
    //             }
    //             else {
    //                 System.out.println(postal);
    //                 f6.setText(""); 
    //             } 
    //         }
    //     }
    //     else {JOptionPane.showMessageDialog(null,"insert postal code", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
    // }

        /*basma*/

    /*hazem*/
    public boolean postal(String text) {
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null,"insert postal code", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
            return false;
        }
        else if (!isPostalCode(text)) {
            JOptionPane.showMessageDialog(null,"Insert 7 digits and input can not contain spaces ,special chars or letters", "Error Message", JOptionPane.ERROR_MESSAGE,inticon);
            return false;
        }
        return true;
    }
    /*hazem*/

//******************************ID**************************************//

    /*basma */

    // public boolean ID(String text , JTextField f7){
    //     if(!text.isEmpty()){
    //         Pattern pattern = Pattern.compile("[^a-zA-Z0-9]"); 
    //         Matcher matcher = pattern.matcher(text);
    //         if (!text.matches("\\d+")|| matcher.find()||text.contains(" ")) {
    //             JOptionPane.showMessageDialog(null,"input may contain space ,special chars or string", "Error Message", JOptionPane.ERROR_MESSAGE,inticon);
    //         }
    //         else {
    //             int id = Integer.parseInt(text);
    //             if (text.length() > max_id) {
    //                 JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);
    //             }
    //             else if (text.length() < max_id) {
    //                 JOptionPane.showMessageDialog(null,"Insert 8 digits", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon2);
    //             }
    //             else {
    //                 System.out.println(id);
    //                 f7.setText(""); 
    //                 return true;
    //             }
    //         }
    //     }
    //     else {JOptionPane.showMessageDialog(null,"insert ID", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
    //     return false;
    // }

        /*basma */

    /*hazem */

    public boolean ID(String text) {
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null,"insert ID", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
            return false;
        }
        else if (!isNum(text)) {
            JOptionPane.showMessageDialog(null,"ID can't contain spaces,special chars or characters", "Error Message", JOptionPane.ERROR_MESSAGE,inticon);
            return false;
        }
        return true;
    }

        /*hazem */

//******************************F-NAME**************************************//

    /*basma */

    // public void f_name(String text, JTextField f8) {
    //     if(!text.isEmpty()){
    //         Pattern pattern = Pattern.compile("[^a-zA-Z0-9]"); 
    //         Matcher matcher = pattern.matcher(text);
    //         //mib2ash combination of string and int,,, wla feh space ,,, wla special chars
    //         if (text.matches("\\d.*")|| matcher.find() ||text.matches(".*\\d+.*")) {
    //             JOptionPane.showMessageDialog(null,"name must be string without space or special chars", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
    //         }
    //         else {
    //             if(text.length()>max_fname) {
    //                 JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);
    //             }
    //             else {
    //                 System.out.println(text);
    //                 f8.setText(""); 
    //             }
    //         }
    //     } 
    //     else {JOptionPane.showMessageDialog(null,"insert your first name", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
    // }

    /*basma */

    /*Hazem */

    public boolean f_name(String text) {
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null,"insert first name", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
            return false;
        }
        else if (!isString(text)) {
            JOptionPane.showMessageDialog(null,"first name must be letters without spaces , special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
            return false;
        }
        return true;
    }

    /*Hazem */

//******************************L-NAME**************************************//

    /*basma*/
    // public void l_name(String text, JTextField f9){
    //     if(!text.isEmpty()) {
    //         Pattern pattern =Pattern.compile("[^a-zA-Z0-9]"); 
    //         Matcher matcher = pattern.matcher(text);
    //         if (text.matches("\\d.*")||matcher.find()||text.matches(".*\\d+.*")) {
    //             JOptionPane.showMessageDialog(null,"name must be string without space or special chars", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
    //         }
    //         else {
    //             if (text.length() > max_lname) { 
    //                 JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);
    //             }
    //             else {
    //             System.out.println(text);
    //             f9.setText("");
    //             }
    //         }
    //     }
    //     else {JOptionPane.showMessageDialog(null,"insert your last name", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
    // }   
    /*basma*/

    /*Hazem */

    public boolean l_name(String text){
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null,"insert last name", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
            return false;
        }
        else if (!isString(text)) {
            JOptionPane.showMessageDialog(null,"last name must be letters without spaces , special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
            return false;
        }
        return true;
    }

    /*Hazem */

//******************************CITY**************************************//

        /*basma*/

    // public void city(String text,JTextField f11) {
        // if(!text.isEmpty()) {
        //     if (text.matches("\\d+") || text.matches(".*\\d+.*")) {
        //         JOptionPane.showMessageDialog(null,"city must be string without space or special chars", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
        //     }
        //     else {
        //         if(text.length()>max_city) {
        //             JOptionPane.showMessageDialog(null,"Limit Exceeded ", "Error Message", JOptionPane.ERROR_MESSAGE,limiticon1);
        //         }
        //         else{
        //             System.out.println(text);
        //             f11.setText("");
        //         }
        //     }
        // }
        // else {JOptionPane.showMessageDialog(null,"insert your city", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);}
        // }   

        /*basma*/

    /*hazem*/
    public boolean city(String text){
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null,"insert city", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
            return false;
        }
        else if (!isStringWithSpaces(text)) {
            JOptionPane.showMessageDialog(null,"city must be letters without special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
            return false;
        }
        return true;
    }
    /*hazem*/

    //******************************Payment Method**************************************//

        /*hazem*/
        public boolean payment(boolean Visa , boolean Cash){
            if (Visa == false && Cash == false) {
                JOptionPane.showMessageDialog(null,"choose payment method", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
                return false;
            }
            return true;        
        }
        /*hazem*/

    //******************************Borrow Date**************************************//

        /*hazem */
        public boolean BorrowDate(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Borrow Date is Empty or Incomplete , Enter date in (yyyy-mm-dd) format", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isValidDate(text)) {
                invalidDATE();
                return false;
            }
            return true;        
        }
        /*hazem */

    //******************************NumOfPrintings**************************************//

        /*hazem */
        public boolean NumOfPrintings(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"insert number of printings", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isNum(text)) {
                JOptionPane.showMessageDialog(null,"number of printings can't contain spaces,special chars or characters", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            return true;        
        }
        /*hazem */

        //******************************EndOfPrintingDate**************************************//

        /*hazem */
        public boolean EndOfPrintingDate(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"insert end of printings date", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isValidDate(text)) {
                invalidDATE();
                return false;
            }
            return true;        
        }
        /*hazem */

        //******************************Price**************************************//

        /*hazem */
        public boolean price(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"insert price", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isNum(text)) {
                JOptionPane.showMessageDialog(null,"Price can't contain spaces,special chars or characters", "Error Message", JOptionPane.ERROR_MESSAGE,inticon);
                return false;
            }
            return true;        
        }
        /*hazem */

        //******************************Type**************************************//

        /*hazem */
        public boolean type(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"insert type", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isStringWithSpaces(text)) {
                JOptionPane.showMessageDialog(null,"type must be letters without special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            return true;        
        }
        /*hazem */

        //******************************Language**************************************//

        /*hazem */
        public boolean language(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"insert language", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isString(text)) {
                JOptionPane.showMessageDialog(null,"language must be letters without spaces , special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            return true;        
        }
        /*hazem */

        //******************************Title**************************************//

        /*hazem */
        public boolean title(String text){
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null,"insert title", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            else if (!isStringWithSpaces(text)) {
                JOptionPane.showMessageDialog(null,"type must be letters without special chars or numbers", "Error Message", JOptionPane.ERROR_MESSAGE,erroricon);
                return false;
            }
            return true;        
        }
        /*hazem */

        //******************************Availablility**************************************//

        /*hazem*/
        public boolean availablility(boolean Available , boolean Unavailable){
            if (Available == false && Unavailable == false) {
                JOptionPane.showMessageDialog(null,"choose availablility", "Error Message", JOptionPane.ERROR_MESSAGE,inserticon);
                return false;
            }
            System.out.println("true");
            return true;        
        }
        /*hazem*/
}
