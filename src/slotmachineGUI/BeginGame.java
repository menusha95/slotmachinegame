package slotmachineGUI;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BeginGame extends JFrame {
		private BufferedImage image;
		private JPanel jpanelcont = null;
		
	    JLabel lb;
	    JLabel coinsAm;
	    
	  // Constructor:
	  public BeginGame() {
		super();
		Initialize();
	  }
	  
	  /*Creating the Content panel*/
	  public void Initialize(){
		  this.setSize(1050, 550);
		    this.setContentPane(getJContentPane());
		    this.setTitle("Welcome to Slot Machine");
		    this.setLocationRelativeTo ( null );
		    ImgExecute config = new ImgExecute();
		   
		    
	  }
	  private JPanel getJContentPane() {
		    if (jpanelcont == null) {
		    	jpanelcont = new JPanel();
		    	jpanelcont.setLayout(null);

		        JPanel panel = new JPanel();
		        BorderLayout layout = new BorderLayout();
		        layout.setHgap(10);
		        layout.setVgap(20);
		        JPanel topFirst = new JPanel(layout);
		        topFirst.setBounds(20,50,1000, 50);

		        BorderLayout ImageFlip = new BorderLayout();
		        JPanel imgArea = new JPanel(ImageFlip);
		        imgArea.setBounds(100,100,1000, 100);
		        
		        FlowLayout buttons = new FlowLayout();
		        buttons.setHgap(10);              
		        buttons.setVgap(10);
		        JPanel btnLayout = new JPanel(buttons);


		        panel.setBounds(15,5,1000, 500);
		        BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);
		        panel.setLayout(bl);
		        jpanelcont.add(panel);
		        
		       /*creating the bet area*/
			   JLabel pointText = new JLabel("BetArea :");
			   pointText.setFont(new Font("Arial", Font.PLAIN, 22));
			   JLabel pointUpdate = new JLabel("0");
			   pointUpdate.setFont(new Font("Arial", Font.PLAIN, 22));
		       JPanel pointSection = new JPanel(new FlowLayout());
		       pointSection.add(pointText);
		       pointSection.add(pointUpdate);
		       
		       /*creating the available coins area*/
		       JLabel Coins = new JLabel("Coins :");
		       Coins.setFont(new Font("Arial", Font.PLAIN, 22));
		       coinsAm = new JLabel("10");
		       coinsAm.setFont(new Font("Arial", Font.PLAIN, 22));
			   JButton coinAdd = new JButton("Add");
		       JPanel coinSection = new JPanel(new FlowLayout());
		       coinSection.add(Coins);
		       coinSection.add(coinsAm);
		       coinSection.add(coinAdd);
		       topFirst.add(pointSection, BorderLayout.CENTER);
		       topFirst.add(coinSection, BorderLayout.SOUTH);

		       
		       coinAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Runnable addCoin = () -> {	//after thread is started,it becomes runnable which executing the task
						int coins = Integer.parseInt(coinsAm.getText());
						System.out.println(coins);
						coinsAm.setText(String.valueOf(++coins));
					};
					Thread run = new Thread(addCoin);
					run.start();
				}
			});
		       
		       
		       /*Executing the image flip part*/
		       JLabel img1 = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\watermelon.png").getImage().getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH)));
		       JLabel img2 = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\cherry.png").getImage().getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH)));
		       JLabel img3 = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\plum.png").getImage().getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH)));
		       
		       /*Adding images to the labels*/
		       imgArea.add(img1, BorderLayout.WEST);
		       imgArea.add(img2, BorderLayout.CENTER);
		       imgArea.add(img3, BorderLayout.EAST);

		       /*Creating the buttons*/
		       JButton spinButton = new JButton("Spin");
		       JButton spinBetOne = new JButton("BetOne");
		       JButton spinBetMax = new JButton("BetMax");
		       JButton stat = new JButton("Statistics");
		       
		       /*Adding buttons to the panel*/
		       btnLayout.add(spinButton);
		       btnLayout.add(spinBetOne);
		       btnLayout.add(spinBetMax);
		       btnLayout.add(stat);

		       spinBetOne.addActionListener(new ActionListener() {	//implementing betOnebutton 
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Runnable addCoin = () -> {
						int coins = Integer.parseInt(coinsAm.getText());
						int bet = Integer.parseInt(pointUpdate.getText());

						if((coins-1) > 0){
							coinsAm.setText(String.valueOf(coins-1));
							pointUpdate.setText(String.valueOf(++bet));
						}else{
							JOptionPane.showMessageDialog(panel, "OUT OF CREDITS!");
						}
					};
					Thread run = new Thread(addCoin);
					run.start();		
				}
			});
		       
		       spinBetMax.addActionListener(new ActionListener() {	//implementing betMaxbutton 
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Runnable addCoin = () -> {
						int coins = Integer.parseInt(coinsAm.getText());
						int bet = Integer.parseInt(pointUpdate.getText());

						if((coins) > 0){
							coinsAm.setText(String.valueOf("0"));
							pointUpdate.setText(String.valueOf(bet+coins));
						}else{
							JOptionPane.showMessageDialog(panel, "OUT OF CREDITS!");
						}
					};
					Thread run = new Thread(addCoin);
					run.start();	
					
				}
			});
		       stat.addActionListener(new ActionListener() {	//implementing statistics 
				
				@Override
				public void actionPerformed(ActionEvent e) {
					BorderLayout img = new BorderLayout();
			        JPanel imageP = new JPanel(ImageFlip);

			        DefaultTableModel model = new DefaultTableModel(); 
			        String s = "YOU WON!"+String.valueOf(ImgExecute.getInstance().won);
			        JLabel TotalLabelWon = new JLabel(s);
			        String b = "YOU LOST! "+String.valueOf(ImgExecute.getInstance().lose);
			        JLabel TotalLabelLost = new JLabel(b);
			        imageP.add(TotalLabelWon, BorderLayout.EAST);
			        imageP.add(TotalLabelLost, BorderLayout.WEST);

			        
			        
					final JComponent[] inputs = new JComponent[] {
							imageP
					};
					int result = JOptionPane.showConfirmDialog(null, inputs, "", JOptionPane.PLAIN_MESSAGE);
				}
			});
		       
		       
		       spinButton.addActionListener(new ActionListener() {	//Adding task to the spin button
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					ImgExecute.getInstance().reel = new Thread(new Reels(img1, 1, panel));
					ImgExecute.getInstance().reel1 = new Thread(new Reels(img2, 2, panel));
					ImgExecute.getInstance().reel2 = new Thread(new Reels(img3, 3, panel));
					
					/*Make the buttons Unavailable after spin button is clicked*/
					spinBetOne.setEnabled(false);
	       			spinBetMax.setEnabled(false);
	       			stat.setEnabled(false);
	       			coinAdd.setEnabled(false);
	       			spinButton.setEnabled(false);

					if(true){
						System.out.println(ImgExecute.getInstance().reel.isAlive());
						
						Runnable addCoin = () -> {
							int coins = Integer.parseInt(coinsAm.getText());
							if((coins-3) > 0){
								ImgExecute.getInstance().reel.start();
								ImgExecute.getInstance().reel1.start();
								ImgExecute.getInstance().reel2.start();
								coinsAm.setText(String.valueOf(coins-3));
								
							}else{
								
								JOptionPane.showMessageDialog(panel, "You are out of credits!");
								
							}
						};
						Thread run = new Thread(addCoin);
						run.start();
						
					}
					
				}
			});
		       
		       img1.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                	ImgExecute.getInstance().reel.interrupt();
	                }

	            });
		       
		       img2.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                	ImgExecute.getInstance().reel1.interrupt();
	                }

	            });
		       img3.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                	ImgExecute.getInstance().reel2.interrupt();
	                	
						/*Make the buttons available after all the 3 reels are cicked*/
	                	spinBetOne.setEnabled(true);
		       			spinBetMax.setEnabled(true);
		       			stat.setEnabled(true);
		       			coinAdd.setEnabled(true);
		       			spinButton.setEnabled(true);
	                }

	            });
		        panel.add(imgArea);
		        panel.add(topFirst);
		        panel.add(btnLayout);

		    }
		    return jpanelcont;
		}
	  
	  
	  public static void main(String[] args) {
		  BeginGame beg  =new BeginGame();
		  beg.setVisible(true);
		  beg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	  }

	  
	} 

