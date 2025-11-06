import java.awt.*;
import javax.swing.*;

class MarvellousCalc
{
    JFrame fobj;
    JLabel nobj1, nobj2, robj;
    JTextField tobj1, tobj2;
    JButton bobj0, bobj1, bobj2, bobj3, bobj4, bobj5, bobj6, bobj7, bobj8, bobj9, bobjA, bobjS, bobjM, bobjD, bobjCLEAR, bobjEQUAL;

    public MarvellousCalc(String title, int width, int height)
    {
        fobj = new JFrame(title);

        nobj1 = new JLabel("Number 1");
        nobj1.setBounds(10, 4, 100, 41);

        nobj2 = new JLabel("Number 2");
        nobj2.setBounds(10, 55, 100, 41);

        tobj1 = new JTextField();
        tobj1.setBounds(134 , 4, 100, 41);

        tobj2 = new JTextField();
        tobj2.setBounds(134 , 55, 100, 41);

        bobj1 = new JButton("1");
        bobj1.setBounds(10, 110, 50, 50);

        bobj2 = new JButton("2");
        bobj2.setBounds(70, 110, 50, 50);

        bobj3 = new JButton("3");
        bobj3.setBounds(130, 110, 50, 50);

        bobjA = new JButton("+");
        bobjA.setBounds(190, 110, 50, 50);

        bobj4 = new JButton("4");
        bobj4.setBounds(10, 170, 50, 50);

        bobj5 = new JButton("5");
        bobj5.setBounds(70, 170, 50, 50);

        bobj6 = new JButton("6");
        bobj6.setBounds(130, 170, 50, 50);

        bobjS = new JButton("-");
        bobjS.setBounds(190, 170, 50, 50);

        bobj7 = new JButton("7");
        bobj7.setBounds(10, 230, 50, 50);

        bobj8 = new JButton("8");
        bobj8.setBounds(70, 230, 50, 50);

        bobj9 = new JButton("9");
        bobj9.setBounds(130, 230, 50, 50);

        bobjM = new JButton("*");
        bobjM.setBounds(190, 230, 50, 50);

        bobjCLEAR = new JButton("C");
        bobjCLEAR.setBounds(10, 290, 50, 50);

        bobj0 = new JButton("0");
        bobj0.setBounds(70, 290, 50, 50);

        bobjEQUAL = new JButton("=");
        bobjEQUAL.setBounds(130, 290, 50, 50);

        bobjD = new JButton("/");
        bobjD.setBounds(190, 290, 50, 50);

        robj = new JLabel("R");
        robj.setBounds(80, 350, 100, 40);


        fobj.add(bobjA);
        fobj.add(bobjS);
        fobj.add(bobjM);
        fobj.add(bobjD);
        fobj.add(bobj1);
        fobj.add(bobj2);
        fobj.add(bobj3);
        fobj.add(bobj4);
        fobj.add(bobj5);
        fobj.add(bobj6);
        fobj.add(bobj7);
        fobj.add(bobj8);
        fobj.add(bobj9);
        fobj.add(bobj0);
        fobj.add(bobjCLEAR);
        fobj.add(bobjEQUAL);
        fobj.add(tobj1);
        fobj.add(tobj2);
        fobj.add(nobj1);
        fobj.add(nobj2);
        fobj.add(robj);  

        fobj.setLayout(null);
        fobj.setSize(width, height);

        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] allButton = {bobj0, bobj1, bobj2, bobj3, bobj4, bobj5, bobj6, bobj7, bobj8, bobj9, bobjA, bobjS, bobjM, bobjD, bobjCLEAR, bobjEQUAL;}
        for(JButton b : allButton)
        {
            b.addActionListener(this);
        }

        public void actionPerformed(ActionEvent aboj)
        {
            float num1 = Float.parseFloat(tobj1.getText());
            float num2 = Float.parseFloat(tobj2.getText());

            
        }
    }
}

class MainCalculator
{
    public static void main(String A[]) 
    {
        MarvellousCalc mobj = new MarvellousCalc("Calculator", 268, 450);
    }
}