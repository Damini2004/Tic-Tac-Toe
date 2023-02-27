import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyGame extends JFrame implements ActionListener {
	
	JLabel heading,clockLabel;
	Font font =new Font("",Font.BOLD,40);
	JPanel mainPanel;
	
	JButton [] btns=new JButton[9];
	//game instances variable 
	int gamechances[]= {2,2,2,2,2,2,2,2,2};
	int activePlayer=0;
	
	int wps[][]= {
			{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
	int winner=2;
	
	MyGame(){
		System.out.println("Hello world");
         setTitle("My Tic Tac Toe");
         setSize(850,750);
         ImageIcon icon=new ImageIcon("src/img/OIP (2).jpg");
         setIconImage(icon.getImage());
         
         
         
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         createGUI();
         setVisible(true);
	}
	
	
	
  void createGUI() {
	  
	 this.setLayout(new BorderLayout());
	 heading =new JLabel("Tic Tac Toe");
	 heading.setFont(font);
	 heading.setHorizontalAlignment(SwingConstants.CENTER);
	 this.add(heading,BorderLayout.NORTH); 
	  clockLabel=new JLabel("WELCOME");
	  clockLabel.setFont(font);
	  clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
this.add(clockLabel,BorderLayout.SOUTH);


	 
	 mainPanel =new JPanel();
	 mainPanel.setLayout(new GridLayout(3,3));
	 for(int i=1;i<=9;i++) {
		 JButton btn=new JButton();
		 btn.setFont(font);
		 mainPanel.add(btn);
		 btn.addActionListener(this);
		 btn.setName(String.valueOf(i-1));
	 }
	 
	 this.add(mainPanel,BorderLayout.CENTER);
	 
	 
	 
	 
	 
	 
 }



@Override
public void actionPerformed(ActionEvent e) {
JButton currentbutton=(JButton)e.getSource();
String nameStr= currentbutton.getName();
System.out.println(nameStr);
int name=Integer.parseInt(nameStr.trim());
if(gamechances[name]==2) {
	if(activePlayer==1) {
		currentbutton.setIcon(new ImageIcon("src/img/OIP (1).jpg"));
		gamechances[name]=activePlayer;
		activePlayer=0;
	}
	else {
		currentbutton.setIcon(new ImageIcon("src/img/OIP.jpg"));
		gamechances[name]=activePlayer;
		activePlayer=1;
	}
	//find the winner........
	for(int [] temp:wps) {
		if((gamechances[temp[0]]==gamechances[temp[1]])&&  (gamechances[temp[1]]==gamechances[temp[2]])  && gamechances[temp[2]]!=2) {
			
			winner=gamechances[temp[0]];
			JOptionPane.showMessageDialog(null, "player "+ winner+"has won the game");			
			break;
		}
	}
	
	
	
	
}else {
	JOptionPane.showMessageDialog(this, "Position already occupied....");	
}



}
}
