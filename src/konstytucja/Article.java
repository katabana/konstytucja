package konstytucja;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Article {
	public int number;
	public String text;
	public ArrayList<String> points;
	
	public Article(int number) {
		this.number = number;
		this.text = "";
	}
	
	public Article(int number, String text) {
		this.number = number;
		this.text = text;
	}
	
	public ArrayList<Article> readArticle(ArrayList<Article> articles, BufferedReader reader, int number) {
		try {
			String line = reader.readLine();
			while(!line.startsWith("Rozdzia") || !line.startsWith("Art")) {
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
				else {
					article.text += line;
					article.text += "proba1";
				}
				line = reader.readLine();
				articles.add(article);
			}
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
		if(this.points != null && !this.points.isEmpty()) {
	        Iterator<String> iterator = this.points.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next().toString());
	        }
		}
		else System.out.println("etwasarticle");
	}
	
}
