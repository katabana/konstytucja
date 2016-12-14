package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;


public class Article {
	private int number;
	private String text;
	public ArrayList<String> points;
	
	public Article(int number) {
		this.number = number;
		this.text = "";
		this.points = new ArrayList<String>();
	}
	public int number(){
		return this.number;
	}
	
	public String text(){
		return this.text;
	}
	
	public Article(int number, String text) {
		this.number = number;
		this.text = text;
		this.points = new ArrayList<String>();
	}
	
	public Article readArticle(ArrayList<String> file, int id) {
		try {
			if(id < file.size() && file.get(id) != null) {
				String line = file.get(id);
				this.text = line;
				//System.out.println("tekst artykulu " + this.text);
				
				while(id <= file.size() && !line.startsWith("Rozdzia") && !line.startsWith("Art")) {
					int i = 0;
					String tmp = "";
					while(line.charAt(i) != ' ') {
							tmp += line.charAt(i);
							i++;
							if(i == line.length())
								break;
					}
									
					if(tmp.equals(Integer.toString(this.points.size()+1) + '.')) {
						this.text = "";
						String nline = line;
						this.points.add(nline);
						while(!line.endsWith(".")){
							id++;
							if(line.endsWith("-")) {
								line = file.get(id);
								nline = nline.substring(0,nline.length()-1) + line;
								this.points.set(this.points.size()-1, nline);
							}
							else {
								line = file.get(id);
								nline += " " + line;
								this.points.set(this.points.size()-1, nline);
							}
						}
					}
					else {
						String nline = line;
						while(id < file.size() && !nline.endsWith(".")){
							id++;
							if(line.endsWith(":")){
								this.text = this.text.substring(0,this.text.length()-2)+":\n";
							}
							if(line.endsWith("-")) {
								//System.out.println(nline);
								line = file.get(id);
								nline = nline.substring(0,nline.length()-1) + line;
								this.text = nline;
							}
							else {
								line = file.get(id);
								nline += " " + line;
								this.text = nline;
							}
						
						}
					}
					
					id++;
					if (id < file.size())
						line = file.get(id);
				} 
			}
			
		} catch (NullPointerException e){
			e.getMessage();
			
		}
		return this;
	}
	
	public void printArticle() {
		//prints article's parts
		System.out.println("Art. "+ this.number);
		if(this.text != "")
			System.out.println(this.text);
		
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
