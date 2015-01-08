import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Гар on 13.12.2014.
 */
public class Pirate implements GameCharacter {

    int hp = 100;
    int goldd = -1;
    int speedx = 0, speedy = 0;
    int puls=3;
    int score=-1;

    int xx = 100;int yy = 400;
    int xp = xx;
    int yp = yy;
    int xg = 100;
    int yg = 400;

    int minx = 0;
    int maxy = 660;
    int miny = 50;
    int maxx = 1000;

    Random rand = new Random();

    Image pirate = new ImageIcon("res/piratew.png").getImage();
    Image gold = new ImageIcon("res/gold.png").getImage();
    Image gd;
    Image gold1 = new ImageIcon("res/g1.png").getImage();
    Image gold2 = new ImageIcon("res/g2.png").getImage();
    Image gold3 = new ImageIcon("res/g3.png").getImage();
    Image gold0 = new ImageIcon("res/png").getImage();


    public void move() {
        xx += speedx;
        yy -= speedy;

        if (xx <= minx) xx = minx;
        if (yy >= maxy) yy = maxy;
        if (yy <= miny) yy = miny;
        if (xx >= maxx) xx = maxx;
    }

    public void check() {
        if ((xg - 50 <= xx & xx <= xg + 50) & (yg-50 <= yy & yy <= yg + 50)) {
            xg = (rand.nextInt(90) * 10);
            yg = 50 + rand.nextInt(60) * 10;
            goldd++;
            score++;
        }
    }

    public void goldUp() {
        if (goldd == 0)
            gd=gold0;
        if (goldd == 1)
            gd=gold1;
        if (goldd == 2)
            gd = gold2;
        if (goldd == 3)
            gd = gold3;

    }


    public int X() {
        return xx;
    }

    public int Y() {
        return yy;
    }


}