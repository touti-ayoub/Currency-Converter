import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    //variables i used
    JTextField amount1;
    JTextField amount2;
    JComboBox comboBox;
    JComboBox comboBox2;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel copyright;
    JButton convert;
    //constructor
    public MyFrame(){
        super ("Convertisseur de monnaies");
        setLayout(new FlowLayout());
    //add first text field with message and currency select
        label1 = new JLabel("enter an amount:  ");
        add(label1);
        amount1= new JTextField(10);
        add(amount1);
        String [] currency = {"TND","EUR","USD"};
        label2=new JLabel("chose a currency:");
        comboBox = new JComboBox(currency);
        add(comboBox);

    //add second text field with message and currency select
        label3 = new JLabel("enter an amount:  ");
        add(label2);
        amount2 = new JTextField(10);
        add(amount2);
        String [] currency2 = {"TND","EUR","USD"};
        label4=new JLabel("chose a currency:");
        comboBox2 = new JComboBox(currency2);
        add(comboBox2);


    //organizing elements in a panel
        JPanel panel = new JPanel(new GridLayout(2, 3, 12, 6));
            panel.add(label1);
            panel.add(label2);
            panel.add(label3);
            panel.add(label4);
            panel.add(amount1);
            panel.add(comboBox);
            panel.add(amount2);
            panel.add(comboBox2);
        add(panel);

        //organizing button and copyright label
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        convert = new JButton("convert!");
        add(convert);
        copyright = new JLabel(" © Project realized by Ayoub Touti ");
        add(copyright);
        listPane.add(convert);
        listPane.add(copyright);
        convert.setAlignmentX(Component.CENTER_ALIGNMENT);
        copyright.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(listPane);
        //start of action listener
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //get what user typed and convert it to double
                    Double input=Double.parseDouble(amount1.getText());
                    //convert euro to usd
                    if(comboBox.getSelectedItem().equals("EUR")&& comboBox2.getSelectedItem().equals("USD")){
                        Double result = input*1.13;
                        amount2.setText(result+"$");
                    }
                    //convert euro to tnd
                    if(comboBox.getSelectedItem().equals("EUR")&& comboBox2.getSelectedItem().equals("TND")){
                        Double result = input*3.24;
                        amount2.setText(result+"TND");
                    }
                    //convert usd to euro
                    if(comboBox.getSelectedItem().equals("USD")&& comboBox2.getSelectedItem().equals("EUR")){
                        Double result = input*0.88;
                        amount2.setText(result+"€");
                    }
                    //convert usd to dinar
                    if(comboBox.getSelectedItem().equals("USD")&& comboBox2.getSelectedItem().equals("TND")){
                        Double result = input*2.87;
                        amount2.setText(result+"TND");
                    }
                    //convert tnd to euro
                    if(comboBox.getSelectedItem().equals("TND")&& comboBox2.getSelectedItem().equals("EUR")){
                        Double result = input*0.31;
                        amount2.setText(result+"€");
                    }
                    //convert tnd to usd
                    if(comboBox.getSelectedItem().equals("TND")&& comboBox2.getSelectedItem().equals("USD")){
                        Double result = input*0.35;
                        amount2.setText(result+"$");
                    }
                    //i tired to use "else if" but it didnt work properly so i had to it manually
                    if((comboBox.getSelectedItem().equals("TND")&& comboBox2.getSelectedItem().equals("TND"))||
                            (comboBox.getSelectedItem().equals("EUR")&& comboBox2.getSelectedItem().equals("EUR"))||
                            (comboBox.getSelectedItem().equals("USD")&& comboBox2.getSelectedItem().equals("USD"))) {
                        JOptionPane.showMessageDialog(panel, "Nice Joke, chose another option");
                    }
                } /*end try statement */ catch (Exception ignored){
                    //JOptionPane.showMessageDialog(panel, ignored.getMessage());
                    JOptionPane.showMessageDialog(panel, "No amount detected, try again please");

                } //end catch statement
            } // end actionPerformed
        }); //end ActionListener

    } //end constructor MyFrame

}//end class MyFrame
