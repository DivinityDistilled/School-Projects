import java.util.ArrayList;
import java.io.*;class 

Project2Testing {
	
	BufferedReader fileReader;		// Buffer Reader so we don't have to keep the file open to access its contents
	BinarySearchTree bst;
	
	public static void main(String [] args) {
		
		Project2Testing Test = new Project2Testing("src/datafile.txt");	// Creates a Project2Testing object with the specified file
		
		Test.bst.print();	// prints Binary Search Tree
	}
	
	public Project2Testing(String filename) {		// Creates the Binary Search Tree
		try {
			bst = new BinarySearchTree();
			fileReader = new BufferedReader(new FileReader(filename));  
			
			ArticleData article = readNextRecord();		
			while ((article = readNextRecord()) != null) {	// adds articles to the binary search tree until there are no articles remaining
				bst.addArticle(article);
			}
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArticleData readNextRecord() {	// Reads in the articles from the file
		if(fileReader==null) {	// Checks if the buffered file reader is empty
			System.out.print("Error: you must open the file first.");
			return null;
		}else {
			ArticleData article;
			try {					// try catch conditions for parsing the buffered reader
				String data = fileReader.readLine();
				if(data==null) {
					return null;
				}
				
				int titleID= Integer.parseInt(data);
				String title = fileReader.readLine();
				String author = fileReader.readLine();
				int numKeys = Integer.parseInt(fileReader.readLine());
				article = new ArticleData(titleID,title,author,numKeys);
				
				String keyword;	
				for (int i=0; i<numKeys;i++) {									// adds keywords to arrayList
					keyword = fileReader.readLine();
					article.addKeyword(keyword);
				}
				// we can add testing for space later; for now read the blank line
				fileReader.readLine();
			
			}
			catch(NumberFormatException e) {	// adds exceptions
				System.out.println("Error: Number Expected!");
				return null;
			}
			catch(Exception e) {
				System.out.println("Fatal Error: "+ e);
				return null;
			}
			return article;
		}
		
	}
	
	
	
	
	
}

