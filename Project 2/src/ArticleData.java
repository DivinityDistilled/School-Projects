import java.util.ArrayList;
public class ArticleData {		//Article Data class
	int id;
	String title;
	String author;
	ArrayList<String> keywords;

	public ArticleData(int id, String title, String author, int numKeywords) { // Creates Article Data object 
		
		this.id =id;
		this.title = title;
		this.author = author;
		keywords = new ArrayList<String>(numKeywords);		// Creates arrayList of keywords for the Article Data object
		
	}
	
	void addKeyword(String keyword) {		// adds keywords to the arrayList
		keywords.add(keyword);
	}
	
}


