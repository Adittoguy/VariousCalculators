import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Marvellous implements ActionListener
{
    JFrame fobj;
    JLabel Num1, Num2, ResultLabel;
    JTextField tfobj1, tfobj2;
    JButton bobj;

    DataInputStream diobj;
    DataOutputStream doobj;

    public Marvellous(String title, int width, int height, DataInputStream dio, DataOutputStream doo)
    {
        diobj = dio;
        doobj = doo;

        fobj = new JFrame(title);

        Num1 = new JLabel("Number 1");
        Num1.setBounds(40, 40, 100, 40);

        tfobj1 = new JTextField();
        tfobj1.setBounds(150, 40, 150, 40);

        Num2 = new JLabel("Number 2");
        Num2.setBounds(40, 100, 100, 40); 

        tfobj2 = new JTextField();
        tfobj2.setBounds(150, 100, 150, 40);

        bobj = new JButton("Submit");
        bobj.setBounds(100, 170, 100, 50);

        ResultLabel = new JLabel("");
        ResultLabel.setBounds(100, 240, 200, 40);

        fobj.add(Num1);
        fobj.add(Num2);
        fobj.add(tfobj1);
        fobj.add(tfobj2);
        fobj.add(bobj);
        fobj.add(ResultLabel);

        bobj.addActionListener(this);

        fobj.setSize(width, height);
        fobj.setLayout(null);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent aboj)
    {
        try
        {
            int number1 = Integer.parseInt(tfobj1.getText());
            int number2 = Integer.parseInt(tfobj2.getText());

            doobj.writeInt(number1);
            doobj.writeInt(number2);
            doobj.flush();

            int iSum = diobj.readInt();
            ResultLabel.setText("Result is : "+iSum);
        }
        catch(Exception eobj)
        {}
    }
}

class Client2
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Client is running");


        Socket sobj = new Socket("localhost", 2100);
        System.out.println("Connected to server to successfully");

        DataInputStream diobj = new DataInputStream(sobj.getInputStream());
        DataOutputStream doobj = new DataOutputStream(sobj.getOutputStream());

        Marvellous mobj = new Marvellous("Client Request", 400, 300, diobj, doobj);
        

        System.out.println("Client application terminated");
    }
}