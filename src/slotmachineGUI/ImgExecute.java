package slotmachineGUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImgExecute {
		static ImgExecute config;
		/*Java singleton concept */
		static Thread reel = new Thread();
		static Thread reel1  = new Thread();
		static Thread reel2  = new Thread();
		static List<Symbol> IMAGESL = new ArrayList<>(); 
		/*implementing image locations*/
			final String BELL = "C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\bell.png";
			final String CHERRY = "C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\cherry.png";
			final String LEMON = "C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\lemon.png";
			final String PLUM = "C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\plum.png";
			final String REDSEVEN = "C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\redseven.png";
			final String WATERMELON = "C:\\Users\\Menusha\\workspace\\slotmachineGUI\\src\\slotmachineGUI\\watermelon.png";
			
			ImgExecute(){
			 IMAGESL.add(new Symbol(REDSEVEN, 7));
			 IMAGESL.add(new Symbol(BELL, 6));
			 IMAGESL.add(new Symbol(WATERMELON, 5));
			 IMAGESL.add(new Symbol(PLUM, 4));
			 IMAGESL.add(new Symbol(LEMON, 3));
			 IMAGESL.add(new Symbol(CHERRY, 2));

		}
			/*points allocate for each fruit*/
		static int point1 = 0;
		static int point2 = 0;
		static int point3 = 0;

		
		static int bell = 0;
		static int cherry = 0;
		static int lemon = 0;
		static int plum = 0;
		static int redseven = 0;
		static int watermelon = 0;
		
		/*Defaukt credits*/
		final int INITIAL_CREDITS = 3;
		final int LOOSE_CREDITS = 1;
		
		/*to bet maximum coins*/
		final int BET_MAX_COINS = 3;

		
		static int won=0;
		static int lose=0;

		public static ImgExecute getInstance(){
			return config;
		}
	}

