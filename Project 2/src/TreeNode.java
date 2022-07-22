class TreeNode {
    TreeNode leftChild;
    String keyword;
    TreeNode rightChild;
    ArticleNode head;
    
    public TreeNode(String key, ArticleNode rec){ // Creates a tree node object to be added to the Binary Search Tree
        leftChild = null;
        keyword = key;
        rightChild = null;
        head = rec;
    }
}    