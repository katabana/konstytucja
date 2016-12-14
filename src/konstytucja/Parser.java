package konstytucja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Parser {
	
	public Konstytucja kon;
	public String filePath;
	public String message;
	
	
	public Parser(String[] args) {
		this.kon = new Konstytucja();
		this.filePath = args[0];
		this.message = "";
	}
	
	//reads file, save as Strings Array and delete every occurence of two unnecessary lines
	public ArrayList<String> cleanFile() {
		
		BufferedReader reader = null;
		ArrayList<String> file = new ArrayList<String>();
		
		try{
			reader = new BufferedReader(new FileReader(this.filePath + "\\konstytucja.txt"));
			
			String line = null;
			while((line = reader.readLine()) != null ){
				if(line.startsWith("Rozdzia")) {
		       		file.add(line);
		       		break;
		        }
			}
			while((line = reader.readLine()) != null) {
					
				if (line.startsWith("©")) {
					reader.readLine();
					continue;
				}
				else
					file.add(line);
			}
			
		} catch (FileNotFoundException e) {
			this.message = e.getMessage();
			System.out.println(this.message);
			return null;
		} 
	    finally {
	    	 try{
				  if (reader != null) 
					  reader.close();
			  } catch (IOException e) {
				  System.out.println(e.getMessage());
			  }
	    	 
	    	 return file;
	    }
		
	    
	}
	
	public boolean parse() {
		
		ArrayList<String> file = new ArrayList<String>();
		file = this.cleanFile();
		String line = "";
		int artnumber = 0;
		boolean parsed = false;
		
		/*System.out.println("Enter file path: ");
		Scanner scanner = new Scanner(System.in);
		filePath = scanner.nextLine();
		range = scanner.nextLine();
		scanner.close(); */
			        
		if(file != null && !file.isEmpty()){
			int i = 0;
			parsed = true;
			while(i < file.size() && file.get(i)!= null) {
					line = file.get(i);
			    	Chapter chapter = null;
			    	Article article = null;
			    	
			    	if(line.startsWith("Rozdzia")) {
			    		chapter = new Chapter(this.kon.chapters.size()+1);
			    		i++;
			    		if(file.get(i) != null)
			    			line = file.get(i);
			    		
				    	chapter.title = line;
				    	this.kon.chapters.add(chapter);
				    	//System.out.println("Rozdział " + chapter.arabicToRoman(chapter.number));
				    	//chapter.printChapter();
				    	//System.out.println();
				    	i++;
				    	continue;
			    	}
				    if(line.startsWith("Art")) {
				    	chapter = this.kon.chapters.get(this.kon.chapters.size()-1);
				    	if(chapter.articles != null) {
					    	artnumber++;
					    	article = new Article(artnumber);
					    	i++;
					    	article = article.readArticle(file, i);
					    	chapter.articles.add(article);
				    	} 	
				    	continue;
				    }
				    i++;
			    
			    }
			    
		}
		
		return parsed; 
	} 
} 
