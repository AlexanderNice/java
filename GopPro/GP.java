import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Window.Type;

public class GP extends JFrame {
	Random rand = new Random();
	private boolean Adidas = false;
	private boolean Lada = false;
	private boolean BMW = false;
	private boolean Princess = false;
	private boolean Larek = false;
	
	private int money = 50;
	private int fill = 100;
	private int respect = 0;
	private int day = 1;
	private int mood = 100;
	private boolean life = true;
	private JLabel countMoney;
	private JLabel countDay;
	private JLabel countFill;
	private JLabel countRespect;
	private JLabel countMood;
	private JLabel prost;
	private JButton addBeer;
	private JButton addSemki;
	private JButton addPelmen;
	private JButton addPanhandleMoney;
	private JButton addLohMoney;
	private JButton addHustleMoney;
	private JButton buyAdidas;
	private JButton buyLada;
	private JButton buyBmw;
	private JButton findLove;
	private JButton openLarek;
	private JButton Litrbol;
	private JButton playPoker;
	private JButton draka;
		
	public GP() {
	    super("GopPro. Ровный симулятор");
	    getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
	    setSize(600, 230);
	    setBounds(100, 100, 600, 230);
	    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alexg_000\\Downloads\\gopnik.png"));
	    countMoney = new JLabel("Деньги:" + money);
	    countMoney.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    countMoney.setBounds(220, 0, 100, 12);
	    countFill = new JLabel("Сытость:" + fill);
	    countFill.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    countFill.setBounds(330, 0, 100, 12);
	    countRespect = new JLabel("Авторитет:" + respect);
	    countRespect.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    countRespect.setBounds(110, 0, 100, 12);
	    countDay = new JLabel("День:" + day);
	    countDay.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    countDay.setBounds(0, 0, 100, 12);
	    countMood = new JLabel("Настроение:" + mood);
	    countMood.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    countMood.setBounds(440, 0, 100, 12);
	    prost = new JLabel ("");
	    prost.setForeground(new Color(204, 0, 0));
	    prost.setLocation(85, 93);
	    prost.setSize(400, 12);
	    getContentPane().setLayout(null);
	    
	    getContentPane().add(countDay);
	    getContentPane().add(countMoney);
	    getContentPane().add(countFill);
	    getContentPane().add(countMood);
	    getContentPane().add(countRespect);
	    getContentPane().add(prost);
	    addBeer = new JButton("Отведать пивка (-50)");
	    addBeer.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    addBeer.setBounds(0, 45, 190, 20);
	    getContentPane().add(addBeer);
	    addSemki = new JButton("Перекусить семечками(-20)");
	    addSemki.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    addSemki.setBounds(0, 23, 190, 20);
	    getContentPane().add(addSemki);
	    addPelmen = new JButton("Съесть пельменей (-100)");
	    addPelmen.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    addPelmen.setBounds(0, 67, 190, 20);
	    getContentPane().add(addPelmen);
	    addPanhandleMoney = new JButton("Попросить милостыню");
	    addPanhandleMoney.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    addPanhandleMoney.setBounds(214, 23, 160, 20);
	    getContentPane().add(addPanhandleMoney);
	    addLohMoney = new JButton("Кинуть лоха");
	    addLohMoney.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    addLohMoney.setBounds(214, 45, 160, 20);
	    getContentPane().add(addLohMoney);
	    addHustleMoney = new JButton("Провернуть аферу");
	    addHustleMoney.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    addHustleMoney.setBounds(214, 67, 160, 20);
	    getContentPane().add(addHustleMoney);
	    buyAdidas = new JButton("Экипироваться в Адидас (3к)");
	    buyAdidas.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    buyAdidas.setBounds(0, 109, 190, 20);
	    getContentPane().add(buyAdidas);
	    buyLada = new JButton("Купить Ладу (30к)");
	    buyLada.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    buyLada.setBounds(214, 109, 160, 20);
	    getContentPane().add(buyLada);
	    Litrbol = new JButton("Играть в литрбол с корешами");
	    Litrbol.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    Litrbol.setBounds(394, 23, 190, 20);
	    getContentPane().add(Litrbol);
	    buyBmw = new JButton("Купить БМВ (100к)");
	    buyBmw.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    buyBmw.setBounds(394, 109, 190, 20);
	    getContentPane().add(buyBmw);
	    findLove = new JButton("Найти принцессу (50к, необходим БМВ)");
	    findLove.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    findLove.setBounds(0, 135, 240, 20);
	    getContentPane().add(findLove);
	    playPoker = new JButton("Сыграть в покер");
	    playPoker.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    playPoker.setBounds(394, 45, 190, 20);
	    getContentPane().add(playPoker);
	    openLarek = new JButton("Открыть ларек (150к, необходимы БМВ и принцесса)");
	    openLarek.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    openLarek.setBounds(264, 135, 320, 20);
	    getContentPane().add(openLarek);
	    draka = new JButton("Подраться");
	    draka.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    draka.setBounds(394, 67, 190, 20);
	    getContentPane().add(draka);
	    
	    JButton button = new JButton("\u041D\u0430\u0447\u0430\u0442\u044C \u0437\u0430\u043D\u043E\u0432\u043E");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		prost.setText("                           паринь, ты возродился аки птица феникс");
	    		life = true;
				money = 50;
				fill = 100;
				respect = 0;
				mood = 100;
				day = 1;
	    		ok();
	    	}
	    });
	    button.setBounds(236, 166, 120, 20);
	    getContentPane().add(button);
	    
	    draka.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    mood = mood-2+rand.nextInt(3);
	    	    fill = fill-2+rand.nextInt(3); 
	    	    respect = respect +5*rand.nextInt(1);
	    	    ok();
	    	  }
	    	});
	    
	    openLarek.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  if(BMW&Princess&!Larek){
	    			day++;
	    	    	money = money-150000;
	    	    	respect = respect+1000;   
	    	    	Larek=true;
	    	    	ok();
	    		  }
	    		  else{
	    			  prost.setText("Тебе чего то не хватает, паринь");
	    		  }
	    	  }
	    	});
	    
	    playPoker.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money+500*(rand.nextInt(2)-1);
	    	    mood = mood-2+rand.nextInt(1);
	    	    fill = fill-2+rand.nextInt(1); 
	    	    ok();
	    	  }
	    	});
	    
	    findLove.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  if(BMW&!Princess){
	    			  day++;
	    			  money = money-50000;
	    			  respect = respect+200;     	    
	    			  Princess=true;
	    			  ok();
	    		  }
	    		  else{
	    			  prost.setText("Без БМВ ты - никто");
	    		  }
	    	  }
	    	});
	    
	    buyBmw.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  if(Adidas&Lada&!BMW){	    			   
	    			  day++;
	    			  money = money-100000;
	    			  respect = respect+500;     	    
	    			  BMW=true;
	    			  ok();
	    		  }
	    		  else{	    			  
	    			  prost.setText("Тебе чего то не хватает, паринь");
	    		  }
	    	  }
	    	});
	    
	    Litrbol.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money - 100;
	    	    mood = mood+5+rand.nextInt(3);
	    	    fill = fill+1+rand.nextInt(3); 
	    	    ok();
	    	  }
	    	});
	    
	    buyLada.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		  if(Adidas&!Lada){
	    			day++;
	    		  	money = money-30000;
	    		  	respect = respect+200; 
	    		  	Lada = true;
	    		  	ok();
	    		  }
	    		  else
	    		  {
	    			  prost.setText("Тебе чего то не хватает, паринь");
	    		  }
	    	  }
	    	});
	    
	    buyAdidas.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    		if(!Adidas){
	    	    day++;
	    	    money = money-3000;
	    	    respect = respect+20;    
	    	    Adidas = true;
	    	    ok();
	    	    }
	    		else
	    		{
	    			prost.setText("Тебе нужна лада, паринь");
	    		}
	    	 }
	    	});
	    
	    addHustleMoney.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money+500*rand.nextInt(1);
	    	    fill = fill-rand.nextInt(10);  
	    	    mood = mood-rand.nextInt(10);
	    	    ok();
	    	  }
	    	});
	    
	    addLohMoney.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money+40+rand.nextInt(30);
	    	    fill = fill-rand.nextInt(5);  
	    	    mood = mood-rand.nextInt(5);
	    	    ok();
	    	  }
	    	});
	    
	    addPanhandleMoney.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money+20+rand.nextInt(30);
	    	    fill = fill-rand.nextInt(3);  
	    	    mood = mood-rand.nextInt(3);
	    	    ok();
	    	  }
	    	});
	    
	    addPelmen.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money-100;
	    	    fill = fill+5+rand.nextInt(5);     	    
	    	    ok();
	    	  }
	    	});
	    
	    addSemki.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money-20;
	    	    fill = fill+5+rand.nextInt(5);     	    
	    	    ok();
	    	  }
	    	});
	    
	    addBeer.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
	    	    day++;
	    	    money = money-50;
	    	    fill = fill+10+rand.nextInt(5);     	    
	    	    ok();
	    	  }
	    	});
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
	
	private void ok() {		
		if (life){
			update();
		}
		if ((fill|mood|money)<=0){
			life=false;
			prost.setText("Смирть забираит лучших из нас. Мни ачинь жаль (((99дивятачка");			
		}

	}
	
	private void update() {
		if (fill >= 100){
	    	fill = 100;	    	
	    }
	    if (mood >= 100){
	    	mood = 100;
	    }
	    countMoney.setText("Деньги:" + money);
	    countFill.setText("Сытость:" + fill);
	    countRespect.setText("Авторитет:" + respect);
	    countDay.setText("День:" + day);   
	    countMood.setText("Настроение:" + mood);
	}
	
	 public static void main(String[] args) {
		    GP app = new GP();
		    app.setPreferredSize(new Dimension(600, 230));
		    app.setVisible(true);
		    app.pack();
	 }
}

