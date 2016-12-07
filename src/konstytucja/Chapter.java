package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;

public class Chapter {
	public int number;
	public String title;
	public ArrayList <Article> articles;
	
	public Chapter(int number) {
		this.number = number;
		this.articles = new ArrayList<>();
	}
	
public String arabicToRoman(int n){
	
		String number = "";
		while(n > 0){
			if(n >= 100) {
				number += "C";
				n -= 100;
			}
			if(n >= 90){
				number += "XC";
				n -= 90;
			}
			if(n >= 50){
				number += "L";
				n -= 50;
			}
			if(n >= 40){
				number += "XL";
				n -= 40;
			}
			if(n >= 10){
				number += "X";
				n -= 10;
			}
			if(n >= 9){
				number += "IX";
				n -= 9;
			}
			if(n >= 5){
				number += "V";
				n -= 5;
			}
			if(n >= 4){
				number += "IV";
				n -= 4;
			}
			if(n >= 1){
				number += "I";	
				n -= 1;
			}
		}
		return number;
	}
	
	public void printChapter(){
		//prints chapter's parts
		System.out.println("Rozdzial " + arabicToRoman(this.number));
		System.out.println(this.title);
		
		//prints chapter's articles
		if(!this.articles.isEmpty()) {
	        Iterator<Article> iterator = this.articles.iterator();
	        while (iterator.hasNext()) {
	            iterator.next().printArticle();
	        }
		}
	}
}
