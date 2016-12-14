package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;

public class Printer {
	
	private Konstytucja kon;
	private String range;
	
	public Printer(String[] args, Konstytucja kon){
		this.kon = kon;
		this.range = args[1];
	}
	
	public String getRange(){
		return this.range;
	}
	
	private String findRange(){
		String tmp = this.range;
		if(tmp.startsWith("R")) {
			int i = 0;
			while(i < tmp.length() && !(tmp.charAt(i) >= '0' && tmp.charAt(i) <= '9'))
				i++;
			tmp = "R" + tmp.substring(i);
			return tmp;
		}
		if(tmp.startsWith("A")) {
			int i = 0;
			while(i < tmp.length() && !(tmp.charAt(i) >= '0' && tmp.charAt(i) <= '9'))
				i++;
			tmp = "A" + tmp.substring(i);
			return tmp;
		}
		else
			tmp = null;
			return tmp;
	}
	
	public void printRange(){
		int start = 0;
		int end = 0;
		String tmp = this.findRange();
		if(tmp == null)
			this.printAll();
		else {
			if(tmp.startsWith("R")){
				if(tmp.contains("-"))
					System.out.println("Chapter should not be range.");
				else {
					start = Integer.parseInt(tmp.substring(1));
					end = start;
				}
			}
			if(tmp.startsWith("A")){
				
				if(tmp.contains("-")){
					int a = tmp.indexOf("-");
					start = Integer.parseInt(tmp.substring(1,a));
					end = Integer.parseInt(tmp.substring(a+1));
				}
				else {
					start = Integer.parseInt(tmp.substring(1));
					end = start;
				}
			}
			
			if(!this.kon.getChapters().isEmpty()) {
				ArrayList<Chapter> chapters = this.kon.getChapters();
				if(tmp.startsWith("R")){
					//because indexes start from 0
					start--;
					if(start >= 0 && start < chapters.size())
						chapters.get(start).printChapter();
					else if(start < 0) {
						System.out.println();
					}
					else {
						start++;
						System.out.println("No such chapter " + start);
					}
				}
				else {
					for (Chapter i : chapters) {
						if(!i.getArticles().isEmpty()) {
							for (Article j : i.getArticles()){
								if(j.getNumber() >= start && j.getNumber() <= end){
									j.printArticle();
								}
							}
						}
					}
					ArrayList<Article> arts = chapters.get(chapters.size()-1).getArticles();
					if(!arts.isEmpty()) {
						Article lastArticle = arts.get(arts.size()-1);
						boolean inRange = lastArticle.getNumber() < start || lastArticle.getNumber() < end;
						if (start != end && inRange) {
							System.out.println("Not enough articles from range");
						}
						if(start == end && inRange) {
							System.out.println("The " + start +". article does not exist");
						}
						if(start > end){
							System.out.println("Wrong range - start: "+start+", end: "+end);
						}
					}
				}	
			}
		}
	}
	
	public void printAll(){
		
		if(!this.kon.getChapters().isEmpty()) {
	        Iterator<Chapter> iterator = this.kon.getChapters().iterator();
	        while (iterator.hasNext()) {
	        	System.out.println();
	            iterator.next().printChapter();
	        } 
		} 
	}
}
