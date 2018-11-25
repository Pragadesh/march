package org.pg.march.geeksforgeeks;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    
    public void insert(T data) {
        if(this.root == null) {
            this.root = new BinaryTreeNode(data);
            return;
        }
    }
    
    public static class BinaryTreeNode<T>{
        private T data;
        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;
        
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        
    }
}
