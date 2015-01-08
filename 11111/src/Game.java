import javax.swing.*;

/**
 * Created by Гар on 13.12.2014.
 * Есть статическое поле(без препятствий,со свободным перемещением игроков в 4х направлениях),
 по которому бегает Пират,охотясь за Сундуками с золотом.
 При этом есть полицейские,которые бегают за пиратом(4 направления)(кол-во увеличивается с увеличением уровня сложности)
 Контакт с полицаем(столкновение) убивает пирата и заканчивает игру.
 Полицейский не может стрелять,только бегать за Пиратом.
 Пират имеет возможность стрелять из пистолета(кол-во пуль ограничено,но оно может увеличиться за счет убийства мента или собранного золота)
 Упрвление осуществляется удержанием кнопки соответсвующей направлению двежения. Стрелять можно только по направлению движения.
 Смысл игры - собрать все сундуки,после чего сложность уровня увличивается. Цель игры - набрать как можно больше очков(кол-во уровней)
 *
 */
public class Game {

    JFrame jf;
    JLabel ll;

    public static void main(String[] args){

        JFrame jf =  new JFrame("Super Game");
        JLabel ll = new JLabel("=");

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1100,800);
        jf.add(ll);

        GameCharacter pp = new Pirate();
        ll.setText("=="+pp.X());


        jf.add(new Drawing());


        jf.setVisible(true);
    }
}