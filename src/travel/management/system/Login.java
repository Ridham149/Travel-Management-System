
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton signup,login,password;
    JTextField tfusername,tfpassword;
    Login(){
        setSize(900,400);
        setLocation(200,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE); //yeh functionpure panel ko uthakr back. color chng kr dega
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233)); //panel ko show krne ke liye tki dikhe hme,color class awt mai hote hai
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,150,150);
        p1.add(image); //yeh panel pe image add krege
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,400,300);
        add(p2);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN SERIE",Font.PLAIN,20));
        p2.add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel lblpasword=new JLabel("Password");
        lblpasword.setBounds(60,110,100,25);
       lblpasword.setFont(new Font("SAN SERIE",Font.PLAIN,20));
        p2.add(lblpasword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
       tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        
        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);//yeh button ke andr likhe text ko color krega
        login.addActionListener(this);
        p2.add(login);
        
        signup=new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);//yeh button ke andr likhe text ko color krega
        signup.addActionListener(this);
        p2.add(signup);
        
        password=new JButton("Forget Password");
        password.setBounds(130,250,140,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.WHITE);//yeh button ke andr likhe text ko color krega
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text=new JLabel("Trouble in login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        setVisible(true);
    }
    //ab mrko btn pr km krna ke mtlb agr login pe click kru toh loading vala frame khul jaye.
    //agr signup pe click kru toh signup vala frame khul jaye
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
                String username=tfusername.getText();
                String pass=tfpassword.getText();
                
                String query="select * from account where username='"+username+"' AND password='"+pass+"'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
           
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args){
        Login l=new Login();
    }
}
