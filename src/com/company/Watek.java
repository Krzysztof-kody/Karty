package com.company;

public class Watek extends Thread{
    Lacznik L1;
    int szufluj = -1;
    public int sleep = 15;
    public int rots = 5;

    public void shuffle() throws InterruptedException {
        if(szufluj > -1){

            for(Karta k: L1.karty)
                k.strona = 0;
            L1.Stol.repaint();
            Thread.sleep(1000);

            for(int i = 0; i<rots; i++) {
                szufluj = (int)(Math.random()*2);
                for (int k = 0; k < 11; k++) {
                    L1.karty.get(szufluj).setPosition(L1.karty.get(szufluj).x + 10, L1.karty.get(szufluj).y + 10);
                    L1.karty.get(szufluj + 1).setPosition(L1.karty.get(szufluj + 1).x - 10, L1.karty.get(szufluj + 1).y - 10);
                    L1.Stol.repaint();
                    Thread.sleep(sleep);
                }
                for (int k = 0; k < 11; k++) {
                    L1.karty.get(szufluj).setPosition(L1.karty.get(szufluj).x, L1.karty.get(szufluj).y - 10);
                    L1.karty.get(szufluj + 1).setPosition(L1.karty.get(szufluj + 1).x, L1.karty.get(szufluj + 1).y + 10);
                    L1.Stol.repaint();
                    Thread.sleep(sleep);
                }
                Karta c = L1.karty.get(szufluj);
                L1.karty.set(szufluj, L1.karty.get(szufluj + 1));
                L1.karty.set(szufluj + 1, c);
            }
            szufluj = -2;

        }

    }

    public Watek(Lacznik L){
        L1 = L;

    }

    public void run() {
        while(true){
            try {
                shuffle();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
