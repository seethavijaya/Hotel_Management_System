package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lb1roomnumber, lb1checkintime, lb1checkouttime;
    JButton checkout, back;
    Checkout () {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        JLabel lb1id = new JLabel("Customer Id");
        lb1id.setBounds(30, 80, 100, 30);
        add(lb1id);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 80, 20, 20);
        add(tick);
        
        JLabel lb1room = new JLabel("Room Number");
        lb1room.setBounds(30, 130, 100, 30);
        add(lb1room);
        
        lb1roomnumber = new JLabel();
        lb1roomnumber.setBounds(150, 130, 100, 30);
        add(lb1roomnumber);
        
        JLabel lb1checkin = new JLabel("Checkin Time");
        lb1checkin.setBounds(30, 180, 100, 30);
        add(lb1checkin);
        
        lb1checkintime = new JLabel();
        lb1checkintime.setBounds(150, 180, 100, 30);
        add(lb1checkintime);
        
        JLabel lb1checkout = new JLabel("Checkout Time");
        lb1checkout.setBounds(30, 230, 100, 30);
        add(lb1checkout);
        
        Date date = new Date();
        lb1checkouttime = new JLabel("" + date);
        lb1checkouttime.setBounds(150, 230, 150, 30);
        add(lb1checkouttime);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        checkout.setBounds(30, 280, 120, 30);
        add(checkout);
    
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(170, 280, 120, 30);
        add(back);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
                lb1roomnumber.setText(rs.getString("room"));
                lb1checkintime.setText(rs.getString("checkintime"));
                
            }
        }  catch(Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);
        
        setBounds(300, 200, 800, 400);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == checkout) {
             String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
             String query2 = "update room set availability = 'Available' where roomnumber = '"+lb1roomnumber.getText()+"'";
             
             try {
                 Conn c = new Conn();
                 c.s.execute(query1);
                 c.s.execute(query2);
                 
                JOptionPane.showMessageDialog(null, "Checkout done");
                setVisible(false);
                new Reception();
             
             } catch (Exception e) {
                 e.printStackTrace();
             }
             
         } else {
             setVisible(false);
             new Reception();
         }
     }
    public static void main(String[] args) {
        new Checkout();
    }
}
