package konstytucja;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


//TODO: zle wypisuje artykuly
//psuje sie chyba tylko przy @...
public class Article {
	public int number;
	public String text;
	public ArrayList<String> points;
	
	public Article(int number) {
		this.number = number;
		this.text = "";
		this.points = new ArrayList<String>();
	}
	
	public Article(int number, String text) {
		this.number = number;
		this.text = text;
		this.points = new ArrayList<String>();
	}
	
	public ArrayList<Article> readArticle(ArrayList<Article> articles, BufferedReader reader, int number) {
		try {
			
			String line = reader.readLine();
			this.text = line;
			//System.out.println("tekst artykulu " +this.text);
			reader.mark(0);
			//System.out.println("reset readera");			
		
			while(!line.startsWith("Rozdzia") && !line.startsWith("Art")) {
				
				int i = 0;
				String tmp = "";
				while(line.charAt(i) != ' ') {
						tmp += line.charAt(i);
						i++;
				}
				
				if(line.startsWith("©")){
					reader.readLine();
				}
								
				if(tmp.equals(Integer.toString(this.points.size()+1) + '.')) {
					this.text = "";
					String tmppoint = line;
					String nline = line;
					this.points.add(tmppoint);
					while(!line.endsWith(".")){
						
						if(line.startsWith("©")){
							reader.readLine();
						} 
						
						if(line.endsWith("-")) {
							line = reader.readLine();
							nline = nline.substring(0,nline.length()-2) + line;
							this.points.set(this.points.size()-1, nline);
						}
						else {
							line = reader.readLine();
							nline += " " + line;
							this.points.set(this.points.size()-1, nline);
						}
					}
				}
				else {
					String nline = line;
					while(!line.endsWith(".")){
						//line = reader.readLine();
						//nline += line;
						if(line.endsWith(":")){
							this.text = this.text.substring(0,this.text.length()-2 )+":\n";
						}
						if(line.endsWith("-")) {
							//System.out.println(nline);
							line = reader.readLine();
							nline = nline.substring(0,nline.length()-2) + line;
							this.text = nline;
						}
						else {
							line = reader.readLine();
							nline += " " + line;
							//this.text = nline;
							this.text += nline;
						}
					}
				}
				line = reader.readLine();
			}
			reader.reset();
			
		} catch (IOException e) {
			e.getMessage();
		} finally {
			return articles;
		}
		
	}
	
	public void printArticle() {
		//prints article's parts
		System.out.println("Art. "+ this.number);
		//System.out.println(this.text);
		
		//prints article's points
		if(this.points != null && !this.points.isEmpty()) {
	        Iterator<String> iterator = this.points.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next().toString());
	        }
		}
		else ;
	}
	
}
