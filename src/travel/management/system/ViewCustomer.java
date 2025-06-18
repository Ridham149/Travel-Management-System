
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    ViewCustomer(String username){
       setBounds(350,120,850,600);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       //sbse phle labels bnane hai
       // label 1
       JLabel lblusername=new JLabel("Username");
       lblusername.setBounds(30,50,150,25);
       add(lblusername);
       
       JLabel labelusername=new JLabel();
       labelusername.setBounds(220,50,150,25);
       add(labelusername);
       
       //label 2
       JLabel lblid=new JLabel("Id");
       lblid.setBounds(30,110,150,25);
       add(lblid);
       
       JLabel labelid=new JLabel();
       labelid.setBounds(220,110,150,25);
       add(labelid);
       
       //label 3
       JLabel lblnumber=new JLabel("Number");
       lblnumber.setBounds(30,170,150,25);
       add(lblnumber);
       
       JLabel labelnumber=new JLabel();
       labelnumber.setBounds(220,170,150,25);
       add(labelnumber);
       
       //label 4
       JLabel lblname=new JLabel("Name");
       lblname.setBounds(30,230,150,25);
       add(lblname);
       
       JLabel labelname=new JLabel();
       labelname.setBounds(220,230,150,25);
       add(labelname);
       
      //label 5
      JLabel lblgender=new JLabel("Gender");
       lblgender.setBounds(30,290,150,25);
       add(lblgender);
       
       JLabel labelgender=new JLabel();
       labelgender.setBounds(220,290,150,25);
       add(labelgender);
       
       //label 6
       JLabel lblcountry=new JLabel("Country");
       lblcountry.setBounds(450,50,150,25);
       add(lblcountry);
       
       JLabel labelcountry=new JLabel();
       labelcountry.setBounds(650,50,150,25);
       add(labelcountry);
       
       //label 7
       JLabel lbladdress=new JLabel("Address");
       lbladdress.setBounds(450,110,150,25);
       add(lbladdress);
       
       JLabel labeladdress=new JLabel();
       labeladdress.setBounds(650,110,150,25);
       add(labeladdress);
       
       //label 8
       JLabel lblphone=new JLabel("Phone");
       lblphone.setBounds(450,170,150,25);
       add(lblphone);
       
       JLabel labelphone=new JLabel();
       labelphone.setBounds(650,170,150,25);
       add(labelphone);
       
       //email
       JLabel lblemail=new JLabel("Email");
       lblemail.setBounds(450,230,150,25);
       add(lblemail);
       
       JLabel labelemail=new JLabel();
       labelemail.setBounds(650,230,190,25);
       add(labelemail);
       
       //btn
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setBounds(325,350,100,25);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
       //add image
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
       Image i2=i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(10,400,600,200);
       add(image);
       
       //image ane ke bhd right side space khali reh rhi hai...isliye hum duplicate image lga rhe hai usi mai se
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
       Image i5=i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel image2=new JLabel(i6);
       image2.setBounds(600,400,600,200);
       add(image2);
       
       //ab jitna data voh database mai se nikal na or label pr place krna
       try{
          conn c=new conn();
          //yeh jo username le rha hu mai...upr maine constructor ke andr username var liye jo piche se pass hoga
          String query="select * from customer where username='"+username+"'";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next()){
              labelusername.setText(rs.getString("username"));
              labelid.setText(rs.getString("id"));
              labelnumber.setText(rs.getString("number"));
              labelname.setText(rs.getString("name"));
              labelgender.setText(rs.getString("gender"));
              labelcountry.setText(rs.getString("country"));
              labeladdress.setText(rs.getString("address"));
              labelphone.setText(rs.getString("phone"));
              labelemail.setText(rs.getString("email"));
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
        new ViewCustomer("");
    }
}
