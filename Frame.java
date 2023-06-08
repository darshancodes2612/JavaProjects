import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    JTextField jtxt = new JTextField();
    JPasswordField jpass = new JPasswordField();
    JLabel username = new JLabel("USERNAME");
    JLabel password = new JLabel("PASSWORD");
    JLabel checkbox_text = new JLabel("Show password");
    JButton login = new JButton("LOGIN");
    JButton reset = new JButton("RESET");
    JCheckBox show_pass = new JCheckBox();

    Container container = getContentPane();

    Frame() {
        setLayoutManager();
        setSizePosition();
        addComponents();
        setActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setSizePosition() {
        username.setBounds(40, 100, 100, 40);
        jtxt.setBounds(170,113,110,25);
        password.setBounds(40,147,100,40);
        jpass.setBounds(170,160,110,25);
        login.setBounds(40,227,90,35);
        reset.setBounds(150,227,90,35);
        checkbox_text.setBounds(40,282,90,35);
        show_pass.setBounds(150,282,30,30);
    }

    public void addComponents() {
        container.add(username);
        container.add(password);
        container.add(login);
        container.add(reset);
        container.add(show_pass);
        container.add(jpass);
        container.add(jtxt);
        container.add(checkbox_text);
        container.add(show_pass);
    }

    public void setActionEvent() {
        login.addActionListener(this);
        reset.addActionListener(this);
        show_pass.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            String user_name,passfield;
            user_name = username.getText();
            passfield = jpass.getText();
            if (user_name.isEmpty() || passfield.isEmpty()){
                JOptionPane.showMessageDialog(this,"user name and password required");
            }
            else {
                JOptionPane.showMessageDialog(this,"Login successful");
                dispose();
            }
        }
        else if (e.getSource() == reset){
            String user_n;
            String pass_n;
            user_n = jtxt.getText();
            pass_n = jpass.getText();
            if (user_n.isEmpty() || pass_n.isEmpty()){
                JOptionPane.showMessageDialog(this,"Field already empty add text for reset operation");
            }else {
                jtxt.setText("");
                jpass.setText("");
            }

        } else if (e.getSource() == show_pass){
            String j_pass;
            j_pass = jpass.getText();
            if (j_pass.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nothing to show");
            }
            else {
                if (show_pass.isSelected()){
                    jpass.setEchoChar((char) 0);
                }
                else {
                    jpass.setEchoChar('*');
                }
            }
        }
    }
}
