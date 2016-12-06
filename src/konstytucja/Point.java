package konstytucja;

public class Point {
	public int number;
	public String text;
	
	public Point(int number, String text) {
		this.number = number;
		this.text = text;
	}
	
	@Override
	public String toString() {
		return (this.text);
	}
}
