
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton bookpackage,checkprice,back;
    String username;
    BookPackage(String username){
        this.username=username;
        setBounds(350,200,1000,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Book Package");
        text.setBounds(90,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblusername.setBounds(40,70,100,20);
       add(lblusername);
       
       labelusername=new JLabel();
       lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
       labelusername.setBounds(250,70,200,20);
       add(labelusername);
       
       //label 2
       JLabel lblpackage=new JLabel("Select Package");
       lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblpackage.setBounds(40,110,150,20);
       add(lblpackage);
       //select package jo hoga voh drop down hoga
       cpackage=new Choice();
       cpackage.add("Gold Package");
       cpackage.add("Silver Package");
       cpackage.add("Bronze Package");
       cpackage.setBounds(250,110,200,20);
       add(cpackage);
       
       //label 3
       JLabel lblpersons=new JLabel("Total Persons");
       lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblpersons.setBounds(40,150,150,20);
       add(lblpersons);
       
       tfpersons=new JTextField("1");//value bydefault he rkhi bhd mai chnge krege
       tfpersons.setBounds(250,150,200,25);
       add(tfpersons);
       
       //label 4
       JLabel lblid=new JLabel("Id");
      lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblid.setBounds(40,190,150,20);
       add(lblid);
       
       labelid=new JLabel();
       labelid.setBounds(250,190,150,25);
       add(labelid);
       
      //label 5
      JLabel lblnumber=new JLabel("Number");
      lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblnumber.setBounds(40,230,150,25);
       add(lblnumber);
       
       labelnumber=new JLabel();
       labelnumber.setBounds(250,230,150,25);
       add(labelnumber);
       
       JLabel lblphone=new JLabel("Phone");
      lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblphone.setBounds(40,270,150,20);
       add(lblphone);
       
       labelphone=new JLabel();
       labelphone.setBounds(250,270,200,25);
       add(labelphone);
       
      //label 5
      JLabel lbltotal=new JLabel("Total Price");
      lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
       lbltotal.setBounds(40,310,150,25);
       add(lbltotal);
       
       labelprice=new JLabel();
       labelprice.setBounds(250,310,150,25);
       add(labelprice);
       
       try{
          conn c=new conn();
          //yeh jo username le rha hu mai...upr maine constructor ke andr username var liye jo piche se pass hoga
          String query="select * from customer where username='"+username+"'";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next()){
              labelusername.setText(rs.getString("username"));
              labelid.setText(rs.getString("id"));
              labelnumber.setText(rs.getString("number"));
              labelphone.setText(rs.getString("phone"));
          }
       }catch(Exception e){
       e.printStackTrace();
       }
        
       //btns
       checkprice=new JButton("Check Price");
       checkprice.setBackground(Color.BLACK);
       checkprice.setForeground(Color.WHITE);
       checkprice.setBounds(60,380,120,25);
       checkprice.addActionListener(this);
       add(checkprice);
       
       bookpackage=new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
       add(bookpackage);
       
        back=new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
       add(back);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,10,350,400);
        add(image);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost+=12000; 
            }else if(pack.equals("Silver Package")){
                cost+=25000;
            }else{
                cost+=32000;
            }
            int persons=Integer.parseInt(tfpersons.getText());
            cost*=persons;
            labelprice.setText("Rs"+cost);
        }else if(ae.getSource()==bookpackage){
            //iske click pr sara data,database mai dalan
            try{
               conn c=new conn();
               c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
              
               JOptionPane.showMessageDialog(null,"Package Booked Successfully");
               setVisible(false); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
      new BookPackage("ridham");
    }
}
