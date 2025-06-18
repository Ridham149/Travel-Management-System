
package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    //JProgressbar ko globally declare krna pdega 
    JProgressBar bar;
    String username;
    public void run(){
        try{
            for(int i=0;i<=101;i++){
                int max=bar.getMaximum();//100
                int value=bar.getValue();
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }
                else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username=username;//eh jo mai username as argument pass kr rha hu jidr welcome ridham likh ke aye
        t=new Thread(this);
        setBounds(450,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Baleway",Font.BOLD,35));
        add(text);
        
        //progress bar
        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        
       //2 label lgao 
       JLabel loading=new JLabel("Loading,please...");
       loading.setBounds(230,130,150,30);
       loading.setForeground(Color.RED);
       loading.setFont(new Font("Baleway",Font.BOLD,16));
       add(loading);
       
       JLabel lblusername=new JLabel("Welcome "+ username);
       lblusername.setBounds(20,310,400,40);
       lblusername.setForeground(Color.RED);
       lblusername.setFont(new Font("Baleway",Font.BOLD,16));
       add(lblusername);
       
       t.start();
        setVisible(true);
    }
    public static void main(String[] args){
        new Loading("");
    }
}
