package konstytucja;

public class Konstytucja {

	public static void main(String args[]) {
		
		KonstytucjaParser konstytucja = new KonstytucjaParser(args);
		System.out.println(konstytucja.cleanFile(konstytucja));
		
		
	}
}
