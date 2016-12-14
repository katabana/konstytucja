package konstytucja;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	@Test
	public void ArgumentTest() {
		
		//when file "konstytucja.txt" is in C:\Users\Kasia\Java\projekty\projekty
		String[] args1 = new String[2];
		args1[0] = "C:\\Users\\Kasia\\Java\\projekty\\projekty";
	    args1[1] = "R   3";
	    
	    Parser parser = new Parser(args1);
	    
	    assertFalse(parser.cleanFile().isEmpty());
	    
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
	    assertEquals(parser3.message, "C:\\Users\\Kasia\\Java\\proje\\konstytucja.txt (The system cannot find the path specified)");
	
	    
	
	}

}
