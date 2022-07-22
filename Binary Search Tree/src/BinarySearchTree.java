
public class BinarySearchTree {
	
	TreeNode root;
	
	
	public void addArticle(ArticleData article) {	//  Reads in articleData object in order to add article to the binary search trees for all given keywords
		
		for(String key:article.keywords) {
			ArticleNode newArticleNode = new ArticleNode(article.id,article.title,article.title,null);
			boolean inserted = insertTreeNode(key, newArticleNode);
			//System.out.printf("%s %s\n",key,inserted);
			if(!inserted) {
				// append the ArticleNode
				appendArticleNode(key, newArticleNode);
			}
		}
	}
	
	public void appendArticleNode(String keyword, ArticleNode newArticleNode) {		// Adds article to the Binary Search Tree based on given keyword
		TreeNode current = root;
		while(current !=null) {
			if(keyword.compareTo(current.keyword)< 0) {		// Compares to left child
				//System.out.printf("Test Left %s %s %d\n",keyword,current.keyword,newArticleNode.id);
				
				current = current.leftChild;
				
			}else if (keyword.compareTo(current.keyword) > 0) {	// Compares to right child
				//System.out.printf("Test Right %s %s %d\n",keyword,current.keyword,newArticleNode.id);
				
				current = current.rightChild;
				
			}else {		// adds article to current keyword's linked list
				//System.out.printf("Test Equal %s %s %d\n",keyword,current.keyword,newArticleNode.id);
				newArticleNode.next = current.head;
				current.head = newArticleNode;
				return;
			}
		}
		
	}
	
	public boolean insertTreeNode(String keyword, ArticleNode newArticleNode) {	// Creates new tree node in Binary Search Tree if possible
		if( root==null) {	// If root is null, initialize root using given keyword and ArticleNode
			
			root = new TreeNode(keyword, newArticleNode);
			return true;
			
		}else {		// If root exists, checks left then right child nodes for existence to determine where to insert node
			
			TreeNode parent = null;
			TreeNode current = root;
			
			while(current !=null) {
				if(keyword.compareTo(current.keyword)< 0) {
					//System.out.printf("Test Left %s %s %d\n",keyword,current.keyword,newArticleNode.id);
					parent = current;
					current = current.leftChild;
					
				}else if (keyword.compareTo(current.keyword) > 0) {
					//System.out.printf("Test Right %s %s %d\n",keyword,current.keyword,newArticleNode.id);
					parent = current;
					current = current.rightChild;
					
				}else {
					//System.out.printf("Test Equal %s %s %d\n",keyword,current.keyword,newArticleNode.id);
					return false;
				}
			}
			
			if(keyword.compareTo(parent.keyword)< 0) {
				
				parent.leftChild= new TreeNode(keyword, newArticleNode);
				
			}else if(keyword.compareTo(parent.keyword)> 0) {
				
				parent.rightChild= new TreeNode(keyword, newArticleNode);
			}
			
		}
		return true;
	}
	
	public void print() {	// prints root
		inOrderPrint(root);

	}
	
	private void inOrderPrint(TreeNode node) {	// Prints articles in given tree node
		
		if(node==null ) return;
		
		inOrderPrint(node.leftChild);
		System.out.printf("\n%s\n",node.keyword);
		ArticleNode article = node.head;
		while ( article != null) {
			System.out.printf("\t %d %s %s-->\n",article.id,article.title,article.author);
			article = article.next;
		}
		inOrderPrint(node.rightChild);
		
		
	}
	
	private void preOrderPrint(TreeNode root) {
		
		if(root==null ) return;
		System.out.printf("\n %s\n",root.keyword);
		ArticleNode article = root.head;
		while ( article != null) {
			System.out.printf("\t %d | %s | %s-->\n",article.id,article.title,article.author);
			article = article.next;
		}
		inOrderPrint(root.leftChild);
	     inOrderPrint(root.rightChild);
	}
	
	
}
	
	

