package konstytucja;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ParserTest {

	@Test
	public void cleanFileTest() {
		
		//when file "konstytucja.txt" is in C:\Users\Kasia\Java\projekty\projekty
		String[] args1 = new String[2];
		args1[0] = "C:\\Users\\Kasia\\Java\\projekty\\projekty";
	    args1[1] = "R   3";
	    
	    Parser parser = new Parser(args1);
	    
	    assertFalse(parser.cleanFile().isEmpty());
	    
	    ArrayList<String> file = parser.cleanFile();
	    boolean wronglines = false;
	    for (String i : file) {
	    	if (i.startsWith("©"))
	    		wronglines = true;
	    }
	    assertFalse(wronglines);
	    assertEquals(file.get(0), "Rozdział I");
	    
	    //when empty file "konstytucja.txt" is in C:\Users\Kasia\Java\projekty
	    String[] args2 = new String[2];
		args2[0] = "C:\\Users\\Kasia\\Java\\projekty";
	    args2[1] = "3";
	    
	    Parser parser2 = new Parser(args2);
	    
	    assertTrue(parser2.cleanFile().isEmpty());
	    
	    //when there is in such directory C:\Users\Kasia\Java\proje
	    String[] args3 = new String[2];
		args3[0] = "C:\\Users\\Kasia\\Java\\proje";
	    args3[1] = "3";
	    
	    Parser parser3 = new Parser(args3);
	    parser3.cleanFile();
	    assertEquals(parser3.getMessage(), "C:\\Users\\Kasia\\Java\\proje\\konstytucja.txt (The system cannot find the path specified)");
	
	
	}
	
	@Test
	public void parseTest() {
		//when file "konstytucja.txt" is in C:\Users\Kasia\Java\projekty\projekty
		String[] args1 = new String[2];
		args1[0] = "C:\\Users\\Kasia\\Java\\projekty\\projekty";
		args1[1] = "R   3";
		Parser parser = new Parser(args1);
		
		assertTrue(parser.parse());
		assertFalse(parser.getKon().getChapters().isEmpty());
		assertTrue(parser.getKon().getChapters().size() == 13);
		for (Chapter i : parser.getKon().getChapters()) {
			assertFalse(i.getArticles().isEmpty());
		}
		Chapter lastChapter = parser.getKon().getChapters().get(parser.getKon().getChapters().size()-1);
		Article lastArticle = lastChapter.getArticles().get(lastChapter.getArticles().size()-1);
		assertTrue(lastArticle.getNumber() == 243);
	}

}
