/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;

/**
 *
 * @author MarcDominic
 */
public class MapTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map wew = new Map(40, 15);
        wew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //wew.setSize(300, 300);
        wew.setVisible(true);
    }
    
}
