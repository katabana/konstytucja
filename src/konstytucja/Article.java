package konstytucja;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Article {
	public int number;
	public String text;
	public ArrayList<String> points;
	
	public Article(int number, String text) {
		this.number = number;
		this.text = text;
	}
	
	public ArrayList<Article> readArticle(ArrayList<Article> articles, BufferedReader reader, int number) {
		try {
			String line = reader.readLine();
			Article article = new Article(number, line);
			
			int i = 0;
			String tmp = "";
			while(line.charAt(i) != ' ') {
					tmp += line.charAt(i);
					i++;
			}
			if (tmp == (Integer.toString(points.size()+1) + '.')) {
				points.add(line);
				//while()
			}
			articles.add(article);
			article.printArticle();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			return articles;
		}
		
	}
	
	public void printArticle() {
		//prints article's parts
		System.out.println("Art. "+ this.number);
		System.out.println(this.text);
		
		//prints article's points
		if(!this.points.isEmpty()) {
	        Iterator<String> iterator = this.points.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next().toString());
	        }
		}
		else System.out.print("etwas");
	}
	
}
