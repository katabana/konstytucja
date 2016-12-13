package konstytucja;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		
		KonstytucjaParser konstytucja = new KonstytucjaParser(args);
		ArrayList<String> file = konstytucja.cleanFile(konstytucja);
		/*for(String i : file) {
			System.out.println(i);
		}
		System.out.println("indeks 0 "+file.get(0));*/
		konstytucja.konParse(konstytucja);
		
	}
}
