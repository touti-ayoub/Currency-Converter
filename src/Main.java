import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize (500, 150);
        frame.setResizable(false);
        frame.setVisible (true);
        frame.setLocationRelativeTo(null); // to open the window in the main screen
    }
}
