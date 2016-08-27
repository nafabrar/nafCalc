//import Jama.Matrix;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import Jama.Matrix;
// /**To be added later
// * Created by Thenextbestthing on 8/24/16.
// */
//public class Xyz extends JPanel {
//    Dimension size = new Dimension(75, 25);
//
//    JTextField x1,y1,x2,y2,lhs,rhs;
//    public Xyz() {
//        GridBagLayout lay = new GridBagLayout();
//        setLayout(lay);
//        GridBagConstraints c = new GridBagConstraints();
//
//        //c.insets = new Insets(10, 0, 0, 0);
//        x1 = new JTextField("x1");
//        y1 = new JTextField("y1");
//
//        x2 = new JTextField("x2");
//        y2 = new JTextField("y2");
//
//        lhs = new JTextField("lhs");
//        rhs = new JTextField("rhs");
//        JButton answer = new JButton("=");
//        // x1.setSize(size);
//        c.gridx = 1;
//        c.gridy = 0;
//        //c.gridwidth = 75   ;
//        //c.gridheight = 25;
//        c.weightx = 1;
//        c.fill = GridBagConstraints.BOTH;
//        add(x1, c);
//
//        c.gridx = 2;
//        c.gridy = 0;
//        //  c.weightx = 1;
//        c.fill = GridBagConstraints.BOTH;
//        add(y1, c);
//
//        c.gridx = 1;
//        c.gridy = 2;
//        add(x2,c);
//
//        c.gridx = 2;
//        c.gridy = 2;
//        add(y2,c);
//
//        c.gridx = 4;
//        c.gridy = 0;
//        add(lhs,c);
//
//        c.gridx = 4;
//        c.gridy = 2;
//        add(rhs,c);
//
//
//        c.gridx = 2;
//        c.gridy = 5;
//        add(answer, c);
//        answer.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                int a = Integer.parseInt(x1.getText()) ;
//                int b = Integer.parseInt(y1.getText()) ;
//                int rhs1= Integer.parseInt(lhs.getText()) ;
//                int a1 =Integer.parseInt(x2.getText()) ;
//                int b1 = Integer.parseInt(y2.getText()) ;
//                int rhs2= Integer.parseInt(rhs.getText()) ;
//                double[][] lhsArray = {{a, b,}, {a1, b1}};
//                double[] rhsArray = {rhs1, rhs2};
//                //Creating Matrix Objects with arrays
//                Matrix lhs = new Matrix(lhsArray);
//                Matrix rhs = new Matrix(rhsArray, 2);
//                //Calculate Solved Matrix
//                Matrix ans = lhs.solve(rhs);
//                //Printing Answers
//                System.out.println("x = " + Math.round(ans.get(0, 0)));
//                System.out.println("y = " + Math.round(ans.get(1, 0)));
//
//            }
//        });
//
//
//
////                Scanner sc = new Scanner(System.in);
////                int x1 = sc.nextInt();
////                int y1 = sc.nextInt();
////                int rhs1= sc.nextInt();
////                int x2 =sc.nextInt();
////                int y2 = sc.nextInt();
////                int rhs2= sc.nextInt();
////                double[][] lhsArray = {{x1, y1,}, {x2, y2,}};
////                double[] rhsArray = {rhs1, rhs2,};
////                //Creating Matrix Objects with arrays
////                Matrix lhs = new Matrix(lhsArray);
////                Matrix rhs = new Matrix(rhsArray, 2);
////                //Calculate Solved Matrix
////                Matrix ans = lhs.solve(rhs);
////                //Printing Answers
////                System.out.println("x = " + Math.round(ans.get(0, 0)));
////                System.out.println("y = " + Math.round(ans.get(1, 0)));
//
//
//    }}