package konstytucja;

import java.util.ArrayList;

public class KonstytucjaSystem {
	/*
	 * args[] :
	 * args[0] - path to file
	 * args[1] - A[...]" "int{-int} | R[...]" "int
	 * for example "Rozdzial 2", "Art 2-20", "R 4"
	 */

	//TODO: tests
	public static void main(String args[]) {
		
		Parser parser = new Parser(args);
		parser.parse();
		if(parser.kon != null) {
			Printer printer = new Printer(args, parser.kon);
			
			if (printer.range == null)
				printer.printAll();
			else {
				printer.getRange();
				printer.printRange();
			}
		}
		else
			System.out.println("parser pusty");
		
		
		
	}
}
