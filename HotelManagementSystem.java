package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
        HotelManagementSystem() {
         setSize(1366, 565);
         setLocation(100, 100);
         setBounds(0, 0, 1250, 700);  
         setLayout(null);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first image.jpeg"));
         JLabel image = new JLabel(i1);
         image.setBounds(0, 0, 1250,700);//locationx,locationy,length,breadth
         add(image);
         
         JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
         text.setBounds(20, 560, 1000, 50);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("serit", Font.PLAIN, 50));
         image.add(text);
         
         JButton next = new JButton("NEXT");
         next.setBounds(1050, 550, 150, 50);
         next.setBackground(Color.WHITE);
         next.setForeground(Color.MAGENTA);
         next.addActionListener(this);
         next.setFont(new Font("serit", Font.PLAIN, 24));
         image.add(next);
         
        setVisible(true);
        
        
        while(true){
            text.setVisible(false);
        try {
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
        try {
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
    }
    }

        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Login();
        }
    public static void main(String[] args) {
       new HotelManagementSystem();
    }
    
}





