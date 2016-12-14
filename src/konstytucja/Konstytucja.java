package konstytucja;

import java.util.ArrayList;

public class Konstytucja {
	
	private ArrayList<Chapter> chapters;
	
	public Konstytucja(){
		this.chapters = new ArrayList<Chapter>();
	}
	
	public ArrayList<Chapter> getChapters(){
		return this.chapters;
	}

}
