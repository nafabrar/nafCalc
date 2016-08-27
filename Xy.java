import Jama.Matrix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import Jama.Matrix;
 /**
 * Created by Thenextbestthing on 8/24/16.
 */
public class Xy extends JPanel {
    Dimension size = new Dimension(75, 25);

    JTextField x1,y1,x2,y2,lhs,rhs;
    public Xy() {
        GridBagLayout lay = new GridBagLayout();
        setLayout(lay);
        GridBagConstraints c = new GridBagConstraints();
        //c.insets = new Insets(10, 0, 0, 0);
        x1 = new JTextField("x1");
        y1 = new JTextField("y1");
        x2 = new JTextField("x2");
        y2 = new JTextField("y2");
        lhs = new JTextField("RHS(no variable coeff)");
        rhs = new JTextField("RHS(no variable coeff)");
        JButton answer = new JButton("=");
        JButton help = new JButton("Help!");
        JLabel eq1 = new JLabel("Equation 1:");
        c.gridx = 0;
        c.gridy = 0;
        add(eq1,c);

        JLabel eq2 = new JLabel("Equation 2:");
        c.gridx =0;
        c.gridy =2;
        add(eq2,c);

        // x1.setSize(size);
        c.gridx = 1;
        c.gridy = 0;
        //c.gridwidth = 75   ;
        //c.gridheight = 25;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(x1, c);

        c.gridx = 2;
        c.gridy = 0;
        //  c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(y1, c);

        c.gridx = 1;
        c.gridy = 2;
        add(x2,c);

        c.gridx = 2;
        c.gridy = 2;
        add(y2,c);

        c.gridx = 4;
        c.gridy = 0;
        add(lhs,c);

        c.gridx = 4;
        c.gridy = 2;
        add(rhs,c);

        c.gridx = 4;
        c.gridy = 5;
        add(help,c);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Please enter only the coefficients of the varibale in the text fields:eg" + '\n' +
                        "Equation 1: 2x + y = 7\n" +
                        "Equation 2: 3x - y = 8\n");
            }
        });



        c.gridx = 2;
        c.gridy = 5;
        add(answer, c);
        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
try{
                Double a = Double.parseDouble(x1.getText()) ;
                Double b = Double.parseDouble(y1.getText()) ;
                Double rhs1= Double.parseDouble(lhs.getText()) ;
                Double a1 =Double.parseDouble(x2.getText()) ;
                Double b1 = Double.parseDouble(y2.getText()) ;
                Double rhs2= Double.parseDouble(rhs.getText()) ;}
catch (NumberFormatException z){
    JOptionPane.showMessageDialog(null,"Please enter a number." + " " + z.getMessage());
    return;
}

                Double a = Double.parseDouble(x1.getText()) ;
                Double b = Double.parseDouble(y1.getText()) ;
                Double rhs1= Double.parseDouble(lhs.getText()) ;
                Double a1 =Double.parseDouble(x2.getText()) ;
                Double b1 = Double.parseDouble(y2.getText()) ;
                Double rhs2= Double.parseDouble(rhs.getText()) ;
                double[][] lhsArray = {{a, b,}, {a1, b1}};
                double[] rhsArray = {rhs1, rhs2};
                //Creating Matrix Objects with arrays
                Matrix lhs = new Matrix(lhsArray);
                Matrix rhs = new Matrix(rhsArray, 2);
                //Calculate Solved Matrix
                Matrix ans = lhs.solve(rhs);
                //Printing Answers



                JOptionPane.showMessageDialog(null, "Answer is" + '\n'+
                "x = " + (ans.get(0, 0)) + '\n'
                + "y =" + (ans.get(1, 0)));



            }
        });






    }}