import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;


public class FrmLoginTest {
    public FrmLogin frmLogin;
    @Before
    public void loadFromData(){
        Main.mainFrame = new JFrame("Login");
        frmLogin = new FrmLogin();
        Main.mainFrame.setContentPane(frmLogin.pnlogin);
        Main.mainFrame.pack();
        Main.mainFrame.setResizable(false);
        Main.mainFrame.setLocationRelativeTo(null);
        Main.mainFrame.setVisible(true);
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void ClickOnButton() {
        frmLogin.usernamefeld.setText("Testname");
        frmLogin.passwortfeld.setText("Testpasswort");
        for(Component comp : frmLogin.pnlogin.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().equals("Sign Up")) {
                    button.doClick();
                    break;
                }
            }
        }
        frmLogin.usernamefeld.setText("Testname");
        frmLogin.passwortfeld.setText("Testpasswort");
        for(Component comp : frmLogin.pnlogin.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().equals("Log in")) {
                    button.doClick();
                    break;
                }
            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Movie Form");
    }

    @Test
    public void ClickOnButtonFail() {
        frmLogin.usernamefeld.setText("Testperson");
        frmLogin.passwortfeld.setText("Testpasswort");
        for(Component comp : frmLogin.pnlogin.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().equals("Sign Up")) {
                    button.doClick();
                    break;
                }
            }
        }
        frmLogin.usernamefeld.setText("Testperson");
        frmLogin.passwortfeld.setText("DasisteinString");
        for(Component comp : frmLogin.pnlogin.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().equals("Log in")) {
                    button.doClick();
                    break;
                }
            }
        }
    }


    @Test
    public void LoginPossible(){
        String name = "Testperson";
        String passwort = "Testpasswort";
        Person pers = new Person(name,passwort);
        frmLogin.login(name,passwort);
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Login Form");
    }

    @Test
    public void LoginNotPossible(){
        String name = "Testperson";
        String passwort = "Testpasswort";
        Person pers = new Person(name,"Passwort");
        frmLogin.login(name,passwort);
    }


    @Test
    public void GetPersonPossible(){
        String name = "Testperson";
        String passwort = "Testpasswort";
        Person pers = new Person(name,passwort);
        Persons persons = new Persons();
        persons.add(pers);
        persons.saveToJson();
        frmLogin.getPerson(name,passwort);
    }

    @Test
    public void GetPersonNotPossible(){
        String name = "Testperson";
        String passwort = "Testpasswort";
        Person pers = new Person(name,"Passwort");
        Persons persons = new Persons();
        persons.add(pers);
        persons.saveToJson();
        frmLogin.getPerson(name,passwort);
    }

    @Test
    public void SignUpNotPossible(){
        String name = "Testperson";
        String passwort = "Passwort";
        Person pers = new Person(name,passwort);
        frmLogin.signup(name,passwort);
    }

    @Test
    public void SignUpPossible(){
        String name = "Testperson";
        String passwort = "Testpasswort";
        Person pers = new Person(name,passwort);
        frmLogin.signup(name,passwort);
        Persons persons = new Persons();
        persons.saveToJson();
    }



    @Test
    public void SaveToJsonPossible(){
        frmLogin.saveToJson(new Person("Testperson","Testpasswort"));
    }
}