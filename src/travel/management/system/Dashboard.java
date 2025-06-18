
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addpersonalDetails,destinations,about,viewBookedHotel,calculators,notepad,payments,bookhotel,viewPersonalDetails,updatePersonalDetails,checkpackages,bookpackages,viewpackages,viewhotels;
    Dashboard(String username){
        this.username=username;
        //setBounds(0,0,1600,1000);  
        //agr puri screen pr frame kholna toh use below function
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);  //yeh mera header hai
        add(p1);
        
        //ab header pe mrko image and text likha hua chaiye
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        
        
        //dusra panel
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);  //yeh mera header hai
        add(p2);
        
        //ek ek krke btn lgane hai ....phla btn
        addpersonalDetails=new JButton("Add Personal Details");
        addpersonalDetails.setBounds(0,0,300,45);
        addpersonalDetails.setBackground(new Color(0,0,102));
        addpersonalDetails.setForeground(Color.WHITE);
        addpersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addpersonalDetails.setMargin(new Insets(0,0,0,60));//yeh btn ke andr text ko left align krna,60 jo hai voh right side se hai
        addpersonalDetails.addActionListener(this);
        p2.add(addpersonalDetails);
        
        //dusra btn
        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,45,300,45);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        //third btn
        viewPersonalDetails=new JButton("View Details");
        viewPersonalDetails.setBounds(0,90,300,45);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        //fourth btn
        JButton deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,135,300,45);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,30));
        p2.add(deletePersonalDetails);
        
        //fifth btn
        checkpackages=new JButton("Check Package");
        checkpackages.setBounds(0,180,300,45);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        //sixth btn
        bookpackages=new JButton("Book Package");
        bookpackages.setBounds(0,225,300,45);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,115));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        //
        viewpackages=new JButton("View Package");
        viewpackages.setBounds(0,270,300,45);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,115));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);
        
        //
        viewhotels=new JButton("View Hotel");
        viewhotels.setBounds(0,315,300,45);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,140));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        //
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBounds(0,360,300,45);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,140));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        //
        viewBookedHotel=new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,405,300,45);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,70));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        //
        destinations=new JButton("Destinations");
        destinations.setBounds(0,450,300,45);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        //
        payments=new JButton("Payments");
        payments.setBounds(0,495,300,45);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,150));
        payments.addActionListener(this);
        p2.add(payments);
        
        
        //
//        notepad=new JButton("Notepad");
//        notepad.setBounds(0,495,300,45);
//        notepad.setBackground(new Color(0,0,102));
//        notepad.setForeground(Color.WHITE);
//        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
//        notepad.setMargin(new Insets(0,0,0,155));
//        notepad.addActionListener(this);
//        p2.add(notepad);
        
        //
        notepad=new JButton("Notepad");
        notepad.setBounds(0,540,300,45);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155));
       notepad.addActionListener(this);
        p2.add(notepad);
        
        calculators=new JButton("Calculators");
        calculators.setBounds(0,585,300,45);
        calculators.setBackground(new Color(0,0,102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculators.setMargin(new Insets(0,0,0,130));
        calculators.addActionListener(this);
        p2.add(calculators);
        
        
        //ab right side ek image lgani hai
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Baleway",Font.BOLD,45));
        image.add(text);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersonalDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource()==viewPersonalDetails){
            new ViewCustomer("username"); //iske click pe viewcustomer vala frame khula but koi data nhi aya,kyuke username idr se pass ho rha,or yeh ayega login class se
        }else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkpackages){
            new CheckPackage();
        }else if(ae.getSource()==bookpackages){
            new BookPackage(username);  
        }else if(ae.getSource()==viewpackages){
            new ViewPackage(username);
        }else if(ae.getSource()==viewhotels){
            new CheckHotels();
        }else if(ae.getSource()==destinations){
            new Destinations(); 
        }else if(ae.getSource()==bookhotel){
            new BookHotel(username);
        }else if(ae.getSource()==viewBookedHotel){
            new ViewBookedHotel(username);
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==calculators){
            try{
                Runtime.getRuntime().exec("calc.exe");//yeh calce honi chaiye 
            }catch(Exception e){
                e.printStackTrace();    
            }
        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");//yeh calce honi chaiye 
            }catch(Exception e){
                e.printStackTrace();    
            }
        }
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}
