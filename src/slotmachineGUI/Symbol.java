package slotmachineGUI;


public class Symbol implements ISymbol{
	String imagePath;
	int Points;
	Symbol(String imagePath, int points){
		this.imagePath = imagePath;
		this.Points = points;
	}
	@Override
	public void setImage(String path) {
		this.imagePath = path;
	}

	@Override
	public String getImage() {
		return imagePath;
	}

	@Override
	public void setValue(int value) {
		this.Points = value;
	}

	@Override
	public int getValue() {
		return Points;
	}

	

}