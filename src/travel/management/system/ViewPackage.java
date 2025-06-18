
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ViewPackage extends JFrame implements ActionListener{
   
JButton back;
    ViewPackage(String username){
       setBounds(450,200,900,450);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel text=new JLabel("View Package Details");
       text.setBounds(60,0,300,30);
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       add(text);
       //sbse phle labels bnane hai
       // label 1
       JLabel lblusername=new JLabel("Username");
       lblusername.setBounds(30,50,150,25);
       add(lblusername);
       
       JLabel labelusername=new JLabel();
       labelusername.setBounds(220,50,150,25);
       add(labelusername);
       
       //label 2
       JLabel lblid=new JLabel("package");
       lblid.setBounds(30,90,150,25);
       add(lblid);
       
       JLabel labelpackage=new JLabel();
       labelpackage.setBounds(220,90,150,25);
       add(labelpackage);
       
       //label 3
       JLabel lblnumber=new JLabel("Total Persons");
       lblnumber.setBounds(30,130,150,25);
       add(lblnumber);
       
       JLabel labelpersons=new JLabel();
       labelpersons.setBounds(220,130,150,25);
       add(labelpersons);
       
       //label 4
       JLabel lblname=new JLabel("Id");
       lblname.setBounds(30,170,150,25);
       add(lblname);
       
       JLabel labelid=new JLabel();
       labelid.setBounds(220,170,150,25);
       add(labelid);
       
      //label 5
      JLabel lblgender=new JLabel("Number");
       lblgender.setBounds(30,210,150,25);
       add(lblgender);
       
       JLabel labelnumber=new JLabel();
       labelnumber.setBounds(220,210,150,25);
       add(labelnumber);
       
       //label 6
       JLabel lblcountry=new JLabel("Phone");
       lblcountry.setBounds(30,250,150,25);
       add(lblcountry);
       
       JLabel labelphone=new JLabel();
       labelphone.setBounds(220,250,150,25);
       add(labelphone);
       
       //label 7
       JLabel lbladdress=new JLabel("Price");
       lbladdress.setBounds(30,290,150,25);
       add(lbladdress);
       
       JLabel labelprice=new JLabel();
       labelprice.setBounds(220,290,150,25);
       add(labelprice);
       
       //btn
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setBounds(130,360,100,25);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
       //add image
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
       Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(450,20,500,400);
       add(image);
       
       //ab jitna data voh database mai se nikal na or label pr place krna
       try{
          conn c=new conn();
          //yeh jo username le rha hu mai...upr maine constructor ke andr username var liye jo piche se pass hoga
          String query="select * from bookpackage where username='"+username+"'";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next()){
              labelusername.setText(rs.getString("username"));
              labelid.setText(rs.getString("id"));
              labelnumber.setText(rs.getString("number"));
              labelpackage.setText(rs.getString("package"));
              labelprice.setText(rs.getString("price"));
              labelphone.setText(rs.getString("phone"));
              labelpersons.setText(rs.getString("persons"));
              
          }
       }catch(Exception e){
           e.printStackTrace();
       }
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new ViewPackage("ridham");
    }
}

