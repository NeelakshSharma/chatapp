import javax.swing.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Server11 implements ActionListener
{
  static String his_mess="",msg,r_msg;
  JFrame f;
  JFrame f2;
  JButton b1,b2;
  JTextField t1,t2;
  JPasswordField p1;
  static JTextArea history;
  static Scanner sc;
  PrintStream p;
  static ServerSocket so;
  static Socket ss;
  Server11()
  {
    f=new JFrame("Server side");
    f2=new JFrame("Welcome Server side");
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
      if (un.equals("Rashi") && pwd.equals("mine"))
      {
        f.setVisible(false);
        f2.setVisible(true);
      }
    }
    else
    {
      msg=t2.getText();
      System.out.println("message Displayed: "+msg);
      his_mess+="Rashi: "+msg+"\n";
      System.out.println("history: \n"+his_mess);
      history.setText(his_mess);
      t2.setText("");
      try
      {
        p=new PrintStream(ss.getOutputStream());
      }
      catch(Exception e1)
      {
          System.out.println("Error: "+e1);
      }
      p.println(msg);
    }
  }
  public static void main(String[] args)
  {
    try
    {
        so=new ServerSocket(8080);
        ss=so.accept();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    new Server11();
    try
    {
      sc=new Scanner(ss.getInputStream());
      while(true)
      {
        r_msg=sc.nextLine();
        if(r_msg!=null)
        {
          System.out.println(r_msg);
          his_mess+="Neelaksh: "+r_msg+"\n";
          history.setText(his_mess);
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e+"while scanning");
    }
  }
}
