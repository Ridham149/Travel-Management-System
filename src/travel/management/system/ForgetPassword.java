
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements  ActionListener{
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrive,back;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(570,70,200,200);
        add(image);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
//panel ke left side components lgane hai and right side image lgani hai

        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(220,20,150,25); 
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        // ek or component for name
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(220,60,150,25); 
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        //ek or component
        JLabel lblquestion=new JLabel("Security Question");
        lblquestion.setBounds(40,100,100,25);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblquestion);
        
        tfquestion=new JTextField();
        tfquestion.setBounds(220,100,150,25); 
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        //answer ke lye
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setBounds(40,140,100,25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblanswer);
        
        tfanswer=new JTextField();
        tfanswer.setBounds(220,140,150,25); 
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        
//ab hme ek button bnana pdega answer ke agee jo retrive ke name se jo apke password ko retrive krega
        retrive=new JButton("Retrive");
        retrive.setBackground(Color.GRAY);
        retrive.setForeground(Color.WHITE);
        retrive.setBounds(380,140,100,25);
        retrive.addActionListener(this);
        p1.add(retrive);
        
       
        //password bnayege jidr hmara jo password tha vo ayega iske textfield mai
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,180,100,25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblpassword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(220,180,150,25); 
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            //agr search btn pr click hua toh query ko hit krna pdega
            try{
                String query="select * from account where username='"+tfusername.getText()+"'";
                //ab query execute krani hai toh conn class ka object bnana pdega 
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==retrive){
            try{
                String query="select * from account where answer='"+tfanswer.getText()+"'AND username='"+tfusername.getText()+"'";
                //ab query execute krani hai toh conn class ka object bnana pdega 
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Login();
        }
    } 
    public static void main(String[] args){
        new ForgetPassword();
    }
}
