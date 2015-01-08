import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Гар on 13.12.2014.
 */
public class Cop implements GameCharacter{

    public Cop(int x,int y,double speed){
        xx=x;
        yy=y;
        speedx=speed;speedy=speed;
    }


    int hp =100;
    int xx=700;int yy=400;
    double speedx,speedy,size=1;

    public static final int minx=0;
    public static final int maxy=660;
    public static final int miny=50;
    public static final int maxx=1000;

    Image cop = new ImageIcon("res/cop.png").getImage();

    public int X(){
        return xx;
    }
    public int Y(){
        return yy;
    }

    public void move(){
        xx+=speedx;
        yy-=speedy;

        if (xx<=minx) xx =minx;
        if (yy>=maxy) yy =maxy;
        if (yy<=miny) yy =miny;
        if (xx>=maxx) xx =maxx;
    }


}
