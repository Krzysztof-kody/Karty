package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener {

    Lacznik L1;
    ImageIcon wall = new ImageIcon("src/com/company/table.jpg");
    public Panel(Lacznik L){
        L1 = L;
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


        //g.fillRect(0,0,640, 480);
        g.drawImage(wall.getImage(),0,0,640,480, null);
        for(Karta k: L1.karty){
            g.drawImage(k.getGraphics(),k.x, k.y, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean loose = false;
        if(L1.wait==false) {
            try {
                if (L1.watek.szufluj != -2)
                    L1.shuffle();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            if (L1.watek.szufluj == -2) {
                for (Karta k : L1.karty) {
                    if (e.getY() >= k.y && e.getY() <= k.y + 200)
                        if (e.getX() >= k.x && e.getX() <= k.x + 100) {
                            if (k.wartosc == 1) {
                                System.out.println("LVL " + (15 - L1.watek.sleep + 1) + "_" + (L1.watek.rots - 4));
                                L1.watek.rots++;
                                if (L1.watek.rots > 15) {
                                    L1.watek.rots = 5;
                                    L1.watek.sleep--;
                                }
                            } else {
                                L1.watek.sleep = 15;
                                L1.watek.rots = 5;
                                loose = true;
                                for (Karta kk : L1.karty) {
                                    kk.strona = 1;
                                    repaint();
                                }
                                System.out.println("nope :(");
                                System.out.println("---->   obejrzyj reklamę by kontynuować   <----");
                            }
                            if (k.strona == 1 && loose == false) k.strona = 0;
                            else
                                k.strona = 1;
                            loose = false;
                        }
                }
                L1.watek.szufluj = -1;
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
