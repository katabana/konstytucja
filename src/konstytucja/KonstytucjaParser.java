package konstytucja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KonstytucjaParser {
	
	public static void main() {
		
		String filePath;
		String range;
		ArrayList <Chapter> chapters = new ArrayList<>();
		BufferedReader reader = null;
		
		System.out.println("Enter file path: ");
		Scanner scanner = new Scanner(System.in);
		filePath = scanner.nextLine();
		range = scanner.nextLine();
		scanner.close();
		
		try
		  {
		    reader = new BufferedReader(new FileReader(filePath + "konstytucja.txt"));
		    String line;	
		    while ((line = reader.readLine()) != null)
		    {
		      if(line.startsWith("@")) {
		    	  reader.readLine();
		    	  line = reader.readLine();
		      }
		      if(line.startsWith("Rozdzia")) {
		    	  Chapter chapter = new Chapter(chapters.size()+1);
		    	  chapter.title = line;
		    	  System.out.println(range);
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
