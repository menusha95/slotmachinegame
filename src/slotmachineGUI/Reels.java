package slotmachineGUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Reels implements Runnable{

	List<Symbol> str = ImgExecute.getInstance().IMAGESL;
	JLabel lb;
	int point = 0;
	JPanel panel;
	Reels(JLabel lb, int point, JPanel panel){
		this.lb = lb;
		this.point = point;
		this.panel = panel;

	}
	
	@Override
	public void run(){
		int i = 0;
		while(!Thread.currentThread().isInterrupted()){
			if(i == str.size()){
				i = 0;
			}
			/*Place where images are loaded to the reel*/
			lb.setIcon(new ImageIcon(new ImageIcon(str.get(i).imagePath).getImage().getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH)));
			System.out.println(str.get(i).getValue());
			switch (point) {
			case 1:
				ImgExecute.point1 = str.get(i).getValue();
				break;
			case 2:
				ImgExecute.point2 = str.get(i).getValue();
				break;
			case 3:
				ImgExecute.point3 = str.get(i).getValue();
				break;
			default:
				break;
			}
			
			try {
				Thread.sleep(100);	//Flipping time of the reels
				i++;
				
			} catch (InterruptedException e) {
				switch(str.get(i).getValue()){
					case 2:
						ImgExecute.cherry++;
						break;
					case 3:
						ImgExecute.lemon++;
						break;
					case 4:
						ImgExecute.plum++;
						break;
					case 5:
						ImgExecute.watermelon++;
						break;
					case 6:
						ImgExecute.bell++;
						break;
					case 7:
						ImgExecute.redseven++;
						break;
					default:
						
				}
				/*Implementing the winning logic*/
				if((!ImgExecute.reel.isAlive() && !ImgExecute.reel1.isAlive()) || (!ImgExecute.reel.isAlive() && !ImgExecute.reel2.isAlive()) || (!ImgExecute.reel1.isAlive() && !ImgExecute.reel2.isAlive())){
					if(ImgExecute.point1 == ImgExecute.point2 &&  ImgExecute.point3 == ImgExecute.point1){
						JOptionPane.showMessageDialog(panel, "You Won");
						ImgExecute.getInstance().won+=1;	//Setting the statistics for winnings
					}else{
						JOptionPane.showMessageDialog(panel, "You Lost");
						ImgExecute.getInstance().lose+=1;	//Setting the statistics for Lost
					}
				}
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}
