/**
 * @description a test GUI that displays five buttons: North, South, East, West and Center.
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class NSEWC {

    private JFrame f = new JFrame("NSEWC");
    private JPanel pNorth = new JPanel();
    private JPanel pSouth = new JPanel();
    private JPanel pEast = new JPanel();
    private JPanel pWest = new JPanel();
    private JPanel pCenter = new JPanel();

    private JButton bNorth = new JButton("North");
    private JButton bSouth = new JButton("South");
    private JButton bEast = new JButton("East");
    private JButton bWest = new JButton("West");
    private JButton bCenter = new JButton("Center");

    public ListenNSEWC n = new ListenNSEWC();

    /**
     * @description
     * This is the constructor for NSEWC.
     */
    public NSEWC() {
        pNorth.add(bNorth);
        pSouth.add(bSouth);
        pEast.add(bEast);
        pWest.add(bWest);
        pCenter.add(bCenter);

        bNorth.addActionListener(n);
        bSouth.addActionListener(n);
        bEast.addActionListener(n);
        bWest.addActionListener(n);
        bCenter.addActionListener(n);

        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(pNorth, BorderLayout.NORTH);
        f.getContentPane().add(pSouth, BorderLayout.SOUTH);
        f.getContentPane().add(pEast, BorderLayout.EAST);
        f.getContentPane().add(pWest, BorderLayout.WEST);
        f.getContentPane().add(pCenter, BorderLayout.CENTER);
    }

    /**
     * @description
     * This method displays the simple NSEWC GUI window.
     */
    public void launchNSEWC() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    /**
     * @description 
     * This is a class that will listen for the North, South, East, West, and Center Buttons
     * to be pressed. It will cause a simple message box to be displayed when an Action is
     * Detected.
     */
    public class ListenNSEWC implements ActionListener {
        public void  actionPerformed(ActionEvent e) {
            String showText = e.getActionCommand();
            JOptionPane.showMessageDialog(f,new JLabel("You pressed " + showText + "!"));
        }
    }

    /**
     * @description
     * This is the starting point of this program.
     */
    public static void main(String[] args) {
        NSEWC nsew = new NSEWC();
        nsew.launchNSEWC();
    }
}

