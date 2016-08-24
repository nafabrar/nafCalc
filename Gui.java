/**
 * Created by Thenextbestthing on 7/17/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;
import Jama.Matrix;
import java.util.Scanner;


public class Gui extends JFrame implements ActionListener,KeyListener {
    private JTextField JTresult;
    public static String num1;
    public static String num;
    public static String sanswer;
    public static int operator = 99;
    private JPanel content;
    private static final int WIDTH = 320;
    private static final int HEIGHT = 480;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private double answer;
//x-cord,y-cord,width,height
    private int [][] numconstraints = new int[][]{
        {0,7,2,1},
        {0,6,1,1},
        {1,6,1,1},
        {2,6,1,1},
        {0,5,1,1},
        {1,5,1,1},
        {2,5,1,1},
        {0,4,1,1},
        {1,4,1,1},
        {2,4,1,1},
};
    private int [][] opconstraints = new int[][]{
            {2,7,1,1},
            {3,6,1,2},
            {3,5,1,1},
            {3,4,1,1},
            {3,3,1,1},//5 ie +
            {2,3,1,1},
            {1,3,1,1},
            {3,2,1,1},
            {0,3,1,1},
            {1,2,1,1},
            {0,2,1,1},
            {2,2,1,1}
//        final String[] op = {"=", "/", "x", "-", "+", "ANS", "HIST","AC","new","o","w"};


    };



    public Gui () {
        super("nafCalc");
        num1 ="";
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        layout = new GridBagLayout();
        layout.columnWidths = new int[] {80,80,80,80};
        layout.rowHeights = new int[] {80,80,80,80,80,80,80,80};
        setLayout(layout);
        gbc = new GridBagConstraints();

        Dimension size = new Dimension(75, 25);
        final JButton[] numberlist = new JButton[10];
        final String[] names = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < numberlist.length; i++) {
            numberlist[i] = new JButton(names[i]);
            gbc.gridx = numconstraints[i][0];
            gbc.gridy = numconstraints[i][1];
            gbc.gridwidth = numconstraints[i][2];
            gbc.gridheight = numconstraints[i][3];
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(2,2,2,2);
            add(numberlist[i],gbc);


            numberlist[i].setPreferredSize(size);
        }


        JButton[] Operation = new JButton[12];
        final String[] op = {"=", "/", "x", "-", "+", ".", "HIST","AC","C","o","w","l"};
        for (int i = 0; i < op.length; i++) {
            Operation[i] = new JButton(op[i]);
            gbc.gridx = opconstraints[i][0];
            gbc.gridy = opconstraints[i][1];
            gbc.gridwidth = opconstraints[i][2];
            gbc.gridheight = opconstraints[i][3];
            gbc.insets = new Insets(2,2,2,2);
            add(Operation[i],gbc);


        }

        JTresult = new JTextField();
        JTresult.setBorder(BorderFactory.createLineBorder(Color.black));
        JTresult.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        add(JTresult,gbc);


/// THIS IS FOR DIFFERNT MODES


        JRadioButton mode = new JRadioButton("xy equation");
        mode.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.gridx = 0;
        gbc.gridy = 1;
        //gbc.gridheight = 1;
        //gbc.gridwidth = 1;
        add(mode,gbc);
        mode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame();
                JButton but = new JButton();
                frame.getContentPane().add(BorderLayout.EAST,but);
                frame.setSize(300,300);
                frame.setVisible(true);
                
//                Scanner sc = new Scanner(System.in);
//                int x1 = sc.nextInt();
//                int y1 = sc.nextInt();
//                int rhs1= sc.nextInt();
//                int x2 =sc.nextInt();
//                int y2 = sc.nextInt();
//                int rhs2= sc.nextInt();
//                double[][] lhsArray = {{x1, y1,}, {x2, y2,}};
//                double[] rhsArray = {rhs1, rhs2,};
//                //Creating Matrix Objects with arrays
//                Matrix lhs = new Matrix(lhsArray);
//                Matrix rhs = new Matrix(rhsArray, 2);
//                //Calculate Solved Matrix
//                Matrix ans = lhs.solve(rhs);
//                //Printing Answers
//                System.out.println("x = " + Math.round(ans.get(0, 0)));
//                System.out.println("y = " + Math.round(ans.get(1, 0)));
            }
        });

        JRadioButton mode2 = new JRadioButton("xyz equation");
        mode.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.gridx = 2;
        gbc.gridy = 1;
        //gbc.gridheight = 1;
        //gbc.gridwidth = 1;
        add(mode2,gbc);

       // JRadioButton mode3= new JRadioButton("2 variable equation solver");


        //Addding Action Listener for each button

        numberlist[1].setFocusable(false);
        numberlist[2].setFocusable(false);
        numberlist[3].setFocusable(false);
        numberlist[4].setFocusable(false);
        numberlist[5].setFocusable(false);
        numberlist[6].setFocusable(false);
        numberlist[7].setFocusable(false);
        numberlist[8].setFocusable(false);
        numberlist[9].setFocusable(false);
        numberlist[0].setFocusable(false);

        numberlist[1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "1");
                    JTresult.setText("1");
                    num1 = "1";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("1"));

                    num1 = num1.concat("1");

                    System.out.println("num is now " + num1);

                    } else{ JTresult.setText("1");
                    num1 = "1";

                }


                }

        });

        numberlist[2].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            if (num1 == "") {
                                System.out.printf("num1 is %s%n", "2");
                                JTresult.setText("2");
                                num1 = "2";
                            } else if(!(sanswer == num1))

                            {
                                JTresult.setText(num1.concat("2"));

                                num1 = num1.concat("2");

                                System.out.println("num is now " + num1);

                            } else{ JTresult.setText("2");
                                num1 = "2";

                            }
                        }
                    });




        numberlist[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "3");
                    JTresult.setText("3");
                    num1 = "3";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("3"));

                    num1 = num1.concat("3");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("3");
                    num1 = "3";

                }
            }
        });
        numberlist[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "4");
                    JTresult.setText("4");
                    num1 = "4";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("4"));

                    num1 = num1.concat("4");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("4");
                    num1 = "4";

                }
            }
        });
        numberlist[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "5");
                    JTresult.setText("5");
                    num1 = "5";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("5"));

                    num1 = num1.concat("5");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("5");
                    num1 = "5";

                }
            }
        });
        numberlist[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "6");
                    JTresult.setText("6");
                    num1 = "6";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("6"));

                    num1 = num1.concat("6");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("6");
                    num1 = "6";

                }
            }
        });
        numberlist[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "7");
                    JTresult.setText("7");
                    num1 = "7";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("7"));

                    num1 = num1.concat("7");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("7");
                    num1 = "7";

                }
            }
        });
        numberlist[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "8");
                    JTresult.setText("8");
                    num1 = "8";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("8"));

                    num1 = num1.concat("8");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("8");
                    num1 = "8";

                }
            }
        });
        numberlist[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "") {
                    System.out.printf("num1 is %s%n", "9");
                    JTresult.setText("9");
                    num1 = "9";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("9"));

                    num1 = num1.concat("9");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("9");
                    num1 = "9";

                }
            }
        });

        numberlist[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



//                    if (num1 == "") {
//                       // JOptionPane.showMessageDialog(null,"Enter a number please!");
//
//                    } else
                     if(!(sanswer == num1))

                    {
                        JTresult.setText(num1.concat("0"));

                        num1 = num1.concat("0");

                        System.out.println("num is now " + num1);

                    } else{ JTresult.setText("0");
                         num1="0";
                        //JOptionPane.showMessageDialog(null,"Enter a number please!");

                    }
            }

        });

//        final String[] op = {"=", "/", "x", "-", "+", "ANS", "HIST","AC","C","o","w","l"};

//ADDITION
        Operation[0].setFocusable(false);
        Operation[1].setFocusable(false);
        Operation[2].setFocusable(false);
        Operation[3].setFocusable(false);
        Operation[4].setFocusable(false);
        Operation[5].setFocusable(false);
        Operation[6].setFocusable(false);
        Operation[7].setFocusable(false);
        Operation[8].setFocusable(false);
        Operation[9].setFocusable(false);
        Operation[10].setFocusable(false);
        Operation[11].setFocusable(false);

        Operation[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "") {
                    System.out.println("Enter first number" );

                } else
                    if (!(num1 == "0")) {
                        num = num1;
                        JTresult.setText("");
                        num1 = "";
                        operator = 1;
                        System.out.println("num is now " + num);}

                else {
                            JOptionPane.showMessageDialog(null, "You cannot divide by 0");
                        }

                    }
                }
            );
        Operation[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "") {
                    System.out.println("Enter first number" );

                } else {
                    num = num1;
                    JTresult.setText("");
                    num1 = "";
                    operator = 2;



                    System.out.println("num is now " + num );
                    //adding Op action listener


                }}});
        //Subtraction

        Operation[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "") {
                    System.out.println("Enter first number" );

                } else {
                    num = num1;
                    JTresult.setText("");
                    num1 = "";
                    operator = 3;



                    System.out.println("num is now " + num );
                    //adding Op action listener


                }}});
        Operation[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "") {
                    System.out.println("Enter first number" );

                } else {
                    num = num1;
                    JTresult.setText("");
                    num1 = "";
                    operator = 4;



                    System.out.println("num is now " + num );
                    //adding Op action listener


                }}});
//Decimal button
        Operation[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JTresult.getText().contains(".") & !(sanswer == num1)) {
                    return;
                }
else
                if (num1 == "") {
                    System.out.printf("num1 is %s%n", ".");
                    JTresult.setText(".");
                    num1 = ".";
                } else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("."));

                    num1 = num1.concat(".");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText(".");
                    num1 = ".";




                }}});


//HIST
        Operation[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTresult.setText(sanswer);
                num1= sanswer;}}
        );





//AC Button done!
        Operation[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = "" ;

            num = "";
            operator = 99;
            JTresult.setText("");
        }});
//C button
        Operation[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!num1.isEmpty())
                num1 =num1.substring(0, num1.length() - 1);
                JTresult.setText(num1);
            }});




//Equal button
                Operation[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (operator == 99) {
                    System.out.println("Enter numbers");
                } else if (operator == 4) {
                    double ans = Double.parseDouble(num) + Double.parseDouble(num1);
//                    String ans1 = String.format("%.02f", ans);

                    sanswer = String.format("%.02f", ans);


                    System.out.println("num is now " + ans);
                JTresult.setText(((sanswer)));
                    num1 = sanswer ;
                    operator = 99 ;


                }else if (operator == 3) {
                        double ans = Double.parseDouble(num)-Double.parseDouble(num1);
                        sanswer = Double.toString(ans);


                        System.out.println("num is now " + ans);
                        JTresult.setText(((sanswer)));
                        num1 = sanswer ;
                        operator = 99 ;


                    }
                else if (operator == 1 ) {
                    try {
                        double ans = Double.parseDouble(num) / Double.parseDouble(num1);
                        sanswer = String.format("%.02f", ans);


                        System.out.println("num is now " + ans);
                        JTresult.setText(((sanswer)));
                        num1 = sanswer;
                        operator = 99;
                    } catch (ArithmeticException x) {
                        x.getMessage();
                        JOptionPane.showMessageDialog(null,x.getMessage());
                    }
                }
                else if (operator == 2) {
                    double ans = Double.parseDouble(num)*Double.parseDouble(num1);
                    sanswer = String.format("%.02f", ans);

                    System.out.println("num is now " + ans);
                    JTresult.setText(((sanswer)));
                    num1 = sanswer ;
                    operator = 99 ;



            }}});

        JTresult.addKeyListener(this);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

            };


    @Override
    public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_1){
                { if (num1 == "") {
                    System.out.printf("num1 is %s%n", "1");
                    JTresult.setText("1");
                    num1 = "1";
                }
                else if(!(sanswer == num1))

                {
                    JTresult.setText(num1.concat("1"));

                    num1 = num1.concat("1");

                    System.out.println("num is now " + num1);

                } else{ JTresult.setText("1");
                    num1 = "1";

                }}}
else
        if (e.getKeyCode() == KeyEvent.VK_2){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "2");
                JTresult.setText("2");
                num1 = "2";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("2"));

                num1 = num1.concat("2");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("2");
                num1 = "2";

            }}}
        else

        if (e.getKeyCode() == KeyEvent.VK_3){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "3");
                JTresult.setText("3");
                num1 = "3";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("3"));

                num1 = num1.concat("3");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("3");
                num1 = "3";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_4){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "4");
                JTresult.setText("4");
                num1 = "4";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("4"));

                num1 = num1.concat("4");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("4");
                num1 = "4";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_5){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "5");
                JTresult.setText("5");
                num1 = "5";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("5"));

                num1 = num1.concat("5");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("5");
                num1 = "5";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_6){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "6");
                JTresult.setText("6");
                num1 = "6";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("6"));

                num1 = num1.concat("6");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("6");
                num1 = "6";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_7){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "7");
                JTresult.setText("7");
                num1 = "7";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("7"));

                num1 = num1.concat("7");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("7");
                num1 = "7";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_8){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "8");
                JTresult.setText("8");
                num1 = "8";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("8"));

                num1 = num1.concat("8");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("8");
                num1 = "8";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_9){
            { if (num1 == "") {
                System.out.printf("num1 is %s%n", "9");
                JTresult.setText("9");
                num1 = "9";
            }
            else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("9"));

                num1 = num1.concat("9");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("9");
                num1 = "9";

            }}}
        if (e.getKeyCode() == KeyEvent.VK_0){


            if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("0"));

                num1 = num1.concat("0");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText("0");
                num1="0";
                //JOptionPane.showMessageDialog(null,"Enter a number please!");

            }


    }
        if(e.getKeyCode() == KeyEvent.VK_PERIOD){
            if(JTresult.getText().contains(".") & !(sanswer == num1)) {
                return;
            }
            else
            if (num1 == "") {
                System.out.printf("num1 is %s%n", ".");
                JTresult.setText(".");
                num1 = ".";
            } else if(!(sanswer == num1))

            {
                JTresult.setText(num1.concat("."));

                num1 = num1.concat(".");

                System.out.println("num is now " + num1);

            } else{ JTresult.setText(".");
                num1 = ".";




            }
        }

//OPERATIONS
//        final String[] op = {"=", "/", "x", "-", "+", ".", "HIST","AC","C","o","w","l"};

//Division
        if (e.getKeyCode() == KeyEvent.VK_D){
            if (num1 == "") {
                System.out.println("Enter first number" );

            } else
            if (!(num1 == "0")) {
                num = num1;
                JTresult.setText("");
                num1 = "";
                operator = 1;
                System.out.println("num is now " + num);}

            else {
                JOptionPane.showMessageDialog(null, "You cannot divide by 0");
            }}
        //    SUBTRACTION
        if (e.getKeyCode() == KeyEvent.VK_S){
            if (num1 == "") {
                System.out.println("Enter first number" );

            } else {
                num = num1;
                JTresult.setText("");
                num1 = "";
                operator = 3;



                System.out.println("num is now " + num );
                //adding Op action listener


            }}
//Multyply
        if (e.getKeyCode() == KeyEvent.VK_M){
            if (num1 == "") {
                System.out.println("Enter first number" );

            } else {
                num = num1;
                JTresult.setText("");
                num1 = "";
                operator = 2;



                System.out.println("num is now " + num );
                //adding Op action listener


            }}
  //Addition
        if (e.getKeyCode() == KeyEvent.VK_A){
            if (num1 == "") {
                System.out.println("Enter first number" );

            } else {
                num = num1;
                JTresult.setText("");
                num1 = "";
                operator = 4;



                System.out.println("num is now " + num );
                //adding Op action listener


            }}

        //C Button
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            if (!num1.isEmpty())
                num1 =num1.substring(0, num1.length() - 1);
            JTresult.setText(num1);
        }


        //AC Button
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            num1 = "" ;

            num = "";
            operator = 99;
            JTresult.setText("");
        }

        if (e.getKeyCode() == KeyEvent.VK_H){
            JTresult.setText(sanswer);
            num1= sanswer;}






//EQUALS
        if (e.getKeyCode() == KeyEvent.VK_EQUALS){
            if (operator == 99) {
                System.out.println("Enter numbers");
            } else if (operator == 4) {
                double ans = Double.parseDouble(num) + Double.parseDouble(num1);
//                    String ans1 = String.format("%.02f", ans);

                sanswer = String.format("%.02f", ans);


                System.out.println("num is now " + ans);
                JTresult.setText(((sanswer)));
                num1 = sanswer ;
                operator = 99 ;


            }else if (operator == 3) {
                double ans = Double.parseDouble(num)-Double.parseDouble(num1);
                sanswer = Double.toString(ans);


                System.out.println("num is now " + ans);
                JTresult.setText(((sanswer)));
                num1 = sanswer ;
                operator = 99 ;


            }
            else if (operator == 1 ) {
                try {
                    double ans = Double.parseDouble(num) / Double.parseDouble(num1);
                    sanswer = String.format("%.02f", ans);


                    System.out.println("num is now " + ans);
                    JTresult.setText(((sanswer)));
                    num1 = sanswer;
                    operator = 99;
                } catch (ArithmeticException x) {
                    x.getMessage();
                    JOptionPane.showMessageDialog(null,x.getMessage());
                }
            }
            else if (operator == 2) {
                double ans = Double.parseDouble(num)*Double.parseDouble(num1);
                sanswer = String.format("%.02f", ans);

                System.out.println("num is now " + ans);
                JTresult.setText(((sanswer)));
                num1 = sanswer ;
                operator = 99 ;



            }

        }



    };



    @Override
    public void keyReleased(KeyEvent e) {

    }
}

