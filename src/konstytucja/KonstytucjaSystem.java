package konstytucja;

public class KonstytucjaSystem {
	/*
	 * Arguments for main:
	 * 
	 * args[] :
	 * args[0] - path to file directory
	 * for example C:\Users\User\Documents where konstytucja.txt is in Documents
	 * args[1] ::= "A[...] int{-int}" | "R[...] int"
	 * for example "Rozdzial 2", "Art 2-20", "R 4"
	 * 
	 * Attention! It works only on Windows as file path is different with "/" not "\".
	 */

	//TODO: tests
	public static void main(String[] args) {
		
		boolean validArgs = true;
		if(args.length > 2)
			validArgs = false;
		if(args != null){
			if(args.length != 0) {
				validArgs = args[0] != null;
				if(args.length != 1)
					validArgs = args[1] != null;
				else
					validArgs = false;
			}
			else validArgs = false;
		}
		else
			validArgs = false;
		
		if(validArgs){
			Parser parser = new Parser(args);
			if(!parser.parse())
				System.out.println("The file was not parsed properly.");
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
		else
			System.out.println("Not enough arguments");
		
		
	}
}
