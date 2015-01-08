import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Гар on 13.12.2014.
 */
public class Bullet {

    int xx,yy=0;
    
    int speedx =0;

    
    public Bullet(int x,int y,int s,Direction direction){
    	xx=x;
        yy=y;

        switch (direction){
            case UP:
                speedx=s;
                break;
            case DOWN:
                speedx=s;
                break;
            case LEFT:
                speedx=-s;
                pul=bull;
                break;
            case RIGHT:
                speedx=s;
                pul=bull1;
                break;
        }
    }
  
    Image bull1 = new ImageIcon("res/pulya1.png").getImage();
    Image bull = new ImageIcon("res/pulya.png").getImage();
    Image pul;

    
    public void fire(){    	
        xx+=speedx;
                     
    }



}
