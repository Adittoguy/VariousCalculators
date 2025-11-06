import javax.swing.*;
import java.awt.event.*;

class MarvellousLogin implements ActionListener
{
    // Characteristics
    JFrame fobj;
    JButton bobjA, bobjS, bobjM, bobjD; 
    JTextField tobj1, tobj2;
    JLabel Num1Label, Num2Label, ResultLabel;

    public MarvellousLogin(String title, int width, int height)
    {
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
        String Text1 = tobj1.getText();
        String Text2 = tobj2.getText();

        float number1 = Float.parseFloat(Text1);
        float number2 = Float.parseFloat(Text2);

        float result = 0;

        if(aobj.getSource()==bobjA)
        {
            result = number1 + number2;
        }
        else if(aobj.getSource()==bobjS)
        {
            result = number1 - number2;
        }
        else if(aobj.getSource()==bobjM)
        {
            result = number1 * number2;
        }
        else if(aobj.getSource()==bobjD)
        {
            result = number2!=0 ? number1/number2 : 0;
        }

        ResultLabel.setText("Result: "+result);
    }
}

class GUIcalc
{
    public static void main(String A[])
    {
        MarvellousLogin mobj = new MarvellousLogin("Calculator", 400, 300);
    }   
}
