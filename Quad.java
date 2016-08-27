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
public class Quad extends JPanel {
    Dimension size = new Dimension(75, 25);

    JTextField a, b, d;
    double root1, root2, discriminant;
    public Quad() {
        GridBagLayout lay = new GridBagLayout();
        setLayout(lay);
        GridBagConstraints c = new GridBagConstraints();

        //c.insets = new Insets(10, 0, 0, 0);
        a = new JTextField("a^2");
        b = new JTextField("b");
        d = new JTextField("d");
        JLabel label1 = new JLabel("Enter coefficient of each variable of the quadratic equation:" + '\n' +
        "ax^2+bx+c=0");

        c.gridx = 1 ;
        c.gridy = 0;
        c.gridwidth =4;
        add(label1,c);
        JButton answer = new JButton("=");
        // x1.setSize(size);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth =1;
        //c.gridheight = 25;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(a, c);

        c.gridx = 2;
        c.gridy = 1;
        //  c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(b, c);

        c.gridx = 4;
        c.gridy = 1;
        add(d,c);



        c.gridx = 2;
        c.gridy = 6;
        add(answer, c);
        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               try{ int a1 = Integer.parseInt(a.getText()) ;
                int b1 = Integer.parseInt(b.getText()) ;
                int rhs1= Integer.parseInt(d.getText()) ;}

               catch(NumberFormatException p){
                   JOptionPane.showMessageDialog(null,"Please enter a number." + " " + p.getMessage());
                   return;
               }
                int a1 = Integer.parseInt(a.getText()) ;
                int b1 = Integer.parseInt(b.getText()) ;
                int rhs1= Integer.parseInt(d.getText()) ;
                discriminant = b1 * b1 - 4 * a1 * rhs1;

                root1 = (((-1 * b1) + (Math.sqrt(discriminant))) / (2 * a1));

                root2 = (((-1 * b1) - (Math.sqrt(discriminant))) / (2 * a1));
                if (discriminant > 0) {

                    String output = "The roots are " + " " + root1 + " " + "and" + " " + root2;

                    JOptionPane.showMessageDialog(null, output);

                }

                if (discriminant == 0) {

                    String output = "The root is " + root1;

                    JOptionPane.showMessageDialog(null, output);

                }

                if (discriminant < 0) {

                    String output = "The equation has no root";

                    JOptionPane.showMessageDialog(null, output);

                }



            }
        });






        }}