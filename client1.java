import javax.swing.*;
import java.util.*;
import java.net.Socket;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Client11 implements ActionListener
{
  String his_mess="",msg;
  JFrame f;
  JFrame f2;
  JButton b1,b2;
  JTextField t1,t2;
  JPasswordField p1;
  JTextArea history;
  Client11()
  {
    f=new JFrame("Client side");
    f2=new JFrame("Welcome");
    b1=new JButton("Login");
    b2=new JButton(">>");
    t1=new JTextField();
    t2=new JTextField();
    p1=new JPasswordField();
    JLabel l1=new JLabel("Username");
    JLabel l2=new JLabel("Password");
    history=new JTextArea("");
    f.setLayout(null);
    f.setSize(600,600);
    f2.setLayout(null);
    f2.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    l1.setBounds(150,150,150,50);
    l2.setBounds(150,250,150,50);
    history.setBounds(10,10,400,400);
    b1.setBounds(200,350,150,50);
    b2.setBounds(450,450,100,50);
    t1.setBounds(250,150,150,50);
    t2.setBounds(150,450,200,40);
    p1.setBounds(250,250,150,50);
    b1.addActionListener(this);
    b2.addActionListener(this);
    history.setBackground(Color.WHITE);
    history.setOpaque(true);
    f.add(l1);
    f.add(l2);
    f2.add(history);
    f.add(b1);
    f2.add(b2);
    f.add(t1);
    f2.add(t2);
    f.add(p1);
    f.setVisible(true);
    f2.setVisible(false);
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      String un=t1.getText();
      String pwd=p1.getText();
      System.out.println(un+" "+pwd);
      if (un.equals("Neelaksh") && pwd.equals("mine"))
      {
        f.setVisible(false);
        f2.setVisible(true);
      }
    }
    else
    {
      msg=t2.getText();
      System.out.println("message Displayed: "+msg);
      his_mess+="Neelaksh: "msg+"\n";
      System.out.println("history: \n"+his_mess);
      history.setText(his_mess);
      t2.setText("");
    }
  }
  public static void main(String[] args)
  {
    new Client11();
  }
}
