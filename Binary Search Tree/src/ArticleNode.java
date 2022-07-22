class ArticleNode {
    int id;
    String title;
    String author;
    ArticleNode next;

    ArticleNode(int i, String t, String a, ArticleNode r){	// Creates Article Node object for linked list of articles in the Binary Search Tree
        id = i;
        title = t;
        author = a;
        next = r;
    }
}