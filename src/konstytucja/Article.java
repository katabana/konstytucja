package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;

public class Article {
	public int number;
	public String text;
	public ArrayList<Point> points;
	
	public Article(int number, String text) {
		this.number = number;
		this.text = text;
	}
	
	public void printArticle() {
		//prints article's parts
		System.out.println("Art. "+ this.number);
		System.out.println(this.text);
		
		//prints article's points
		if(!this.points.isEmpty()) {
	        Iterator<Point> iterator = this.points.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next().toString());
	        }
		}
	}
	
}
