/**
 * Created by Thenextbestthing on 7/17/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame {
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
        num1 ="empty";
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
        final String[] op = {"=", "/", "x", "-", "+", "ANS", "HIST","AC","new","o","w","l"};
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
        JRadioButton mode = new JRadioButton("Equation solver");
        mode.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.gridx = 0;
        gbc.gridy = 1;
        //gbc.gridheight = 1;
        //gbc.gridwidth = 1;
        add(mode,gbc);




        //Addding Action Listener for each button


            numberlist[1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "1");
                    JTresult.setText("1");
                    num1 = "1";
                } else {
                    JTresult.setText(num1.concat("1"));

                    num1 = num1.concat("1");

                    System.out.println("num is now " + num1);

                    }
                }
            });
                    numberlist[2].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            if (num1 == "empty") {
                                System.out.printf("num1 is %s%n", "2");
                                JTresult.setText("2");
                                num1 = "2";
                            } else {
                                JTresult.setText(num1.concat("2"));

                                num1 = num1.concat("2");
                                System.out.println("num is now " + num1);


                            }
                        }
                    });




        numberlist[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "3");
                    JTresult.setText("3");
                    num1 = "3";
                } else {
                    JTresult.setText(num1.concat("3"));

                    num1 = num1.concat("3");
                    System.out.println("num is now " + num1);


                }
            }
        });
        numberlist[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "4");
                    JTresult.setText("4");
                    num1 = "4";
                } else {
                    JTresult.setText(num1.concat("4"));

                    num1 = num1.concat("4");
                    System.out.println("num is now " + num1);


                }
            }
        });
        numberlist[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "5");
                    JTresult.setText("5");
                    num1 = "5";
                } else {
                    JTresult.setText(num1.concat("5"));

                    num1 = num1.concat("5");
                    System.out.println("num is now " + num1);


                }
            }
        });
        numberlist[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "6");
                    JTresult.setText("6");
                    num1 = "6";
                } else {
                    JTresult.setText(num1.concat("6"));

                    num1 = num1.concat("6");
                    System.out.println("num is now " + num1);


                }
            }
        });
        numberlist[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "7");
                    JTresult.setText("7");
                    num1 = "7";
                } else {
                    JTresult.setText(num1.concat("7"));

                    num1 = num1.concat("7");
                    System.out.println("num is now " + num1);


                }
            }
        });
        numberlist[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "8");
                    JTresult.setText("8");
                    num1 = "8";
                } else {
                    JTresult.setText(num1.concat("8"));

                    num1 = num1.concat("8");
                    System.out.println("num is now " + num1);


                }
            }
        });
        numberlist[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                    System.out.printf("num1 is %s%n", "9");
                    JTresult.setText("9");
                    num1 = "9";
                } else {
                    JTresult.setText(num1.concat("9"));

                    num1 = num1.concat("9");
                    System.out.println("num is now " + num1.concat("9"));


                }
            }
        });

        numberlist[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (num1 == "empty") {
                  JOptionPane.showMessageDialog(null,"Enter a number please!");
                } else {
                    JTresult.setText(num1.concat("0"));

                    num1 = num1.concat("0");
                    System.out.println("num is now " + num1.concat("0"));


                }
            }
        });
//        final String[] op = {"=", "/", "x", "-", "+", "ANS", "HIST","AC","new","o","w","l"};

//ADDITION
        Operation[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "empty") {
                    System.out.println("Enter first number" );

                } else {
                    num = num1;
                    JTresult.setText("");
                    num1 = "empty";
                    operator = 4;



                    System.out.println("num is now " + num );
                    //adding Op action listener


                }}});
        //SUBTRAction

        Operation[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "empty") {
                    System.out.println("Enter first number" );

                } else {
                    num = num1;
                    JTresult.setText("");
                    num1 = "empty";
                    operator = 3;



                    System.out.println("num is now " + num );
                    //adding Op action listener


                }}});
        Operation[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num1 == "empty") {
                    System.out.println("Enter first number" );

                } else {
                    num = num1;
                    JTresult.setText("");
                    num1 = "empty";
                    operator = 3;



                    System.out.println("num is now " + num );
                    //adding Op action listener


                }}});




        Operation[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (operator == 99) {
                    System.out.println("Enter numbers");
                } else if (operator == 4) {
                    int ans = Integer.parseInt(num) + Integer.parseInt(num1);
                     sanswer = Integer.toString(ans);


                    System.out.println("num is now " + ans);
                JTresult.setText(((sanswer)));
                    num1 = sanswer ;
                    operator = 99 ;

                }else if (operator == 3) {
                        int ans = Integer.parseInt(num)-Integer.parseInt(num1);
                        sanswer = Integer.toString(ans);


                        System.out.println("num is now " + ans);
                        JTresult.setText(((sanswer)));
                        num1 = sanswer ;
                        operator = 99 ;


                    }



        //adding Op action listener


    }});}}

