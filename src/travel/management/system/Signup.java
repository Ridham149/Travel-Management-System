
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;
    Signup(){
        setSize(800,360);
        getContentPane().setBackground(Color.WHITE);
        setLocation(200,200);
        setLayout(null);
        
         JPanel p1=new JPanel();
         p1.setBackground(new Color(131,193,233));
         p1.setBounds(0,0,400,400);
         p1.setLayout(null);
         add(p1);
         
         //ab mai label dalunga username ke liye
         JLabel lblusername=new JLabel("Username");
         lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
         lblusername.setBounds(50,20,125,25);
         p1.add(lblusername);
         
         //ab text field dalo
          tfusername=new JTextField();
         tfusername.setBounds(190,20,180,25);
         tfusername.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfusername);
         
         //ab mai label dalunga name ke liye
         JLabel lblname=new JLabel("Name");
         lblname.setFont(new Font("Tahoma",Font.BOLD,14));
         lblname.setBounds(50,60,125,25);
         p1.add(lblname);
         
         //ab text field dalo
          tfname=new JTextField();
         tfname.setBounds(190,60,180,25);
         tfname.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfname);
         
         //ab mai label dalunga password ke liye
         JLabel lblpassword=new JLabel("Password");
         lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
         lblpassword.setBounds(50,100,125,25);
         p1.add(lblpassword);
         
         //ab text field dalo
          tfpassword=new JTextField();
         tfpassword.setBounds(190,100,180,25);
         tfpassword.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfpassword);
         
        //ab label hai security ques ke name se,or textfield ke andr dropdownlist hai,kaise bante hai dekho
         JLabel lblsecurity=new JLabel("Security Question");
         lblsecurity.setBounds(50,140,125,25);
         lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
         p1.add(lblsecurity);
         
         //dropdown kaise bnaye
          security=new Choice();
         security.add("Fav character from the boys");
         security.add("Fav marvel superhero");
         security.add("your lucky number");
         security.add("your childhood superhero");
         security.setBounds(190,140,180,25);
         p1.add(security);
         
         //label bnao answer ka
         JLabel lblanswer=new JLabel("Answer");
         lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
         lblanswer.setBounds(50,180,125,25);
         p1.add(lblanswer);
         
         //ab text field dalo
          tfanswer=new JTextField();
         tfanswer.setBounds(190,180,180,25);
         tfanswer.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfanswer);
         
         //ab mrko button dalne hai
          create=new JButton("Create");
         create.setBackground(Color.WHITE);
         create.setForeground(new Color(133,193,233));
         create.setFont(new Font("Tahoma",Font.BOLD,14));
         create.setBounds(80,250,100,30);
         create .addActionListener(this);
         p1.add(create);
         
          back=new JButton("Back");
         back.setBackground(Color.WHITE);
         back.setForeground(new Color(133,193,233));
         back.setFont(new Font("Tahoma",Font.BOLD,14));
         back.setBounds(250,250,100,30);
         back.addActionListener(this);
         p1.add(back);
         
         
         
         //ab mrko right side image lgani hai
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,50,250,250);
        add(image); //yeh panel pe image add krege
         
        setVisible(true);
    }
    //jo 2 btn hai voh constructor ke andr hai unka bhr se koi access nhi hai isliye unko globally define kiya
    public void actionPerformed(ActionEvent ae){
        //ab btana konsa btn call hua voh btata ActionEvent
        if(ae.getSource()==create){
            //iske andr mrko textfield ke text ko uthana hai
            String username=tfusername.getText();
            String name=tfname.getText();
            String password=tfpassword.getText();
            String question=security.getSelectedItem();
            String answer=tfanswer.getText();
            //yeh sara data mrko databse mai store krvana table main account table mai
            //java ke help se ek query bnane pdege
            String query="insert into account value('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                //mysql ke connection ko establish krna pdega
                conn c=new conn();
                c.s.executeUpdate(query);
                //agr mera data store ho jata hai toh mrko ek popup dikhana hai using JOptionPane.....
                JOptionPane.showMessageDialog(null,"Account created successfully");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
          //back btn pr click krke frame clse krdena hai fir login pe ajana vapis
          setVisible(false);
          new Login();
        }
    }
    public static void main(String[] args){
      Signup s=new Signup();  
    }
}
