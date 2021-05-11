package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lacznik {
    public JFrame Okno = new JFrame();
    public Panel Stol = new Panel(this);
    ArrayList<Karta> karty = new ArrayList<>();
    public Watek watek = new Watek(this);
    public boolean wait = false;

    public Lacznik(){
        karty.add(new Karta(0));
        karty.add(new Karta(1));
        karty.add(new Karta(0));

        karty.get(0).setPosition(160,140);
        karty.get(1).setPosition(110+160,140);
        karty.get(2).setPosition(220+160,140);

        Stol.setPreferredSize(new Dimension(640, 480));
        Okno.add(Stol);
        Okno.pack();
        Okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Okno.setVisible(true);

        watek.start();
    }
    public void shuffle() throws InterruptedException {
        Karta c;
        for(int i = 0; i< 2; i++){
            this.watek.szufluj = i;

        }
    }
}
