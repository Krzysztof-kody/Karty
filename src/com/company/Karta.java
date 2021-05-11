package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.AttributedCharacterIterator;

public class Karta {
    public int wartosc;
    ImageIcon back = new ImageIcon("src/com/company/cardB.png");
    public int x;
    public int y;
    int strona;

    public Karta(int wartosc){
        this.wartosc = wartosc;
        strona = 1;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Image getGraphics(){
        BufferedImage bufferedImage = new BufferedImage(100, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        if(strona == 0){
            //g2d.setColor(Color.green);
            return back.getImage();}
        else {
            if (wartosc == 0) {
                g2d.setColor(Color.white);

            } else {
                g2d.setColor(Color.orange);
            }
            g2d.fillRect(0,0,100,200);
        }
        return bufferedImage;
    }
    public void setSide(int side){

        strona = side;
    }
}
