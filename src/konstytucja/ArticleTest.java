package konstytucja;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArticleTest {

	@Test
	public void test() {
		Article art1 = new Article(12);
		assertEquals(12, art1.number);
		assertEquals("", art1.text);
		assertTrue(art1.points.isEmpty());
		
		Article art2 = new Article(2, "some text");
		assertEquals(2, art2.number);
		assertEquals("some text", art2.text);
		assertTrue(art2.points.isEmpty());
	}
	
	@Test 
	public void readArticleTest() {
		String[] args1 = new String[2];
		args1[0] = "C:\\Users\\Kasia\\Java\\projekty\\projekty";
	    args1[1] = "R   3";
	    
	    Parser parser = new Parser(args1);
	    ArrayList<String> file = parser.cleanFile();
	    
	    Article art1 = new Article(1);
	   	art1 = art1.readArticle(file, 3);
	   	assertEquals(art1.number, 1);
	   	assertEquals(art1.text, "Rzeczpospolita Polska jest dobrem wspólnym wszystkich obywateli.");
	 
	   	Article art2 = new Article(2);
	   	art2 = art2.readArticle(file, 10);
	   	assertEquals(art2.number, 2);
	   	assertEquals(art2.text, "");
	   	assertFalse(art2.points.isEmpty());
	   	assertEquals(art2.points.get(0), "1. Władza zwierzchnia w Rzeczypospolitej Polskiej należy do Narodu.");
	   	assertEquals(art2.points.get(1), "2. Naród sprawuje władzę przez swoich przedstawicieli lub bezpośrednio.");
	    
	   	Article art3 = new Article(3);
	   	art3 = art3.readArticle(file, 18);
	   	assertEquals(art3.text, "");
	   	assertEquals(art3.points.get(0), "1. Rzeczpospolita Polska stwarza warunki upowszechniania i równego dostępu do dóbr kultury, będącej źródłem tożsamości narodu polskiego, jego trwania i rozwoju.");
	   	assertEquals(art3.points.get(1),"2. Rzeczpospolita Polska udziela pomocy Polakom zamieszkałym za granicą w zachowaniu ich związków z narodowym dziedzictwem kulturalnym.");
	    
		Article art4 = new Article(4);
		art4 = art4.readArticle(file, 5);
		assertEquals(art4.text, "Rzeczpospolita Polska jest demokratycznym państwem prawnym, urzeczywistniającym zasady sprawiedliwości społecznej.");
	}

}
