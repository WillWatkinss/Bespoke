/* Course: CS 335
 * Author: William Watkins
 * Project: Exercise 3, Problem 1: Bespoke
 * Date: 9/13/2020
 * Purpose: Simulate GUI order of meal from a Chinese restaurant, user may order from radio button menu in a
 *      pop-up window, or the bespoke button will randomize the selections, then repeat the order in the
 *      original window when the pop-up is closed.
 **/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bespoke {

    public static void main(String[] args){

        // initialize GUI elements
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        JFrame f = new JFrame("Menu");
        JFrame f2 = new JFrame("Menu of a Menu");
        JLabel l = new JLabel("\n", SwingConstants.CENTER);
        JLabel l2 = new JLabel("\n" + "Select your preferences, exit when complete");
        JButton b = new JButton("Start Order");
        JButton bespoke = new JButton("Bespoke");
        JMenuBar m = new JMenuBar(); // menu bar

        // soup options
        JMenu soup = new JMenu("Soup"); // menu selection
        ButtonGroup sp = new ButtonGroup(); // menu group (only pick one)
        String soups[] = {"No ", "Miso ", "Egg Drop ", "Won Ton ", "Hot & Sour "};
        JRadioButtonMenuItem[] soupitems = new JRadioButtonMenuItem[soups.length];
        for (int i = 0; i < soups.length; i++){
            soupitems[i] = new JRadioButtonMenuItem(soups[i]);
            soup.add(soupitems[i]);
            sp.add(soupitems[i]);
        }

        // style options
        JMenu style = new JMenu("Style");
        ButtonGroup se = new ButtonGroup();
        String styles[] = {"Sweet & Sour  ", "Stir-Fried ", "Kung Pao ", "General Tso ", "Mongolian ",
            "Hunan ", "Sesame "};
        JRadioButtonMenuItem[] styleitems = new JRadioButtonMenuItem[styles.length];
        for (int i = 0; i < styles.length; i++){
            styleitems[i] = new JRadioButtonMenuItem(styles[i]);
            style.add(styleitems[i]);
            se.add(styleitems[i]);
        }

        // meat options
        JMenu meat = new JMenu("Meat");
        ButtonGroup mt = new ButtonGroup();
        String meats[] = {"Chicken ", "Steak ", "Pork ", "Shrimp "};
        JRadioButtonMenuItem[] meatitems = new JRadioButtonMenuItem[meats.length];
        for (int i = 0; i < meats.length; i++){
            meatitems[i] = new JRadioButtonMenuItem(meats[i]);
            meat.add(meatitems[i]);
            mt.add(meatitems[i]);
        }

        // vegetable options
        JMenu vegetable = new JMenu("Vegetable");
        ButtonGroup ve = new ButtonGroup();
        String vegetables[] = {"No vegetable ", "Broccoli ", "Carrot ", "Green Pepper ", "Snow Peas ", "Cashews (nuts) "};
        JRadioButtonMenuItem[] vegetableitems = new JRadioButtonMenuItem[vegetables.length];
        for (int i = 0; i < vegetables.length; i++){
            vegetableitems[i] = new JRadioButtonMenuItem(vegetables[i]);
            vegetable.add(vegetableitems[i]);
            ve.add(vegetableitems[i]);
        }

        // noodle options
        JMenu noodle = new JMenu("Noodle");
        ButtonGroup ne = new ButtonGroup();
        String noodles[] = {"No ", "Egg-and-Wheat ", "Wheat ", "Lo Mein "};
        JRadioButtonMenuItem[] noodleitems = new JRadioButtonMenuItem[noodles.length];
        for (int i = 0; i < noodles.length; i++){
            noodleitems[i] = new JRadioButtonMenuItem(noodles[i]);
            noodle.add(noodleitems[i]);
            ne.add(noodleitems[i]);
        }

        // rice options
        JMenu rice = new JMenu("Rice");
        ButtonGroup re = new ButtonGroup();
        String rices[] = {"No ", "Fried ", "White ", "Brown "};
        JRadioButtonMenuItem[] riceitems = new JRadioButtonMenuItem[rices.length];
        for (int i = 0; i < rices.length; i++){
            riceitems[i] = new JRadioButtonMenuItem(rices[i]);
            rice.add(riceitems[i]);
            re.add(riceitems[i]);
        }

        // add action listener to button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // start order
                // add items to menu
                m.add(soup);
                m.add(style);
                m.add(meat);
                m.add(vegetable);
                m.add(noodle);
                m.add(rice);
                p2.add(m); // add menu to panel
                p2.add(bespoke); // add bespoke button to panel
                p2.add(l2); // add label to panel
                f2.add(p2); // add panel to frame

                // randomizer button
                bespoke.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // randomize selections
                        soupitems[(int)(Math.random() * soups.length)].setSelected(true);
                        styleitems[(int)(Math.random() * styles.length)].setSelected(true);
                        meatitems[(int)(Math.random() * meats.length)].setSelected(true);
                        vegetableitems[(int)(Math.random() * vegetables.length)].setSelected(true);
                        noodleitems[(int)(Math.random() * noodles.length)].setSelected(true);
                        riceitems[(int)(Math.random() * rices.length)].setSelected(true);
                    }
                });

                // set size
                f2.setSize(500, 300);
                // set visible
                f2.setVisible(true);

                // when window is closed, show order on previous window
                f2.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        super.windowDeactivated(e);
                        String m1 = "", m2 = "", m3 = "", m4 = "", m5 = "", m6 = "";

                        for (int i = 0; i < soupitems.length; i++){
                            if (soupitems[i].isSelected()){
                                m1 = soups[i];
                            }
                        }
                        for (int i = 0; i < styleitems.length; i++){
                            if (styleitems[i].isSelected()){
                                m2 = styles[i];
                            }
                        }
                        for (int i = 0; i < meatitems.length; i++){
                            if (meatitems[i].isSelected()){
                                m3 = meats[i];
                            }
                        }
                        for (int i = 0; i < vegetableitems.length; i++){
                            if (vegetableitems[i].isSelected()){
                                m4 = vegetables[i];
                            }
                        }
                        for (int i = 0; i < noodleitems.length; i++){
                            if (noodleitems[i].isSelected()){
                                m5 = noodles[i];
                            }
                        }
                        for (int i = 0; i < riceitems.length; i++){
                            if (riceitems[i].isSelected()){
                                m6 = rices[i];
                            }
                        }

                        // Referenced used for new line using JLabel:
                        // https://stackoverflow.com/questions/1090098/newline-in-jlabel
                        l.setText("<html>" + "<br/>" + m1 + "soup" + "<br/>" + m2 + m3 +
                                "<br/>" + m4 + "<br/>" + m5 + "noodles" + "<br/>" + m6 + "rice" + "<br/><html/>");
                    }
                });
                // when closed, dispose of window
                f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        p.setLayout(new BorderLayout());
        p.add(b, BorderLayout.NORTH); // add button to panel
        p.add(l, BorderLayout.CENTER); // add label to panel
        f.add(p); // add panel to frame

        // set size
        f.setSize(500, 500);
        // set to visible
        f.setVisible(true);
        // when closed, exit program
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}