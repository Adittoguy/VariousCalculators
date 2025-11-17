import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Marvellous implements ActionListener
{
    JFrame fobj;
    JButton bobjA, bobjS, bobjM, bobjD; 
    JTextField tobj1, tobj2;
    JLabel Num1Label, Num2Label, ResultLabel;

    DataInputStream diobj;
    DataOutputStream doobj;

    public Marvellous(String title, int width, int height, DataInputStream dio, DataOutputStream doo)
    {
        diobj = dio;
        doobj = doo;

        fobj = new JFrame(title);

        Num1Label = new JLabel("Number 1 ");
        Num1Label.setBounds(50, 50, 100, 30);

        tobj1 = new JTextField();
        tobj1.setBounds(150, 50, 150, 30);

        Num2Label = new JLabel("Number 2");
        Num2Label.setBounds(50, 100, 100, 30);

        tobj2 = new JTextField();
        tobj2.setBounds(150, 100, 150, 30);

        bobjA = new JButton("+");
        bobjA.setBounds(40, 150, 50, 30);

        bobjS = new JButton("-");
        bobjS.setBounds(120, 150, 50, 30);

        bobjM = new JButton("*");
        bobjM.setBounds(190, 150, 50, 30);

        bobjD = new JButton("/");
        bobjD.setBounds(260, 150, 50, 30);

        ResultLabel = new JLabel("");
        ResultLabel.setBounds(150, 200, 250, 30);

        fobj.add(bobjA);
        fobj.add(bobjS);
        fobj.add(bobjM);
        fobj.add(bobjD);
        fobj.add(tobj1);
        fobj.add(tobj2);
        fobj.add(Num1Label);
        fobj.add(Num2Label);
        fobj.add(ResultLabel);

        bobjA.addActionListener(this);
        bobjS.addActionListener(this);
        bobjM.addActionListener(this);
        bobjD.addActionListener(this);

        fobj.setLayout(null);
        fobj.setSize(width, height);

        fobj.setResizable(true);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent aobj)
    {
        try
        {
            int number1 = Integer.parseInt(tobj1.getText());
            int number2 = Integer.parseInt(tobj2.getText());
            char operator = '\0';

            doobj.writeInt(number1);
            doobj.writeInt(number2);

            if(aobj.getSource()== bobjA)
            {
                operator = '+';
            }
            else if(aobj.getSource()==bobjS)
            {
                operator = '-';
            }
            else if(aobj.getSource()==bobjM)
            {
                operator = '*';
            }
            else if(aobj.getSource()==bobjD)
            {
                operator = '/';
            }

            doobj.writeChar(operator);

            doobj.flush();

            int iSum = diobj.readInt();
            ResultLabel.setText("Result is : "+iSum);
        }
        catch(Exception eobj)
        {}
    }
}

class Client3
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