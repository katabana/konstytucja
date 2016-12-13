package konstytucja;

public class Main {

	public static void main(String args[]) {
		
		KonstytucjaParser konstytucja = new KonstytucjaParser(args);
		System.out.print(konstytucja.cleanFile(konstytucja));
		
		
		
	}
}
