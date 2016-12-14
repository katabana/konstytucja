package konstytucja;

import static org.junit.Assert.*;

import org.junit.Test;

public class KonstytucjaTest {

	@Test
	public void test() {
		Konstytucja kon = new Konstytucja();
		assertFalse(kon == null);
		assertFalse(kon.getChapters() == null);
	}

}
