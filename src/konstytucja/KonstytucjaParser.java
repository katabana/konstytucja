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
	
	public void konParse(KonstytucjaParser konstytucja) {
		
		String filePath = konstytucja.filePath;
		String range = konstytucja.range;
		int artnumber = 0;
		
		BufferedReader reader = null;
		
		/*System.out.println("Enter file path: ");
		Scanner scanner = new Scanner(System.in);
		filePath = scanner.nextLine();
		range = scanner.nextLine();
		scanner.close(); */
		
		try
		  {
		    reader = new BufferedReader(new FileReader(filePath + "\\konstytucja.txt"));
		    String line;
		    if(reader != null){
			    while ((line = reader.readLine()) != null)
			    {
			    	Chapter chapter = null;
			    	Article article = null;
			    	int number;
			    	
			    	if (line.startsWith("©")) {
			    		reader.readLine();
			    		continue;
			    	}
			    	if(line.startsWith("Rozdzia")) {
			    		chapter = new Chapter(chapters.size()+1);
				    	line = reader.readLine();
				    	chapter.title = line;
				    	this.chapters.add(chapter);
				    	System.out.println(chapter.arabicToRoman(chapter.number));
				    	System.out.println(chapter.title);
				    	System.out.println();
				    	continue;
			    	}
				    if(line.startsWith("Art")) {
				    	chapter = chapters.get(chapters.size()-1);
				    	if(chapter.articles != null) {
					    	artnumber++;
					    	article = new Article(artnumber);
					    	chapter.articles.add(article);
					    	article.readArticle(chapter.articles, reader, artnumber);
					    	article.printArticle();
					    	System.out.println();
					    	continue;
				    	} 				    		
				    }
			    
			    }
			    
			   }
		  } catch (FileNotFoundException e) {
			    e.printStackTrace();
		  } catch (IOException e) {
			  	e.printStackTrace();
		  } finally {
			  try{
				  if (reader != null) 
					  reader.close();
			  } catch (IOException e) {
				  
			  }
		
		  }
		return ;
	}
}