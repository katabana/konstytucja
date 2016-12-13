package konstytucja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//osobno wczytywanie 

public class KonstytucjaParser {
	
	public ArrayList <Chapter> chapters;
	public String filePath;
	public String range;
	
	
	public KonstytucjaParser(String[] args) {
		chapters = new ArrayList<Chapter>();
		filePath = args[0];
		range = args[1];
	}
	
	public ArrayList<String> cleanFile(KonstytucjaParser konstytucja) {
		String filePath = konstytucja.filePath;
		String range = konstytucja.range;
		
		BufferedReader reader = null;
		ArrayList<String> file = new ArrayList<String>();
		
		try{
		reader = new BufferedReader(new FileReader(filePath + "\\konstytucja.txt"));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	    try {
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
	    } catch (IOException e) {
	    	e.getMessage();
	    }
	    finally {
	    	 try{
				  if (reader != null) 
					  reader.close();
			  } catch (IOException e) {
				  
}
	    }
	    
	    return file;
	}
	
	public void konParse(KonstytucjaParser konstytucja) {
		
		ArrayList<String> file = new ArrayList<String>();
		file = this.cleanFile(konstytucja);
		String line = "";
		int artnumber = 0;
		
		/*System.out.println("Enter file path: ");
		Scanner scanner = new Scanner(System.in);
		filePath = scanner.nextLine();
		range = scanner.nextLine();
		scanner.close(); */
			        
		if(file != null){
			int i = 0;
			System.out.print(file);
			while(i < file.size() && file.get(i)!= null) {
					line = file.get(i);
			    	Chapter chapter = null;
			    	Article article = null;
			    	int number;
			    	
			    	if(line.startsWith("Rozdzia")) {
			    		System.out.println();
			    		chapter = new Chapter(this.chapters.size()+1);
			    		i++;
			    		if(file.get(i)!=null)
			    			line = file.get(i);
			    		
				    	chapter.title = line;
				    	this.chapters.add(chapter);
				    	System.out.println("Rozdział " + chapter.arabicToRoman(chapter.number));
				    	System.out.println(chapter.title);
				    	System.out.println();
				    	i++;
				    	continue;
			    	}
				    if(line.startsWith("Art")) {
				    	chapter = chapters.get(chapters.size()-1);
				    	if(chapter.articles != null) {
					    	artnumber++;
					    	article = new Article(artnumber);
					    	chapter.articles.add(article);
					    	//article.readArticle(chapter.articles, reader, artnumber);
					    	//article.printArticle();
					    	//System.out.println();
					    	i++;
					    	continue;
				    	} 				    		
				    }
				    i++;
			    
			    }
			    
			}
		return ; 
	} 
} 
