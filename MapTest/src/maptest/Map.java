/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author MarcDominic
 */
public class Map extends JFrame{
    private JLabel[][] labels;
    private JLabel activeLabel;
    private int x=0, y=0;
    private final int xMAX, yMAX;
    
    public Map(int x, int y){
        super("Map");
        setLayout(null);
        xMAX = x;
        yMAX = y;
        labels = new JLabel[xMAX][yMAX];
        int i, j;
        for(i=0; i<xMAX; i++)
            for(j=0; j<yMAX; j++){
                labels[i][j] = new JLabel();
                labels[i][j].setSize(20, 20);
                labels[i][j].setForeground(Color.red);
                labels[i][j].setLocation(0 + (i*20), 0 + (j*20));
                labels[i][j].setText("#");
                add(labels[i][j]);
            }
        
        KeyShit k = new KeyShit();
        addKeyListener(k);
        activeLabel = labels[this.x][this.y];
        activeLabel.setForeground(Color.blue);
        pack();
    }
    
    public void WalaLang(){
        ;
    }
    
    private class KeyShit implements KeyListener {

        public void keyTyped(KeyEvent e) {
            WalaLang();
        }
        
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) { 
                case KeyEvent.VK_UP:
                    if(y!=0){
                        y--;
                        activeLabel.setForeground(Color.red);
                        activeLabel = labels[x][y];
                        activeLabel.setForeground(Color.blue);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "LOL nope");
                    break;
                case KeyEvent.VK_DOWN:
                    if(y!=yMAX-1){
                        y++;
                        activeLabel.setForeground(Color.red);
                        activeLabel = labels[x][y];
                        activeLabel.setForeground(Color.blue);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "LOL nope");
                    break;
                case KeyEvent.VK_LEFT:
                    if(x!=0){
                        x--;
                        activeLabel.setForeground(Color.red);
                        activeLabel = labels[x][y];
                        activeLabel.setForeground(Color.blue);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "LOL nope");
                    break;
                case KeyEvent.VK_RIGHT :
                    if(x!=xMAX-1){
                        x++;
                        activeLabel.setForeground(Color.red);
                        activeLabel = labels[x][y];
                        activeLabel.setForeground(Color.blue);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "LOL nope");
                    break;
            }
        }

        public void keyReleased(KeyEvent e) {
            WalaLang();
        }
        
    }
}
