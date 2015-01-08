import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;


/**
 * Created by Гар on 13.12.2014.
 */
public class Drawing extends JPanel implements ActionListener {

    Timer mainTimer = new Timer(20, this);

    Backstage fon = new Backstage();
    Pirate p = new Pirate();
    OtherPics o = new OtherPics();
    Direction direction;

    int ss = 5;
    double sss = 1;
    int cophow = 1;
    int score=1;
    Image pirate = new ImageIcon("res/piratew.png").getImage();
    Image pirate1 = new ImageIcon("res/piratew1.png").getImage();
    Image pirated = new ImageIcon("res/piratesd.png").getImage();
    Image map1 = new ImageIcon("res/Map1.jpg").getImage();
    Image map2 = new ImageIcon("res/Map2.jpg").getImage();
    Image map3 = new ImageIcon("res/Map3.jpg").getImage();


    Image copl = new ImageIcon("res/cop.png").getImage();
    Image copr = new ImageIcon("res/cop1.png").getImage();
    Image png = new ImageIcon("res/").getImage();


    public Drawing() {
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }


    public LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    public LinkedList<Cop> cops = new LinkedList<Cop>();

    Random rand = new Random();

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_D) {
                p.pirate = pirate;
                p.speedx = ss;
                direction = Direction.RIGHT;

            }
            if (key == KeyEvent.VK_A) {
                p.pirate = pirate1;
                p.speedx = -ss;
                direction = Direction.LEFT;
            }
            if (key == KeyEvent.VK_W) {
                p.speedy = ss;
            }
            if (key == KeyEvent.VK_S) {
                p.speedy = -ss;
            }
            if (key == KeyEvent.VK_G) {
                if ( p.puls!=0) {
                    bullets.add(new Bullet(p.X(), p.Y() + 30, 20, direction));
                    p.puls--;

                }
            }
            if (key == KeyEvent.VK_P) {
                cops.add(new Cop(rand.nextInt(900), rand.nextInt(500), sss));
            }
        }

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_D) {
                p.speedx = 0;
            }
            if (key == KeyEvent.VK_A) {
                p.speedx = 0;
            }
            if (key == KeyEvent.VK_W) {
                p.speedy = 0;
            }
            if (key == KeyEvent.VK_S) {
                p.speedy = 0;
            }
            if (key == KeyEvent.VK_G) {

            }
        }
    }


    boolean i = false;
    int k = 0;

    public void newCop() {

        if ((cops.size() < cophow)) {
            if (!i) {
                cops.add(new Cop(rand.nextInt(900) + 200, rand.nextInt(1200), sss));
                k++;
            }
        }
        if (k == cophow)
            i = true;
    }

    public void copRun() {
        int n = 50;
        for (Cop cop : cops) {
            cop.speedx = 0;
            cop.speedy = 0;
            if ((p.xx + n <= cop.xx)) {
                cop.cop = copl;
                cop.speedx = -sss;

            }

            if ((cop.xx <= p.xx - n)) {
                cop.cop = copr;
                cop.speedx = sss;
            }
            if (p.yy + n <= cop.yy) {
                cop.speedy = sss;
            }
            if (p.yy - n >= cop.yy) {
                cop.speedy = -sss;
            }

        }
    }

    public void arest() {
        for (Cop cop : cops) {
            if ((p.xx - 50 <= cop.xx & cop.xx <= p.xx + 50) & (cop.yy - 50 <= p.yy & p.yy <= cop.yy + 50)) {
                p.hp = 0;
                p.pirate = pirated;
                p.maxy = p.yy;
                p.maxx = p.xx;
                p.miny = p.yy;
                p.minx = p.xx;
                o.heart=o.heart1;
                mainTimer.stop();

            }

        }
    }
    Random rr = new Random();
    public void pirateFire() {

        for (Bullet bullet : bullets) {
            for (Cop cop : cops) {
                if ((cop.xx - 50 <= bullet.xx & bullet.xx <= cop.xx + 50)
                        & (cop.yy <= bullet.yy & bullet.yy <= cop.yy + 100)) {
                    cop.hp = 0;
                    bullet.yy=1000;
                    p.score++;
                    p.puls=p.puls+rr.nextInt(2);
                }
            }
        }
        Iterator<Cop> copIterator = cops.iterator();

        while (copIterator.hasNext()) {
            Cop cop = copIterator.next();
            if (cop.hp == 0) {
                copIterator.remove();
            }
        }


    }


    public void mapChange(int score){
        switch (score){
            case 2:
                //fon.map=map1;
                o.lvl = o.lv2;
                break;
            case 3:
                fon.map=map1;
                o.lvl = o.lv3;
                break;
            case 4:
                o.lvl=o.lv4;
                break;
            case 5:
                fon.map=map3;
                o.lvl=o.lv5;
                break;
        }

    }
    int how=1;
    int level=1;
    public void newLevel() {

        if (p.goldd == how) {
            how++;
            p.goldd = 0;
            cophow++;
            sss=sss+0.5;
            score++;
            p.puls=p.puls+2;
            level++;

            k = 0;
            i = false;
            if (k == cophow) {
                i = true;
            }


        }

    }




    public void actionPerformed(ActionEvent e) {
        newCop();
        copRun();
        p.move();
        arest();
        p.check();
        p.goldUp();
        mapChange(score);

        for (Cop cop : cops)
            cop.move();

        for (Bullet bullet : bullets) {
            bullet.fire();
        }
        pirateFire();
        newLevel();

        repaint();
    }
    public void paint(Graphics g) {
        g.drawImage(fon.map, 0, 0, null);
        g.drawImage(fon.white, 0, 0, null);
        g.drawImage(p.pirate, p.xx, p.yy, null);

        for (Cop cop : cops) {
            g.drawImage(cop.cop, cop.xx, cop.yy, null);
        }
        g.drawImage(p.gold, p.xg, p.yg, null);
        g.drawImage(o.heart, o.x, o.y, null);
     //   g.drawImage(o.lvl, o.x, o.y, null);
        g.drawImage(o.bul, o.x-50, o.y, null);
        g.drawImage(p.gd, o.x, o.y, null);
        int fontSize = 28;
        g.setFont(new Font("Porsche", Font.PLAIN, fontSize));
        g.setColor(Color.black);
        g.drawString("LV. " +(Integer.toString(level)),50,30);
        g.drawString("SCORE : " +(Integer.toString(p.score)),500,30);
        g.drawString(" : " +(Integer.toString(p.puls)),830,30);

        for (Bullet bullet : bullets) {
            g.drawImage(bullet.pul, bullet.xx, bullet.yy, null);
        }

    }

}
